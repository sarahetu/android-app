package com.example.myapplication.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/*
public class FavoritesFragment extends Fragment {

    public static final String COUNTER_STATE_KEY = "CounterState";
    private View rootView;
    private NavigationInterface navigationInterface;
    private Integer currentCounter;
    private Button addButton;
    private Button removeButton;
    private TextView counterTextView;

    public FavoritesFragment() {
    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NavigationInterface) {
            this.navigationInterface = (NavigationInterface) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_favorites, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("On activity created " + this);
        setupButtons();

        if (savedInstanceState != null) {
            currentCounter = savedInstanceState.getInt(COUNTER_STATE_KEY);
        } else {
            currentCounter = 4;
        }
        refreshCounter();
    }

    private void setupButtons() {
        addButton = rootView.findViewById(R.id.add_button);
        removeButton = rootView.findViewById(R.id.remove_button);
        counterTextView = rootView.findViewById(R.id.counter_textview);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCounter(true);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateCounter(false);
            }
        });
    }

    private void updateCounter(boolean increment) {
        if ((currentCounter > 0) || (currentCounter == 0 && increment)) {
            currentCounter = increment ? currentCounter + 1 : currentCounter - 1;
            refreshCounter();
        }
    }

    private void refreshCounter() {
        counterTextView.setText(Integer.toString(currentCounter));
        removeButton.setEnabled(currentCounter != 0);
        if (navigationInterface != null) {
            navigationInterface.updateFavoriteCounter(currentCounter);
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_STATE_KEY, currentCounter);
    }
}
*/