package com.developer.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BrandModel {
    @SerializedName("brand")
    public ArrayList<BrandInfoModel> brandinfo;

    public ArrayList<BrandInfoModel> getBrandinfo() {
        return brandinfo;
    }

    public void setBrandinfo(ArrayList<BrandInfoModel> brandinfo) {
        this.brandinfo = brandinfo;
    }
}
