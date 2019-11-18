package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    String[] nameArray = {"Tacos", "Quiche Lorraine", "Pizza"};

    String[] infoArray = {
            "Faboulous Tacos",
            "Delicious french dish",
            "\"Na pizza della madonna\"",
    };

    Integer[] imageArray = {R.drawable.tacos,
            R.drawable.quiche,
            R.drawable.pizza};

    Integer[] ratingArray = {3, 4, 5};


    private TabLayout tabLayout;


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


        Intent intent = getIntent();

        tabLayout =  findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(this);
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        if(intent.getStringExtra("class") != "home"){
            tab.select();
        }

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //Log.d("d", "onCreate: ");
        //viewPager.setCurrentItem(tab.getPosition());


        if(tab.getPosition() == 1){
            Intent intent = new Intent(this, FridgeActivity.class);
            intent.putExtra("class", "home");
            startActivity(intent);
        }
        else if(tab.getPosition() == 2){
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("class", "home");
            startActivity(intent);
        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
