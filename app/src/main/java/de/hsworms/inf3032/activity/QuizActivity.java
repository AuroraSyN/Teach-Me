package de.hsworms.inf3032.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.adapters.QuizAdapter;
import de.hsworms.inf3032.adapters.QuizSelectAdapter;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.data.preference.PrefKey;
import de.hsworms.inf3032.listeners.ListItemClickListener;
import de.hsworms.inf3032.models.quiz.QuizModel;
import de.hsworms.inf3032.models.quiz.ResultModel;
import de.hsworms.inf3032.utility.ActivityUtilities;
import de.hsworms.inf3032.utility.BeatBox;
import de.hsworms.inf3032.utility.DialogUtilities;
import de.hsworms.inf3032.utility.SoundUtilities;

public class QuizActivity extends BaseActivity implements DialogUtilities.OnCompleteListener {

    ArrayList<String> mOptionList;
    ArrayList<String> mBackgroundColorList;
    private Activity mActivity;
    private Context mContext;
    private ImageButton mBtnSpeaker;
    private Button mBtnNext;
    private ImageView mImgFirstLife, mImgSecondLife, mImgThirdLife, mImgFourthLife, mImgFifthLife;
    private List<QuizModel> mItemList;
    private RecyclerView mRecyclerQuiz;
    private QuizAdapter mAdapter = null;
    private TextView mQuestionTextView;

    private int mQuestionPosition = 0;
    private int mScore = 0, mWrongAns = 0, mSkip = 0;
    private int mLifeCounter = 5;
    private boolean mUserHasPressed = false;
    private boolean mIsSkipped = false, mIsCorrect = false;
    private String mQuestionText, mGivenAnsText, mCorrectAnsText;
    private ArrayList<ResultModel> mResultList;

