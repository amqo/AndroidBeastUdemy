package com.example.alberto.beastmainproject.inmemory;

import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseInMemory {

    protected final Bus bus;
    protected final BeastApplication application;

    public BaseInMemory(BeastApplication application) {
        this.application = application;
        this.bus = this.application.getBus();
        bus.register(this);
    }
}
