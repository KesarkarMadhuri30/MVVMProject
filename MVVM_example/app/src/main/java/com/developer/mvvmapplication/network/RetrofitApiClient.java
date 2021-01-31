package com.developer.mvvmapplication.network;

import com.developer.mvvmapplication.model.BrandInfoModel;
import com.developer.mvvmapplication.model.BrandModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RetrofitApiClient {
    @Headers("X-API-KEY: VEHICLE@2020")
    @GET("marvel")
    //@GET("brand")
    Call<ArrayList<BrandInfoModel>> getBrandJSONData();
}
