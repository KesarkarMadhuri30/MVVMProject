package com.developer.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BrandModel {

    @SerializedName("brand")
    ArrayList<BrandInfoModel> brandInfo;

    public ArrayList<BrandInfoModel> getBrandInfo() {
        return brandInfo;
    }

    @Override
    public String toString() {
        return "BrandModel{" +
                "brandInfo=" + brandInfo +
                '}';
    }
}
