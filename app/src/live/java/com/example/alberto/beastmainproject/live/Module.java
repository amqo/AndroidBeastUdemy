package com.example.alberto.beastmainproject.live;

import com.example.alberto.beastmainproject.infrastructure.BeastApplication;

public class Module {
    public static void register(BeastApplication application) {
        new LiveBrotherService(application);
        new LiveCardsService(application);
        new LivePictureService(application);
        new LiveRushService(application);
    }
}
