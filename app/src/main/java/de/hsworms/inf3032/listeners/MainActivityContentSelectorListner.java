package de.hsworms.inf3032.listeners;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.constant.AppConstant;

public class MainActivityContentSelectorListner implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
        Context mContext = v.getContext();
        MainActivity mainActivity = ((MainActivity) mContext);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);
        mainActivity.content_listWindow.dismiss();
        String selectedItemText = ((TextView) v).getText().toString();
        mainActivity.mContentSelectorButton.setText(selectedItemText);
        String selectedItemID = v.getTag().toString();

        switch (selectedItemText) {
            // ENGLISH
            case "Computer science":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Mobile Computing":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Linguistics":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            // RUSSIAN
            case "Мобильная информатика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Информатика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Лингвистика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            // GERMAN
            case "Angewandte Informatik":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Mobile Computing ":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;

            case "Sprachwissenschaft":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.mContentSelectorButton.setText(selectedItemText);
                break;
        }
    }

}