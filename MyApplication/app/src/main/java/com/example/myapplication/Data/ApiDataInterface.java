package com.example.myapplication.Data;

import android.renderscript.Element;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiDataInterface {

    String JSONURL = "https://www.thecocktaildb.com/api/json/v1/1/";

    @GET
    Call<ApiData> getsearchList(@Url String url);

    @GET("filter.php")
    Call<ApiData> getAlcoholFilter(@Query("a") String filter);

    @GET("filter.php")
    Call<ApiData> getIngredientFilter(@Query("i") String filter);

    @GET("filter.php")
    Call<ApiData> getDrinkTypeFilter(@Query("c") String filter);

    @GET("search.php?s=margarita")
    Call<String> getString();

    @GET("search.php")
    Call<ApiData> getSearchResults(@Query("s") String search);

    @GET("random.php")
    Call<ApiData> getRandomixer();

    @GET("lookup.php")
    Call<ApiData> getDrinkById(@Query("i") String id);


}
