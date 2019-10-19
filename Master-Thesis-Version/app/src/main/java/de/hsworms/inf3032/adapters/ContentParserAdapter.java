package de.hsworms.inf3032.adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hsworms.inf3032.data.constant.ContentConstant;
import de.hsworms.inf3032.models.content.Contents;
import de.hsworms.inf3032.models.content.Item;

import static de.hsworms.inf3032.activity.MainActivity.mAdapter;
import static de.hsworms.inf3032.activity.MainActivity.mContentList;
import static de.hsworms.inf3032.engine.Provider.hideLoader;

public class ContentParserAdapter {

    public static String jsonData;

    public ContentParserAdapter (String _jsonData){
        jsonData = _jsonData;
    }

    public static void parseJson() {
        try {
            JSONObject jsonObjMain = new JSONObject(jsonData);
            JSONArray jsonArray1 = jsonObjMain.
                    getJSONArray(ContentConstant.JSON_KEY_ITEMS);

            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObj = jsonArray1.getJSONObject(i);

                String title = jsonObj.getString
                        (ContentConstant.JSON_KEY_TITLE);

                ArrayList<Item> items = new ArrayList<>();

                JSONArray jsonArray2 = jsonObj.
                        getJSONArray(ContentConstant.JSON_KEY_CONTENT);

                for (int j = 0; j < jsonArray2.length(); j++) {
                    JSONObject jsonObj2 = jsonArray2.getJSONObject(j);
                    String tag_line = jsonObj2.
                            getString(ContentConstant.JSON_KEY_TAG_LINE);

                    ArrayList<String> detailList = new ArrayList<>();

                    JSONArray jsonArray3 = jsonObj2.
                            getJSONArray(ContentConstant.JSON_KEY_DETAILS);

                    for (int k = 0; k < jsonArray3.length(); k++) {
                        String details = jsonArray3.get(k).toString();
                        detailList.add(details);
                    }
                    items.add(new Item(tag_line, detailList));
                }
                mContentList.add(new Contents(title, items));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hideLoader();
        mAdapter.notifyDataSetChanged();
    }

}
