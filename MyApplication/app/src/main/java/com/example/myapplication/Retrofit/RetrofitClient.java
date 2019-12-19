package com.example.myapplication.Retrofit;

import com.example.myapplication.Repository.DrinkDisplayDataRepository;
import com.example.myapplication.Repository.DrinkDisplayRemoteDataSource;
import com.example.myapplication.Repository.DrinkDisplayRepository;
import com.example.myapplication.Data.ApiDataInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * a class to retrieve and upload JSON data via a REST based webservice.
 *
 */
public class RetrofitClient {

    private static ApiDataInterface drinkDisplayService;
    private static Retrofit retrofit;
    private static DrinkDisplayRepository drinkDisplayRepository;
    private static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";


    /**
     * configure which converter is used for the data serialization. For JSON we use GSon.
     * @return a Retrofit instance
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
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

    /**
     * @return a a drink display repository
     */
    public static DrinkDisplayRepository getDrinkDisplayRepository() {
        if (drinkDisplayRepository == null) {
            drinkDisplayRepository = new DrinkDisplayDataRepository(
                    new DrinkDisplayRemoteDataSource(getDrinkDisplayService())
            );
        }
        return drinkDisplayRepository;
    }

    /**
     * @return a drink display service
     */
    public static ApiDataInterface getDrinkDisplayService() {
        if (drinkDisplayService == null) {
            drinkDisplayService = getRetrofit().create(ApiDataInterface.class);
        }
        return drinkDisplayService;
    }
}
