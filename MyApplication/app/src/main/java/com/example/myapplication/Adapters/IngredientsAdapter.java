package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.Ingredients;

import java.util.ArrayList;
/*
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {


    private ArrayList<Ingredients> mMeasuresArrayList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public IngredientsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setMeasuresList(ArrayList<Ingredients> measuresList) {
        this.mMeasuresArrayList = measuresList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.recycler_item_ingredients, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Ingredients measures = mMeasuresArrayList.get(position);
        holder.mIngredientText.setText(measures.getIngredient());
        holder.mMeasureText.setText(measures.getMeasure());

        String ingredient = measures.getIngredient();
        String in = ingredient.replaceAll(" ", "%20");

    }


    @Override
    public int getItemCount() {
        return mMeasuresArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mIngredientsImage;
        TextView mIngredientText;
        TextView mMeasureText;

        MyViewHolder(View itemView) {
            super(itemView);

            mIngredientsImage = itemView.findViewById(R.id.list_ingredients_icon);
            mIngredientText = itemView.findViewById(R.id.list_ingredient_text);
            mMeasureText = itemView.findViewById(R.id.list_measure_text);

        }
    }
}
*/