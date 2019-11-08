package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

String[] nameArray = {"Tacos","Quiche Lorraine","Pizza"};

    String[] infoArray = {
            "Faboulous Tacos",
            "Delicious french dish",
            "\"Na pizza della madonna\"",
    };

    Integer[] imageArray = {R.drawable.tacos,
            R.drawable.quiche,
            R.drawable.pizza};

    Integer[] ratingArray = {3, 4, 5};




    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, infoArray, imageArray);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(whatever);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(HomeActivity.this, RecipeActivity.class);
                String recipe_name = nameArray[position];
                String recipe_info = infoArray[position];
                Integer recipe_rating = ratingArray[position];
                Integer recipe_image = imageArray[position];


                Bundle extras = new Bundle();

                extras.putString("recipe_name", recipe_name);
                extras.putString("recipe_info", recipe_info);
                extras.putString("recipe_rating", String.valueOf(recipe_rating));
                extras.putString("recipe_image", String.valueOf(recipe_image));

                intent.putExtras(extras);
                startActivity(intent);

            }
        });


    }
}
