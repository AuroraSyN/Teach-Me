package org.teachme.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.teachme.database.constant.AppConstant;
import org.teachme.models.content.Item;

import java.util.ArrayList;

public class Parser {

    private String data;
    private String title;
    private ArrayList<Item> items = null;

    public Parser(String data) {
        this.data = data;
    }

    public void parse() {
        try {
            JSONObject jsonObjMain = new JSONObject(this.data);
            JSONArray jsonArray1 = jsonObjMain.getJSONArray(AppConstant.JSON_KEY_ITEMS);

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);

                this.title = jsonObj.getString(AppConstant.JSON_KEY_TITLE);
                items = new ArrayList<>();
                JSONArray jsonArray2 = jsonObj.getJSONArray(AppConstant.JSON_KEY_CONTENT);
                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);

                    String tag_line = jsonObj2.getString(AppConstant.JSON_KEY_TAG_LINE);

                    ArrayList<String> detailList = new ArrayList<>();
                    JSONArray jsonArray3 = jsonObj2.getJSONArray(AppConstant.JSON_KEY_DETAILS);
                    for (int k = 0; k < jsonArray3.length(); k++) {
                        String details = jsonArray3.get(k).toString();
                        detailList.add(details);
                    }
                    items.add(new Item(tag_line, detailList));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

}
