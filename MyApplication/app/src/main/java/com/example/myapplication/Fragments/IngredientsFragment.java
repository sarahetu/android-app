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
    private String id;
    private String name;
    private String thumb;
    private String instruction;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    private String ingredient5;
    private String alcoholic;
    private TextView textViewName;
    private ImageView textViewThumb;
    private TextView textViewInstruction;
    private TextView textViewIngredient1;
    private TextView textViewIngredient2;
    private TextView textViewIngredient3;
    private TextView textViewIngredient4;
    private TextView textViewIngredient5;
    private TextView textViewAlcoholic;



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
        ingredient3 = drinkItemViewModel.getIngrdient3();
        ingredient4 = drinkItemViewModel.getIngrdient4();
        ingredient5 = drinkItemViewModel.getIngrdient5();
        alcoholic = drinkItemViewModel.getAlcoholic();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.drink_fragment, container, false);

        textViewName = rootView.findViewById(R.id.tv_name_details);
        textViewThumb = rootView.findViewById(R.id.textView_image);
        textViewInstruction = rootView.findViewById(R.id.textView_instruction);
        textViewIngredient1 = rootView.findViewById(R.id.textView_ingredient1);
        textViewIngredient2 = rootView.findViewById(R.id.textView_ingredient2);
        textViewIngredient3 = rootView.findViewById(R.id.textView_ingredient3);
        textViewIngredient4 = rootView.findViewById(R.id.textView_ingredient4);
        textViewIngredient5 = rootView.findViewById(R.id.textView_ingredient5);
        textViewAlcoholic = rootView.findViewById(R.id.textView_alcoholic);

        textViewName.setText(name);
        textViewInstruction.setText(instruction);
        textViewIngredient1.setText(ingredient1);
        textViewIngredient1.setText(ingredient2);
        textViewIngredient1.setText(ingredient3);
        textViewIngredient1.setText(ingredient4);
        textViewIngredient1.setText(ingredient5);
        textViewIngredient1.setText(alcoholic);
        setIngredient(ingredient1, textViewIngredient1);
        setIngredient(ingredient2, textViewIngredient2);
        setIngredient(ingredient3, textViewIngredient3);
        setIngredient(ingredient4, textViewIngredient4);
        setIngredient(ingredient5, textViewIngredient5);
        setAlcoholic(alcoholic,textViewAlcoholic);
        Glide.with(rootView)
                .load(thumb)
                .apply(new RequestOptions().override(500,500))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(textViewThumb);

        return rootView;
    }

    public void setInstruction(String instruction, TextView textView){
        if (instruction != null && !instruction.isEmpty()){
            textView.setText(instruction);
        }
    }


    public void setIngredient(String ingredient, TextView textView){
        if (ingredient != null && !ingredient.isEmpty()){
            textView.setText(ingredient);
        }
    }

    public void setAlcoholic(String alcoholic, TextView textView){
        if(alcoholic != null && !alcoholic.isEmpty()){
            textView.setText(alcoholic);
        }
    }


}
