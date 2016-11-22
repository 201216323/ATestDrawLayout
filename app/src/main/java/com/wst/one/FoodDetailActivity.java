package com.wst.one;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.one.module.FoodListModule;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by: BruceChang
 * Date on : 2016/11/22.
 * Time on: 15:33
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public class FoodDetailActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgPic)
    ImageView imgPic;
    @BindView(R.id.tvFoodName)
    TextView tvFoodName;
    @BindView(R.id.tvFoodKeyWord)
    TextView tvFoodKeyWord;
    @BindView(R.id.tvFoodFood)
    TextView tvFoodFood;
    @BindView(R.id.tvFoodDesc)
    TextView tvFoodDesc;
    Intent mIntent;
    FoodListModule.TngouBean mTngouBean;
    private String img;
    private String description;
    private String food;
    private String keywords;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mIntent = getIntent();
        mTngouBean = (FoodListModule.TngouBean) mIntent.getSerializableExtra("bean");
        img = mTngouBean.getImg();
        description = mTngouBean.getDescription();
        food = mTngouBean.getFood();
        keywords = mTngouBean.getKeywords();
        name = mTngouBean.getName();
        Picasso.with(FoodDetailActivity.this)
                .load(AllURL.ServerImg2 + img)
                .into(imgPic);
        tvFoodName.setText(name);
        tvFoodKeyWord.setText(keywords);
        tvFoodFood.setText(food);
        tvFoodDesc.setText(description);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
