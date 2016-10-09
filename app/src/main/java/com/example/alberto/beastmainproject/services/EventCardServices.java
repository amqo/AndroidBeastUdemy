package com.example.alberto.beastmainproject.services;

import com.example.alberto.beastmainproject.entities.EventCard;

import java.util.List;

public class EventCardServices {

    private EventCardServices() {
    }

    public static class SearchCommunityServiceCardsRequest {
        public String fireBaseUrl;

        public SearchCommunityServiceCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCommunityServiceCardsResponse {
        public List<EventCard> communityServiceCards;
    }

    public static class SearchBrotherHoodServiceCardsRequest {
        public String fireBaseUrl;

        public SearchBrotherHoodServiceCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchBrotherHoodCardsResponse {
        public List<EventCard> brotherHoodCards;
    }

    public static class SearchSocialServiceCardsRequest {
        public String fireBaseUrl;

        public SearchSocialServiceCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchSocialCardsResponse {
        public List<EventCard> socialeCards;
    }
}
