package com.example.alberto.beastmainproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.EventPicture;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.alberto.beastmainproject.activities.PhotoPagerActivity.EXTRA_CARD_INFO;

public class EventPhotoFragment extends BaseFragment {

    @BindView(R.id.fragment_event_picture_ImageView)
    ImageView imageView;

    @BindView(R.id.fragment_event_picture_ProgressBar)
    ProgressBar progressBar;


    private String photoUrl;

    public static EventPhotoFragment newInstance(EventPicture eventPicture) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CARD_INFO, eventPicture.getPictureUrl());
        EventPhotoFragment eventPhotoFragment = new EventPhotoFragment();
        eventPhotoFragment.setArguments(arguments);

        return eventPhotoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EXTRA_CARD_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_picture, container, false);
        ButterKnife.bind(this, rootView);

        Picasso.with(getActivity()).load(photoUrl)
                .fit()
                .centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;
    }
}
