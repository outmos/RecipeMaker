package com.e.recipemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
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
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);


    }

    public void next_clicked(View view) {
        String fileName = "dbUsername.csv";
        final String filePath = this.getFilesDir().getPath().toString() + fileName;


        File file = new File(filePath);
        boolean exists = file.exists();
        if (!exists) {
            writeFile(file, new String[]{"admin", "a"});
        }
        String[] record = {editText.getText().toString(),editText2.getText().toString()};
        if(!record[0].isEmpty() && !record[1].isEmpty() ) {
            writeFile(file, record);
            allergiesform(view);
        }

        readFile(file);
        System.out.println(filePath);
    }

    public void writeFile(File file, String[] record){
        try (CSVWriter writer = new CSVWriter(new FileWriter(file, true))){
            writer.writeNext(record);
            System.out.println(record);
        } catch (IOException e) {
            System.out.println("echec d'écriture");
            e.printStackTrace();
        }
    }

    public void readFile(File file){
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            System.out.println("lecture...");
            //Read CSV line by line and use the string array as you want
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    //Verifying the read data here
                    System.out.println(Arrays.toString(nextLine));
                }
            }
        } catch (IOException e) {
            System.out.println("echec de lecture");
            e.printStackTrace();
        }
    }


    public void allergiesform(View view) {
        Intent intent = new Intent(this, AllergiesActivity.class);
        startActivity(intent);
    }
}
