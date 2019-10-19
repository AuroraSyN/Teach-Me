package de.hsworms.inf3032.adapters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.engine.Provider;
import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;

public class ContentLoaderAdapter extends Provider {

    StringBuffer stringBuffer;

    public ContentLoaderAdapter() {
        loadData();
    }

    public void loadData() {
        stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {
            if (AppConstant.DEVICE_LANGUAGE_FLAG == true) {
                switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                    case 1:
                        if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.english))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_EN)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.en));
                        } else if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.german))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_DE)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.de));
                        } else if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.russian))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_RU)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.ru));
                        }
                        break;
                    case 2:
                        if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.english))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_EN)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.en));
                        } else if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.german))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_RU)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.de));
                        } else if (AppPreference.getLanguage().equals(AppPreference.mContext.getApplicationContext().getString(R.string.russian))) {
                            br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_DE)));
                            MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.ru));
                        }
                        break;
                }
                String temp;
                while ((temp = br.readLine()) != null)
                    stringBuffer.append(temp);
            } else {
                AppPreference.getInstance(MainActivity.mContext).getLanguage();
                switch (AppConstant.CONTENT_SELECTOR_FLAG) {
                    case 1:
                        switch (Locale.getDefault().getLanguage()) {
                            case "en":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_EN)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.en));
                                break;
                            case "de":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_DE)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.de));
                                break;
                            case "ru":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.COMPUTER_SCINCE_CONTENT_FILE_RU)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.ru));
                                break;
                        }
                        break;
                    case 2:
                        switch (Locale.getDefault().getLanguage()) {
                            case "en":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_EN)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.en));
                                break;
                            case "de":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_DE)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.de));
                                break;
                            case "ru":
                                br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(ContentConstant.MATHS_CONTENT_FILE_RU)));
                                MainActivity.mLanguageSelectorButton.setText(AppPreference.mContext.getString(R.string.ru));
                                break;
                        }
                        break;
                }
                String temp;
                while ((temp = br.readLine()) != null)
                    stringBuffer.append(temp);
            }
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
