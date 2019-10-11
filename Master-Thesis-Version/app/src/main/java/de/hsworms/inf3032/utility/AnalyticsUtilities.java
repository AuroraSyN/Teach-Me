package de.hsworms.inf3032.utility;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class AnalyticsUtilities {

    private static AnalyticsUtilities mAnalyticsUtilities;
    private FirebaseAnalytics mFirebaseAnalytics;

    private AnalyticsUtilities(Context context) {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public static AnalyticsUtilities getAnalyticsUtils(Context context) {
        if (mAnalyticsUtilities == null) {
            mAnalyticsUtilities = new AnalyticsUtilities(context);
        }
        return mAnalyticsUtilities;
    }

    public void trackEvent(String activityName) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, activityName);
        mFirebaseAnalytics.logEvent("PAGE_VISIT", bundle);
    }

}
