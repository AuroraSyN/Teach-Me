package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.ContentLoaderAdapter;
import de.hsworms.inf3032.adapters.DetailsAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.utility.ActivityUtilities;

public class SearchActivity extends BaseActivity {

    private Activity mActivity;
    private Context mContext;
    private DetailsAdapter mAdapter = null;
    private RecyclerView mRecyclerContent;
    private ArrayList<String> mItemList;
    private ArrayList<String> mSearchList;
    private ImageButton mSpeakButton;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        mActivity = SearchActivity.this;
        mContext = mActivity.getApplicationContext();

        mItemList = new ArrayList<>();
        mSearchList = new ArrayList<>();
    }

    private void initView() {
        setContentView(R.layout.activity_details_list);
        mSpeakButton = findViewById(R.id.mSpeakButton);
        mRecyclerContent = findViewById(R.id.rvContent);
        if (!AppConstant.LAYOUT_MANAGER){
            mRecyclerContent.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        }else{
            mRecyclerContent.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
        }
        initLoader();
        initToolbar(true);
        enableUpButton();
        setToolbarTitle(getString(R.string.search));
    }

    //TODO VALUE STRING
    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, How can I help you?");
        try {
            startActivityForResult(intent, AppConstant.REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry your device not supported",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void initFunctionality() {
        showLoader();
        ContentLoaderAdapter contentLoaderAdapter = new ContentLoaderAdapter();
        contentLoaderAdapter.loadData();
        parseJson(contentLoaderAdapter.getStringBuffer().toString());
        mAdapter = new DetailsAdapter(mContext, mActivity, mSearchList);
        mRecyclerContent.setAdapter(mAdapter);
    }

    public void initListener() {
        // Recent post list item click listener
        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, DetailsActivity.class, position, mSearchList, false);
            }
        });
        mSpeakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case AppConstant.REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchView.setQuery(result.get(0), true);
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
                }
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
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

    private void parseJson(String jsonData) {
        try {

            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(ContentConstant.JSON_KEY_ITEMS);

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);

                JSONArray jsonArray2 = jsonObj.getJSONArray(ContentConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);

                    JSONArray jsonArray3 = jsonObj2.getJSONArray(ContentConstant.JSON_KEY_DETAILS);
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
