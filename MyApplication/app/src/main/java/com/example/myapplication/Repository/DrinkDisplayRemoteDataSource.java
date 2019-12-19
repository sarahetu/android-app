package com.example.myapplication.Repository;

import com.example.myapplication.Data.ApiDataInterface;
import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

/**
 * a class representing a remote data source.
 */
public class DrinkDisplayRemoteDataSource {

    private ApiDataInterface data;

    /**
     * Buils an instance of DrinkDisplayRemoteDataSource
     * @param data an ApiDataInterface object
     */
    public DrinkDisplayRemoteDataSource(ApiDataInterface data) {
        this.data = data;
    }

    /**
     * @return a DrinksListResponse object representing all the Ordinary drinks
     */
    public Single<DrinksListResponse> getDrinkSearchResponse() {
        return data.listCocktailIds("Ordinary_Drink");
    }

    /**
     * @param id a String representing the drink id
     * @return an ApiDataListResponse object of a drink by his id
     */
    public Single<ApiDataListResponse> getDrinkDetails(String id) {
        return data.searchCocktailById(id);
    }

    /**
     * @return a DrinksListResponse object representing all the non alcoholic drinks
     */
    public Single<DrinksListResponse> getNonAlcoholSearchResponse() {
        return data.getAlcoholFilter("Non_Alcoholic");
    }

    /**
     * @return a DrinksListResponse object representing all the alcoholic drinks
     */
    public Single<DrinksListResponse> getAlcoholSearchResponse() {
        return data.getAlcoholFilter("Alcoholic");
    }
}
