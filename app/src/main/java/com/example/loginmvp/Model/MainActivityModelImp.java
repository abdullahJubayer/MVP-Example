package com.example.loginmvp.Model;

import com.example.loginmvp.Network.Api;
import com.example.loginmvp.Network.RetrofitClient;
import com.example.loginmvp.Presenter.MainActivityPresenter;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityModelImp implements MainActivity_Model{
    public MainActivityPresenter mainActivityPresenter;
    private Api api;

    public MainActivityModelImp(){
        api= RetrofitClient.getRetrofitInstance().create(Api.class);
    }

    @Override
    public void login(String email, String pass) {
        if (email != null && !email.isEmpty() && pass != null && !pass.isEmpty()){
            api.login(email,pass).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        mainActivityPresenter.LoginSuccess(response.message());
                    }else {
                        mainActivityPresenter.LoginFailed(response.message()+"TTT");
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    mainActivityPresenter.LoginFailed(t.getMessage());
                }
            });
        }else {
            mainActivityPresenter.LoginFailed("Login Failed");
        }
    }
}
