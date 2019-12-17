package com.example.myapplication.Retrofit;

import android.content.Context;

import com.example.myapplication.Activities.DrinkDisplayDataRepository;
import com.example.myapplication.Activities.DrinkDisplayRemoteDataSource;
import com.example.myapplication.Activities.DrinkDisplayRepository;
import com.example.myapplication.Data.ApiDataInterface;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static ApiDataInterface drinkDisplayService;
    private static Retrofit retrofit;
    private static Gson gson;
    private static DrinkDisplayRepository drinkDisplayRepository;
    private static Context applicationContext;

    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";


    public static Retrofit getRetrofit() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static DrinkDisplayRepository getDrinkDisplayRepository() {
        if (drinkDisplayRepository == null) {
            drinkDisplayRepository = new DrinkDisplayDataRepository(
                    new DrinkDisplayRemoteDataSource(getDrinkDisplayService())
            );
        }
        return drinkDisplayRepository;
    }

    public static ApiDataInterface getDrinkDisplayService() {
        if (drinkDisplayService == null) {
            drinkDisplayService = getRetrofit().create(ApiDataInterface.class);
        }
        return drinkDisplayService;
    }
}
