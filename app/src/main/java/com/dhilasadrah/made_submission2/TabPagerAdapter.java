package com.dhilasadrah.made_submission2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class TabPagerAdapter extends FragmentStatePagerAdapter {

    private String[] title = new String[]{"Now Playing", "Upcoming"};

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return title[i];
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        switch (i) {
            case 0:
                fragment = new NowPlaying();
                break;
            case 1:
                fragment = new Upcoming();
                break;
            default:
                fragment = null;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
