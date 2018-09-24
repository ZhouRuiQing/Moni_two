package com.bwie.moni_two.app;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
