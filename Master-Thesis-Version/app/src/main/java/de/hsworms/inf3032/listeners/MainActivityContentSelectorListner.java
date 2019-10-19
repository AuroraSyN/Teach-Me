package de.hsworms.inf3032.listeners;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.constant.AppConstant;
import de.hsworms.inf3032.data.preference.AppPreference;

public class MainActivityContentSelectorListner implements OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
        String computer_science = AppPreference.mContext.getApplicationContext().getString(R.string.computer_science);
        String mobile_computing = AppPreference.mContext.getApplicationContext().getString(R.string.mobile_computing);
        computer_science = computer_science.substring(0, computer_science.length() - 3);
        mobile_computing = mobile_computing.substring(0, mobile_computing.length() - 3);
        Context mContext = v.getContext();
        MainActivity mainActivity = ((MainActivity) mContext);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);
        mainActivity.content_listWindow.dismiss();
        String selectedItemText = ((TextView) v).getText().toString();
        String selectedItemID = v.getTag().toString();
        mainActivity.mContentSelectorButton.setText(selectedItemText);
        if (selectedItemText.equals(computer_science)) {
            AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
            MainActivity.loadJson();
            mainActivity.mContentSelectorButton.setText(selectedItemText);
        } else if (selectedItemText.equals(mobile_computing)) {
            AppConstant.CONTENT_SELECTOR_FLAG = Short.parseShort(selectedItemID);
            MainActivity.loadJson();
            mainActivity.mContentSelectorButton.setText(selectedItemText);
        }
    }
}