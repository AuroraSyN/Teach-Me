package org.teachme.ui;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.KeyEvent;
import android.view.MenuItem;

import org.teachme.R;
import org.teachme.engine.Base;
import org.teachme.utility.ActivityUtilities;


public class Settings extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(R.id.content, new MyPreferenceFragment()).commit();
        initToolbar(true);
        setToolbarTitle(getString(R.string.settings));
        enableUpButton();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ActivityUtilities.getInstance().invokeNewActivity(Main.mActivity, Main.class, true);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                ActivityUtilities.getInstance().invokeNewActivity(Main.mActivity, Main.class, true);
                finish();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
        }
    }
}