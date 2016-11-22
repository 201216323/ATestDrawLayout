package com.wst.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.http.service.FoodTabService;
import com.wst.one.adapter.FoodTabsAdapter;
import com.wst.one.fragment.FoodDetailFragment;
import com.wst.one.module.FoodTabModule;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private MainActivity mActivity;
    @BindView(R.id.tabs)
    AdvancedPagerSlidingTabStrip tabs;
    @BindView(R.id.vp_main)
    ViewPager vp_main;
    ArrayList<String> mtitles;
    FoodTabsAdapter mFoodDetailTabsAdapter;
    private FragmentManager mFragmentManager;
    private List<Fragment> fragmentList;


    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        init();

        return view;
    }


    @Override
    public void onClick(View v) {

    }

    private void init() {
        mtitles = new ArrayList<>();
        fragmentList = new ArrayList<Fragment>();
        mFragmentManager = getChildFragmentManager();
        mtitles.add("减肥瘦身");
        fragmentList.add(FoodDetailFragment.newInstance("11"));
        mtitles.add("私密生活");
        fragmentList.add(FoodDetailFragment.newInstance("7"));
        mtitles.add("女性保养");
        fragmentList.add(FoodDetailFragment.newInstance("5"));
        mtitles.add("男性健康");
        fragmentList.add(FoodDetailFragment.newInstance("4"));
        mtitles.add("孕婴手册");
        fragmentList.add(FoodDetailFragment.newInstance("6"));

        mtitles.add("夫妻情感");
        fragmentList.add(FoodDetailFragment.newInstance("13"));
        mtitles.add("育儿宝典");
        fragmentList.add(FoodDetailFragment.newInstance("8"));
        mtitles.add("健康饮食");
        fragmentList.add(FoodDetailFragment.newInstance("3"));
        mtitles.add("医疗护理");
        fragmentList.add(FoodDetailFragment.newInstance("12"));
        mtitles.add("老人健康");
        fragmentList.add(FoodDetailFragment.newInstance("1"));

        mtitles.add("孩子健康");
        fragmentList.add(FoodDetailFragment.newInstance("2"));
        mtitles.add("四季养生");
        fragmentList.add(FoodDetailFragment.newInstance("10"));
        mtitles.add("心里健康");
        fragmentList.add(FoodDetailFragment.newInstance("9"));


        vp_main.setOffscreenPageLimit(fragmentList.size());
        mFoodDetailTabsAdapter = new FoodTabsAdapter(mFragmentManager, mtitles, fragmentList);
        vp_main.setAdapter(mFoodDetailTabsAdapter);
        tabs.setViewPager(vp_main);
        vp_main.setCurrentItem(0);
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Toast.makeText(mActivity, "position:" + position + "size:" + mtitles.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        loadData();
    }


    private void loadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AllURL.Server)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FoodTabService service = retrofit.create(FoodTabService.class);
        Call<FoodTabModule> call = service.getFoodTab();
        call.enqueue(new Callback<FoodTabModule>() {
            @Override
            public void onResponse(Call<FoodTabModule> call, Response<FoodTabModule> response) {

                FoodTabModule foodTabModule = response.body();
                if (foodTabModule.isStatus() == true) {

                    for (int i = 0; i < 13; i++) {//
//                        mtitles.add(foodTabModule.getTngou().get(i).getName());
                        fragmentList.add(FoodDetailFragment.newInstance("" + foodTabModule.getTngou().get(i).getId()));
                    }
                    mFoodDetailTabsAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(mActivity, "暂无数据", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodTabModule> call, Throwable t) {
                Toast.makeText(mActivity, "连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
