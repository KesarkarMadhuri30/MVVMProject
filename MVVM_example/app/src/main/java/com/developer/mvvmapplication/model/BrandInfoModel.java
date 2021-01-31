package com.developer.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

public class BrandInfoModel {
    @SerializedName("id")
    private String id;

    @SerializedName("brand_name")
    private String brand_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @SerializedName("name")
    private String name;
    @SerializedName("team")
    private String team;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
