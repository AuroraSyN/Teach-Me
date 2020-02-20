package org.teachme.utility;

import android.app.Activity;

import org.teachme.database.constant.EnglishVideoURL;
import org.teachme.models.content.Item;
import org.teachme.ui.CustomUrl;
import org.teachme.ui.Details;

import java.util.ArrayList;

public class ItemUtilities {

    private Activity mActivity;
    private ArrayList<Item> mItemList;
    private Item model;
    private int position;

    public ItemUtilities(Activity mActivity, ArrayList<Item> mItemList, Item model, int position) {
        this.mActivity = mActivity;
        this.mItemList = mItemList;
        this.position = position;
        this.model = model;
    }

    public void work() {
        switch (mItemList.get(position).getTagLine()) {
            case "Connecting to SQL Server using SSMS - Part 1": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mItemList.get(position).getDetails().toString().substring(1,
                                mItemList.get(position).getDetails().toString().length() - 1),
                        EnglishVideoURL.DATABASE_URL_1, false);
            }
            break;
            case "Creating altering and dropping a database - Part 2": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mItemList.get(position).getDetails().toString().substring(1,
                                mItemList.get(position).getDetails().toString().length() - 1),
                        EnglishVideoURL.DATABASE_URL_2, false);
            }
            break;
            case "Creating and working with tables - Part 3": {
                ActivityUtilities.getInstance().invokeCustomUrlActivity(mActivity, CustomUrl.class,
                        mItemList.get(position).getDetails().toString().substring(1,
                                mItemList.get(position).getDetails().toString().length() - 1),
                        EnglishVideoURL.DATABASE_URL_3, false);

            }
            break;
            default: {
                ActivityUtilities.getInstance().invokeDetailsActiviy(mActivity, Details.class,
                        position, model.getDetails(), false);
            }
            break;
        }
    }
}
