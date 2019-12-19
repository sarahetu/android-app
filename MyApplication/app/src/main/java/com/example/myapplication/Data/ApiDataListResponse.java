package com.example.myapplication.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * a class to represent all the drinks thanks to a list of ApiData objects
 */
public class ApiDataListResponse {

    @SerializedName("drinks")
    @Expose
    List<ApiData> drinks;

    /**
     * @return a list of ApiData objects that contains all the drinks
     */
    public List<ApiData> getDrinks() {
        return drinks;
    }

}
