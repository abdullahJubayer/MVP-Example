package com.example.mvppractice.Model;

import com.example.mvppractice.commonListner.RequestSuccessListner;

import java.util.ArrayList;
import java.util.List;

public class ModelImplementation implements Model{

    @Override
    public void getCity(RequestSuccessListner<List<String>> listner) {
        List<String> name=new ArrayList<>();
        name.add("Abdullah");
        name.add("Abdullah");
        name.add("Abdullah");
        name.add("Abdullah");
        name.add("Abdullah");

        listner.Success(name);
    }
}
