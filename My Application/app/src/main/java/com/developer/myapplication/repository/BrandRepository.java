package com.developer.myapplication.repository;

import android.app.Application;
import android.util.Log;

import com.developer.myapplication.model.BrandInfoModel;
import com.developer.myapplication.model.BrandModel;
import com.developer.myapplication.network.RetrofitApiClient;
import com.developer.myapplication.network.RetrofitClientInstance;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandRepository {
    public ArrayList<BrandInfoModel> brandData=new ArrayList<>();
    public MutableLiveData<ArrayList<BrandInfoModel>> mutableLiveData=new MutableLiveData<>();
    Application application;

    public BrandRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<ArrayList<BrandInfoModel>> getMutableLiveData()
    {
        RetrofitApiClient apiClient = RetrofitClientInstance.getInstance().getApi();
        Call<BrandModel> brandcall = apiClient.getBrandJSONData();
        brandcall.enqueue(new Callback<BrandModel>() {
            @Override
            public void onResponse(Call<BrandModel> call, Response<BrandModel> response) {
                if (response.body() !=null) {
                    Log.d("###","response");
                    Log.d("###", String.valueOf(response.body().getBrandInfo()));
                    BrandModel brandModel = response.body();
                    if (brandModel != null && brandModel.getBrandInfo() != null) {
                        brandData = brandModel.getBrandInfo();
                        mutableLiveData.setValue(brandData);
                    }
                }

            }

            @Override
            public void onFailure(Call<BrandModel> call, Throwable t) {
                Log.d("###","fail response");
            }
        });
        return mutableLiveData;
    }
}
