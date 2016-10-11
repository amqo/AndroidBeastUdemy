package com.example.alberto.beastmainproject.live;

import com.example.alberto.beastmainproject.entities.RushEvent;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.RushServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveRushService extends BeastLiveService {

    public LiveRushService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void postCommunityRushEvents(RushServices.SearchRushEventsCommunityRequest request) {
        RushServices.SearchRushEventsCommunityResponse response =
                new RushServices.SearchRushEventsCommunityResponse();

        response.communityRushEvents = new ArrayList<>();
        response.communityRushEvents.add(new RushEvent(
           1, "Rush Community Event 1",
                "Date", "Time", "Location", 41.385064, 2.173403,
                false, "Description"
        ));
        response.communityRushEvents.add(new RushEvent(
                2, "Rush Community Event 2",
                "Date", "Time", "Location", 41.385064, 2.173403,
                false, "Description"
        ));

        bus.post(response);
    }

    @Subscribe
    public void postSocialRushEvents(RushServices.SearchRushEventsSocialRequest request) {
        RushServices.SearchRushEventsSocialResponse response =
                new RushServices.SearchRushEventsSocialResponse();

        response.socialRushEvents = new ArrayList<>();
        response.socialRushEvents.add(new RushEvent(
                1, "Rush Social Event 1",
                "Date", "Time", "Location", 41.385064, 2.173403,
                true, "Description"
        ));
        response.socialRushEvents.add(new RushEvent(
                2, "Rush Social Event 2",
                "Date", "Time", "Location", 41.385064, 2.173403,
                true, "Description"
        ));

        bus.post(response);
    }


}
