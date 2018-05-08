package com.gtx.sj7.firestorechatapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gtx.sj7.firestorechatapp.AllUsersFragment;
import com.gtx.sj7.firestorechatapp.NotificationFragment;
import com.gtx.sj7.firestorechatapp.ProfileFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0: return new ProfileFragment();
            case 1: return new AllUsersFragment();
            case 2: return new NotificationFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
