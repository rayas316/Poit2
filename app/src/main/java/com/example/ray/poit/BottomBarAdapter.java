package com.example.ray.poit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ray on 2018/04/02.
 */

public class BottomBarAdapter extends Viewpageradapter {
    private final List <Fragment> fragments = new ArrayList<>();

    public BottomBarAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    public void addFragments(Fragment fragment){
        fragments.add(fragment);
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
