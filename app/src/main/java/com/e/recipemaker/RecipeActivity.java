package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class RecipeActivity extends AppCompatActivity {

    String name, description;
    Integer image;

    @Override
        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details);

        Parcelable parcelable = getIntent().getParcelableExtra("DATE-KEY");
        Recipe recipe = Parcels.unwrap(parcelable);

        TextView nameTextField =  findViewById(R.id.name);
        ImageView imageView = findViewById(R.id.image);
        RatingBar ratingsView = findViewById(R.id.rating);
        TextView nutritionTextField = findViewById(R.id.nutrition);
        TextView timeTextField = findViewById(R.id.time);
        TextView ingredientsTextField = findViewById(R.id.ingredients);
        TextView instructionsTextField = findViewById(R.id.instruction);
        TextView commentsTextField = findViewById(R.id.comments);

        nameTextField.setText(recipe.getName());
        ratingsView.setRating(recipe.getRatings());
        Picasso.get().load(recipe.getImage()).into(imageView);
        nutritionTextField.setText(recipe.getNutrition());
        timeTextField.setText((recipe.getTime()));
        ingredientsTextField.setText(recipe.getIngredients());
        instructionsTextField.setText(recipe.getInstructions());
        commentsTextField.setText(recipe.getComments());
    }
}