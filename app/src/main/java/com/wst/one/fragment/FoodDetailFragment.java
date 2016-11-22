package com.wst.one.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.http.service.FoodService;
import com.wst.main.MainActivity;
import com.wst.one.adapter.FoodListAdapter;
import com.wst.one.module.FoodListModule;

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
 * Created by: BruceChang
 * Date on : 2016/11/18.
 * Time on: 11:55
 * Progect_Name:ATestDrawLayout
 * Source Github：
 * Description:
 */

public class FoodDetailFragment extends Fragment implements View.OnClickListener {

    private MainActivity mActivity;
    @BindView(R.id.recyclerViewFirst)
    XRecyclerView recyclerViewFirst;
    FoodListAdapter recyclerViewAdapter;
    private String id;
    private List<FoodListModule.TngouBean> mData;
    private Handler handler;
    private int page = 1;
    private int rows = 15;


    public static FoodDetailFragment newInstance(String id) {
        FoodDetailFragment fragment = new FoodDetailFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);
        ButterKnife.bind(this, view);
        initData();
        refresh();
        return view;
    }


    @Override
    public void onClick(View v) {

    }

    private void initData() {
        recyclerViewFirst.setPullRefreshEnabled(false);
        mData = new ArrayList<>();
        recyclerViewAdapter = new FoodListAdapter(mActivity, mData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewFirst.setLayoutManager(layoutManager);
        recyclerViewFirst.setAdapter(recyclerViewAdapter);
        recyclerViewFirst.setPullRefreshEnabled(true);
        handler = new Handler();
        recyclerViewFirst.setRefreshProgressStyle(ProgressStyle.LineScalePulseOut);
        recyclerViewFirst.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        recyclerViewFirst.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                        recyclerViewFirst.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                        recyclerViewFirst.loadMoreComplete();
                    }
                }, 2000);


            }
        });


    }


    private void refresh() {
        page = 1;
        if (mData.size() > 0) {
            mData.clear();
        }
        loadFoodListData(id);
    }

    private void loadMore() {
        page++;
        loadFoodListData(id);
    }

    private void loadFoodListData(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AllURL.Server)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FoodService foodService = retrofit.create(FoodService.class);
        Call<FoodListModule> foodList = foodService.getFoodList("1", page, rows);
        foodList.enqueue(new Callback<FoodListModule>() {
            @Override
            public void onResponse(Call<FoodListModule> call, Response<FoodListModule> response) {
                FoodListModule foodListModule = response.body();

                if (foodListModule.isStatus() == true) {
                    if (foodListModule.getTngou().size() > 0) {
                        mData.addAll(foodListModule.getTngou());
                    }
                    recyclerViewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(mActivity, "接口错误", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FoodListModule> call, Throwable t) {

            }
        });

    }
}
