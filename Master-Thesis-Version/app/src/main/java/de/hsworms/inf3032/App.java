package de.hsworms.inf3032;

import android.app.Application;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseMessaging.getInstance().subscribeToTopic("Teach-Me-Notification");
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    }
}
