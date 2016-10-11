package com.example.alberto.beastmainproject.services;

import com.example.alberto.beastmainproject.entities.RushEvent;

import java.util.List;

public class RushServices {

    private RushServices() {
    }

    public static class SearchRushEventsCommunityRequest {
        public String fireBaseUrl;

        public SearchRushEventsCommunityRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushEventsCommunityResponse {
        public List<RushEvent> communityRushEvents;
    }

    public static class SearchRushEventsSocialRequest {
        public String fireBaseUrl;

        public SearchRushEventsSocialRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushEventsSocialResponse {
        public List<RushEvent> socialRushEvents;
    }



}
