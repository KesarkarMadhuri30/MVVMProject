package com.developer.myapplication.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static final String BASE_URL="http://testapp.steponglobal.com/api/vehicle/";
    public static Retrofit retrofit=null;
    public static RetrofitClientInstance retrofitClientInstance;

    private RetrofitClientInstance()
    {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static synchronized RetrofitClientInstance getInstance()
    {
        if (retrofitClientInstance==null)
        {
            retrofitClientInstance = new RetrofitClientInstance();
        }
        return retrofitClientInstance;
    }

    public RetrofitApiClient getApi()
    {
        return retrofit.create(RetrofitApiClient.class);
    }
}
