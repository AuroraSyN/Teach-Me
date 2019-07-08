package de.hsworms.inf3032.listeners;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import java.util.Locale;

import de.hsworms.inf3032.activity.BaseActivity;
import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.preference.AppPreference;
import de.hsworms.inf3032.utility.ActivityUtilities;

public class MainActivityLanguageSelectorListner extends BaseActivity implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
        Context mContext = v.getContext();
        MainActivity mainActivity = ((MainActivity) mContext);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);
        mainActivity.language_listWindow.dismiss();
        String selectedItemText = ((TextView) v).getText().toString();
        mainActivity.mLanguageSelectorButton.setText(selectedItemText);
        String selectedItemID = v.getTag().toString();

        String lang = "";
        Locale locale = new Locale(lang);
        Configuration config = new Configuration();

        switch (selectedItemText){
            case "English":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "English");
                AppPreference.mEditor.apply();
                lang = "en";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "German":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "German");
                AppPreference.mEditor.apply();
                lang = "de";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Russian":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Russian");
                AppPreference.mEditor.apply();
                lang = "ru";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Englisch":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "English");
                AppPreference.mEditor.apply();
                lang = "en";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Deutsch":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Deutsch");
                AppPreference.mEditor.apply();
                lang = "de";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Russisch":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Russisch");
                AppPreference.mEditor.apply();
                lang = "ru";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Английский":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Английский");
                AppPreference.mEditor.apply();
                lang = "en";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Немецкий":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Немецкий");
                AppPreference.mEditor.apply();
                lang = "de";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
            case "Русский":
                AppPreference.mEditor = AppPreference.mSettingsPreferences.edit();
                AppPreference.mEditor.putString("pref_language", "Русский");
                AppPreference.mEditor.apply();
                lang = "ru";
                locale = new Locale(lang);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                AppPreference.mContext.getApplicationContext().getResources().updateConfiguration(config,
                        AppPreference.mContext.getApplicationContext().getResources().getDisplayMetrics());
                MainActivity.loadJson();
                break;
        }
    }

}