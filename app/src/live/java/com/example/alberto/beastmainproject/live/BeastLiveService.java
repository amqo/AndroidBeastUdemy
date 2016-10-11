package com.example.alberto.beastmainproject.live;

import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.otto.Bus;

public class BeastLiveService {

    protected Bus bus;
    protected BeastApplication application;
    protected final DatabaseReference databaseReference;

//    public static final String FIREBASE_REFERENCE = "https://beastandroidcourse-67c94.firebaseio.com/";

    public BeastLiveService(BeastApplication application) {
        this.application = application;
        bus = application.getBus();
        bus.register(this);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}
