package com.example.myapplication.Data;


import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Single;

/**
 * An interface to search for drinks in the API "TheCocktailDB"
 */
public interface ApiDataInterface {

    /**
     * @param category String representing the category of drinks
     * @return a DrinksListResponse of drinks filtered by category
     */
    @GET("filter.php")
    Single<DrinksListResponse> listCocktailIds(@Query("c") String category);

    /**
     * @param category String representing the alcoholic status
     * @return a DrinksListResponse of drinks filtered by alcoholic
     */
    @GET("filter.php")
    Single<DrinksListResponse> getAlcoholFilter(@Query("a") String category);

    /**
     * @param i String representing the id
     * @return an ApiDataListResponse of full cocktail lookup details by id
     */
    @GET("lookup.php")
    Single<ApiDataListResponse> searchCocktailById(@Query("i") String i);

    /**
     * @param search String representing the name
     * @return an ApiDataListResponse of cocktails searched by name
     */
    @GET("search.php")
    Single<ApiDataListResponse> getSearchResults(@Query("s") String search);

    /**
     * @return an ApiDataListResponse of random cocktails
     */
    @GET("random.php")
    Single<ApiDataListResponse> getRandomixer();

}
