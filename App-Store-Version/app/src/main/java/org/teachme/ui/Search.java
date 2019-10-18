package org.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.teachme.R;
import org.teachme.adapters.DetailsAdapter;
import org.teachme.database.constant.AppConstant;
import org.teachme.engine.Base;
import org.teachme.listeners.ListItemClickListener;
import org.teachme.utility.ActivityUtilities;
import org.teachme.utility.AdsUtilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Search extends Base {

    private Activity mActivity;
    private Context mContext;
    private DetailsAdapter mAdapter = null;
    private RecyclerView mRecyclerContent;
    private ArrayList<String> mItemList;
    private ArrayList<String> mSearchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        mActivity = Search.this;
        mContext = mActivity.getApplicationContext();

        mItemList = new ArrayList<>();
        mSearchList = new ArrayList<>();
    }

    private void initView() {
        setContentView(R.layout.activity_details_list);

        mRecyclerContent = findViewById(R.id.rvContent);
        mRecyclerContent.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));

        initLoader();
        initToolbar(true);
        enableUpButton();
        setToolbarTitle(getString(R.string.search));
    }

    private void initFunctionality() {
        loadData();

        mAdapter = new DetailsAdapter(mContext, mActivity, mSearchList);
        mRecyclerContent.setAdapter(mAdapter);

        // show full-screen ads
        AdsUtilities.getInstance(mContext).showFullScreenAd();
    }

    public void initListener() {
        // Recent post list item click listener
        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                //TODO mSearchList
                ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, Details.class, position, mSearchList, false);
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setQueryHint(getString(R.string.search));
        searchView.postDelayed(new Runnable() {
            @Override
            public void run() {
                searchView.setIconifiedByDefault(true);
                searchView.setFocusable(true);
                searchView.setIconified(false);
                searchView.requestFocusFromTouch();
            }
        }, 200);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //some texts here
                showLoader();
                mSearchList.clear();

                for (String temp : mItemList) {
                    if (temp.toLowerCase().contains(newText)) {
                        mSearchList.add(temp);
                    }
                }
                if (!mSearchList.isEmpty() && mSearchList.size() > 0) {
                    mAdapter.notifyDataSetChanged();
                    hideLoader();
                } else {
                    showEmptyView();
                }

                return false;
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void loadData() {
        showLoader();
        loadJson();

    }

    private void loadJson() {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getAssets().open(AppConstant.GLOBAL)));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        parseJson(sb.toString());
    }

    private void parseJson(String jsonData) {
        try {

            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(AppConstant.JSON_KEY_ITEMS);

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);

                JSONArray jsonArray2 = jsonObj.getJSONArray(AppConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);

                    JSONArray jsonArray3 = jsonObj2.getJSONArray(AppConstant.JSON_KEY_DETAILS);
                    for (int k = 0; k < jsonArray3.length(); k++) {
                        String details = jsonArray3.get(k).toString();
                        mItemList.add(details);
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        hideLoader();
    }

}
