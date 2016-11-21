package com.wst.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wst.R;
import com.wst.http.AllURL;
import com.wst.one.module.FoodListModule;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hosa2015 on 2016-9-18.
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {
    private Context context;
    private List<FoodListModule.TngouBean> mData;


    public FoodListAdapter(Context context, List<FoodListModule.TngouBean> mData) {
        this.context = context;
        this.mData = mData;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FoodListModule.TngouBean tngouBean = mData.get(position);
        Picasso.with(context)
                .load(AllURL.ServerImg2+tngouBean.getImg())
                .into(holder.imgFood);
        holder.tvName.setText(tngouBean.getName());
        holder.tvKeyWords.setText(tngouBean.getKeywords());

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

        @BindView(R.id.imgFood)
        ImageView imgFood;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvKeyWords)
        TextView tvKeyWords;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
