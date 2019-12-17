package com.example.myapplication.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class IngredientsFragment extends Fragment {

    private TextView title;
    private TextView type;
    private TextView recette;
    private TextView ingredients;
    private ImageView image;
    private Activity activity;

    public IngredientsFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }


}
