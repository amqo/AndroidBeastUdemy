package com.example.alberto.beastmainproject.infrastructure;

import android.app.Application;

import com.example.alberto.beastmainproject.inmemory.Module;
import com.squareup.otto.Bus;

public class BeastApplication extends Application {
    private Bus bus;

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
