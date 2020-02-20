package org.teachme.utility;

import android.app.Activity;

import org.teachme.database.constant.EnglishVideoURL;
import org.teachme.ui.CustomUrl;
import org.teachme.ui.Details;

import java.util.ArrayList;

public class SearchUtilities {

    private Activity mActivity;
    private ArrayList<String> mSearchList;
    private int position;

    public SearchUtilities(Activity mActivity, ArrayList<String> mSearchList, int position) {
        this.mActivity = mActivity;
        this.mSearchList = mSearchList;
        this.position = position;
    }

    public void work() {
        switch (mSearchList.get(position)) {
            case "Connecting to SQL Server using SSMS - Part 1": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mSearchList.get(position), EnglishVideoURL.DATABASE_URL_1, false);
            }
            break;
            case "Creating altering and dropping a database - Part 2": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mSearchList.get(position), EnglishVideoURL.DATABASE_URL_2, false);
            }
            break;
            case "Creating and working with tables - Part 3": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mSearchList.get(position), EnglishVideoURL.DATABASE_URL_3, false);
            }
            break;

            default: {
                ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, Details.class, position, mSearchList, false);
            }
            break;
        }
    }

}
