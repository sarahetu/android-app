package com.example.myapplication.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Cocktail  {
    private String mDrinkName;
    private String mDrinkThumb;
    private String mDrinkId;

    public Cocktail() {
    }

    public Cocktail(String Id, String name, String Thumb) {
        this.mDrinkId = Id;
        this.mDrinkName = name;
        this.mDrinkThumb = Thumb;
    }

    public String getmDrinkName() {
        return mDrinkName;
    }

    public void setmDrinkName(String mDrinkName) {
        this.mDrinkName = mDrinkName;
    }

    public String getmDrinkThumb() {
        return mDrinkThumb;
    }

    public void setmDrinkThumb(String mDrinkThumb) {
        this.mDrinkThumb = mDrinkThumb;
    }

    public String getmDrinkId() {
        return mDrinkId;
    }

    public void setmDrinkId(String mDrinkId) {
        this.mDrinkId = mDrinkId;
    }

}
