package com.example.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.Data.DrinkItemViewModel;
import com.example.myapplication.Fragments.IngredientsFragment;
import com.example.myapplication.R;


import java.util.ArrayList;
import java.util.List;

/**
 * An adapter to create a list with RecyclerView.
 * The app can display a scrolling list of elements, thanks to the use of RecyclerView.
 * The views in the list are represented by view Custom holder objects.
 * Each view holder is in charge of displaying a single item with a view.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {

    public static class CustomViewHolder extends RecyclerView.ViewHolder  {

        private View mView;

        private DrinkItemViewModel drinkItemViewModel;

        private TextView strDrink;
        private ImageView strDrinkThumb;
        private TextView strInstructions;
        private TextView strAlcoholic;


        private FragmentManager fragmentManager;

        /**
         * create a CustomViewHolder to display a drink with a picture, a name and his alcoholic category
         * @param itemView a View
         * @param fragmentManager a FragmentManager
         */
        public CustomViewHolder(@NonNull View itemView, FragmentManager fragmentManager) {
            super(itemView);
            mView = itemView;
            this.fragmentManager = fragmentManager;
            strDrink = mView.findViewById(R.id.testView_strDdrink);
            strDrinkThumb = mView.findViewById(R.id.imageView_strDrinkThumb);
            strInstructions = mView.findViewById(R.id.textView_strInstructions);
            strAlcoholic = mView.findViewById(R.id.testView_alcoholic);
        }


        /**
         * fill the view with information about the drink item
         * @param drinkItemViewModel a DrinkItemViewModel object
         */
        void bind(DrinkItemViewModel drinkItemViewModel){
            this.drinkItemViewModel = drinkItemViewModel;
            strDrink.setText(this.drinkItemViewModel.getmDrinkName());
            strAlcoholic.setText(this.drinkItemViewModel.getAlcoholic());
            Glide.with(mView)
                    .load(drinkItemViewModel.getmDrinkThumb())
                    .apply(new RequestOptions().override(200,200))
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(strDrinkThumb);
        }
    }

    private List<DrinkItemViewModel> drinkItemViewModelList;
    private FragmentManager fragmentManager;

    /**
     * Build an instance of the ListAdapter
     * @param fragmentManager a FragmentManager
     */
    public ListAdapter(FragmentManager fragmentManager){
        drinkItemViewModelList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
    }

    /**
     * fill the view model
     * @param drinkItemViewModelList a list of DrinkItemViewModel object
     */
    public void bindViewModels(List<DrinkItemViewModel> drinkItemViewModelList){
        this.drinkItemViewModelList.addAll(drinkItemViewModelList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_fragment, parent, false);

        return new CustomViewHolder(view, fragmentManager);
    }


    /**
     * fill the view
     * @param holder a CustomViewHolder
     * @param position an integer to represent the position
     */
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        final DrinkItemViewModel currentElement = drinkItemViewModelList.get(position);
        holder.bind(drinkItemViewModelList.get(position));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = IngredientsFragment.newInstance(currentElement);
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinkItemViewModelList.size();
    }
}
