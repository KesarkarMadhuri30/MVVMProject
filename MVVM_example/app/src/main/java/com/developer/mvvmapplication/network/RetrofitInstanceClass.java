package com.developer.mvvmapplication.network;

import com.developer.mvvmapplication.model.BrandModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceClass {
    String BASE_URL = "https://simplifiedcoding.net/demos/";
   //  public static String BASE_URL="http://testapp.steponglobal.com/api/vehicle/";
    public static Retrofit retrofit=null;
    public static RetrofitInstanceClass retrofitInstanceClass;

    public RetrofitInstanceClass()
    {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitInstanceClass getInstance()
    {
        if (retrofitInstanceClass==null)
            retrofitInstanceClass= new RetrofitInstanceClass();
        return retrofitInstanceClass;
    }

    public static RetrofitApiClient getApi()
    {
        return retrofit.create(RetrofitApiClient.class);
    }



}
