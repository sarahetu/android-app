package com.example.myapplication.Presenter;

import com.example.myapplication.Data.DrinkItemViewModel;

import java.util.List;

public interface DrinkSearchContract {

    interface View {
        void displayDrinks(List<DrinkItemViewModel> drinkItemViewModel);
        List<String> getAllDrinksId(List<DrinkItemViewModel> drinkItemViewModel);
    }


    interface Presenter {
        void searchDrinks();
        void searchNonAlcoholicDrinks();
        void attachView(View view);
    }
}
