package com.bwie.moni_two.base;

public interface IBasePresent <V extends IBaseView>{

    void attch(V v);
    void deattch();
}
