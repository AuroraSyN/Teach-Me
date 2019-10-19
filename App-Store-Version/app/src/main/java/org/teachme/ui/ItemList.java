package org.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

import org.teachme.R;
import org.teachme.adapters.ItemAdapter;
import org.teachme.database.constant.AppConstant;
import org.teachme.database.preference.AppPreference;
import org.teachme.engine.Base;
import org.teachme.listeners.ListItemClickListener;
import org.teachme.models.content.Contents;
import org.teachme.models.content.Item;
import org.teachme.utility.AdsUtilities;
import org.teachme.utility.ItemUtilities;

import java.util.ArrayList;

public class ItemList extends Base {

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
        mActivity = ItemList.this;
        mContext = mActivity.getApplicationContext();

        Intent intent = getIntent();
        if (intent != null) {
            mContent = intent.getParcelableExtra(AppConstant.BUNDLE_KEY_ITEM);
            try {
                mItemList = mContent.getItems();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        setContentView(R.layout.activity_item_list);

        mRecycler = findViewById(R.id.rvContent);
        if (AppPreference.getInstance(mContext).isWidescreenOn()) {
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 8, GridLayoutManager.HORIZONTAL, false));
        } else {
            mRecycler.setLayoutManager(new GridLayoutManager(mActivity, 3, GridLayoutManager.VERTICAL, false));
        }
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
                ItemUtilities itemUtilities = new ItemUtilities(mActivity, mItemList, model, position);
                itemUtilities.work();
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
