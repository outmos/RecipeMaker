package com.e.recipemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class DietaryRestrictionActivity extends AppCompatActivity {

    private Button button_next;
    private CheckBox CheckBoxVegan;
    private CheckBox CheckBox0Vegetarian;
    private CheckBox CheckBoxLVegetarian;
    private CheckBox CheckBoxPVegetarian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register3);

    }

    public void homeView(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


}
