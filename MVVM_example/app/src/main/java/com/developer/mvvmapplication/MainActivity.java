package com.developer.mvvmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.developer.mvvmapplication.model.BrandInfoModel;
import com.developer.mvvmapplication.model.BrandModel;
import com.developer.mvvmapplication.viewmodel.BrandViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    AdapterRecycler adapterRecycler;
    RecyclerView recyclerView;
    BrandViewModel brandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandViewModel = ViewModelProviders.of(this).get(BrandViewModel.class);
       // brandViewModel = ViewModelProvider.Factory(this).get(BrandViewModel.class);


        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);

       // list.add(brandViewModel.getBrandValue());

        brandViewModel.getBrandJSONData().observe(this, new Observer<ArrayList<BrandInfoModel>>() {
            @Override
            public void onChanged(ArrayList<BrandInfoModel> brandInfoModels) {
                adapterRecycler = new AdapterRecycler(getApplicationContext(),brandInfoModels);
                recyclerView.setAdapter(adapterRecycler);
            }
        });

    }


}