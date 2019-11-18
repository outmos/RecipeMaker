package com.e.recipemaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import com.e.recipemaker.IOFile;

public class RegisterActivity extends AppCompatActivity {

    private Button button_next;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        if (!exists)
            IOFile.writeFile(file, new String[]{"1", "admin", "a"});

        String[] record = {"0", editText.getText().toString(),editText2.getText().toString()};
        int id = IOFile.validateRecord(file, record);
        if(id > 0 ) {
            record[0]= String.valueOf(id);
            IOFile.writeFile(file, record);
            Intent intent = new Intent(this, AllergiesActivity.class);
            startActivity(intent);
        }
        else {
            editText.setText("");
            editText2.setText("");
        }

        IOFile.readFile(file);
        System.out.println(id);
    }


}
