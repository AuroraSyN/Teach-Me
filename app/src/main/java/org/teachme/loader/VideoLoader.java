package org.teachme.loader;

import org.teachme.database.constant.AppConstant;
import org.teachme.ui.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VideoLoader {

    private StringBuffer stringBuffer = null;

    public void work() {
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
                    br = new BufferedReader(new InputStreamReader(Main.mContext.getAssets().open(AppConstant.COMPUTER_SCIENCE_VIDEO)));
                    break;
                case 2:
                    br = new BufferedReader(new InputStreamReader(Main.mContext.getAssets().open(AppConstant.SCRIPTS_VIDEO)));
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
