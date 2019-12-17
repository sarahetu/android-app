package com.example.myapplication.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiDataListResponse {

    @SerializedName("drinks")
    @Expose
    List<ApiData> drinks;

    int totalDrinks;
    public List<ApiData> getDrinks() {
        return drinks;
    }
    public int getTotalDrinks() {
        return totalDrinks;
    }
    public void setDrinks(List<ApiData> drinks) {
        this.drinks = drinks;
    }
}
