package org.teachme.database.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.teachme.R;
import org.teachme.database.constant.AppConstant;

public class AppPreference {

    public static SharedPreferences mSharedPreferences;
    public static SharedPreferences.Editor mEditor;
    private static Context mContext;
    private static AppPreference mAppPreference = null;
    private SharedPreferences mSettingsPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    private AppPreference() {
        mSharedPreferences = mContext.getSharedPreferences(PrefKey.APP_PREF_NAME, Context.MODE_PRIVATE);
        mSettingsPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();

        initListener();
    }

    public static AppPreference getInstance(Context context) {
        if (mAppPreference == null) {
            mContext = context;
            mAppPreference = new AppPreference();
        }
        return mAppPreference;
    }

    public static Context getContext() {
        return mContext;
    }

    private void initListener() {
        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

                if (key.equals(AppConstant.PREF_NOTIFICATION)) {
                    if (AppPreference.getInstance(mContext).isNotificationOn()) {
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.notification_true),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.notification_false),
                                Toast.LENGTH_SHORT).show();
                    }
                }

                if (key.equals(AppConstant.PREF_WIDESCREEN)) {
                    if (AppPreference.getInstance(mContext).isWidescreenOn()) {
                        AppConstant.WIDESCREEN_MODE = true;
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.widescreen_true),
                                Toast.LENGTH_SHORT).show();

                    } else {
                        AppConstant.WIDESCREEN_MODE = false;
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.widescreen_false),
                                Toast.LENGTH_SHORT).show();
                    }
                }

                if (key.equals(AppConstant.PREF_FONT_SIZE)) {
                    if (AppPreference.getInstance(mContext).getTextSize().equals(mContext.getResources().getString(R.string.small_text))) {
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.textsize_small),
                                Toast.LENGTH_SHORT).show();
                    }
                    if (AppPreference.getInstance(mContext).getTextSize().equals(mContext.getResources().getString(R.string.default_text))) {
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.textsize_normal),
                                Toast.LENGTH_SHORT).show();
                    }
                    if (AppPreference.getInstance(mContext).getTextSize().equals(mContext.getResources().getString(R.string.large_text))) {
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.textsize_large),
                                Toast.LENGTH_SHORT).show();
                    }
                }

                if (key.equals(AppConstant.PREF_LANGUAGE)) {
                    if (AppPreference.getInstance(mContext).getLanguage().equals(mContext.getResources().getString(R.string.language_english))) {
                        AppConstant.LANGUAGE = mContext.getString(R.string.language_english);
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.language_english),
                                Toast.LENGTH_SHORT).show();
                    }
                    if (AppPreference.getInstance(mContext).getLanguage().equals(mContext.getResources().getString(R.string.language_german))) {
                        AppConstant.LANGUAGE = mContext.getString(R.string.language_german);
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.language_german),
                                Toast.LENGTH_SHORT).show();
                    }
                    if (AppPreference.getInstance(mContext).getLanguage().equals(mContext.getResources().getString(R.string.language_russian))) {
                        AppConstant.LANGUAGE = mContext.getString(R.string.language_russian);
                        Toast.makeText(mContext.getApplicationContext(), mContext.getString(R.string.language_russian),
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        };
        mSettingsPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, null);
    }

    public void setBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    public boolean isNotificationOn() {
        return mSettingsPreferences.getBoolean(AppConstant.PREF_NOTIFICATION, true);
    }

    public String getTextSize() {
        return mSettingsPreferences.getString(AppConstant.PREF_FONT_SIZE, mContext.getResources().getString(R.string.default_text));
    }

    public boolean isWidescreenOn() {
        return mSettingsPreferences.getBoolean(AppConstant.PREF_WIDESCREEN, false);
    }

    public String getLanguage() {
        return mSettingsPreferences.getString(AppConstant.PREF_LANGUAGE, mContext.getResources().getString(R.string.default_language));
    }

}
