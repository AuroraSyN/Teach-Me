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

public class SelectorListner implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {

        // get the context and main activity to access variables
        Context mContext = v.getContext();
        MainActivity mainActivity = ((MainActivity) mContext);

        // add some animation when a list item was clicked
        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);

        // dismiss the pop up
        mainActivity.listWindow.dismiss();

        // get the text and set it as the button text
        String selectedItemText = ((TextView) v).getText().toString();
        mainActivity.contentSelector.setText(selectedItemText);

        // get the id
        String selectedItemID = v.getTag().toString();

        switch (selectedItemText){
                // ENGLISH
            case "Computer science":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Mobile Computing":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Linguistics":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

                // RUSSIAN
            case "Мобильная информатика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Информатика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Лингвистика":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

                // GERMAN
            case "Angewandte Informatik":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Mobile Computing ":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;

            case "Sprachwissenschaft":
                AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
                MainActivity.loadJson();
                mainActivity.contentSelector.setText(selectedItemText);
                break;
        }
    }

}