package com.example.myapplication.Activities;

import com.example.myapplication.Data.ApiDataInterface;
import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

public class DrinkDisplayRemoteDataSource {

    private ApiDataInterface data;

    public DrinkDisplayRemoteDataSource(ApiDataInterface data) {
        this.data = data;
    }

    public Single<DrinksListResponse> getDrinkSearchResponse() {
        return data.listCocktailIds("Ordinary_Drink");
    }

    public Single<ApiDataListResponse> getDrinkDetails(String id) {
        return data.searchCocktailById(id);
    }

    public Single<DrinksListResponse> getNonAlcoholSearchResponse() {
        return data.getAlcoholFilter("Non_Alcoholic");
    }

    public Single<DrinksListResponse> getAlcoholSearchResponse() {
        return data.getAlcoholFilter("Alcoholic");
    }
}
