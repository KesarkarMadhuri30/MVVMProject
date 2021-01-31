package com.developer.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.developer.myapplication.adapter.BrandAdapter;
import com.developer.myapplication.model.BrandInfoModel;
import com.developer.myapplication.viewmodel.BrandViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BrandAdapter brandAdapter;
    BrandViewModel brandViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandViewModel = ViewModelProviders.of(this).get(BrandViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(linearLayoutManager);

        brandViewModel.getBrandData().observe(this, new Observer<ArrayList<BrandInfoModel>>() {
            @Override
            public void onChanged(ArrayList<BrandInfoModel> brandInfoModels) {
                brandAdapter = new BrandAdapter(getApplicationContext(),brandInfoModels);
                recyclerView.setAdapter(brandAdapter);
            }
        });

    }
}