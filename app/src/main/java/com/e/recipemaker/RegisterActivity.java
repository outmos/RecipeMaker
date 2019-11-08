package com.e.recipemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button button_next;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ON EST AL");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register1);


    }

    public void allergiesform(View view) {
        Intent intent = new Intent(this, AllergiesActivity.class);
        startActivity(intent);
    }
}
