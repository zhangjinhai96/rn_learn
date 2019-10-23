package com.rn_learn.bootpage;

import android.view.View;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BootAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments=null;

    public BootAdapter(FragmentManager fm ,List<Fragment> list) {
        super(fm);
        fragments=list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
