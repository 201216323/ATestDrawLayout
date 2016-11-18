package com.wst.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.http.FoodTabService;
import com.wst.one.adapter.FoodTabsAdapter;
import com.wst.one.module.FoodTabModule;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wst.main.MainFragmentAdapter.VIEW_FIRST;
import static com.wst.main.MainFragmentAdapter.VIEW_SIZE;

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

        loadData();
        init();
        return view;
    }


    @Override
    public void onClick(View v) {

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
                    for (int i = 0; i < foodTabModule.getTngou().size(); i++) {
                        mtitles.add(foodTabModule.getTngou().get(i).getName());
                    }

                } else {

                }
            }

            @Override
            public void onFailure(Call<FoodTabModule> call, Throwable t) {

            }
        });
    }

    private void init() {
        mtitles = new ArrayList<>();
        mFragmentManager = getFragmentManager();
        vp_main.setOffscreenPageLimit(VIEW_SIZE);
        mFoodDetailTabsAdapter = new FoodTabsAdapter(mFragmentManager, mtitles);
        vp_main.setAdapter(mFoodDetailTabsAdapter);
        tabs.setViewPager(vp_main);
        vp_main.setCurrentItem(VIEW_FIRST);
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
