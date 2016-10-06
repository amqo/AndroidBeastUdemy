package com.example.alberto.beastmainproject.inmemory;

import com.example.alberto.beastmainproject.entities.Brother;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryBrotherService extends BaseInMemory {

    public InMemoryBrotherService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void postBrothers(BrotherServices.SearchBrotherRequest request) {
        BrotherServices.SearchBrotherResponse response = new BrotherServices.SearchBrotherResponse();
        response.brothers = new ArrayList<>();

        for (int i = 0; i < 32; ++i) {
            response.brothers.add(new Brother(
                    i,
                    "Brother " + i,
                    "Brother " + i + " joined for that",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Mechanical Engineering",
                    "Spring 2013",
                    "Whatever"
            ));
        }

        bus.post(response);
    }
}
