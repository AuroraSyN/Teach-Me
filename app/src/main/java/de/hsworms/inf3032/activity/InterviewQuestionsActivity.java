package de.hsworms.inf3032.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.EnglishConstant;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.data.trees.EnglishTree;
import de.hsworms.inf3032.data.trees.GermanTree;
import de.hsworms.inf3032.data.trees.RussianTree;
import de.hsworms.inf3032.listeners.InterviewQuestionsListner;
import de.hsworms.inf3032.utility.ActivityUtilities;


public class InterviewQuestionsActivity extends BaseActivity {

    public PopupWindow listView;
    public Button selectButton;
    public TextView text, title;
    String popUpContents[];
    List<String> contentList = null;
    private String selectedItem = ".";
    private ListView mListView;
    private List<String> trees = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_questions);
        mListView = findViewById(R.id.lv1);
        initToolbar(true);
        setToolbarTitle(getString(R.string.interview_questions_title));
        enableUpButton();

        if (AppConstant.DEVICE_LANGUAGE_FLAG == true) {
            switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                case 1:
                    if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.english))) {
                        trees = EnglishTree.CS_ENGLISH_INTERVIEW_TREE;
                    } else if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.german))) {
                        trees = GermanTree.CS_GERMAN_INTERVIEW_TREE;
                    } else if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.russian))) {
                        trees = RussianTree.CS_RUSSIAN_INTERVIEW_TREE;
                    }
                    break;
                case 2:
                    if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.english))) {
                        trees = EnglishTree.MC_ENGLISH_INTERVIEW_TREE;
                    } else if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.german))) {
                        trees = GermanTree.MC_GERMAN_INTERVIEW_TREE;
                    } else if (AppPreference.getInstance(AppPreference.mContext).getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.russian))) {
                        trees = RussianTree.MC_RUSSIAN_INTERVIEW_TREE;
                    }
                    break;
            }
        } else {
            switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                case 1:
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        trees = EnglishTree.CS_ENGLISH_INTERVIEW_TREE;
                    } else if (Locale.getDefault().getLanguage().equals("de")) {
                        trees = GermanTree.CS_GERMAN_INTERVIEW_TREE;
                    } else if (Locale.getDefault().getLanguage().equals("ru")) {
                        trees = RussianTree.CS_RUSSIAN_INTERVIEW_TREE;
                    }
                    break;
                case 2:
                    if (Locale.getDefault().getLanguage().equals("en")) {
                        trees = EnglishTree.MC_ENGLISH_INTERVIEW_TREE;
                    } else if (Locale.getDefault().getLanguage().equals("de")) {
                        trees = GermanTree.MC_GERMAN_INTERVIEW_TREE;
                    } else if (Locale.getDefault().getLanguage().equals("ru")) {
                        trees = RussianTree.MC_RUSSIAN_INTERVIEW_TREE;
                    }
                    break;
            }
        }
        initListView();
    }

    private void initListView() {
        contentList = new ArrayList<String>();
        popUpContents = new String[contentList.size()];
        contentList.toArray(popUpContents);
        listView = popupWindow();

        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.inteview_questions_selectButton:
                        listView.showAsDropDown(v, -5, 0);
                        break;
                }
            }
        };

        selectButton = findViewById(R.id.inteview_questions_selectButton);
        selectButton.setOnClickListener(handler);
        text = findViewById(R.id.interview_textView);
        title = findViewById(R.id.interview_interview_question_title);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, trees);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                selectedItem = item;
                checkSelectedItem();
                selectButton.setVisibility(View.VISIBLE);
                Toast.makeText(AppPreference.mContext, item, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void checkSelectedItem() {
        if (selectedItem != null) {
            contentList = new ArrayList<String>();
            short counter = 0;
            if (selectedItem.equals("Java Interview Questions")) {
                while (counter <= EnglishTree.JAVA_INERVIEW_QUESTIONS.length - 1) {
                    contentList.add(EnglishTree.JAVA_INERVIEW_QUESTIONS[counter] + EnglishConstant._KEY_ + EnglishTree.JAVA_INERVIEW_QUESTIONS_A[counter]);
                    counter++;
                }
            } else if (selectedItem.equals("C++ Interview Questions")) {
                while (counter <= EnglishTree.C_INERVIEW_QUESTIONS.length - 1) {
                    contentList.add(EnglishTree.C_INERVIEW_QUESTIONS[counter] + EnglishConstant._KEY_ + EnglishTree.C_INERVIEW_QUESTIONS_A[counter]);
                    counter++;
                }
            } else if (selectedItem.equals("Operating System Questions")) {
                while (counter <= EnglishTree.OS_INERVIEW_QUESTIONS.length - 1) {
                    contentList.add(EnglishTree.OS_INERVIEW_QUESTIONS[counter] + EnglishConstant._KEY_ + EnglishTree.OS_INERVIEW_QUESTIONS_A[counter]);
                    counter++;
                }
            } else if (selectedItem.equals("DSA Interview Questions")) {
                while (counter <= EnglishTree.DSA_INERVIEW_QUESTIONS.length - 1) {
                    contentList.add(EnglishTree.DSA_INERVIEW_QUESTIONS[counter] + EnglishConstant._KEY_ + EnglishTree.DSA_INERVIEW_QUESTIONS_A[counter]);
                    counter++;
                }
            }
            popUpContents = new String[contentList.size()];
            contentList.toArray(popUpContents);
            listView = popupWindow();
        }
    }

    public PopupWindow popupWindow() {
        PopupWindow popupWindow = new PopupWindow(this);
        ListView _listView = new ListView(this);
        _listView.setAdapter(listViewAdapter(popUpContents));
        _listView.setOnItemClickListener(new InterviewQuestionsListner());
        popupWindow.setFocusable(true);
        popupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(_listView);
        return popupWindow;
    }

    private ArrayAdapter<String> listViewAdapter(String array[]) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];
                TextView listItem = new TextView(InterviewQuestionsActivity.this);
                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(20);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);
                return listItem;
            }
        };
        return adapter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(MainActivity.mActivity, MainActivity.class, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}