package com.wst.one.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.http.service.FoodService;
import com.wst.main.MainActivity;
import com.wst.main.OnRecyclerViewItemClickListener;
import com.wst.one.FoodDetailActivity;
import com.wst.one.adapter.FoodListAdapter;
import com.wst.one.module.FoodListModule;
import com.wst.util.LoadingUtils;

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
    private int rows = 20;
    @BindView(R.id.imgNoData)
    ImageView imgNoData;

    LoadingUtils mLoadingUtils;

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
        mLoadingUtils = new LoadingUtils(context);
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
//        refresh();
        recyclerViewFirst.setRefreshing(true);
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

                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {


                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                        recyclerViewFirst.loadMoreComplete();
                    }
                }, 1000);


            }
        });
        recyclerViewAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, FoodListModule.TngouBean data) {
                Intent intent = new Intent(mActivity, FoodDetailActivity.class);
                intent.putExtra("bean", data);
                startActivity(intent);
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
//        mLoadingUtils.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AllURL.Server)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FoodService foodService = retrofit.create(FoodService.class);
        final Call<FoodListModule> foodList = foodService.getFoodList(id, page, rows);
        foodList.enqueue(new Callback<FoodListModule>() {
            @Override
            public void onResponse(Call<FoodListModule> call, Response<FoodListModule> response) {
                recyclerViewFirst.refreshComplete();
                FoodListModule foodListModule = response.body();
                mLoadingUtils.dismiss();
                if (foodListModule != null) {
                    if (foodListModule.isStatus() == true && foodListModule.getTngou().size() > 0) {
                        recyclerViewFirst.setVisibility(View.VISIBLE);
                        imgNoData.setVisibility(View.GONE);
                        if (foodListModule.getTngou().size() > 0) {
                            mData.addAll(foodListModule.getTngou());
                        }
                        recyclerViewAdapter.notifyDataSetChanged();
                    } else {

                        if (mData.size() == 0) {
                            recyclerViewFirst.setVisibility(View.GONE);
                            imgNoData.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(mActivity, "暂无更多", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else {
                    recyclerViewFirst.setVisibility(View.GONE);
                    imgNoData.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<FoodListModule> call, Throwable t) {
                recyclerViewFirst.refreshComplete();
                mLoadingUtils.dismiss();
                Toast.makeText(mActivity, "连接失败", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
