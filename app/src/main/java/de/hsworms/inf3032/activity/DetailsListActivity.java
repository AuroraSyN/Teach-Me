package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.DetailsAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.models.content.Item;
import de.hsworms.inf3032.utility.ActivityUtilities;


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
        if (!AppConstant.LAYOUT_MANAGER) {
            mRecycler.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        } else {
            mRecycler.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
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

