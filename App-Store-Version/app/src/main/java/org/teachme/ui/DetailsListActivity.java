package org.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

import org.teachme.R;
import org.teachme.adapters.DetailsAdapter;
import org.teachme.database.constant.AppConstant;
import org.teachme.database.preference.AppPreference;
import org.teachme.listeners.ListItemClickListener;
import org.teachme.models.content.Item;
import org.teachme.utility.ActivityUtilities;
import org.teachme.utility.AdsUtilities;

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
        if (AppPreference.getInstance(mContext).isWidescreenOn()) {
            mRecycler.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        } else {
            mRecycler.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        }
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

