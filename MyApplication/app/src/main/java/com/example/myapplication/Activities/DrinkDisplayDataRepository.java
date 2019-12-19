package com.example.myapplication.Activities;

import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

public class DrinkDisplayDataRepository implements DrinkDisplayRepository{

    private DrinkDisplayRemoteDataSource drinkDisplayRemoteDataSource;

    public DrinkDisplayDataRepository(DrinkDisplayRemoteDataSource drinkDisplayRemoteDataSource) {
        this.drinkDisplayRemoteDataSource = drinkDisplayRemoteDataSource;
    }

    @Override
    public Single<DrinksListResponse> getDrinksListResponse() {
        return drinkDisplayRemoteDataSource.getDrinkSearchResponse();
    }

    @Override
    public Single<ApiDataListResponse> getDrinkSearchResponse(String id) {
        return drinkDisplayRemoteDataSource.getDrinkDetails(id);
    }

    @Override
    public Single<DrinksListResponse> getNonAlcoholicListResponse() {
        return drinkDisplayRemoteDataSource.getNonAlcoholSearchResponse();
    }

    @Override
    public Single<DrinksListResponse> getAlcoholicListResponse() {
        return drinkDisplayRemoteDataSource.getAlcoholSearchResponse();
    }


}
