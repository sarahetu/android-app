package com.example.myapplication.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredients {

    private String Ingredient;
    private String Measure;

    public Ingredients() {
    }

    public String getIngredient() {
        return Ingredient;
    }

    public void setIngredient(String ingredient) {
        Ingredient = ingredient;
    }

    public String getMeasure() {
        return Measure;
    }

    public void setMeasure(String measure) {
        Measure = measure;
    }


    private Ingredients(Parcel in) {
        Ingredient = in.readString();
        Measure = in.readString();
    }

    public static final Parcelable.Creator<Ingredients> CREATOR = new Parcelable.Creator<Ingredients>() {
        @Override
        public Ingredients createFromParcel(Parcel in) {
            return new Ingredients(in);
        }

        @Override
        public Ingredients[] newArray(int size) {
            return new Ingredients[size];
        }
    };


}
