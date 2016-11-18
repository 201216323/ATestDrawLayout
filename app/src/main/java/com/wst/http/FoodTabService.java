package com.wst.http;

import com.wst.one.module.FoodTabModule;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 13:57
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:食物详情的页
 */

public interface FoodTabService {
    @GET("/api/cook/classify")
    Call<FoodTabModule> getFoodTab();
}
