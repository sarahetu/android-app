package com.example.myapplication.Repository;

import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

/**
 * A class repository considered has a mediator between different data source.
 * This Repository handle data operations to provide a clean API.
 * The app know where to get the data from and what API calls to make when data is updated.
 *
 */
public class DrinkDisplayDataRepository implements DrinkDisplayRepository {

    private DrinkDisplayRemoteDataSource drinkDisplayRemoteDataSource;

    /**
     * Build a repository to handle data operations
     * @param drinkDisplayRemoteDataSource a DrinkDisplayRemoteDataSource object
     */
    public DrinkDisplayDataRepository(DrinkDisplayRemoteDataSource drinkDisplayRemoteDataSource) {
        this.drinkDisplayRemoteDataSource = drinkDisplayRemoteDataSource;
    }

    /**
     * @return a DrinksListResponse object representing all the drinks
     */
    @Override
    public Single<DrinksListResponse> getDrinksListResponse() {
        return drinkDisplayRemoteDataSource.getDrinkSearchResponse();
    }

    /**
     * @param id a String to represent the id
     * @return an ApiDataListResponse object representing a drink searched by his id
     */
    @Override
    public Single<ApiDataListResponse> getDrinkSearchResponse(String id) {
        return drinkDisplayRemoteDataSource.getDrinkDetails(id);
    }

    /**
     * @return a DrinksListResponse object representing all the non alcoholic drinks
     */
    @Override
    public Single<DrinksListResponse> getNonAlcoholicListResponse() {
        return drinkDisplayRemoteDataSource.getNonAlcoholSearchResponse();
    }

    /**
     * @return a DrinksListResponse object representing all the alcoholic drinks
     */
    @Override
    public Single<DrinksListResponse> getAlcoholicListResponse() {
        return drinkDisplayRemoteDataSource.getAlcoholSearchResponse();
    }


}
