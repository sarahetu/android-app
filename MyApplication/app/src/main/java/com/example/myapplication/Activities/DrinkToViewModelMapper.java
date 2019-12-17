package com.example.myapplication.Activities;

import com.example.myapplication.Data.ApiData;
import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.Data.Drinks;

import java.util.ArrayList;
import java.util.List;

public class DrinkToViewModelMapper {

    private DrinkItemViewModel map(Drinks drink) {
        DrinkItemViewModel drinkItemViewModel = new DrinkItemViewModel();
        drinkItemViewModel.setmDrinkId(drink.getIdDrink());
        return drinkItemViewModel;
    }

    public List<DrinkItemViewModel> map(DrinkDisplayRepository repository, List<Drinks> drinks){
        List<DrinkItemViewModel> drinkList = new ArrayList<>();

        for(Drinks drink : drinks){
            drinkList.add(map(drink));
        }
        return drinkList;
    }

    public List<DrinkItemViewModel> mapInfos(List<ApiData> drinks) {
        List<DrinkItemViewModel> drinkList = new ArrayList<>();
        for (ApiData drink : drinks) {
            drinkList.add(mapInfos(drink));
        }
        return drinkList;
    }

    private DrinkItemViewModel mapInfos(ApiData cocktailInfo){
        DrinkItemViewModel cocktailItemViewModel = new DrinkItemViewModel();
        cocktailItemViewModel.setmDrinkId(cocktailInfo.getIdDrink());
        cocktailItemViewModel.setIngrdient1(cocktailInfo.getStrIngredient1());
        cocktailItemViewModel.setInstruction(cocktailInfo.getStrInstructions());
        cocktailItemViewModel.setmDrinkName(cocktailInfo.getStrDrink());
        cocktailItemViewModel.setmDrinkThumb(cocktailInfo.getStrDrinkThumb());

        return cocktailItemViewModel;
    }
}
