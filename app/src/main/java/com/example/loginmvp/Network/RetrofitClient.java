package com.example.loginmvp.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofitClient;
    private RetrofitClient(){
    }

    public static Retrofit getRetrofitInstance(){
        if (retrofitClient != null){
            return retrofitClient;
        }else {
            return retrofitClient= new Retrofit.Builder()
                    .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
