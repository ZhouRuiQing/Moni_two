package com.bwie.moni_two.utils;


import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    public OkHttpClient client;

    private static  OkHttpUtils okHttpUtils = new OkHttpUtils();

    public static OkHttpUtils getInstance() {
        if(okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                okHttpUtils=new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }

    private OkHttpUtils() {
        if(client==null){
            synchronized (OkHttpClient.class){

                client=new OkHttpClient.Builder().build();
            }
        }
    }

    public void  get(String url, Callback callback){

        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    //拦截器
    class MyIntercepter implements Interceptor {
        //intercept 拦截
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //获取请求方法
            String method = request.method();
            if (method.equals("GET")) {
                //取出url地址
                String url = request.url().toString();
                //拼接公共参数
                boolean contains = url.contains("?");
                if (contains) {
                    url = url + "&source=android";
                } else {
                    url = url + "?source=android";
                }

                Request request1 = request.newBuilder().url(url).build();

                Response response = chain.proceed(request1);

                return response;


            }

            return null;
        }
    }
}
