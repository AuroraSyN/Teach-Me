package com.teachme.loader;

import com.teachme.database.constant.AppConstant;
import com.teachme.ui.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VideoLoader {

    private StringBuffer stringBuffer = null;

    public void load() {
        this.stringBuffer = new StringBuffer();
        BufferedReader br = null;
        try {
            switch (AppConstant.SELECTED_CONTENT) {
                case 1:
                    br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.COMPUTER_SCIENCE_VIDEO)));
                    break;
                case 2:
                    br = new BufferedReader(new InputStreamReader(MainActivity.mContext.getAssets().open(AppConstant.SCRIPTS_VIDEO)));
                    break;
            }
            String temp;
            while ((temp = br.readLine()) != null)
                stringBuffer.append(temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public StringBuffer getStringBuffer() {
        return this.stringBuffer;
    }

}
