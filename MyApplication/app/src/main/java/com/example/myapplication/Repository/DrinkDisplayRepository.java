package com.example.myapplication.Repository;

import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import io.reactivex.Single;

/**
 * An interface to model the repository who handle data operations to provide a clean API.
 * The app know where to get the data from and what API calls to make when data is updated.
 *
 */
public interface DrinkDisplayRepository {

    /**
     * @return a DrinksListResponse object representing all the drinks
     */
    Single<DrinksListResponse> getDrinksListResponse();

    /**
     * @param id a String to represent the id
     * @return an ApiDataListResponse object representing a drink searched by his id
     */
    Single<ApiDataListResponse> getDrinkSearchResponse(String id);

    /**
     * @return a DrinksListResponse object representing all the non alcoholic drinks
     */
    Single<DrinksListResponse> getNonAlcoholicListResponse();

    /**
     * @return a DrinksListResponse object representing all the alcoholic drinks
     */
    Single<DrinksListResponse> getAlcoholicListResponse();
}
