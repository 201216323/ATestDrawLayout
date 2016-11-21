package com.wst.one.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wst.one.fragment.FoodDetailFragment;

import java.util.ArrayList;

import static com.wst.main.MainFragmentAdapter.VIEW_SIZE;

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
        switch (position) {
            case 0:
                FoodDetailFragment secondFragment0 = FoodDetailFragment.newInstance("", "");
                return secondFragment0;
            case 1:
                FoodDetailFragment secondFragment1 = FoodDetailFragment.newInstance("", "");
                return secondFragment1;
            case 2:
                FoodDetailFragment secondFragment2 = FoodDetailFragment.newInstance("", "");
                return secondFragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < VIEW_SIZE) {
            switch (position) {
                case 0:
                    return "张无忌";
                case 1:
                    return "范遥";
                case 2:
                    return "杨逍";

                default:
                    break;
            }
        }
        return null;
    }
}
