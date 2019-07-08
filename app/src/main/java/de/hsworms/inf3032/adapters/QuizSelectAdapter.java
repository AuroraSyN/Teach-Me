package de.hsworms.inf3032.adapters;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import de.hsworms.inf3032.activity.BaseActivity;
import de.hsworms.inf3032.activity.DetailsActivity;
import de.hsworms.inf3032.activity.QuestionSelectActivity;
import de.hsworms.inf3032.data.constant.EnglishConstant;
import de.hsworms.inf3032.data.constant.GermanConstant;
import de.hsworms.inf3032.data.constant.RussianConstant;
import de.hsworms.inf3032.data.preference.AppPreference;

public class QuizSelectAdapter extends BaseActivity {

    public StringBuffer sb;

    public QuizSelectAdapter() {
        loadJson();
    }

    private void loadJson() {
        sb = new StringBuffer();
        BufferedReader br = null;
        try {
            //SMAL TEST
            if (DetailsActivity.currentItem != null) {
                switch (DetailsActivity.currentItem) {
                    /*
                    case "C++ Overview":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_OVERVIEW)));
                        DetailsActivity.currentItem = null;
                        break;

                    case "C++ Environment Setup":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_ENVIRONMENT_SETUP)));
                        DetailsActivity.currentItem = null;
                        break;

                    case "C++ Basic Syntax":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_BASIS_SYNTAX)));
                        DetailsActivity.currentItem = null;
                        break;

                    //CONTENT FROM BIG_DE_1
                    case "Objekte":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.OBJEKTE)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Klassen":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.KLASSEN)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Objektlebenszyklus":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.OBJEKTLEBENSZYKLUS)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Vererbung":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.VERERBUNG)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Interfaces":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.INTERFACES)));
                        DetailsActivity.currentItem = null;
                        break;

                    //CONTENT FROM BIG_DE_1
                    case "Objekte C++":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.SMALL_6)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Klassen C++":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.SMALL_7)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Objektlebenszyklus C++":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.SMALL_8)));
                        DetailsActivity.currentItem = null;
                        break;
                    case "Vererbung C++":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.SMALL_9)));
                        DetailsActivity.currentItem = null;
                        break;
                    */

                    default:
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_OVERVIEW)));
                        DetailsActivity.currentItem = null;
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Kein Test", Toast.LENGTH_LONG);
                        toast.show();
                }
            } else { // BIG TEST
                switch (QuestionSelectActivity.selectedItem) {
                    //English
                    case "C++ Basics":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_BASICS)));
                        break;
                    case "C++ Object Oriented":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.C_OBJECT_ORIENTED)));
                        break;
                    case "Operating System":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.OPERATING_SYSTEM)));
                        break;
                    case "Java 9":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.JAVA_9)));
                        break;
                    case "Java Basics":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.JAVA_BASICS)));
                        break;
                    case "Java Advanced":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.JAVA_ADVANCED)));
                        break;
                    case "DSA Basics":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.DSA_ADVANCED)));
                        break;
                    case "DSA Advanced":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(EnglishConstant.DSA_ADVANCED)));
                        break;

                    //German
                    case "Objektorientiertes Programmieren in Java":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.JAVA_PROG)));
                        break;
                    case "Objektorientiertes Programmieren mit C++":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(GermanConstant.C_PROG)));
                        break;

                    //Russian
                    case "  ":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(RussianConstant.BIG_1)));
                        break;
                    case "   ":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(RussianConstant.BIG_2)));
                        break;
                    case "    ":
                        br = new BufferedReader(new InputStreamReader(AppPreference.mContext.getAssets().open(RussianConstant.BIG_3)));
                        break;


                    default:
                        br = new BufferedReader(new InputStreamReader(getAssets().open(EnglishConstant.C_BASICS)));
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Error, -> QuestionSelectActivity.selectedItem", Toast.LENGTH_SHORT);
                        toast.show();
                }
            }
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
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
        return sb;
    }
}
