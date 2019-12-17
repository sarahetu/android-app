package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.ListAdapter;


import com.example.myapplication.Activities.DrinkToViewModelMapper;
import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.Presenter.DrinkSearchContract;
import com.example.myapplication.Presenter.DrinkSearchPresenter;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements DrinkSearchContract.View{

    private View rootView;
    private RecyclerView recyclerView;
    private DrinkSearchContract.Presenter presenter;
    private ListAdapter listViewAdapter;
    private FragmentManager fragmentManager;

    private ListFragment(){}

    /***
     * @return a new instance of a ListViewFragment
     */
    public static ListFragment newInstance(){
        return new ListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));

        fragmentManager = getActivity().getSupportFragmentManager();

        setupRecyclerView();

        presenter = new DrinkSearchPresenter(
                RetrofitClient.getDrinkDisplayRepository(),
                new DrinkToViewModelMapper());

        presenter.searchDrinks();

        presenter.attachView(this);

        return rootView;
    }

    /***
     * This method sets up the recycler view of the list view
     */
    public void setupRecyclerView(){
        recyclerView = rootView.findViewById(R.id.recyclerView);
        listViewAdapter = new ListAdapter(fragmentManager);
        recyclerView.setAdapter(listViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void displayDrinks(List<DrinkItemViewModel> drinkItemViewModel) {
        listViewAdapter.bindViewModels(drinkItemViewModel);
    }

    @Override
    public List<String> getAllDrinksId(List<DrinkItemViewModel> drinkItemViewModel) {
        List<String> ids = new ArrayList<>();

        for(DrinkItemViewModel c : drinkItemViewModel){
            ids.add(c.getmDrinkId());
        }

        return ids;
    }



}