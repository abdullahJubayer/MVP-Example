package com.example.loginmvp.Network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@Field("email")String email,@Field("password")String pass);
}
