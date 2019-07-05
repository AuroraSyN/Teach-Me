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
import de.hsworms.inf3032.data.constant.EnglishContentConstant;
import de.hsworms.inf3032.data.constant.GlobalContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.listeners.InterviewQuestionsListner;
import de.hsworms.inf3032.utility.ActivityUtilities;


public class InterviewQuestionsActivity extends BaseActivity {

    String popUpContents[];
    public PopupWindow listView;
    public Button selectButton;
    public TextView text, title;

    private String selectedItem = ".";
    private ListView mListView;
    private List<String> trees = null;
    List<String> contentList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview_questions);
        mListView = findViewById(R.id.lv1);
        initToolbar(true);
        setToolbarTitle(getString(R.string.interview_questions_title));
        enableUpButton();

        if (AppConstant.DEVICE_LANGUAGE_FLAG == true) {
            switch (AppPreference.getInstance(AppPreference.mContext).getLanguage()) {
                case "English":
                    trees = GlobalContentConstant.ENGLISH_INTERVIEW_TREE;
                    break;
                case "Russian":
                    trees = GlobalContentConstant.RUSSIAN_INTERVIEW_TREE;
                    break;
                case "German":
                    trees = GlobalContentConstant.GERMAN_INTERVIEW_TREE;
                    break;
            }
        }else{
            switch (Locale.getDefault().getLanguage()) {
                case "en":
                    trees = GlobalContentConstant.ENGLISH_INTERVIEW_TREE;
                    break;
                case "ru":
                    trees = GlobalContentConstant.RUSSIAN_INTERVIEW_TREE;
                    break;
                case "de":
                    trees = GlobalContentConstant.GERMAN_INTERVIEW_TREE;
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
        title = findViewById(R.id.interview_textView3);

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

    public void checkSelectedItem(){
        if(selectedItem != null ){
            contentList = new ArrayList<String>();
            int i = 0;
            switch (selectedItem){
                case "Java Interview Questions":
                    while (i <= EnglishContentConstant.JAVA_INERVIEW_QUESTIONS.length -1 ){
                        contentList.add(EnglishContentConstant.JAVA_INERVIEW_QUESTIONS[i]+ EnglishContentConstant._KEY_+EnglishContentConstant.JAVA_INERVIEW_QUESTIONS_A[i]);
                        i++;
                    } break;
                case "C++ Interview Questions":
                    while (i <= EnglishContentConstant.C_INERVIEW_QUESTIONS.length -1){
                        contentList.add(EnglishContentConstant.C_INERVIEW_QUESTIONS[i]+ EnglishContentConstant._KEY_+EnglishContentConstant.C_INERVIEW_QUESTIONS_A[i]);
                        i++;
                    } break;

                case "Operating System Questions":
                    while (i <= EnglishContentConstant.OS_INERVIEW_QUESTIONS.length -1){
                        contentList.add(EnglishContentConstant.OS_INERVIEW_QUESTIONS[i]+ EnglishContentConstant._KEY_+EnglishContentConstant.OS_INERVIEW_QUESTIONS_A[i]);
                        i++;
                    } break;
                case "DSA Interview Questions":
                    while (i <= EnglishContentConstant.DSA_INERVIEW_QUESTIONS.length -1){
                        contentList.add(EnglishContentConstant.DSA_INERVIEW_QUESTIONS[i]+ EnglishContentConstant._KEY_+EnglishContentConstant.DSA_INERVIEW_QUESTIONS_A[i]);
                        i++;
                    } break;
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