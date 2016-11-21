package com.wst.http.service;

import com.wst.one.module.FoodTabModule;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator
 * Date:2016/11/21
 * Time:22:23
 * Author:BruceChang
 * Function:
 */

public interface FoodTabService {

    @GET("/api/cook/classify")
    Call<FoodTabModule> getFoodTab();
}
