package com.me.simplehabit.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.me.simplehabit.fragments.OnTheGoFragment;
import com.me.simplehabit.fragments.SeriesFragment;
import com.me.simplehabit.fragments.TeachersFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return OnTheGoFragment.getInstance();
        }else if (position==1){
            return SeriesFragment.getInstance();
        }else {
            return TeachersFragment.getInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "ON THE GO";
        }else if (position==1){
            return "SERIES";
        }else {
            return "TEACHERS";
        }
    }
}
