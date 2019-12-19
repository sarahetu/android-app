package com.example.myapplication.Data;


import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Single;

public interface ApiDataInterface {

    String JSONURL = "https://www.thecocktaildb.com/api/json/v1/1/";

    @GET("filter.php")
    Single<DrinksListResponse> listCocktailIds(@Query("c") String category);

    @GET("filter.php")
    Single<DrinksListResponse> getAlcoholFilter(@Query("a") String category);

    @GET("lookup.php")
    Single<ApiDataListResponse> searchCocktailById(@Query("i") String i);

    @GET("search.php")
    Single<ApiDataListResponse> getSearchResults(@Query("s") String search);

    @GET("random.php")
    Single<ApiDataListResponse> getRandomixer();

    @GET("lookup.php")
    Single<ApiDataListResponse> getDrinkById(@Query("i") String id);

}
