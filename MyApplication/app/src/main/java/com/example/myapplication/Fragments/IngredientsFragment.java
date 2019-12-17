package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.R;

public class IngredientsFragment extends Fragment {

    private View rootView;

    // Data
    private String id;
    private String name;
    private String thumb;
    private String instruction;
    private String ingredient1;
    private String ingredient2;

    // Elements
    private TextView tvCocktailName;
    private ImageView ivCocktailThumb;
    private TextView tvCocktailPreparation;
    private TextView tvIngredient1;
    private TextView tvIngredient2;



    public static IngredientsFragment newInstance(DrinkItemViewModel drinkItemViewModel){
        return new IngredientsFragment(drinkItemViewModel);
    }


    public IngredientsFragment(DrinkItemViewModel drinkItemViewModel){
        id = drinkItemViewModel.getmDrinkId();
        name = drinkItemViewModel.getmDrinkName();
        thumb = drinkItemViewModel.getmDrinkThumb();
        instruction = drinkItemViewModel.getInstruction();
        ingredient1 = drinkItemViewModel.getIngrdient1();
        ingredient2 = drinkItemViewModel.getIngrdient2();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_ingredient, container, false);

        // Binding elements
        tvCocktailName = rootView.findViewById(R.id.tv_name_details);
        ivCocktailThumb = rootView.findViewById(R.id.iv_image_details);
        tvCocktailPreparation = rootView.findViewById(R.id.tv_preparation_details);
        tvIngredient1 = rootView.findViewById(R.id.tv_ingredient1_details);
        tvIngredient2 = rootView.findViewById(R.id.tv_ingredient2);


        // Setting values
        tvCocktailName.setText(name);
        Glide.with(rootView)
                .load(thumb)
                .apply(new RequestOptions().override(300,300))
                .apply(RequestOptions.circleCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivCocktailThumb);
        tvCocktailPreparation.setText(instruction);

        setIngredient(ingredient1, tvIngredient1);

        return rootView;
    }


    public boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }


    public void setIngredient(String ingredient, TextView tvContainer){
        if(!isNullOrEmpty(ingredient)){
            tvContainer.setText("- " + ingredient);
        }
    }


}
