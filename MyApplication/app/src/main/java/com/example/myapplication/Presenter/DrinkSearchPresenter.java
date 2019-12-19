package com.example.myapplication.Presenter;

import com.example.myapplication.Repository.DrinkDisplayRepository;
import com.example.myapplication.Repository.DrinkToViewModelMapper;
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


    /**
     * search for ordinary drinks
     */
    @Override
    public void searchDrinks() {
        compositeDisposable.add(drinkDisplayRepository.getDrinksListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DrinksListResponse>() {
                    @Override
                    public void onSuccess(DrinksListResponse drinkListResponse) {
                        displayDrinks(drinkListResponse);
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));
    }

    /**
     * search for non alcoholic drinks
     */
    @Override
    public void searchNonAlcoholicDrinks() {
        compositeDisposable.add(drinkDisplayRepository.getNonAlcoholicListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DrinksListResponse>() {
                    @Override
                    public void onSuccess(DrinksListResponse drinkListResponse) {
                        displayDrinks(drinkListResponse);
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));
    }


    /**
     * search for alcoholic drinks
     */
    @Override
    public void searchAlcoholicDrinks() {
        compositeDisposable.add(drinkDisplayRepository.getAlcoholicListResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<DrinksListResponse>() {
                    @Override
                    public void onSuccess(DrinksListResponse drinkListResponse) {
                        displayDrinks(drinkListResponse);
                    }
                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.toString());
                    }
                }));
    }


    /**
     * @param drinkListResponse a DrinksListResponse object
     */
    public void displayDrinks(DrinksListResponse drinkListResponse){
        List<String> ids = view.getAllDrinksId(drinkToViewModelMapper.map(
                drinkDisplayRepository,
                drinkListResponse.getDrinks()
        ));
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

    /**
     * connect to the right view to fill
     *
     * @param view
     */
    @Override
    public void attachView(DrinkSearchContract.View view) {
        this.view = view;
    }
}
