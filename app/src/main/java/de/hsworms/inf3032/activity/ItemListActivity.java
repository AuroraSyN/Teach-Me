package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.ItemAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.models.content.Contents;
import de.hsworms.inf3032.models.content.Item;
import de.hsworms.inf3032.utility.ActivityUtilities;

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
                    ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, DetailsActivity.class, position, model.getDetails(), false);
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
