package com.example.alberto.beastmainproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.activities.BaseActivity;
import com.example.alberto.beastmainproject.activities.BrotherPagerActivity;
import com.example.alberto.beastmainproject.entities.Brother;
import com.example.alberto.beastmainproject.infrastructure.BeastApplication;
import com.example.alberto.beastmainproject.services.BrotherServices;
import com.example.alberto.beastmainproject.views.adapters.MeetABroAdapter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeetABroFragment extends BaseFragment implements MeetABroAdapter.OnBrotherClickListener {

    private static final String LOG_TAG = MeetABroFragment.class.getSimpleName();

    private MeetABroAdapter adapter;
    private ArrayList<Brother> brothers;

    @BindView(R.id.fragment_meet_a_bro_RecyclerView)
    RecyclerView recyclerView;

    public static MeetABroFragment newInstance() {
        return new MeetABroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_bro, container, false);
        ButterKnife.bind(this, rootView);

        brothers = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        bus.post(new BrotherServices.SearchBrotherRequest(BeastApplication.FIREBASE_BROTHER_REFERENCE));

        return rootView;
    }

    private void setUpAdapter() {
        adapter = new MeetABroAdapter(this, (BaseActivity) getActivity());
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onBrotherClicked(Brother brother) {
        Intent intent = BrotherPagerActivity.newIntent(getActivity(), brother);
        startActivity(intent);
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response) {
        if (brothers.isEmpty()) {
            brothers.addAll(response.brothers);
            adapter.setBrothers(brothers);
            adapter.notifyDataSetChanged();
        }
    }

}
