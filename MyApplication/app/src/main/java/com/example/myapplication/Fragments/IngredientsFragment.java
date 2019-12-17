package com.example.myapplication.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.R;

public class IngredientsFragment extends Fragment {

    private View rootView;

    // Data
    private String Id;
    private String Name;
    private String Thumb;
    private String Preparation;
    private String Ingredient1;

    // Elements
    private TextView tvCocktailName;
    private ImageView ivCocktailThumb;
    private TextView tvCocktailPreparation;
    private TextView tvIngredient1;



    public static IngredientsFragment newInstance(DrinkItemViewModel drinkItemViewModel){
        return new IngredientsFragment(drinkItemViewModel);
    }


    public IngredientsFragment(DrinkItemViewModel drinkItemViewModel){
        Id = drinkItemViewModel.getmDrinkId();
        Name = drinkItemViewModel.getmDrinkName();
        Thumb = drinkItemViewModel.getmDrinkThumb();
        Preparation = drinkItemViewModel.getInstruction();
        Ingredient1 = drinkItemViewModel.getIngrdient1();
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


        // Setting values
        tvCocktailName.setText(Name);
        Glide.with(rootView)
                .load(Thumb)
                .apply(new RequestOptions().override(300,300))
                .apply(RequestOptions.circleCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivCocktailThumb);
        tvCocktailPreparation.setText(Preparation);

        setIngredient(Ingredient1, tvIngredient1);

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
