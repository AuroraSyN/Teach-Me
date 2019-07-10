package de.hsworms.inf3032.listeners;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextView;

import de.hsworms.inf3032.activity.QuestionsInterviewActivity;

public class InterviewQuestionsListner implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
        Context mContext = v.getContext();
        QuestionsInterviewActivity activity = ((QuestionsInterviewActivity) mContext);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
        fadeInAnimation.setDuration(10);
        v.startAnimation(fadeInAnimation);
        activity.listView.dismiss();
        String selectedItemText = ((TextView) v).getText().toString();
        String selectedItemTag = ((TextView) v).getTag().toString();
        activity.text.setText(selectedItemTag);
        activity.title.setText(selectedItemText);
    }
}
