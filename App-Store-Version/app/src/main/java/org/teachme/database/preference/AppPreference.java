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

        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals(AppConstant.PREF_NOTIFICATION)){
                    if (AppPreference.getInstance(mContext).isNotificationOn() == true){
                        Toast.makeText(mContext.getApplicationContext(),  mContext.getString(R.string.set_true),
                                Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(mContext.getApplicationContext(),  mContext.getString(R.string.set_false),
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (key.equals(AppConstant.PREF_WIDESCREEN)) {
                    if (AppPreference.getInstance(mContext).isWidescreenOn() == true){
                        AppConstant.WIDESCREEN_MODE = true;
                        Toast.makeText(mContext.getApplicationContext(),  mContext.getString(R.string.set_true) + "",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        AppConstant.WIDESCREEN_MODE = false;
                        Toast.makeText(mContext.getApplicationContext(),  mContext.getString(R.string.set_false),
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

    public static Context getContext() {
        return mContext;
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

    public boolean isWidescreenOn(){
        return mSettingsPreferences.getBoolean(AppConstant.PREF_WIDESCREEN,false);
    }

}
