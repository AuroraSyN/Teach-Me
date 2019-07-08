package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.ContentAdapter;
import de.hsworms.inf3032.adapters.ContentLoaderAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.data.sqlite.NotificationDbController;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.listeners.MainActivityContentSelectorListner;
import de.hsworms.inf3032.listeners.MainActivityLanguageSelectorListner;
import de.hsworms.inf3032.models.content.Contents;
import de.hsworms.inf3032.models.content.Item;
import de.hsworms.inf3032.models.notification.NotificationModel;
import de.hsworms.inf3032.utility.ActivityUtilities;
import de.hsworms.inf3032.utility.AppUtilities;
import de.hsworms.inf3032.utility.RateItDialogFragment;

public class MainActivity extends BaseActivity {

    private RelativeLayout mNotificationView;
    private ImageButton mImgBtnSearch, mQuizButton, mInterviewButton;
    private static ArrayList<Contents> mContentList;
    private static ContentAdapter mAdapter = null;
    private RecyclerView mRecycler;
    private String[] contentString;
    private String[] languageString;
    private List<String> contentList;
    private List<String> languageList;
    private ArrayList<Item> items;
    // received new broadcast
    private BroadcastReceiver newNotificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            initNotification();
        }
    };

    public PopupWindow content_listWindow;
    public PopupWindow language_listWindow;
    public static Context mContext;
    public static Activity mActivity;

    public static Button mContentSelectorButton, mLanguageSelectorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateItDialogFragment.show(this, getSupportFragmentManager());
        initVar();
        initView();
        initListener();

        loadData();
        //TODO STRING
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Try Conten in Other Language",
                        Toast.LENGTH_SHORT).show();
            }
        }, 250000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(newNotificationReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(AppConstant.NEW_NOTI);
        LocalBroadcastManager.getInstance(this).registerReceiver(newNotificationReceiver, intentFilter);
        initNotification();
    }

    @Override
    public void onBackPressed() {
        AppUtilities.tapPromptToExit(mActivity);
    }

    private void initVar() {
        mActivity = MainActivity.this;
        mContext = getApplicationContext();
        mContentList = new ArrayList<>();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mNotificationView = findViewById(R.id.notificationView);
        mImgBtnSearch = findViewById(R.id.mainmenu_search_button);
        mRecycler = findViewById(R.id.rvContent);
        mQuizButton = findViewById(R.id.mainmenu_question_button);
        mInterviewButton = findViewById(R.id.mainmenu_interview_button);
        mLanguageSelectorButton = findViewById(R.id.mainmenu_language_selector_button);
        mContentSelectorButton = findViewById(R.id.mainmenu_content_selector_button);

        if (!AppConstant.LAYOUT_MANAGER){
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 2, GridLayoutManager.VERTICAL, false));
        }else{
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 4, GridLayoutManager.HORIZONTAL, false));
        }
        mAdapter = new ContentAdapter(mContext, mActivity, mContentList);
        mRecycler.setAdapter(mAdapter);


        contentList = new ArrayList<String>();
        contentList.add(getString(R.string.computer_science));
        contentList.add(getString(R.string.mobile_computing));
        //contentList.add(getString(R.string.linguistics));

        languageList = new ArrayList<>();
        languageList.add(getString(R.string.mainmenu_English));
        languageList.add(getString(R.string.mainmenu_German));
        languageList.add(getString(R.string.mainmenu_Russian));

        contentString = new String[contentList.size()];
        languageString = new String[languageList.size()];

        contentList.toArray(contentString);
        languageList.toArray(languageString);

        content_listWindow = viewWindow(true);
        language_listWindow = viewWindow(false);

        initToolbar(false);
        initDrawer();
        initLoader();
    }

    private void initListener() {
        mNotificationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, NotificationListActivity.class, false);
            }
        });
        mImgBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, SearchActivity.class, false);
            }
        });
        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Contents model = mContentList.get(position);
                ActivityUtilities.getInstance().invokeItemListActiviy(mActivity, ItemListActivity.class, model, false);
            }

        });
        mQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, QuestionSelectActivity.class, true);
            }
        });
        mInterviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, InterviewQuestionsActivity.class, true);
            }
        });
        mContentSelectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content_listWindow.showAsDropDown(v, -5, 0);
            }
        });
        mLanguageSelectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                language_listWindow.showAsDropDown(v, -5,0);
            }
        });
    }

    private void loadData() {
        showLoader();
        loadJson();
    }

    public static void loadJson() {
        if (mContentList != null){
            mContentList.clear();
        }
        ContentLoaderAdapter contentLoaderAdapter = new ContentLoaderAdapter();
        contentLoaderAdapter.loadData();
        parseJson(contentLoaderAdapter.getStringBuffer().toString());
    }

    public static void parseJson(String jsonData) {
        try {
            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(ContentConstant.JSON_KEY_ITEMS);
            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);
                String title = jsonObj.getString(ContentConstant.JSON_KEY_TITLE);
                ArrayList<Item> items = new ArrayList<>();
                JSONArray jsonArray2 = jsonObj.getJSONArray(ContentConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);
                    String tag_line = jsonObj2.getString(ContentConstant.JSON_KEY_TAG_LINE);
                    ArrayList<String> detailList = new ArrayList<>();
                    JSONArray jsonArray3 = jsonObj2.getJSONArray(ContentConstant.JSON_KEY_DETAILS);
                    for (int k = 0; k < jsonArray3.length(); k++) {
                        String details = jsonArray3.get(k).toString();
                        detailList.add(details);
                    }
                    items.add(new Item(tag_line, detailList));
                }
                mContentList.add(new Contents(title, items));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hideLoader();
        mAdapter.notifyDataSetChanged();
    }

    public void initNotification() {
        NotificationDbController notificationDbController = new NotificationDbController(mContext);
        TextView notificationCount = findViewById(R.id.notificationCount);
        notificationCount.setVisibility(View.INVISIBLE);
        ArrayList<NotificationModel> notiArrayList = notificationDbController.getUnreadData();
        if (notiArrayList != null && !notiArrayList.isEmpty()) {
            int totalUnread = notiArrayList.size();
            if (totalUnread > 0) {
                notificationCount.setVisibility(View.VISIBLE);
                notificationCount.setText(String.valueOf(totalUnread));
            } else {
                notificationCount.setVisibility(View.INVISIBLE);
            }
        }
    }

    private ArrayAdapter<String> listViewAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                // setting the ID and text for every items in the list
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];

                // visual settings for the list item
                TextView listItem = new TextView(MainActivity.this);
                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(22);
                listItem.setPadding(5, 15, 10, 10);
                listItem.setTextColor(Color.WHITE);
                return listItem;
            }
        };
        return adapter;
    }

    public PopupWindow viewWindow(boolean flag) {
        PopupWindow popupWindow = new PopupWindow(this);
        ListView listView = new ListView(this);
        if (flag == true){
            listView.setAdapter(listViewAdapter(contentString));
            listView.setOnItemClickListener(new MainActivityContentSelectorListner());
        }else{
            listView.setAdapter(listViewAdapter(languageString));
            listView.setOnItemClickListener(new MainActivityLanguageSelectorListner());
        }
        popupWindow.setFocusable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(listView);
        return popupWindow;
    }

}
