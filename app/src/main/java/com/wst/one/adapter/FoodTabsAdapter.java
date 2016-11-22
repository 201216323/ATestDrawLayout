package com.wst.one.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 12:00
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public class FoodTabsAdapter extends FragmentStatePagerAdapter {


    private ArrayList<String> mtitles;
    private List<Fragment> fragmentList;


    public FoodTabsAdapter(FragmentManager fm, ArrayList<String> mtitles, List<Fragment> fragmentList) {
        super(fm);
        this.mtitles = mtitles;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }

}
