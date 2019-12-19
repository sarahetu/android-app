package com.example.myapplication.Activities;

import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

public interface DrinkDisplayRepository {
    Single<DrinksListResponse> getDrinksListResponse();
    Single<ApiDataListResponse> getDrinkSearchResponse(String id);
    Single<DrinksListResponse> getNonAlcoholicListResponse();
    Single<DrinksListResponse> getAlcoholicListResponse();
}
