package com.example.mvppractice.Presenter;
import android.view.View;

import com.example.mvppractice.Model.Model;
import com.example.mvppractice.View.MainActivityView;
import com.example.mvppractice.commonListner.RequestSuccessListner;

import java.util.List;

public class MainActivityPresenterImplementation implements Presenter{
    public MainActivityView view;
    public Model model;

    public MainActivityPresenterImplementation(MainActivityView view,Model model){
        this.view=view;
        this.model=model;
    }

    @Override
    public void getCityList() {
        view.progressBarVisibility(View.VISIBLE);
        model.getCity(new RequestSuccessListner<List<String>>() {
            @Override
            public void Success(List<String> data) {
                if (data != null){
                    view.fetchListSuccess(data);
                    view.progressBarVisibility(View.GONE);
                }else {
                    view.fetchListFailer("No Data Found");
                    view.progressBarVisibility(View.GONE);
                }
            }
        });
    }
}
