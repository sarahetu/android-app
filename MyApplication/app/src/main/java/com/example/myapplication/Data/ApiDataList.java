package com.example.myapplication.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiDataList {

    @SerializedName("drinks")
    @Expose
    private List<ApiData> drinks = null;

    public List<ApiData> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<ApiData> drinks) {
        this.drinks = drinks;
    }
}
