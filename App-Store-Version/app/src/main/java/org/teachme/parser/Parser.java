package org.teachme.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.teachme.database.constant.AppConstant;
import org.teachme.models.content.Contents;
import org.teachme.models.content.Item;
import org.teachme.ui.MainActivity;

import java.util.ArrayList;

import static org.teachme.ui.BaseActivity.hideLoader;

public class Parser {

    private static String data;

    public Parser(String data) {
        Parser.data = data;
    }

    public static void work() {
        try {
            JSONObject jsonObjMain = new JSONObject(data);
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(AppConstant.JSON_KEY_ITEMS);

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);
                String title = jsonObj.getString(AppConstant.JSON_KEY_TITLE);
                ArrayList<Item> items = new ArrayList<>();
                JSONArray jsonArray2 = jsonObj.getJSONArray(AppConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);
                    String tag_line = jsonObj2.getString(AppConstant.JSON_KEY_TAG_LINE);

                    ArrayList<String> detailList = new ArrayList<>();

                    JSONArray jsonArray3 = jsonObj2.
                            getJSONArray(AppConstant.JSON_KEY_DETAILS);

                    for (int k = 0; k < jsonArray3.length(); k++) {
                        String details = jsonArray3.get(k).toString();
                        detailList.add(details);
                    }
                    items.add(new Item(tag_line, detailList));
                }
                MainActivity.mContentList.add(new Contents(title, items));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hideLoader();
        MainActivity.mAdapter.notifyDataSetChanged();
    }
}
