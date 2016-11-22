package com.wst.http.service;

import com.wst.one.module.FoodListModule;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 13:57
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:食物详情的页
 */

public interface FoodService {
    @FormUrlEncoded
    @POST("/api/cook/list")
    Call<FoodListModule> getFoodList(@Field("id") String id, @Field("page") int page, @Field("rows") int rows);

}
