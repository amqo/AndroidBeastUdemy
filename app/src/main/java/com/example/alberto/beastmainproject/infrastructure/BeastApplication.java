package com.example.alberto.beastmainproject.infrastructure;

import android.app.Application;

import com.example.alberto.beastmainproject.inmemory.Module;
import com.squareup.otto.Bus;

public class BeastApplication extends Application {
    private Bus bus;

    public static final String YOUTUBE_KEY = "AIzaSyCloaN1bDuAIjzGL-KU9I6-unu_IK3pS60";

    public BeastApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
