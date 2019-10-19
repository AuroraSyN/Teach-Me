package de.hsworms.inf3032.adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hsworms.inf3032.activity.QuestionActivity;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.models.quiz.QuizModel;

import static de.hsworms.inf3032.activity.QuestionActivity.updateQuestionsAndAnswers;
import static de.hsworms.inf3032.engine.Provider.hideLoader;

public class QuizParserAdapter {

    String jsonData;

    public QuizParserAdapter(String _jsonData){
        jsonData = _jsonData;
    }

    public void parseJson() {
        try {
            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObjMain.getJSONArray
                    (ContentConstant.JSON_KEY_QUESTIONNAIRY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                String question = jsonObj.getString(
                        ContentConstant.JSON_KEY_QUESTION);

                int correctAnswer = Integer.parseInt
                        (jsonObj.getString
                                (ContentConstant.JSON_KEY_CORRECT_ANS));

                JSONArray jsonArray2 = jsonObj.getJSONArray
                        (ContentConstant.JSON_KEY_ANSWERS);

                ArrayList<String> contents = new ArrayList<>();
                ArrayList<String> backgroundColors = new ArrayList<>();

                for (int j = 0; j < jsonArray2.length(); j++) {
                    String item_title = jsonArray2.get(j).toString();
                    contents.add(item_title);
                    backgroundColors.add(AppConstant.COLOR_WHITE);
                }
                QuestionActivity.mItemList.add(new QuizModel
                        (question, contents, correctAnswer, backgroundColors));
                Collections.shuffle(QuestionActivity.mItemList);
            }
            hideLoader();
            updateQuestionsAndAnswers();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
