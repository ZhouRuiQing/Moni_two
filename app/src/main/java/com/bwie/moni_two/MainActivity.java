package com.bwie.moni_two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.moni_two.apdater.Myapdater;
import com.bwie.moni_two.bean.UiBean;
import com.bwie.moni_two.mvp.AccountConter;
import com.bwie.moni_two.mvp.AccountPresent;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AccountConter.View {

    private TextView dingwei;
    private TextView yingyuan;
    private TextView ReclerViewLiner;
    private TextView ReclerViewGrid;
    private RecyclerView reclerView;


    private AccountPresent present;
    private List<UiBean.ResultBean.NearbyCinemaListBean> list = new ArrayList<>();
    private Myapdater apdater;
    private Button but_vip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dingwei = findViewById(R.id.dingwei);
        yingyuan =  findViewById(R.id.yingyuan);
        ReclerViewLiner =  findViewById(R.id.ReclerView_Liner);
        ReclerViewGrid = findViewById(R.id.ReclerView_Grid);
        reclerView = findViewById(R.id.reclerView);
        but_vip = findViewById(R.id.but_vip);

        but_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VipActivity.class);
                startActivity(intent);
            }
        });

        reclerView.setLayoutManager(new LinearLayoutManager(this));
         apdater = new Myapdater(this,list);
         reclerView.setAdapter(apdater);

         dingwei.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,ShowGaoDeActivity.class);
                 startActivity(intent);
             }
         });

       /*
       *
       * 网格 列表切换
       * */
         ReclerViewLiner.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ReclerViewLiner.setVisibility(View.GONE);
                 ReclerViewGrid.setVisibility(View.VISIBLE);
                 reclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this));
                 apdater.notifyDataSetChanged();
             }
         });

         ReclerViewGrid.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 ReclerViewLiner.setVisibility(View.VISIBLE);
                 ReclerViewGrid.setVisibility(View.GONE);
                 reclerView.setLayoutManager( new GridLayoutManager(MainActivity.this,2));
                 apdater.notifyDataSetChanged();
             }
         });

        present=new AccountPresent();
        present.attch(this);
        present.ShowData("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?longitude=116.30551391385724&laitude=40.04571807462411&page=1&count=10");
    }

    @Override
    public void Showing(String relcut) {
        Log.i("aaa",relcut+"sss");
        Gson gson = new Gson();
        UiBean bean = gson.fromJson(relcut, UiBean.class);
        list.addAll(bean.getResult().getNearbyCinemaList());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

               apdater.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void hideing() {

    }

    @Override
    public void onError() {

    }
}
