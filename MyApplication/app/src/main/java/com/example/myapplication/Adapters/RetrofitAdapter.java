package com.example.myapplication.Adapters;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Data.ApiData;
import com.example.myapplication.R;

import java.util.ArrayList;


public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ApiData> dataModelArrayList;

    public RetrofitAdapter(Context ctx, ArrayList<ApiData> dataModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public RetrofitAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RetrofitAdapter.MyViewHolder holder, int position) {

        Picasso.get().load(dataModelArrayList.get(position).getStrDrinkThumb()).into(holder.strDrinkThumb);
        holder.strDrink.setText(dataModelArrayList.get(position).getStrDrink());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView strDrink;
        ImageView strDrinkThumb;

        public MyViewHolder(View itemView) {
            super(itemView);

            strDrink = (TextView) itemView.findViewById(R.id.strDrink);
            strDrinkThumb = (ImageView) itemView.findViewById(R.id.strDrinkThumb);
        }

    }
}
