package com.example.myapplication.Activities;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragments.ListFragment;
import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DrinkDisplayActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        configureBottomNavigationView();
        connectFragment(ListFragment.newInstance());
    }

    public void configureBottomNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> updateMainFragment(item.getItemId())
        );
    }


    public Boolean updateMainFragment(int i){
        Fragment f;
        switch (i){
            case R.id.list_view:
                f = ListFragment.newInstance();
                connectFragment(f);
                break;
        }

        return true;
    }

    public void connectFragment(Fragment f){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, f);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




}