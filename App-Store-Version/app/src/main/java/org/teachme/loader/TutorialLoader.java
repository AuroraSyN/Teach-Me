package org.teachme.loader;

import org.teachme.database.constant.AppConstant;
import org.teachme.ui.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TutorialLoader {

    private StringBuffer stringBuffer = null;

    public void work() {
        this.stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {

                        /*
            if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(
                    MainActivity.mContext.getString(R.string.language_english)
            )) {
                switch (AppConstant.SELECTED_CONTENT) {
                    case 1: {
                        br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.COMPUTER_SCIENCE_INTERVIEW)));
                        break;
                    }
                    case 2: {
                        br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.SCRIPTS_JOURNEY_INTERVIEW)));
                        break;
                    }
                }
            } else if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(
                    MainActivity.mContext.getString(R.string.language_german)
            )) {

                // German

            } else if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(
                    MainActivity.mContext.getString(R.string.language_russian)
            )) {

                // Russian

            }
            */

            switch (AppConstant.SELECTED_CONTENT) {
                case 1:
                    br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.COMPUTER_SCIENCE_TUTORIAL)));
                    break;
                case 2:
                    br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.SCRIPTS_TUTORIAL)));
                    break;
            }
            String temp;
            while ((temp = br.readLine()) != null)
                stringBuffer.append(temp);
        } catch (IOException e) {
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
