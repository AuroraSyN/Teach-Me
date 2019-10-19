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

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.engine.Provider;
import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.preference.AppPreference;

public class MainActivityLanguageSelectorListner extends Provider implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
        String english = AppPreference.mContext.getApplicationContext().getString(R.string.mainmenu_English);
        String german = AppPreference.mContext.getApplicationContext().getString(R.string.mainmenu_German);
        String russian = AppPreference.mContext.getApplicationContext().getString(R.string.mainmenu_Russian);
        english = english.substring(0, english.length() - 3);
        german = german.substring(0, german.length() - 3);
        russian = russian.substring(0, russian.length() - 3);

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

        if (selectedItemText.equals(english)) {
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
        } else if (selectedItemText.equals(german)) {
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
        } else if (selectedItemText.equals(russian)) {
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
        }
    }

}