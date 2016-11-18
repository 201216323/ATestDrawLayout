package com.wst.one.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

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


    public FoodTabsAdapter(FragmentManager fm, ArrayList<String> mtitles) {
        super(fm);
        this.mtitles = mtitles;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mtitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }
}
