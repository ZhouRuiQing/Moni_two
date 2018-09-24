package com.bwie.moni_two.mvp;

import java.lang.ref.WeakReference;

public class AccountPresent implements AccountConter.Present {



    private AccountConter.View view;
    private AccountConter.Model model;
    private WeakReference<AccountConter.View> viewWeakReference;
    private WeakReference<AccountConter.Model> modelWeakReference;
    @Override
    public void ShowData(String url) {

        modelWeakReference.get().ShowData(url, new AccountConter.Model.MvpCallBack() {
            @Override
            public void onSuccess(String reluct) {
                view.Showing(reluct);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void attch(AccountConter.View view) {

        this.view =view;
        viewWeakReference=new WeakReference(view);
        model=new AccountModel();
        modelWeakReference=new WeakReference(model);
    }

    @Override
    public void deattch() {

    }
}
