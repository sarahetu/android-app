package com.example.myapplication.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrinksListResponse {

    @SerializedName("drinks")
    List<Drinks> drinks;

    int totalDrinks;
    public List<Drinks> getDrinks() {
        return drinks;
    }
    public int getTotalDrinks() {
        return totalDrinks;
    }
    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }
}
