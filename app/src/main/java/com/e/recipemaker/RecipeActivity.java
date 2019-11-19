package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


import org.parceler.Parcels;

public class RecipeActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_details);

        Parcelable parcelable = getIntent().getParcelableExtra("DATE-KEY");
        final Recipe recipe = Parcels.unwrap(parcelable);

        ImageButton addToFavoriteButton = findViewById(R.id.add_recipe);
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

        addToFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("recipes");
                recipesReference = recipesReference.child(recipe.getId());
                recipesReference.setValue(recipe.getName());
                Toast.makeText(RecipeActivity.this,"The recipe has been added to your favourites !",Toast.LENGTH_LONG).show();
            }
        });

    }
}