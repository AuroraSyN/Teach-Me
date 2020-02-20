package org.teachme.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.teachme.R;
import org.teachme.utility.ActivityUtilities;


public class Splash extends AppCompatActivity {

    // Constants
    private static final int SPLASH_DURATION = 450;
    private Context mContext;
    private Activity mActivity;
    private ImageView mImageView;
    private Animation mAnimation_1;
    private ProgressBar mProgressBar;
    private RelativeLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initVar();
        initView();
    }

    private void initVar() {
        mContext = getApplicationContext();
        mActivity = Splash.this;
    }

    private void initView() {
        setContentView(R.layout.activity_splash);
        mProgressBar = findViewById(R.id.progressBar);
        mRootLayout = findViewById(R.id.splashBody);
        mImageView = findViewById(R.id.splashIcon);
        mAnimation_1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        mImageView.setVisibility(View.GONE);
    }

    private void initFunctionality() {
        mRootLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                mImageView.startAnimation(mAnimation_1);
                mAnimation_1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        ActivityUtilities.getInstance().invokeNewActivity(mActivity, Main.class, true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, SPLASH_DURATION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initFunctionality();
    }
}

