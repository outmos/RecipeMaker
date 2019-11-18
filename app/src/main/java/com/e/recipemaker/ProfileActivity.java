package com.e.recipemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class ProfileActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        tabLayout =  findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(this);
        TabLayout.Tab tab = tabLayout.getTabAt(2);
        if(intent.getStringExtra("class") != "profile"){
            tab.select();
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //Log.d("d", "onCreate: ");
        //viewPager.setCurrentItem(tab.getPosition());

        if(tab.getPosition() == 0){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("class", "profile");
            startActivity(intent);
        }
        else if(tab.getPosition() == 1){
            Intent intent = new Intent(this, FridgeActivity.class);
            intent.putExtra("class", "profile");
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
