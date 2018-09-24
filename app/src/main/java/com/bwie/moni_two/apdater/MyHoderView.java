package com.bwie.moni_two.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.moni_two.R;


class MyHoderView extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView tvName;
    public TextView tvTitle;
    public TextView tvMi;




    public MyHoderView(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_view);
        tvName =  itemView.findViewById(R.id.tv_name);
        tvTitle =  itemView.findViewById(R.id.tv_title);
        tvMi =  itemView.findViewById(R.id.tv_mi);
    }
}
