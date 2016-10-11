package com.example.alberto.beastmainproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.ActivityMaps;
import com.example.alberto.beastmainproject.activities.ActivityMapsCampus;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.entities.RushEvent;
import com.example.alberto.beastmainproject.services.RushServices;
import com.example.alberto.beastmainproject.views.adapters.RushEventAdapter;
import com.example.alberto.beastmainproject.views.viewHolders.RushItem;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RushFragment extends BaseFragment implements RushEventAdapter.RushEventListener {

    private RushEventAdapter adapter;
    private ArrayList<RushEvent> rushSocialEvents;
    private ArrayList<RushEvent> rushCommunityEvents;

    private RushItem social;
    private RushItem community;

    @BindView(R.id.fragment_rush_recyclerView)
    RecyclerView recyclerView;

    public static RushFragment newInstance() {
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush, container, false);
        ButterKnife.bind(this, rootView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rushSocialEvents = new ArrayList<>();
        rushCommunityEvents = new ArrayList<>();

        adapter = new RushEventAdapter((BaseActivity) getActivity(), this);

        List<RushItem> data = adapter.getData();

        social = new RushItem(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "Social Events");
        social.invisibleChildren = new ArrayList<>();
        community = new RushItem(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_HEADER, "Community Events");
        community.invisibleChildren = new ArrayList<>();

        bus.post(new RushServices.SearchRushEventsCommunityRequest("Rush"));
        bus.post(new RushServices.SearchRushEventsSocialRequest("Rush"));

        setUpAdapter();

        data.add(community);
        data.add(social);

        return rootView;
    }

    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onRushEventClicked(RushEvent rushEvent) {
        if (!rushEvent.isOnCampus()) {
            Intent intent = ActivityMaps.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        } else {
            Intent intent = ActivityMapsCampus.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        }
    }

    @Subscribe
    public void getRushSocialEvents(RushServices.SearchRushEventsSocialResponse response) {
        rushSocialEvents.clear();
        rushSocialEvents.addAll(response.socialRushEvents);

        for (RushEvent rushEvent: rushSocialEvents) {
            social.invisibleChildren.add(new RushItem(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }

    @Subscribe
    public void getRushCommunityEvents(RushServices.SearchRushEventsCommunityResponse response) {
        rushCommunityEvents.clear();
        rushCommunityEvents.addAll(response.communityRushEvents);

        for (RushEvent rushEvent: rushCommunityEvents) {
            community.invisibleChildren.add(new RushItem(RushEventAdapter.VIEW_TYPE_EXPANDABLE_LIST_CHILD, rushEvent));
        }
    }
}
