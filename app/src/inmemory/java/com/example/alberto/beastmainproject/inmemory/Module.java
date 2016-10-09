package com.example.alberto.beastmainproject.inmemory;

import com.example.alberto.beastmainproject.infrastructure.BeastApplication;

public class Module {
    public static void register(BeastApplication application) {
        new InMemoryBrotherService(application);
        new InMemoryCardsService(application);
        new InMemmoryPictureService(application);
    }
}
