package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetApiData {

    // gros pb, app ne cesse de s'arreter, ne s'arreta pas quand @GET("/api/json/v1/1/lookup.php?i={idCocktail}") autre comme
    // @GET("/idCocktail")

    @GET("/api/json/v1/1/lookup.php")
    Call<List<ApiData>> getIdCocktail(@Query("i") int idCocktail);

    @GET("api/json/v1/1/randomselection.php")
    Call<List<ApiData>> getCocktail();

    @GET("/api/json/v1/1/search.php")
    Call<List<ApiData>> searchCocktailByName(@Query("s") String nameCocktail);


}
