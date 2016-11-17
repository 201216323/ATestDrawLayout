package com.wst.one.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wst.R;
import com.wst.main.MainActivity;
import com.wst.one.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private MainActivity mActivity;
    @BindView(R.id.recyclerViewFirst)
    XRecyclerView recyclerViewFirst;
    RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<String> mData;
    private Handler handler;


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
        initData();
        return view;
    }


    @Override
    public void onClick(View v) {

    }

    private void initData() {
        recyclerViewFirst.setPullRefreshEnabled(false);
        mData = new ArrayList<>();
        recyclerViewAdapter = new RecyclerViewAdapter(mData);
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

        refresh();
    }


    private void refresh() {
        if (mData.size() > 0) {
            mData.clear();
        }

        for (int i = 0; i < 10; i++) {
            mData.add("刷新第" + i + "数据");
        }


    }

    private void loadMore() {
        for (int i = 0; i < 5; i++) {
            mData.add("更多第" + i + "数据");
        }

    }
}