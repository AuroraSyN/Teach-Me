package de.hsworms.inf3032.engine;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import de.hsworms.inf3032.R;
import de.hsworms.inf3032.activity.MainActivity;
import de.hsworms.inf3032.data.constant.GlobalContentConstant;
import de.hsworms.inf3032.data.preference.AppPreference;

public class SpeechEngine {

    private TextToSpeech mTextToSpeech;
    private Locale mLocale;
    private Activity mActivity;
    private boolean mIsInstallingPackage = false, mInstallerInvoked = false;
    private PlayStatusListener playStatusListener;

    public SpeechEngine(Activity activity) {
        mActivity = activity;
        if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(MainActivity.mContext.getResources().getString(R.string.ENGLISH))) {
            mLocale = new Locale(GlobalContentConstant.TTS_LOCALE_EN);
        } else if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(MainActivity.mContext.getResources().getString(R.string.GERMAN))) {
            mLocale = new Locale(GlobalContentConstant.TTS_LOCALE_DE);
        } else if (AppPreference.getInstance(MainActivity.mContext).getLanguage().equals(MainActivity.mContext.getResources().getString(R.string.RUSSIAN))) {
            mLocale = new Locale(GlobalContentConstant.TTS_LOCALE_RU);
        }
        //Default
        else {
            mLocale = new Locale(GlobalContentConstant.TTS_LOCALE_EN);
        }
    }

    public boolean hasPendingOperation() {
        return mIsInstallingPackage;
    }

    private void invokePacInstaller() {
        mIsInstallingPackage = true;

        if (!mInstallerInvoked) {
            try {
                Intent intent = new Intent();
                intent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                mActivity.startActivity(intent);
                mInstallerInvoked = true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void speak(String textForReading) {
        mIsInstallingPackage = false;
        mTextToSpeech.setLanguage(mLocale);

        int dividerLimit = 3750;
        if (textForReading.length() >= dividerLimit) {
            int textLength = textForReading.length();
            ArrayList<String> texts = new ArrayList<String>();
            int count = textLength / dividerLimit + ((textLength % dividerLimit == 0) ? 0 : 1);
            int start = 0;
            int end = textForReading.indexOf(" ", dividerLimit);
            for (int i = 1; i <= count; i++) {
                texts.add(textForReading.substring(start, end));
                start = end;
                if ((start + dividerLimit) < textLength) {
                    end = textForReading.indexOf(" ", start + dividerLimit);
                } else {
                    end = textLength;
                }
            }
            for (int i = 0; i < texts.size(); i++) {
                mTextToSpeech.speak(texts.get(i), TextToSpeech.QUEUE_ADD, null);
            }
        } else {
            mTextToSpeech.speak(textForReading, TextToSpeech.QUEUE_FLUSH, null);
        }

    }

    public void releaseEngine() {
        if (mTextToSpeech != null) {
            if (mTextToSpeech.isSpeaking()) {
                mTextToSpeech.stop();
            }
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        }
    }


    public void startEngine(final String text) {

        releaseEngine();
        if (mTextToSpeech == null) {
            mTextToSpeech = new TextToSpeech(mActivity.getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {

                    boolean isStarted = isLangPacAvailable(status);
                    if (isStarted) {
                        Toast.makeText(mActivity, mActivity.getApplicationContext().getResources().getString(R.string.tts_wait_msg), Toast.LENGTH_LONG).show();
                        speak(text);
                    } else {
                        invokePacInstaller();
                    }
                }
            });
        }
    }

    public boolean isSpeaking() {
        if (mTextToSpeech != null) {
            return mTextToSpeech.isSpeaking();
        }
        return false;
    }

    private boolean isLangPacAvailable(int initStatus) {
        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if (mTextToSpeech.isLanguageAvailable(mLocale) == TextToSpeech.LANG_AVAILABLE) {
                return true;
            } else {
                Toast.makeText(mActivity, mActivity.getApplicationContext().getResources().getString(R.string.tts_install_msg), Toast.LENGTH_LONG).show();
            }
        } else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(mActivity, mActivity.getApplicationContext().getResources().getString(R.string.failed), Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public interface PlayStatusListener {
        void onStart();

        void onDone();

        void onError();
    }

}
