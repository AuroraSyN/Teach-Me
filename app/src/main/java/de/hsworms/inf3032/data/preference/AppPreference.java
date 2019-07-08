package de.hsworms.inf3032.data.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.data.constant.AppConstant;

public class AppPreference{

    public static Context mContext;

    private static AppPreference mAppPreference = null;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    public static SharedPreferences.Editor mEditor;
    public static SharedPreferences mSettingsPreferences;

    private AppPreference() {
        mSharedPreferences = mContext.getSharedPreferences(PrefKey.APP_PREF_NAME, Context.MODE_PRIVATE);
        mSettingsPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        mEditor = mSharedPreferences.edit();
        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals("pref_language")){
                    AppConstant.DEVICE_LANGUAGE_FLAG = true;
                    Toast.makeText(AppPreference.mContext.getApplicationContext(),"done",
                            Toast.LENGTH_SHORT).show();
                }
                if (key.equals("pref_experimental")){
                    if (AppPreference.getInstance(AppPreference.mContext).isExperimentalOn() == true ){
                        AppConstant.LAYOUT_MANAGER = true;
                        Toast.makeText(AppPreference.mContext.getApplicationContext(),"done",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        AppConstant.LAYOUT_MANAGER = false;
                        Toast.makeText(AppPreference.mContext.getApplicationContext(),"done",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        mSettingsPreferences.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    public static AppPreference getInstance(Context context) {
        if (mAppPreference == null) {
            mContext = context;
            mAppPreference = new AppPreference();
        }
        return mAppPreference;
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

    public static String getLanguage() {
        return mSettingsPreferences.getString(AppConstant.PREF_LANGUAGE,
               null);
    }

    public boolean isLanguageSelectedOn() {
        return mSettingsPreferences.getBoolean(AppConstant.PREF_LANGUAGE_FLAG, false);
    }

    public boolean isExperimentalOn(){
        return mSettingsPreferences.getBoolean(AppConstant.PREF_EXPERIMENTAL, false);
    }

}
