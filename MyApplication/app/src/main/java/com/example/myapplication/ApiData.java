package com.example.myapplication;

import android.provider.ContactsContract;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiData {

    @SerializedName("idCocktail")
    @Expose
    private int idCocktail;

    @SerializedName("nameCocktail")
    @Expose
    private String nameCocktail;

    @SerializedName("firstLetterCocktail")
    @Expose
    private String firstLetterCocktail;

    @SerializedName("idIngredient")
    @Expose
    private int idIngredient;

    @SerializedName("nameIngredient")
    @Expose
    private String nameIngredient;

    @SerializedName("firstLetterIngredient")
    @Expose
    private String firstLetterIngredient;

    public ApiData(String nameCocktail) {
        this.nameCocktail = nameCocktail;
    }

    public int getIdCocktail() {
        return idCocktail;
    }

    public void setIdCocktail(int idCocktail) {
        this.idCocktail = idCocktail;
    }

    public String getNameCocktail() {
        return nameCocktail;
    }

    public void setNameCocktail(String nameCocktail) {
        this.nameCocktail = nameCocktail;
    }

    public String getFirstLetterCocktail() {
        return firstLetterCocktail;
    }

    public void setFirstLetterCocktail(String firstLetterCocktail) {
        this.firstLetterCocktail = firstLetterCocktail;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public String getFirstLetterIngredient() {
        return firstLetterIngredient;
    }

    public void setFirstLetterIngredient(String firstLetterIngredient) {
        this.firstLetterIngredient = firstLetterIngredient;
    }




}