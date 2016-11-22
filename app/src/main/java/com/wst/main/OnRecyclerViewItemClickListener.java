package com.wst.main;

import android.view.View;

import com.wst.one.module.FoodListModule;

/**
 * Created by: BruceChang
 * Date on : 2016/11/22.
 * Time on: 15:41
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public interface OnRecyclerViewItemClickListener {

    void onItemClick(View view , FoodListModule.TngouBean data);
}