    private BeatBox mBeatBox;
    private List<SoundUtilities> mSounds;
    private boolean isSoundOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVar();
        initView();
        initFunctionality();
        initListener();
    }

    private void initVar() {
        mActivity = QuizActivity.this;
        mContext = mActivity.getApplicationContext();

        mItemList = new ArrayList<>();
        mOptionList = new ArrayList<>();
        mBackgroundColorList = new ArrayList<>();
        mResultList = new ArrayList<>();

        mBeatBox = new BeatBox(mActivity);
        mSounds = mBeatBox.getSounds();
    }

    private void initView() {
        setContentView(R.layout.activity_quiz);
        mImgFirstLife = findViewById(R.id.first_life);
        mImgSecondLife = findViewById(R.id.second_life);
        mImgThirdLife = findViewById(R.id.third_life);
        mImgFourthLife = findViewById(R.id.fourth_life);
        mImgFifthLife = findViewById(R.id.fifth_life);
        mBtnSpeaker = findViewById(R.id.btn_speaker);
        mBtnNext = findViewById(R.id.btn_next);
        mQuestionTextView = findViewById(R.id.question_text);
        mRecyclerQuiz = findViewById(R.id.rvQuiz);
        mRecyclerQuiz.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAdapter = new QuizAdapter(mContext, mActivity, mOptionList, mBackgroundColorList);
        mRecyclerQuiz.setAdapter(mAdapter);
    }

    private void initFunctionality() {
        loadData();
    }

    private void loadData() {
        showLoader();

        isSoundOn = AppPreference.getInstance(mActivity).getBoolean(PrefKey.KEY_SOUND, true);
        setSpeakerImage();

        loadJson();
    }

    private void setSpeakerImage() {
        if (isSoundOn) {
            mBtnSpeaker.setImageResource(R.drawable.ic_volume_high_white_48dp);
        } else {
            mBtnSpeaker.setImageResource(R.drawable.ic_volume_off_white_48dp);
        }
    }

    public void initListener() {
        mBtnSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSoundOn = !isSoundOn;
                AppPreference.getInstance(mActivity).setBoolean(PrefKey.KEY_SOUND, isSoundOn);
                setSpeakerImage();
            }
        });
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mUserHasPressed) {
                    FragmentManager manager = getSupportFragmentManager();
                    DialogUtilities dialog = DialogUtilities.newInstance(getString(R.string.skip_text), getString(R.string.skip_prompt), getString(R.string.yes), getString(R.string.no), AppConstant.BUNDLE_KEY_SKIP_OPTION);
                    dialog.show(manager, AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
                } else {
                    updateResultSet();
                    setNextQuestion();
                }
            }
        });

        mAdapter.setItemClickListener(new ListItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                if (!mUserHasPressed) {
                    int clickedAnswerIndex = position;
                    if (mItemList.get(mQuestionPosition).getCorrectAnswer() != -1) {
                        for (int currentItemIndex = 0; currentItemIndex < mOptionList.size(); currentItemIndex++) {
                            if (currentItemIndex == clickedAnswerIndex && currentItemIndex == mItemList.get(mQuestionPosition).getCorrectAnswer()) {
                                mBackgroundColorList.set(currentItemIndex, AppConstant.COLOR_GREEN);
                                mScore++;
                                mIsCorrect = true;
                                if (isSoundOn) {
                                    mBeatBox.play(mSounds.get(AppConstant.BUNDLE_KEY_ZERO_INDEX));
                                }
                            } else if (currentItemIndex == clickedAnswerIndex && !(currentItemIndex == mItemList.get(mQuestionPosition).getCorrectAnswer())) {
                                mBackgroundColorList.set(currentItemIndex, AppConstant.COLOR_RED);
                                mWrongAns++;
                                if (isSoundOn) {
                                    mBeatBox.play(mSounds.get(AppConstant.BUNDLE_KEY_SECOND_INDEX));
                                }
                                decreaseLifeAndStatus();
                            } else if (currentItemIndex == mItemList.get(mQuestionPosition).getCorrectAnswer()) {
                                mBackgroundColorList.set(currentItemIndex, AppConstant.COLOR_GREEN);
                                (mRecyclerQuiz.getLayoutManager()).scrollToPosition(currentItemIndex);
                            }
                        }
                    } else {
                        mBackgroundColorList.set(clickedAnswerIndex, AppConstant.COLOR_GREEN);
                        mScore++;
                        mIsCorrect = true;
                    }

                    mGivenAnsText = mItemList.get(mQuestionPosition).getAnswers().get(clickedAnswerIndex);
                    mCorrectAnsText = mItemList.get(mQuestionPosition).getAnswers().get(mItemList.get(mQuestionPosition).getCorrectAnswer());

                    mUserHasPressed = true;
                    mAdapter.notifyDataSetChanged();
                }
            }

        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void decreaseLifeAndStatus() {
        mLifeCounter--;
        setLifeStatus();
    }

    void increaseLifeAndStatus() {
        if (mLifeCounter < AppConstant.BUNDLE_KEY_MAX_LIFE) {
            mLifeCounter = AppConstant.BUNDLE_KEY_MAX_LIFE;
            setLifeStatus();
        }
    }

    public void setLifeStatus() {
        switch (mLifeCounter) {
            case 1:
                mImgFirstLife.setVisibility(View.VISIBLE);
                mImgSecondLife.setVisibility(View.GONE);
                mImgThirdLife.setVisibility(View.GONE);
                mImgFourthLife.setVisibility(View.GONE);
                mImgFifthLife.setVisibility(View.GONE);
                break;
            case 2:
                mImgFirstLife.setVisibility(View.VISIBLE);
                mImgSecondLife.setVisibility(View.VISIBLE);
                mImgThirdLife.setVisibility(View.GONE);
                mImgFourthLife.setVisibility(View.GONE);
                mImgFifthLife.setVisibility(View.GONE);
                break;
            case 3:
                mImgFirstLife.setVisibility(View.VISIBLE);
                mImgSecondLife.setVisibility(View.VISIBLE);
                mImgThirdLife.setVisibility(View.VISIBLE);
                mImgFourthLife.setVisibility(View.GONE);
                mImgFifthLife.setVisibility(View.GONE);
                break;
            case 4:
                mImgFirstLife.setVisibility(View.VISIBLE);
                mImgSecondLife.setVisibility(View.VISIBLE);
                mImgThirdLife.setVisibility(View.VISIBLE);
                mImgFourthLife.setVisibility(View.VISIBLE);
                mImgFifthLife.setVisibility(View.GONE);
                break;
            case 5:
                mImgFirstLife.setVisibility(View.VISIBLE);
                mImgSecondLife.setVisibility(View.VISIBLE);
                mImgThirdLife.setVisibility(View.VISIBLE);
                mImgFourthLife.setVisibility(View.VISIBLE);
                mImgFifthLife.setVisibility(View.VISIBLE);
                break;
            default:
                mImgFirstLife.setVisibility(View.GONE);
                mImgSecondLife.setVisibility(View.GONE);
                mImgThirdLife.setVisibility(View.GONE);
                mImgFourthLife.setVisibility(View.GONE);
                mImgFifthLife.setVisibility(View.GONE);
                break;
        }
    }

    public void updateResultSet() {
        mResultList.add(new ResultModel(mQuestionText, mGivenAnsText, mCorrectAnsText, mIsCorrect, mIsSkipped));
        mIsCorrect = false;
        mIsSkipped = false;
    }

    public void setNextQuestion() {
        if (isSoundOn) {
            mBeatBox.play(mSounds.get(AppConstant.BUNDLE_KEY_FIRST_INDEX));
        }
        mUserHasPressed = false;
        if (mQuestionPosition < mItemList.size() - 1 && mLifeCounter > 0) {
            mQuestionPosition++;
            updateQuestionsAndAnswers();
        } else if (mQuestionPosition < mItemList.size() - 1 && mLifeCounter == 0) {
            FragmentManager manager = getSupportFragmentManager();
            DialogUtilities dialog = DialogUtilities.newInstance(null, null, getString(R.string.yes), getString(R.string.no), AppConstant.BUNDLE_KEY_REWARD_OPTION);
            dialog.show(manager, AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
        } else {
            ActivityUtilities.getInstance().invokeScoreCardActivity(mActivity, ScoreCardActivity.class, mScore, mWrongAns, mSkip, mResultList, true);
        }
    }

    public void updateQuestionsAndAnswers() {
        mOptionList.clear();
        mBackgroundColorList.clear();
        (mRecyclerQuiz.getLayoutManager()).scrollToPosition(AppConstant.BUNDLE_KEY_ZERO_INDEX);

        mOptionList.addAll(mItemList.get(mQuestionPosition).getAnswers());
        mBackgroundColorList.addAll(mItemList.get(mQuestionPosition).getBackgroundColors());
        mAdapter.notifyDataSetChanged();

        mQuestionTextView.setText(Html.fromHtml(mItemList.get(mQuestionPosition).getQuestion()));
        mQuestionText = mItemList.get(mQuestionPosition).getQuestion();
    }

    public void quizActivityClosePrompt() {
        FragmentManager manager = getSupportFragmentManager();
        DialogUtilities dialog = DialogUtilities.newInstance(getString(R.string.exit), getString(R.string.quiz_close_prompt), getString(R.string.yes), getString(R.string.no), AppConstant.BUNDLE_KEY_CLOSE_OPTION);
        dialog.show(manager, AppConstant.BUNDLE_KEY_DIALOG_FRAGMENT);
    }

    //TODO CONTENT
    private void loadJson() {
        QuizSelectAdapter quizSelectAdapter = new QuizSelectAdapter();
        StringBuffer sb = quizSelectAdapter.getStringBuffer();
        parseJson(sb.toString());
    }

    public void parseJson(String jsonData) {
        try {

            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObjMain.getJSONArray(ContentConstant.JSON_KEY_QUESTIONNAIRY);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                String question = jsonObj.getString(ContentConstant.JSON_KEY_QUESTION);
                int correctAnswer = Integer.parseInt(jsonObj.getString(ContentConstant.JSON_KEY_CORRECT_ANS));

                JSONArray jsonArray2 = jsonObj.getJSONArray(ContentConstant.JSON_KEY_ANSWERS);
                ArrayList<String> contents = new ArrayList<>();
                ArrayList<String> backgroundColors = new ArrayList<>();
                for (int j = 0; j < jsonArray2.length(); j++) {
                    String item_title = jsonArray2.get(j).toString();
                    contents.add(item_title);
                    backgroundColors.add(AppConstant.COLOR_WHITE);
                }
                mItemList.add(new QuizModel(question, contents, correctAnswer, backgroundColors));
                Collections.shuffle(mItemList);
            }

            hideLoader();
            updateQuestionsAndAnswers();

        } catch (JSONException e) {
            e.printStackTrace();
            showEmptyView();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                quizActivityClosePrompt();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        quizActivityClosePrompt();
    }

    @Override
    public void onComplete(Boolean isOkPressed, String viewIdText) {
        if (isOkPressed) {
            if (viewIdText.equals(AppConstant.BUNDLE_KEY_CLOSE_OPTION)) {
                ActivityUtilities.getInstance().invokeNewActivity(mActivity, MainActivity.class, true);
            } else if (viewIdText.equals(AppConstant.BUNDLE_KEY_SKIP_OPTION)) {
                mSkip++;
                mIsSkipped = true;
                mGivenAnsText = getResources().getString(R.string.skipped_text);
                mCorrectAnsText = mItemList.get(mQuestionPosition).getAnswers().get(mItemList.get(mQuestionPosition).getCorrectAnswer());
                updateResultSet();
                setNextQuestion();
            }
        } else if (!isOkPressed && viewIdText.equals(AppConstant.BUNDLE_KEY_REWARD_OPTION)) {
            ActivityUtilities.getInstance().invokeScoreCardActivity(mActivity, ScoreCardActivity.class, mScore, mWrongAns, mSkip, mResultList, true);
        }
    }
}
