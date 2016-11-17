package com.wst.one.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wst.R;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by hosa2015 on 2016-9-18.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<String> mData;

    public RecyclerViewAdapter(ArrayList<String> mData) {
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewNumber.setText(mData.get(position));

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewNumber)
        TextView textViewNumber;

        public MyViewHolder(View itemView) {
            super(itemView);
//            ButterKnife.bind(itemView);
            textViewNumber = (TextView) itemView.findViewById(R.id.textViewNumber);
        }
    }
}
