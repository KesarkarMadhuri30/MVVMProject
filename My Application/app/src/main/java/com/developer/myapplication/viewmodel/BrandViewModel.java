package com.developer.myapplication.viewmodel;

import android.app.Application;

import com.developer.myapplication.model.BrandInfoModel;
import com.developer.myapplication.repository.BrandRepository;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class BrandViewModel extends AndroidViewModel {
    BrandRepository brandRepository;

    public BrandViewModel(@NonNull Application application) {
        super(application);
       brandRepository = new BrandRepository(application);
    }

    public LiveData<ArrayList<BrandInfoModel>> getBrandData()
    {
        return brandRepository.getMutableLiveData();
    }


}
