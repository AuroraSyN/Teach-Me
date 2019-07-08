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