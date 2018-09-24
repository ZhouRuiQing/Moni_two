package com.bwie.moni_two.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.moni_two.MainActivity;
import com.bwie.moni_two.R;
import com.bwie.moni_two.bean.UiBean;

import java.util.List;

public class Myapdater extends RecyclerView.Adapter<MyHoderView> {
    Context context;
    List<UiBean.ResultBean.NearbyCinemaListBean> list;

    public Myapdater(Context context, List<UiBean.ResultBean.NearbyCinemaListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHoderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyHoderView view = new MyHoderView(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoderView holder, int position) {

        Glide.with(context).load(list.get(position).getLogo()).into(holder.imageView);
        holder.tvName.setText(list.get(position).getName());
        holder.tvTitle.setText(list.get(position).getAddress());
        holder.tvMi.setText(list.get(position).getCommentTotal()+"KM");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
