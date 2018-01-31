package com.example.cheatman.myapplication.newcode.adapter;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cheatman on 2018/1/18.
 */

public class HomeFragmentPageAdapter<T extends Fragment> extends FragmentPagerAdapter {
    private List<T> mFragmentList;
    private String[] mStrings;

    /**
     * @param fm
     * @param list
     * @param titles PageTitles
     */
    public HomeFragmentPageAdapter(FragmentManager fm, String[] titles, T ... list) {
        super(fm);
        mFragmentList = new ArrayList<>();
        for (T item : list) {
            mFragmentList.add(item);
        }
        mStrings = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStrings == null ? super.getPageTitle(position) : mStrings[position];
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //如果注释这行，那么不管怎么切换，page都不会被销毁
        super.destroyItem(container, position, object);
    }
}