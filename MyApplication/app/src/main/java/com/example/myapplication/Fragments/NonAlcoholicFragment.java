package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Repository.DrinkToViewModelMapper;
import com.example.myapplication.Adapters.ListAdapter;
import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.Presenter.DrinkSearchContract;
import com.example.myapplication.Presenter.DrinkSearchPresenter;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment for the non alcoholic drinks
 */
public class NonAlcoholicFragment extends Fragment implements DrinkSearchContract.View {

    private View rootView;
    private RecyclerView recyclerView;
    private DrinkSearchContract.Presenter presenter;
    private ListAdapter listViewAdapter;
    private FragmentManager fragmentManager;
    private boolean isLayoutLinear = true;
    private NonAlcoholicFragment(){}


    /**
     * @return a new instance of the NonAlcoholicFragment
     */
    public static NonAlcoholicFragment newInstance(){
        return new NonAlcoholicFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.container_fragment, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));
        fragmentManager = getActivity().getSupportFragmentManager();
        setupRecyclerView();
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (isLayoutLinear) {
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    isLayoutLinear = false;
                } else {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    isLayoutLinear = true;
                }
            }
        });
        presenter = new DrinkSearchPresenter(
                RetrofitClient.getDrinkDisplayRepository(),
                new DrinkToViewModelMapper());
        presenter.searchNonAlcoholicDrinks();
        presenter.attachView(this);
        return rootView;
    }


    /**
     * set up the recycler view of the Alcoholic Fragment
     */
    public void setupRecyclerView(){
        recyclerView = rootView.findViewById(R.id.recyclerView);
        listViewAdapter = new ListAdapter(fragmentManager);
        recyclerView.setAdapter(listViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        isLayoutLinear=true;
    }

    /**
     * fill the view of the drinks
     * @param drinkItemViewModel a list of DrinkItemViewModel object
     */
    @Override
    public void displayDrinks(List<DrinkItemViewModel> drinkItemViewModel) {
        listViewAdapter.bindViewModels(drinkItemViewModel);
    }

    /**
     * @param drinkItemViewModel a list of DrinkItemViewModel object
     * @return all the id drinks
     */
    @Override
    public List<String> getAllDrinksId(List<DrinkItemViewModel> drinkItemViewModel) {
        List<String> drinksIds = new ArrayList<>();
        for(DrinkItemViewModel c : drinkItemViewModel){
            drinksIds.add(c.getmDrinkId());
        }
        return drinksIds;
    }
}
