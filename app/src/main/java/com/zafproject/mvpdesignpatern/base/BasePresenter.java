package com.zafproject.mvpdesignpatern.base;

public interface BasePresenter  < T extends  BaseView>{

    //extend biar bisa komuniaksi dengan baseview

    void onAttach(T view);
    void onDettach();

}
