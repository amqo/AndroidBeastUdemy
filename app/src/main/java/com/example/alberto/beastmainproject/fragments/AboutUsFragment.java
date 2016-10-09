package com.example.alberto.beastmainproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.activities.PhotoPagerActivity;
import com.example.alberto.beastmainproject.activities.YoutubeActivity;
import com.example.alberto.beastmainproject.entities.EventCard;
import com.example.alberto.beastmainproject.services.EventCardServices;
import com.example.alberto.beastmainproject.views.adapters.AboutUsAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutUsFragment extends BaseFragment implements AboutUsAdapter.AboutUsListener {

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> brotherHoodCards;
    private ArrayList<EventCard> socialCards;

    private AboutUsAdapter adapter;

    @BindView(R.id.fragment_about_us_recyclerView)
    RecyclerView recyclerView;

    public static AboutUsFragment newInstance() {
        return new AboutUsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this, rootView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();
        bus.post(new EventCardServices.SearchBrotherHoodServiceCardsRequest("brotherHoodCards"));
        bus.post(new EventCardServices.SearchCommunityServiceCardsRequest("communityCards"));
        bus.post(new EventCardServices.SearchSocialServiceCardsRequest("serviceCards"));

        return rootView;
    }

    private void setUpAdapter() {
        adapter = new AboutUsAdapter(this, (BaseActivity) getActivity());
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnEventCardClicked(EventCard eventCard) {
        if (eventCard.isVideo()) {
            Intent intent = YoutubeActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        } else {
            Intent intent = PhotoPagerActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        }
    }

    @Subscribe
    public void getBrotherHoodCards(EventCardServices.SearchBrotherHoodCardsResponse response) {
        brotherHoodCards = new ArrayList<>();
        brotherHoodCards.addAll(response.brotherHoodCards);
        adapter.setBrotherHoodEventCards(brotherHoodCards);
    }

    @Subscribe
    public void getSocialCards(EventCardServices.SearchSocialCardsResponse response) {
        socialCards = new ArrayList<>();
        socialCards.addAll(response.socialeCards);
        adapter.setSocialEventCards(socialCards);
    }

    @Subscribe
    public void getCommunityCards(EventCardServices.SearchCommunityServiceCardsResponse response) {
        serviceCards = new ArrayList<>();
        serviceCards.addAll(response.communityServiceCards);
        adapter.setCommunityServiceEventCards(serviceCards);
    }
}
