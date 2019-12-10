package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //private ArrayList<GetApiData> contactList;
    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;


    //private ListView myList = null;

    /**
     * Adapter qui lie les fichiers à la liste
     */
    //private FileAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetApiData service = RetrofitClient.getRetrofitInstance().create(GetApiData.class);
        Call<List<ApiData>> call = service.getCocktail();
        System.out.println("callllllllll :" + call);
        System.out.println("callllllllll :" + service.getCocktail());

        call.enqueue(new Callback<List<ApiData>>() {

            @Override
            public void onResponse(Call<List<ApiData>> call, Response<List<ApiData>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<ApiData>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Unable to load cocktails", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDataList(List<ApiData> usersList) {

        //Get a reference to the RecyclerView//
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        myRecyclerView.setAdapter(myAdapter);
    }



/*
        myList = (ListView)findViewById(android.R.id.list);
        //registerForContextMenu(myList);

        // On ajoute un Listener sur les items de la liste
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // clic sur un élément de la liste
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long id) {
                File fichier = mAdapter.getItem(position);
                seeItem(fichier);
            }
        });

    }
*/





    /**
     * Utilisé pour visualiser un fichier
     * @param pFile le fichier à visualiser
     */
    /*
    private void seeItem(File pFile) {
        // On créé un Intent
        Intent i = new Intent(Intent.ACTION_VIEW);

        // On détermine son type MIME
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        String ext = pFile.getName().substring(pFile.getName().indexOf(".") + 1).toLowerCase();
        String type = mime.getMimeTypeFromExtension(ext);

        // On ajoute les informations nécessaires
        i.setDataAndType(Uri.fromFile(pFile), type);

        try {
            startActivity(i);
            // Et s'il n'y a pas d'activité qui puisse gérer ce type de fichier
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "Oups, vous n'avez pas d'application qui puisse lancer ce fichier", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    */


}
