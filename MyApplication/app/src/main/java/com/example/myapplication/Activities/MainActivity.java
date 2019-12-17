package com.example.myapplication.Activities;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Adapters.RetrofitAdapter;
import com.example.myapplication.Data.ApiData;
import com.example.myapplication.Data.ApiDataInterface;

import com.example.myapplication.Data.Cocktail;
import com.example.myapplication.Data.Cocktails;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AlcoholFilterJob";

    private RetrofitAdapter retrofitAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        fetchJSON();

    }

    private void fetchJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiDataInterface.JSONURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiDataInterface api = retrofit.create(ApiDataInterface.class);

        //a voirrr Mixo
        /*
        Call<Cocktails> listCall = api.getAlcoholFilter(filter);
        listCall.enqueue(new Callback<Cocktails>() {
            @Override
            public void onResponse(@NonNull Call<Cocktails> call, @NonNull Response<Cocktails> response) {
                Cocktails cocktails = response.body();

                if (cocktails != null) {
                    List<ApiData> drinks = cocktails.getDrinks();
                    insertBulkData(uri, drinks, getApplicationContext());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Cocktails> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "Throwable " + t, Toast.LENGTH_SHORT).show();

            }
        });

         */



        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Responsestring", response.body().toString());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                        //Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });



    }

    //a voirrr Mixo
    /*
    private void insertBulkData(Uri uri, List<ApiData> list, Context mAct) {
        Vector<ContentValues> cVVector = new Vector<>(list.size());

        final String _id = "_id";
        final String Name = "name";
        final String Thumb = "thumb";

        ArrayList<Cocktail> drinkList = new ArrayList<>();

        Cursor cursor = mAct.getContentResolver().query(uri
                , null
                , null
                , null
                , null);

        assert cursor != null;
        if (cursor.moveToFirst()) {
            do {
                Cocktail cocktail = new Cocktail();

                cocktail.setmDrinkId(cursor.getString(cursor.getColumnIndex(_ID)));
                cocktail.setmDrinkName(cursor.getString(cursor.getColumnIndex(DRINK_NAME)));
                cocktail.setmDrinkThumb(cursor.getString(cursor.getColumnIndex(DRINK_THUMB)));

                drinkList.add(cocktail);
            }
            while (cursor.moveToNext());
        }
        cursor.close();

        for (ApiData drink : list) {
            ContentValues contentValues = new ContentValues();

            String id = drink.getIdDrink();
            boolean isThere = isDrinkInDatabase(id, drinkList);

            if (drink.getStrDrinkThumb() != null && !drink.getStrDrinkThumb().equals("") && !drink.getStrDrinkThumb().equals("null")) {
                if (!isThere) {
                    contentValues.put(_id, drink.getIdDrink());
                    contentValues.put(Name, drink.getStrDrink());
                    contentValues.put(DRINK_THUMB, drink.getStrDrinkThumb());
                    Log.v(TAG, "url" + drink.getStrDrinkThumb());
                    cVVector.add(contentValues);
                }
            }
        }
        if (cVVector.size() > 0) {
            ContentValues[] cvArray = new ContentValues[cVVector.size()];
            cVVector.toArray(cvArray);
            mAct.getContentResolver().bulkInsert(uri, cvArray);
        }
    }

    //a voirrr Mixo
    private boolean isDrinkInDatabase(String id, ArrayList<Cocktail> drinkList) {
        for (Cocktail listItem : drinkList) {
            if (listItem.getmDrinkId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    */



    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response
            JSONObject obj = new JSONObject(response);
            if(obj.optString("status").equals("true")){

                ArrayList<ApiData> modelRecyclerArrayList = new ArrayList<>();
                JSONArray dataArray  = obj.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {

                    ApiData modelRecycler = new ApiData();
                    JSONObject dataobj = dataArray.getJSONObject(i);


                    System.out.println(dataobj.getString("-----------------------------"));
                    System.out.println(dataobj.getString("strDrinkThumb"));

                    modelRecycler.setStrDrinkThumb(dataobj.getString("strDrinkThumb"));
                    modelRecycler.setStrDrink(dataobj.getString("strDrink"));


                    modelRecyclerArrayList.add(modelRecycler);

                }

                retrofitAdapter = new RetrofitAdapter(this,modelRecyclerArrayList);
                recyclerView.setAdapter(retrofitAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

            }else {
                Toast.makeText(MainActivity.this, obj.optString("message")+"", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}