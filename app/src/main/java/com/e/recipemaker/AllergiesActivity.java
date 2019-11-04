package com.e.recipemaker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class AllergiesActivity extends AppCompatActivity {

    private Button button_next;
    private CheckBox CheckBoxEggs;
    private CheckBox CheckBoxWheat;
    private CheckBox CheckBoxPeanut;
    private CheckBox CheckBoxMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);

    }


}
