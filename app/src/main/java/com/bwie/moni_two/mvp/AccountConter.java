package com.bwie.moni_two.mvp;

import com.bwie.moni_two.base.IBaseModel;
import com.bwie.moni_two.base.IBasePresent;
import com.bwie.moni_two.base.IBaseView;

/**
 * MVP契约类
 */
public interface AccountConter {

    interface View extends IBaseView{

        void Showing(String relcut);
        void hideing();
        void onError();
    }

    interface Model extends IBaseModel{

        interface MvpCallBack{

            void onSuccess(String reluct);
            void onError(String msg);
        }
        void ShowData(String url,MvpCallBack callBack);
    }
    interface Present extends IBasePresent<View>{

        void ShowData(String url);
    }
}
