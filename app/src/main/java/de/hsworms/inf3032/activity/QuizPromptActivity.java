package de.hsworms.inf3032.activity;

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

import java.util.List;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.utility.ActivityUtilities;

public class QuizPromptActivity extends BaseActivity {

    public static String selectedItem;
    private Activity mActivity;
    private Context mContext;
    private Button mBtnYes, mBtnNo;
    //Selector
    private ListView mListView;
    private List<String> trees = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initListener();
    }

    private void initVar() {
        mActivity = QuizPromptActivity.this;
        mContext = mActivity.getApplicationContext();
    }

    private void initView() {
        setContentView(R.layout.activity_quiz_prompt);

        mBtnYes = findViewById(R.id.btn_yes);
        mBtnNo = findViewById(R.id.btn_no);

        mListView = findViewById(R.id.lv);

        initToolbar(true);
        setToolbarTitle(getString(R.string.site_menu_quiz));
        enableUpButton();
        initLoader();

        initToolbar(true);
        setToolbarTitle(getString(R.string.quiz_prompt));
        enableUpButton();

        switch (AppPreference.getInstance(mContext).getLanguage()) {
            case "English":
                trees = ContentConstant.ENGLISH_TREE;
                break;
            case "Russian":
                trees = ContentConstant.RUSSIAN_TREE;
                break;
            case "German":
                trees = ContentConstant.GERMAN_TREE;
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, trees);

        mListView.setAdapter(adapter);

        // Set a click listener for ListView items
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get selected item text
                String item = (String) adapterView.getItemAtPosition(i);
                selectedItem = item;
                // Display the selected item
                Toast.makeText(mContext, item, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void initListener() {
        mBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, QuizActivity.class, true);
            }
        });
        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, MainActivity.class, true);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, MainActivity.class, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        ActivityUtilities.getInstance().invokeNewActivity(mActivity, MainActivity.class, true);
    }

}
