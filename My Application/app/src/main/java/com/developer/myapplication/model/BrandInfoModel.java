package com.developer.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class BrandInfoModel {
    @SerializedName("id")
    String id;

    @SerializedName("brand_name")
    String brand_name;

    public String getId() {
        return id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    @Override
    public String toString() {
        return "BrandInfoModel{" +
                "id='" + id + '\'' +
                ", brand_name='" + brand_name + '\'' +
                '}';
    }
}
