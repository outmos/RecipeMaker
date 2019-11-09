package com.e.recipemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.e.recipemaker.IOFile;

import java.io.File;

public class SignInActivity  extends AppCompatActivity {
    private Button button_next;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ON SIGN IN");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void next_clicked(View view) {
        String fileName = "dbUsername.csv";
        final String filePath = this.getFilesDir().getPath().toString() + fileName;
        File file = new File(filePath);
        String[] record = {"0", editText.getText().toString(), editText2.getText().toString()};
        int id = IOFile.checkPassword(file, record);
        if (id > 0) {//1 admin, <=0 error
            Intent intent = new Intent(this, AllergiesActivity.class);
            startActivity(intent);
        }
        else {
            editText.setText("");
            editText2.setText("");
        }
        System.out.println("next");
    }
}