package com.example.loginmvp.Presenter;

import android.view.View;

import com.example.loginmvp.Model.MainActivityModelImp;
import com.example.loginmvp.Model.MainActivity_Model;
import com.example.loginmvp.View.MainActivityView;

public class MainActivityPresenterImp implements MainActivityPresenter{

    private MainActivityView mainActivityView;
    private MainActivity_Model mainActivityModel;
    private MainActivityModelImp mainActivityModelImp;

    public MainActivityPresenterImp(MainActivityView mainActivityView,MainActivity_Model mainActivityModel){
        this.mainActivityView=mainActivityView;
        this.mainActivityModel=mainActivityModel;
        mainActivityModelImp= (MainActivityModelImp) mainActivityModel;
    }

    public void isLogin(String emeil,String password){
        mainActivityView.progressBarVisibility(View.VISIBLE);
        mainActivityModelImp.mainActivityPresenter=this;
        mainActivityModel.login(emeil,password);
    }

    @Override
    public void LoginSuccess(String msg) {
        mainActivityView.progressBarVisibility(View.GONE);
        mainActivityView.SuccessLogin(msg);
    }

    @Override
    public void LoginFailed(String err) {
        mainActivityView.progressBarVisibility(View.GONE);
        mainActivityView.FailesLogin(err);
    }
}
