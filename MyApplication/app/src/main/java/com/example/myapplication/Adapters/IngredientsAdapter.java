package com.example.myapplication.Adapters;

/*
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {


    private ArrayList<Drinks> mMeasuresArrayList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public IngredientsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setMeasuresList(ArrayList<Drinks> measuresList) {
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

        final Drinks measures = mMeasuresArrayList.get(position);
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