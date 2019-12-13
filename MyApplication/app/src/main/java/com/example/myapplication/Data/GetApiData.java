package com.example.myapplication.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GetApiData {

    @GET
    Call<ApiData> getsearchList(@Url String url);

    @GET("filter.php")
    Call<ApiData> getAlcoholFilter(@Query("a") String filter);

    @GET("filter.php")
    Call<ApiData> getIngredientFilter(@Query("i") String filter);

    @GET("filter.php")
    Call<ApiData> getDrinkTypeFilter(@Query("c") String filter);


    @GET("search.php")
    Call<ApiData> getSearchResults(@Query("s") String search);


    @GET("random.php")
    Call<ApiData> getRandomixer();


    @GET("lookup.php")
    Call<ApiData> getDrinkById(@Query("i") String id);


}
