package com.developer.mvvmapplication.viewmodel;

import android.app.Application;

import com.developer.mvvmapplication.model.BrandInfoModel;
import com.developer.mvvmapplication.model.BrandModel;
import com.developer.mvvmapplication.network.RetrofitApiClient;
import com.developer.mvvmapplication.network.RetrofitInstanceClass;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BrandViewModel extends AndroidViewModel {
    Application application;
   private MutableLiveData<ArrayList<BrandInfoModel>> brandData;

    public BrandViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
    }

    public LiveData<ArrayList<BrandInfoModel>> getBrandJSONData()
       {
           if (brandData==null)
           {
               brandData = new MutableLiveData<ArrayList<BrandInfoModel>>();
                loadBrand();
           }
           return brandData;
       }

    private void loadBrand() {
        RetrofitApiClient apiClient = RetrofitInstanceClass.getInstance().getApi();
        Call<ArrayList<BrandInfoModel>> brand_call =apiClient.getBrandJSONData();

        brand_call.enqueue(new Callback<ArrayList<BrandInfoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<BrandInfoModel>> call, Response<ArrayList<BrandInfoModel>> response) {
                brandData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<BrandInfoModel>> call, Throwable t) {

            }
        });
    }
}
