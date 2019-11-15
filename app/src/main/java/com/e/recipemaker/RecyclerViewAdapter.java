package com.e.recipemaker;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private List<Recipe> recipes;

    public RecyclerViewAdapter(Context context, List<Recipe> recipes) {
        this.mContext=context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item,parent,false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        final Recipe recipe = recipes.get(position);

        holder.name.setText(recipes.get(position).getName());
        holder.servings.setText(String.valueOf(recipes.get(position).getServings())+"pp");
        holder.rating.setRating(recipes.get(position).getRatings());
        Picasso.get().load(recipes.get(position).getImage()).into(holder.image);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, RecipeActivity.class);

                Parcelable wrapped = Parcels.wrap(recipe);
                intent.putExtra("DATE-KEY", wrapped);

                // change of activity
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void filteredList(ArrayList<Recipe> filterList) {

        recipes = filterList;
        notifyDataSetChanged();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder {

    TextView name, servings;
    ImageView image;
    RatingBar rating;
    CardView mCardView;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        servings = itemView.findViewById(R.id.servings);
        image = itemView.findViewById(R.id.image);
        rating = itemView.findViewById(R.id.rating);
        mCardView = itemView.findViewById(R.id.my_card_view);
    }
}