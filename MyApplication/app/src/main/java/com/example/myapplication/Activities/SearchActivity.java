package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.myapplication.Data.Cocktails;
import com.example.myapplication.Data.GetApiData;
import com.example.myapplication.Adapters.MyAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.RetrofitClient;
import com.example.myapplication.Data.ApiData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private String query;
    @BindView(R.id.toolbar_search)
    Toolbar toolbar;
    @BindView(R.id.recyclerView_search)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_search)
    SwipeRefreshLayout swipeRefreshLayout;

    private Context context;
    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_search);

        GetApiData service = RetrofitClient.getRetrofitInstance().create(GetApiData.class);
        Call<Cocktails> listcall = service.getSearchResults(mQuery);

        listcall.enqueue(new Callback<Cocktails>() {

            @Override
            public void onResponse(Call<Cocktails> call, Response<Cocktails> response) {
                System.out.println("-------------------------------INIT---------------------------------");
                Cocktails cocktails = response.body();
                if (cocktails != null) {
                    List<ApiData> drinks = cocktails.getDrinks();
                    if (drinks != null && drinks.size() != 0) {
                        mySearchAdapter.setCocktailList(drinks);
                        myRecyclerView.setVisibility(View.VISIBLE);
                        myEmptyView.setVisibility(View.GONE);
                    } else {
                        myRecyclerView.setVisibility(View.GONE);
                        myEmptyView.setVisibility(View.VISIBLE);
                    }
                }
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiData>> call, Throwable throwable) {
                Toast.makeText(SearchActivity.this, "Unable to load cocktails", Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void loadDataList(List<ApiData> usersList) {

        //Get a reference to the RecyclerView//
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        myRecyclerView.setAdapter(myAdapter);


    }


}
