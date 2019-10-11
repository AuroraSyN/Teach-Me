package com.teachme.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;
import com.teachme.R;
import com.teachme.adapters.ContentAdapter;
import com.teachme.database.constant.AppConstant;
import com.teachme.database.preference.AppPreference;
import com.teachme.database.sqlite.NotificationDbController;
import com.teachme.listeners.ListItemClickListener;
import com.teachme.listeners.MainActivityListner;
import com.teachme.loader.InterViewLoader;
import com.teachme.loader.TutorialLoader;
import com.teachme.loader.VideoLoader;
import com.teachme.models.content.Contents;
import com.teachme.models.notification.NotificationModel;
import com.teachme.parser.Parser;
import com.teachme.utility.ActivityUtilities;
import com.teachme.utility.AdsUtilities;
import com.teachme.utility.AppUtilities;
import com.teachme.utility.RateItDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public static Context mContext;
    private static TextView mAppMode;
    private static ArrayList<Contents> mContentList;
    private static ContentAdapter mAdapter = null;
    public PopupWindow popupWindow;
    public Button mContentSelectorButton;
    private Activity mActivity;
    private RelativeLayout mNotificationView;
    private ImageButton mImgBtnSearch, mImgBtnInterview, mImgBtnVideo, mImgBtnTutorial;
    private RecyclerView mRecycler;
    private String[] popUpContents;
    private AppPreference appPreference;
    private BroadcastReceiver newNotificationReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            initNotification();
        }
    };

    public static void loadJson() {
        TutorialLoader tutorialLoader = new TutorialLoader();
        InterViewLoader interViewLoader = new InterViewLoader();
        VideoLoader videoLoader = new VideoLoader();
        switch (AppConstant.APP_MODE) {
            case 0:
                tutorialLoader.load();
                mAppMode.setText(AppConstant.APP_MODE_0);
                parseJson(tutorialLoader.getStringBuffer());
                break;
            case 1:
                interViewLoader.load();
                mAppMode.setText(AppConstant.APP_MODE_1);
                parseJson(interViewLoader.getStringBuffer());
                break;
            case 2:
                videoLoader.load();
                mAppMode.setText(AppConstant.APP_MODE_2);
                parseJson(videoLoader.getStringBuffer());
                break;
        }
    }

    private static void parseJson(StringBuffer buffer) {
        Parser parser = new Parser(buffer.toString());
        parser.parse();
        if (mContentList != null) {
            mContentList.clear();
        }
        mContentList.add(new Contents(parser.getTitle(), parser.getItems()));
        hideLoader();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateItDialogFragment.show(this, getSupportFragmentManager());
        initVar();
        initView();

        appPreference = AppPreference.getInstance(mContext);

        if (AppPreference.mSharedPreferences != null) {
            mContentSelectorButton.setText(AppPreference.mSharedPreferences.getString("content_selector", "Touch Me"));
            AppConstant.SELECTED_CONTENT = AppPreference.mSharedPreferences.getInt("selected_content", 1);
        } else {
            mContentSelectorButton.setText(getString(R.string.content_selector_button_title));
        }
        loadData();
        initListener();
    }

    private ArrayAdapter<String> contentAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];
                TextView listItem = new TextView(MainActivity.this);
                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(22);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);
                return listItem;
            }
        };
        return adapter;
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(newNotificationReceiver);
        AppPreference.mEditor.putString("content_selector", mContentSelectorButton.getText().toString());
        AppPreference.mEditor.putInt("selected_content", AppConstant.SELECTED_CONTENT);
        AppPreference.mEditor.commit();
        AppPreference.mEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(AppConstant.NEW_NOTI);
        LocalBroadcastManager.getInstance(this).registerReceiver(newNotificationReceiver, intentFilter);
        initNotification();
        AdsUtilities.getInstance(mContext).loadFullScreenAd(mActivity);
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
        mImgBtnInterview = findViewById(R.id.imgBtnInterview);
        mImgBtnVideo = findViewById(R.id.imgBtnVideo);
        mImgBtnTutorial = findViewById(R.id.imgBtnTutorial);
        mRecycler = findViewById(R.id.rvContent);
        mContentSelectorButton = findViewById(R.id.content_selector);
        mAppMode = findViewById(R.id.toolbarTitle);
        mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 2, GridLayoutManager.VERTICAL, false));
        mAdapter = new ContentAdapter(mContext, mActivity, mContentList);
        mRecycler.setAdapter(mAdapter);

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

        mImgBtnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppConstant.APP_MODE = 0;
                loadJson();
            }
        });

        mImgBtnInterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppConstant.APP_MODE = 1;
                loadJson();
            }
        });

        mImgBtnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppConstant.APP_MODE = 2;
                loadJson();
            }
        });

        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Contents model = mContentList.get(position);
                ActivityUtilities.getInstance().invokeItemListActiviy(mActivity, ItemListActivity.class, model, false);
            }

        });

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.content_selector:
                        popupWindow.showAsDropDown(v, 0, 0);
                        break;
                }
            }
        };
        mContentSelectorButton.setOnClickListener(handler);
    }

    private void loadData() {
        showLoader();
        AppConstant.APP_MODE_0 = getString(R.string.app_mode_1);
        AppConstant.APP_MODE_1 = getString(R.string.app_mode_2);
        AppConstant.APP_MODE_2 = getString(R.string.app_mode_3);
        loadJson();
        List<String> contentList = new ArrayList<String>();
        contentList.add(getString(R.string.content_selector_1));
        contentList.add(getString(R.string.content_selector_2));
        popUpContents = new String[contentList.size()];
        contentList.toArray(popUpContents);
        popupWindow = popupWindow();
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
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

    public PopupWindow popupWindow() {
        PopupWindow popupWindow = new PopupWindow(this);
        ListView listViewContent = new ListView(this);
        listViewContent.setAdapter(contentAdapter(popUpContents));
        listViewContent.setOnItemClickListener(new MainActivityListner());
        popupWindow.setFocusable(true);
        Display mDisplay = getWindowManager().getDefaultDisplay();
        popupWindow.setWidth(mDisplay.getWidth());
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(listViewContent);
        return popupWindow;
    }

}
