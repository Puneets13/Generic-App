package com.example.genricapp;

import com.example.genricapp.Model.RegisterResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Api {
    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> Register(
//            @Body RegisterResponse registerResponse
             @FieldMap Map<String, String> params
    );

    @Multipart
    @POST("register")
    Call<RegisterResponse>Register(
            @Part ("username")RequestBody username,
            @Part ("email")RequestBody email,
            @Part ("phone")RequestBody phone,
            @Part ("passsword")RequestBody password
            );

//    @FormUrlEncoded
//    @POST("register")   //since we are sending the paramter in the path with id (so we use @PATH)
//    Call<RegisterResponse>Register(
//            @Field("username") String username,
//            @Field ("email") String email,
//            @Field ("phone") String  phone,
//            @Field ("password") String  password
//            );


}
