package com.teachme.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;
import com.teachme.R;
import com.teachme.adapters.DetailsAdapter;
import com.teachme.data.constant.AppConstant;
import com.teachme.listeners.ListItemClickListener;
import com.teachme.models.content.Item;
import com.teachme.utility.ActivityUtilities;
import com.teachme.utility.AdsUtilities;

import java.util.ArrayList;


public class DetailsListActivity extends BaseActivity {

    private Activity mActivity;
    private Context mContext;

    private Item mItem;
    private ArrayList<String> mItemList;
    private DetailsAdapter mAdapter = null;
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
        mActivity = DetailsListActivity.this;
        mContext = mActivity.getApplicationContext();

        Intent intent = getIntent();
        if (intent != null) {
            mItem = intent.getParcelableExtra(AppConstant.BUNDLE_KEY_ITEM);
            mItemList = mItem.getDetails();
        }
    }

    private void initView() {
        setContentView(R.layout.activity_details_list);

        mRecycler = findViewById(R.id.rvContent);
        mRecycler.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));

        initLoader();
        initToolbar(true);
        setToolbarTitle(mItem.getTagLine());
        enableUpButton();
    }

    private void initFunctionality() {
        showLoader();

        mAdapter = new DetailsAdapter(mContext, mActivity, mItemList);
        mRecycler.setAdapter(mAdapter);

        hideLoader();

        // show banner ads
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
    }


    public void initListener() {
        // recycler list item click listener
        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, DetailsActivity.class, position, mItemList, false);
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

