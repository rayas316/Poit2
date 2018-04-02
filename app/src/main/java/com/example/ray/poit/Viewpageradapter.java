package com.example.ray.poit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by ray on 2018/04/02.
 */

public abstract class Viewpageradapter extends FragmentStatePagerAdapter {
    private SparseArray<Fragment>registerFragments = new SparseArray<Fragment>();
    public Viewpageradapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Object instantiateItem(ViewGroup container,int position){
        Fragment fragment = (Fragment)super.instantiateItem(container,position);
        registerFragments.put(position,fragment);
        return fragment;
    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        registerFragments.remove(position);
        super.destroyItem(container,position,object);
    }
    public Fragment getRegisteredFragment(int position){
        return registerFragments.get(position);
    }
}