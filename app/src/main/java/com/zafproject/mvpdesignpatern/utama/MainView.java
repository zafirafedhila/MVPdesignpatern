package com.zafproject.mvpdesignpatern.utama;

import com.zafproject.mvpdesignpatern.base.BaseView;
import com.zafproject.mvpdesignpatern.model.ResultModel;

public interface MainView extends BaseView {
    //satu aktivity punya satu presenter dan viewnya
    //nampilin  view
    //kaya alert dialog

    //buat funtion eror

    void Success (ResultModel dataModel);
    //untuk nyalain lampu
    void Error();

}
