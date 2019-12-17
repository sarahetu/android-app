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
        return data.listCocktailIds("Cocktail");
    }

    public Single<ApiDataListResponse> getDrinkDetails(String id) {
        return data.searchCocktailById(id);
    }
}