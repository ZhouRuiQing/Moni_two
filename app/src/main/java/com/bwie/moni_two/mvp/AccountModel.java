package com.bwie.moni_two.mvp;

import com.bwie.moni_two.base.IBaseModel;
import com.bwie.moni_two.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class AccountModel implements AccountConter.Model{
    private OkHttpClient client;
    public AccountModel(){

        client=new OkHttpClient();
    }

    @Override
    public void ShowData(String url, final MvpCallBack callBack) {

        OkHttpUtils.getInstance().get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String rstring = e.getMessage().toString();
                callBack.onError(rstring);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String estring = response.body().string().toString();
                callBack.onSuccess(estring);
            }
        });
    }
}
