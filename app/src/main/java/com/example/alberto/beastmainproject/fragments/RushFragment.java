package com.example.alberto.beastmainproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alberto.beastmainproject.R;


public class RushFragment extends BaseFragment {

    public static RushFragment newInstance() {
        return new RushFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rush, container, false);
        return rootView;
    }
}
