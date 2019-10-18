package org.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

import org.teachme.R;
import org.teachme.database.constant.AppConstant;
import org.teachme.engine.Base;
import org.teachme.utility.ActivityUtilities;
import org.teachme.utility.AdsUtilities;

import java.util.Arrays;
import java.util.List;


public class QuizPrompt extends Base {

    private Activity mActivity;
    private Context mContext;
    private Button mBtnYes, mBtnNo;
    private ListView mListView;
    private List<String> quizTree = null;
    private ArrayAdapter<String> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVar();
        initView();
        initListener();
        initAdapter();
    }

    private void initVar() {
        mActivity = QuizPrompt.this;
        mContext = mActivity.getApplicationContext();
    }

    private void initView() {
        setContentView(R.layout.activity_quiz_prompt);
        mListView = findViewById(R.id.question_list_view);
        mBtnYes = findViewById(R.id.btn_yes);
        mBtnNo = findViewById(R.id.btn_no);

        initToolbar(true);
        setToolbarTitle(getString(R.string.quiz_prompt));
        enableUpButton();

        AdsUtilities.getInstance(mContext).showFullScreenAd();
        AdsUtilities.getInstance(mContext).showBannerAd((AdView) findViewById(R.id.adsView));
    }


    public void initListener() {
        mBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, Quiz.class, true);
            }
        });
        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, Main.class, true);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                AppConstant.SELECTED_QUEST = item;
                Toast.makeText(mContext, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initAdapter() {

        switch (AppConstant.SELECTED_CONTENT) {
            case 1: // Computer science
                quizTree = Arrays.asList(
                        getString(R.string.quest_selector_1),
                        getString(R.string.quest_selector_2),
                        getString(R.string.quest_selector_3)
                );
                break;
            case 2: // Javascript
                quizTree = Arrays.asList(
                        getString(R.string.quest_selector_1),
                        getString(R.string.quest_selector_2)
                );
                break;
        }

        adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                quizTree
        );
        mListView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, Main.class, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        ActivityUtilities.getInstance().invokeNewActivity(mActivity, Main.class, true);
    }

}
