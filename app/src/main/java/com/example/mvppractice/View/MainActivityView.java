package com.example.mvppractice.View;

import java.util.List;

public interface MainActivityView {
    void progressBarVisibility(int visibility);
    void fetchListSuccess(List<String> cityList);
    void fetchListFailer(String error);
}
