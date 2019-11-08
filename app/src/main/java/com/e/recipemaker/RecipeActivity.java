package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String recipe_name = extras.getString("recipe_name");
        String recipe_info = extras.getString("recipe_info");
        Integer recipe_rating = Integer.valueOf(getIntent().getStringExtra("recipe_rating"));
        Integer recipe_image = Integer.valueOf(getIntent().getStringExtra("recipe_image"));

        TextView nameTextField = (TextView) findViewById(R.id.recipeTitle);
        TextView infoTextField = (TextView) findViewById(R.id.recipeDetails);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.recipeRatingBar);
        ImageView imageView = (ImageView) findViewById(R.id.mainImageView);


        nameTextField.setText(recipe_name);
        infoTextField.setText(recipe_info);
        ratingBar.setRating(recipe_rating);
        imageView.setImageResource(recipe_image);

    }
}
