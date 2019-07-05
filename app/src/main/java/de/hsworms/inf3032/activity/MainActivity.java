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
import de.hsworms.inf3032.data.constant.GlobalContentConstant;
import de.hsworms.inf3032.data.sqlite.NotificationDbController;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.listeners.SelectorListner;
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
    private String[] popUpContents;
    private List<String> studyList;
    private ArrayList<Item> items;
    // received new broadcast
    private BroadcastReceiver newNotificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            initNotification();
        }
    };

    public PopupWindow listWindow;
    public Button contentSelector;
    public static Context mContext;
    public static Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateItDialogFragment.show(this, getSupportFragmentManager());
        initVar();
        initView();
        loadData();
        initListener();

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
        mImgBtnSearch = findViewById(R.id.imgBtnSearch);
        mRecycler = findViewById(R.id.rvContent);
        mQuizButton = findViewById(R.id.quizMainMenuButton);
        mInterviewButton = findViewById(R.id.interviewMainMenuButton);
        if (!AppConstant.LAYOUT_MANAGER){
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 2, GridLayoutManager.VERTICAL, false));
        }else{
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 4, GridLayoutManager.HORIZONTAL, false));
        }
        mAdapter = new ContentAdapter(mContext, mActivity, mContentList);
        mRecycler.setAdapter(mAdapter);
        contentSelector = findViewById(R.id.contentSelector);

        // format is Name::ID
        studyList = new ArrayList<String>();
        studyList.add(getString(R.string.computer_science));
        studyList.add(getString(R.string.mobile_computing));
        studyList.add(getString(R.string.linguistics));
        popUpContents = new String[studyList.size()];
        studyList.toArray(popUpContents);
        listWindow = viewWindow();

        initToolbar(false);
        initDrawer();
        initLoader();
    }

    private void initListener() {
        //notification view click listener
        mNotificationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, NotificationListActivity.class, false);
            }
        });

        // Search button click listener
        mImgBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, SearchActivity.class, false);
            }
        });

        // recycler list item click listener
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

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.contentSelector:
                        listWindow.showAsDropDown(v, -5, 0);
                        break;
                }
            }
        };
        contentSelector.setOnClickListener(handler);
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
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(GlobalContentConstant.JSON_KEY_ITEMS);
            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);
                String title = jsonObj.getString(GlobalContentConstant.JSON_KEY_TITLE);
                ArrayList<Item> items = new ArrayList<>();
                JSONArray jsonArray2 = jsonObj.getJSONArray(GlobalContentConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);
                    String tag_line = jsonObj2.getString(GlobalContentConstant.JSON_KEY_TAG_LINE);
                    ArrayList<String> detailList = new ArrayList<>();
                    JSONArray jsonArray3 = jsonObj2.getJSONArray(GlobalContentConstant.JSON_KEY_DETAILS);
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
                listItem.setTextSize(20);
                listItem.setPadding(5, 15, 10, 10);
                listItem.setTextColor(Color.WHITE);
                return listItem;
            }
        };
        return adapter;
    }

    public PopupWindow viewWindow() {
        PopupWindow popupWindow = new PopupWindow(this);
        ListView _listView = new ListView(this);
        _listView.setAdapter(listViewAdapter(popUpContents));
        _listView.setOnItemClickListener(new SelectorListner());
        popupWindow.setFocusable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(_listView);
        return popupWindow;
    }
}
