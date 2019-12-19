package com.example.myapplication.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * a class to represent all the drinks thanks to a list of Drinks objects
 */
public class DrinksListResponse {

    @SerializedName("drinks")
    List<Drinks> drinks;

    /**
     * @return a list of Drinks objects that contains all the drinks
     */
    public List<Drinks> getDrinks() {
        return drinks;
    }
}
