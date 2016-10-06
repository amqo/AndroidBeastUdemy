package com.example.alberto.beastmainproject.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alberto.beastmainproject.fragments.AboutUsFragment;
import com.example.alberto.beastmainproject.fragments.MeetABroFragment;
import com.example.alberto.beastmainproject.fragments.RushFragment;

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_TABS = 3;

    private static final int ABOUT_US_TAB = 0;
    private static final int MEET_BRO_TAB = 1;
    private static final int RUSH_TAB = 2;

    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case ABOUT_US_TAB:
                return AboutUsFragment.newInstance();
            case MEET_BRO_TAB:
                return MeetABroFragment.newInstance();
            case RUSH_TAB:
                return RushFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case ABOUT_US_TAB:
                return "About Us";
            case MEET_BRO_TAB:
                return "Meet a Bro";
            case RUSH_TAB:
                return "Rush";
            default:
                return null;
        }
    }
}
