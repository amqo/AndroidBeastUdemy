package com.example.alberto.beastmainproject.infrastructure;

import android.app.Application;

import com.example.alberto.beastmainproject.live.Module;
import com.firebase.client.Firebase;
import com.squareup.otto.Bus;

public class BeastApplication extends Application {
    private Bus bus;

    public static final String YOUTUBE_KEY = "AIzaSyCloaN1bDuAIjzGL-KU9I6-unu_IK3pS60";

    public static final String FIREBASE_BROTHER_REFERENCE = "https://beastandroidcourse-67c94.firebaseio.com/data/brothers";

    public BeastApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.register(this);
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }

    public Bus getBus() {
        return bus;
    }
}
