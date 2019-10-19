package org.teachme.loader;

import android.content.Context;

import org.teachme.R;
import org.teachme.database.constant.AppConstant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizLoader {

    private Context mContext;
    private StringBuffer stringBuffer = null;

    public QuizLoader(Context mContext) {
        this.mContext = mContext;
    }

    public void load() {
        this.stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {

                        /*
            if (AppPreference.getInstance(Main.mContext).getLanguage().equals(
                    Main.mContext.getString(R.string.language_english)
            )) {
                switch (AppConstant.SELECTED_CONTENT) {
                    case 1: {
                        br = new BufferedReader(new InputStreamReader(Main.mContext.getAssets().open(AppConstant.COMPUTER_SCIENCE_INTERVIEW)));
                        break;
                    }
                    case 2: {
                        br = new BufferedReader(new InputStreamReader(Main.mContext.getAssets().open(AppConstant.SCRIPTS_JOURNEY_INTERVIEW)));
                        break;
                    }
                }
            } else if (AppPreference.getInstance(Main.mContext).getLanguage().equals(
                    Main.mContext.getString(R.string.language_german)
            )) {

                // German

            } else if (AppPreference.getInstance(Main.mContext).getLanguage().equals(
                    Main.mContext.getString(R.string.language_russian)
            )) {

                // Russian

            }
            */

            switch (AppConstant.SELECTED_CONTENT) {
                case 1:
                    if (AppConstant.SELECTED_QUEST.equals(mContext.getString(R.string.quest_selector_1))) {
                        br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(AppConstant.QUESTION1)));
                    } else if (AppConstant.SELECTED_QUEST.equals(mContext.getString(R.string.quest_selector_2))) {
                        br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(AppConstant.QUESTION2)));
                    } else if (AppConstant.SELECTED_QUEST.equals(mContext.getString(R.string.quest_selector_3))) {
                        br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(AppConstant.QUESTION3)));
                    }
                    break;
                case 2:
                    if (AppConstant.SELECTED_QUEST.equals(mContext.getString(R.string.quest_selector_1))) {
                        br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(AppConstant.QUESTION1)));
                    } else if (AppConstant.SELECTED_QUEST.equals(mContext.getString(R.string.quest_selector_2))) {
                        br = new BufferedReader(new InputStreamReader(mContext.getAssets().open(AppConstant.QUESTION2)));
                    }
                    break;
            }

            String temp;
            while ((temp = br.readLine()) != null)
                stringBuffer.append(temp);
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public StringBuffer getStringBuffer() {
        return this.stringBuffer;
    }

}
