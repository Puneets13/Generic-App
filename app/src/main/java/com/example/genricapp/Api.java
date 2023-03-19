package com.example.genricapp;

import com.example.genricapp.Model.OTP_Response;
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



    @Multipart
    @POST("uniqueAPI")
    Call<OTP_Response>sent_OTP(
            @Part ("email")RequestBody email,
            @Part ("phone")RequestBody phone
    );

    @Multipart
    @POST("register")
    Call<RegisterResponse>Register(
            @Part ("username")RequestBody username,
            @Part ("email")RequestBody email,
            @Part ("phone")RequestBody phone,
            @Part ("password")RequestBody password,
            @Part ("reg_id")RequestBody reg_id,
            @Part ("device_id")RequestBody device_id,
            @Part ("login_type")RequestBody login_type,
            @Part ("latitude")RequestBody latitude,
            @Part ("longitude")RequestBody longitude,
            @Part ("chatId")RequestBody chatId

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
