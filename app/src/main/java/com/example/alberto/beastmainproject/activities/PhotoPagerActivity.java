package com.example.alberto.beastmainproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.EventCard;
import com.example.alberto.beastmainproject.entities.EventPicture;
import com.example.alberto.beastmainproject.fragments.EventPhotoFragment;
import com.example.alberto.beastmainproject.services.EventPhotoService;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoPagerActivity extends BaseActivity {

    private ArrayList<EventPicture> mEventPhotos;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";

    @BindView(R.id.activity_photo_viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);
        ButterKnife.bind(this);

        int cardId = getIntent().getIntExtra(EXTRA_CARD_INFO, 0);
        switch(cardId) {
            case 1:
            case 2:
                bus.post(new EventPhotoService.SearchCommunityPhotosRequest("photos"));
                break;
            case 3:
            case 4:
                bus.post(new EventPhotoService.SearchBrotherHoodPhotosRequest("photos"));
                break;
            case 5:
            case 6:
                bus.post(new EventPhotoService.SearchSocialPhotosRequest("photos"));
                break;
        }

        setUpAdapter();
    }

    private void setUpAdapter() {
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture picture = mEventPhotos.get(position);
                return EventPhotoFragment.newInstance(picture);
            }

            @Override
            public int getCount() {
                return mEventPhotos.size();
            }
        });
    }

    @Subscribe
    public void getCommunityPhotos(EventPhotoService.SearchCommunityPhotosResponse response) {
        mEventPhotos = new ArrayList<>();
        mEventPhotos.addAll(response.communityPhotos);
    }

    @Subscribe
    public void getBrotherHoodPhotos(EventPhotoService.SearchBrotherHoodPhotosResponse response) {
        mEventPhotos = new ArrayList<>();
        mEventPhotos.addAll(response.brotherHoodPhotos);
    }

    @Subscribe
    public void getSocialPhotos(EventPhotoService.SearchSocialPhotosResponse response) {
        mEventPhotos = new ArrayList<>();
        mEventPhotos.addAll(response.socialPhotos);
    }

    public static Intent newIntent(Context context, EventCard eventCard) {
        Intent intent = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return intent;
    }

}
