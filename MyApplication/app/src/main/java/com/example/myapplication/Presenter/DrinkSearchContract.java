package com.example.myapplication.Presenter;

import com.example.myapplication.Data.DrinkItemViewModel;

import java.util.List;

/**
 * An interface to search drinks
 */
public interface DrinkSearchContract {

    /**
     * an interface to handle the fill views
     */
    interface View {

        /**
         * fill the view of the drinks
         * @param drinkItemViewModel a list of DrinkItemViewModel object
         */
        void displayDrinks(List<DrinkItemViewModel> drinkItemViewModel);

        /**
         * @param drinkItemViewModel a list of DrinkItemViewModel object
         * @return all the id drinks
         */
        List<String> getAllDrinksId(List<DrinkItemViewModel> drinkItemViewModel);
    }

    /**
     * an interface to handle the searching
     */
    interface Presenter {
        /**
         * search for ordinary drinks
         */
        void searchDrinks();

        /**
         * search for non alcoholic drinks
         */
        void searchNonAlcoholicDrinks();

        /**
         * search for alcoholic drinks
         */
        void searchAlcoholicDrinks();

        /**
         * connect to the right view to fill
         *
         * @param view
         */
        void attachView(View view);
    }
}
