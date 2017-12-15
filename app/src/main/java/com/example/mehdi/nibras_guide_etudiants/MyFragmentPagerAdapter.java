package com.example.mehdi.nibras_guide_etudiants;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by mehdi on 09/08/16.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

}