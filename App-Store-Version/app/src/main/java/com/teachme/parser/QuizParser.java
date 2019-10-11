package com.teachme.parser;

import com.teachme.database.constant.AppConstant;
import com.teachme.loader.QuizLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuizParser {

    private QuizLoader quizLoader;

    private String question = null;
    private ArrayList<String> contents = null;
    private int correctAnswer = 0;
    private ArrayList<String> backgroundColors = null;

    public QuizParser(QuizLoader quizLoader) {
        this.quizLoader = quizLoader;
    }

    public void parse() {
        try {

            JSONObject jsonObjMain = new JSONObject(quizLoader.getStringBuffer().toString());
            JSONArray jsonArray = jsonObjMain.getJSONArray(AppConstant.JSON_KEY_QUESTIONNAIRY);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                question = jsonObj.getString(AppConstant.JSON_KEY_QUESTION);
                correctAnswer = Integer.parseInt(jsonObj.getString(AppConstant.JSON_KEY_CORRECT_ANS));

                JSONArray jsonArray2 = jsonObj.getJSONArray(AppConstant.JSON_KEY_ANSWERS);
                contents = new ArrayList<>();
                backgroundColors = new ArrayList<>();
                for (int j = 0; j < jsonArray2.length(); j++) {
                    String item_title = jsonArray2.get(j).toString();
                    contents.add(item_title);
                    backgroundColors.add(AppConstant.COLOR_WHITE);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public ArrayList<String> getContents() {
        return this.contents;
    }

    public ArrayList<String> getBackgroundColors() {
        return this.backgroundColors;
    }
}
