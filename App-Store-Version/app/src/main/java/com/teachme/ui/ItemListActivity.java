package com.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;
import com.teachme.R;
import com.teachme.adapters.ItemAdapter;
import com.teachme.database.constant.AppConstant;
import com.teachme.database.constant.EnglishVideoURL;
import com.teachme.listeners.ListItemClickListener;
import com.teachme.models.content.Contents;
import com.teachme.models.content.Item;
import com.teachme.utility.ActivityUtilities;
import com.teachme.utility.AdsUtilities;

import java.util.ArrayList;

public class ItemListActivity extends BaseActivity {

    private Activity mActivity;
    private Context mContext;

    private Contents mContent;
    private ArrayList<Item> mItemList;
    private ItemAdapter mAdapter = null;
    private RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        mActivity = ItemListActivity.this;
        mContext = mActivity.getApplicationContext();

        Intent intent = getIntent();
        if (intent != null) {
            mContent = intent.getParcelableExtra(AppConstant.BUNDLE_KEY_ITEM);
            mItemList = mContent.getItems();
        }
    }

    private void initView() {
        setContentView(R.layout.activity_item_list);

        mRecycler = findViewById(R.id.rvContent);
        mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 3, GridLayoutManager.VERTICAL, false));

        initLoader();
        initToolbar(true);
        setToolbarTitle(mContent.getTitle());
        enableUpButton();
    }

    private void initFunctionality() {
        showLoader();

        mAdapter = new ItemAdapter(mContext, mActivity, mItemList);
        mRecycler.setAdapter(mAdapter);

        hideLoader();

        // show full-screen ads
        AdsUtilities.getInstance(mContext).showFullScreenAd();
        // show banner ads
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
    }


    public void initListener() {
        // recycler list item click listener
        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Item model = mItemList.get(position);
                if (model.getDetails().size() > 1) {
                    ActivityUtilities.getInstance().invokeDetailsListActiviy(mActivity, DetailsListActivity.class, model, false);
                } else {
                    switch (mItemList.get(position).getTagLine()) {
                        case "Connecting to SQL Server using SSMS - Part 1":
                            ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrlActivity.class,
                                    mItemList.get(position).getDetails().toString().substring(1, mItemList.get(position).getDetails().toString().length() - 1),
                                    EnglishVideoURL.DATABASE_URL_1, false);
                            break;
                        case "Creating altering and dropping a database - Part 2":

                            ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrlActivity.class,
                                    mItemList.get(position).getDetails().toString().substring(1, mItemList.get(position).getDetails().toString().length() - 1),
                                    EnglishVideoURL.DATABASE_URL_2, false);
                            break;

                        case "Creating and working with tables - Part 3":
                            ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrlActivity.class,
                                    mItemList.get(position).getDetails().toString().substring(1, mItemList.get(position).getDetails().toString().length() - 1),
                                    EnglishVideoURL.DATABASE_URL_3, false);
                            break;
                        default:
                            ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, DetailsActivity.class, position, model.getDetails(), false);
                            break;
                    }
                }
            }

        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
