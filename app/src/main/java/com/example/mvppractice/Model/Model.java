package com.example.mvppractice.Model;


import com.example.mvppractice.commonListner.RequestSuccessListner;

import java.util.List;

public interface Model {
    void getCity(RequestSuccessListner<List<String>> listner);
}
