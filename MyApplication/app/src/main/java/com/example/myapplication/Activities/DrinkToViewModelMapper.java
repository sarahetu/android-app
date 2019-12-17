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

    /**
     * @param drinks a List of ApiData objects
     *
     * @return a list of DrinkItemViewModel objects, each attribut of each object is associated
     * with the right element refered by the API
     */
    public List<DrinkItemViewModel> mapEachDataAttribut(List<ApiData> drinks) {
        List<DrinkItemViewModel> drinkList = new ArrayList<>();
        for (ApiData drink : drinks) {
            drinkList.add(mapEachDataAttribut(drink));
        }
        return drinkList;
    }

    /**
     * associate to each drink the right name, id, instruction and ingredients refered by the API
     * @param apiData
     * @return a DrinkItemViewModel with a right element associated, refered by the API
     */
    private DrinkItemViewModel mapEachDataAttribut(ApiData apiData){
        DrinkItemViewModel drinkItemViewModel = new DrinkItemViewModel();
        drinkItemViewModel.setmDrinkId(apiData.getIdDrink());
        drinkItemViewModel.setInstruction(apiData.getStrInstructions());
        drinkItemViewModel.setmDrinkName(apiData.getStrDrink());
        drinkItemViewModel.setmDrinkThumb(apiData.getStrDrinkThumb());
        drinkItemViewModel.setIngrdient1(apiData.getStrIngredient1());
        drinkItemViewModel.setIngrdient2(apiData.getStrIngredient2());
        drinkItemViewModel.setIngrdient3(apiData.getStrIngredient3());
        drinkItemViewModel.setIngrdient4(apiData.getStrIngredient4());
        drinkItemViewModel.setIngrdient5(apiData.getStrIngredient5());
        drinkItemViewModel.setAlcoholic(apiData.getStrAlcoholic());
        return drinkItemViewModel;
    }
}
