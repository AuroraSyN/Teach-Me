package de.hsworms.inf3032.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.GlobalContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;

public class ContentLoaderAdapter {

    StringBuffer stringBuffer;

    public ContentLoaderAdapter(){
        loadData();
    }

    public void loadData(){
        stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {
            if (AppConstant.DEVICE_LANGUAGE_FLAG == true) {
                switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                    case 1:
                        switch (AppPreference.getInstance(MainActivity.mContext).getLanguage()) {
                            case "English":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_EN)));
                                break;
                            case "Russian":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_RU)));
                                break;
                            case "German":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                    case 2:
                        switch (AppPreference.getInstance(MainActivity.mContext).getLanguage()) {
                            case "English":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_EN)));
                                break;
                            case "Russian":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_RU)));
                                break;
                            case "German":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                    case 3:
                        switch (AppPreference.getInstance(MainActivity.mContext).getLanguage()) {
                            case "English":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_EN)));
                                break;
                            case "Russian":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_RU)));
                                break;
                            case "German":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                }
                String temp;
                while ((temp = br.readLine()) != null)
                    stringBuffer.append(temp);
            }else{
                AppPreference.getInstance(MainActivity.mContext).getLanguage();
                switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                    case 1:
                        switch (Locale.getDefault().getLanguage()) {
                            case "en":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_EN)));
                                break;
                            case "ru":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_RU)));
                                break;
                            case "de":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.COMPUTER_SCINCE_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                    case 2:
                        switch (Locale.getDefault().getLanguage()) {
                            case "en":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_EN)));
                                break;
                            case "ru":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_RU)));
                                break;
                            case "de":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.MATHS_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                    case 3:
                        switch (Locale.getDefault().getLanguage()) {
                            case "en":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_EN)));
                                break;
                            case "ru":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_RU)));
                                break;
                            case "de":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GlobalContentConstant.LINGUISTICS_CONTENT_FILE_DE)));
                                break;
                        }
                        break;
                }
                String temp;
                while ((temp = br.readLine()) != null)
                    stringBuffer.append(temp);
            }
        }
            catch(IOException e){
                e.printStackTrace();
            } finally{
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }

    public StringBuffer getStringBuffer(){
        return this.stringBuffer;
    }

}
