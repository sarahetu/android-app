package com.example.myapplication.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiData {

    @SerializedName("idDrink")
    @Expose
    private String idDrink;
    @SerializedName("strDrink")
    @Expose
    private String strDrink;
    @SerializedName("strAlcoholic")
    @Expose
    private String strAlcoholic;
    @SerializedName("strInstructions")
    @Expose
    private String strInstructions;
    @SerializedName("strDrinkThumb")
    @Expose
    private String strDrinkThumb;
    @SerializedName("strIngredient1")
    @Expose
    private String strIngredient1;
    @SerializedName("strIngredient2")
    @Expose
    private String strIngredient2;
    @SerializedName("strIngredient3")
    @Expose
    private String strIngredient3;
    @SerializedName("strIngredient4")
    @Expose
    private String strIngredient4;
    @SerializedName("strIngredient5")
    @Expose
    private String strIngredient5;

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }


    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }


    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }


}