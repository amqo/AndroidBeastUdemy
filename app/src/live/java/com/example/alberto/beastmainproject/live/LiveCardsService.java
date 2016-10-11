package com.example.alberto.beastmainproject.live;

import com.example.alberto.beastmainproject.entities.EventCard;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.EventCardServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class LiveCardsService extends BeastLiveService {

    public LiveCardsService(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void postCommunityServiceCards(EventCardServices.SearchCommunityServiceCardsRequest request) {
        EventCardServices.SearchCommunityServiceCardsResponse response =
                new EventCardServices.SearchCommunityServiceCardsResponse();
        response.communityServiceCards = new ArrayList<>();

        for (int i = 1; i < 3; ++i) {
            response.communityServiceCards.add(
                    new EventCard(i,
                            "Community Event " + i,
                            "Community Event Description " + i,
                            "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                            false, "j7HfxgQdDW4")
            );
        }

        bus.post(response);
    }

    @Subscribe
    public void postBrotherHoodCards(EventCardServices.SearchBrotherHoodServiceCardsRequest request) {
        EventCardServices.SearchBrotherHoodCardsResponse response =
                new EventCardServices.SearchBrotherHoodCardsResponse();
        response.brotherHoodCards = new ArrayList<>();

        for (int i = 3; i < 5; ++i) {
            response.brotherHoodCards.add(
                    new EventCard(i,
                            "BrotherHood Event " + i,
                            "BrotherHood Event Description " + i,
                            "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                            i == 4, "j7HfxgQdDW4")
            );
        }

        bus.post(response);
    }

    @Subscribe
    public void postSocialCards(EventCardServices.SearchSocialServiceCardsRequest request) {
        EventCardServices.SearchSocialCardsResponse response =
                new EventCardServices.SearchSocialCardsResponse();
        response.socialeCards = new ArrayList<>();

        for (int i = 5; i < 7; ++i) {
            response.socialeCards.add(
                    new EventCard(i,
                            "Social Event " + i,
                            "Social Event Description " + i,
                            "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                            false, "j7HfxgQdDW4")
            );
        }

        bus.post(response);
    }
}
