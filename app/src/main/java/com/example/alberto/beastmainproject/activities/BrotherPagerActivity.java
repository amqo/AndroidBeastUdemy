package com.example.alberto.beastmainproject.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.alberto.beastmainproject.R;
import com.example.alberto.beastmainproject.entities.Brother;
import com.example.alberto.beastmainproject.fragments.BrotherDetailFragment;
import com.example.alberto.beastmainproject.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrotherPagerActivity extends BaseActivity {

    private ArrayList<Brother> brothers;

    @BindView(R.id.activity_brother_viewPager)
    ViewPager brotherViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brother_pager);
        ButterKnife.bind(this);

        bus.post(new BrotherServices.SearchBrotherRequest("brothers"));

        setUpAdapter();
    }

    private void setUpAdapter() {
        brotherViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Brother brother = brothers.get(position);
                return BrotherDetailFragment.newInstance(brother);
            }

            @Override
            public int getCount() {
                return brothers.size();
            }
        });

        Brother firstBrother = getIntent().getParcelableExtra(PracticeActivity.BROTHER_EXTRA_INFO);
        int firstBrotherIndex = getBrotherIndexById(firstBrother.getBrotherId());
        brotherViewPager.setCurrentItem(firstBrotherIndex);
    }

    private int getBrotherIndexById(int id) {
        for (int i = 0; i < brothers.size(); ++i) {
            if (brothers.get(i).getBrotherId() == id) return i;
        }
        return 0;
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherResponse response) {
        brothers = new ArrayList<>();
        brothers.addAll(response.brothers);
    }

    public static Intent newIntent(Context context, Brother brother) {
        Intent intent = new Intent(context, BrotherPagerActivity.class);
        intent.putExtra(PracticeActivity.BROTHER_EXTRA_INFO, brother);
        return intent;
    }
}
