package com.example.loginmvp.View;

public interface MainActivityView {
    void progressBarVisibility(int v);
    void SuccessLogin(String msg);
    void FailesLogin(String err);
}
