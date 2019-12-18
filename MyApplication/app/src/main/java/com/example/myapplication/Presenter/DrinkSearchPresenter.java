package com.example.myapplication.Presenter;

import com.example.myapplication.Activities.DrinkDisplayRepository;
import com.example.myapplication.Activities.DrinkToViewModelMapper;
import com.example.myapplication.Data.ApiDataListResponse;
import com.example.myapplication.Data.DrinksListResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;


public class DrinkSearchPresenter implements DrinkSearchContract.Presenter {

    private DrinkDisplayRepository drinkDisplayRepository;
    private DrinkSearchContract.View view;
    private CompositeDisposable compositeDisposable;
    private DrinkToViewModelMapper drinkToViewModelMapper;

    public DrinkSearchPresenter(DrinkDisplayRepository drinkDisplayRepository, DrinkToViewModelMapper drinkToViewModelMapper) {
        this.drinkDisplayRepository = drinkDisplayRepository;
        compositeDisposable = new CompositeDisposable();
        this.drinkToViewModelMapper = drinkToViewModelMapper;
    }

    @Override
    public void searchDrinks() {
        //compositeDisposable.clear();
        compositeDisposable.add(drinkDisplayRepository.getDrinksListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DrinksListResponse>() {

                    @Override
                    public void onSuccess(DrinksListResponse drinkListResponse) {

                        List<String> ids = view.getAllDrinksId(drinkToViewModelMapper.map(
                                drinkDisplayRepository,
                                drinkListResponse.getDrinks()
                        ));
                        displayDrinks(ids);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // handle the error case
                        System.out.println(e.toString());
                    }
                }));

    }

    @Override
    public void searchNonAlcoholicDrinks() {
        compositeDisposable.add(drinkDisplayRepository.getNonAlcoholicListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DrinksListResponse>() {

                    @Override
                    public void onSuccess(DrinksListResponse drinkListResponse) {

                        List<String> ids = view.getAllDrinksId(drinkToViewModelMapper.map(
                                drinkDisplayRepository,
                                drinkListResponse.getDrinks()
                        ));
                        displayDrinks(ids);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));

    }

    public void displayDrinks(List<String> ids){
        compositeDisposable.clear();
        for(String id : ids){
            compositeDisposable.add(drinkDisplayRepository.getDrinkSearchResponse(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableSingleObserver<ApiDataListResponse>() {
                        @Override
                        public void onSuccess(ApiDataListResponse apiDataListResponse) {
                            view.displayDrinks(drinkToViewModelMapper.mapEachDataAttribut(
                                    apiDataListResponse.getDrinks())
                            );
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    }));
        }
    }


    @Override
    public void attachView(DrinkSearchContract.View view) {
        this.view = view;
    }
}
