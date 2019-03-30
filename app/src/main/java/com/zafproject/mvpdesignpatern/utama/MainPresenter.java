package com.zafproject.mvpdesignpatern.utama;

import com.zafproject.mvpdesignpatern.base.BasePresenter;
import com.zafproject.mvpdesignpatern.model.ResultModel;

public class MainPresenter implements BasePresenter<MainView> {
    //deklarasi class viewnya
    private MainView mainView;

    //MainView mainView;
    @Override
    public void onAttach(MainView view) {
        mainView = view;
//
    }
            // create metod / function untuk kalkulasi

    public void itung(String inputanA, String inputanB){
        if (inputanA.isEmpty() || inputanB.isEmpty()) {
            mainView.Error();

        }else{
            //parsing type data dari string to double
            double valueA = Double.parseDouble(inputanA);
            double valueB = Double.parseDouble(inputanB);

            //kalikan value A dan value B
            double result = valueA * valueB;
            // parsing data
            ResultModel dataModel = new ResultModel(String.valueOf(result));
            mainView.Success(dataModel);

        }
    }

    @Override
    public void onDettach() {
        mainView = null;

    }

//    deklarasi class viewnya
//    MainView mainView;
//    @Override
//    public void onAttach(MainView view) {
////proses inisialiasi
//        mainView = view;
//
//    }
//
//    @Override
//    public void onAttach() {
//        mainView = null;
//
//    }

    //bergantung pada class base presenter maknaya di extend
}
