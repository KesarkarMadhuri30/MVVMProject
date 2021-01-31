package com.developer.myapplication.network;

import com.developer.myapplication.model.BrandModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface RetrofitApiClient {
//
//    @Headers("X-API-KEY: VEHICLE@2020")
//    @GET("brand")
//    Call<BrandModel> getBrandJSONData();
    @Headers("X-API-KEY: VEHICLE@2020")
    @GET("brand")
    Call<BrandModel> getBrandJSONData();

}
