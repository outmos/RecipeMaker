package com.e.recipemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ProfilActivity extends AppCompatActivity {

    private TextView recipes;
    private Switch switch1;
    private Switch switch2;
    private Switch switch3;
    private Switch switch4;
    private Switch switch5;
    private Switch switch6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        recipes =  findViewById(R.id.textView3);

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);
        switch4 = findViewById(R.id.switch4);
        switch5 = findViewById(R.id.switch5);
        switch6 = findViewById(R.id.switch6);


        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userID = user.getUid();


        ref.child(userID).addListenerForSingleValueEvent((new ValueEventListener() {;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.child("recipes").getChildren()) {
                    recipes.append("\u2022   " + child.getValue(String.class) + " \n ");
                }



                for (DataSnapshot child : dataSnapshot.child("tags").getChildren()) {

                    if(child.getValue(String.class).equals("vegetarian")){
                        switch1.setChecked(true);
                    }
                    if(child.getValue(String.class).equals("ovo-vegetarian")){
                        switch2.setChecked(true);
                    }
                    if(child.getValue(String.class).equals("lacto-vegetarian")){
                        switch3.setChecked(true);
                    }
                    if(child.getValue(String.class).equals("vegan")){
                        switch4.setChecked(true);
                    }
                    if(child.getValue(String.class).equals("halal")){
                        switch5.setChecked(true);
                    }
                    if(child.getValue(String.class).equals("kosher")){
                        switch6.setChecked(true);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("1");
                    recipesReference.setValue("vegetarian");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("1");
                    recipesReference.removeValue();
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("2");
                    recipesReference.setValue("ovo-vegetarian");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("2");
                    recipesReference.removeValue();
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("3");
                    recipesReference.setValue("lacto-vegetarian");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("3");
                    recipesReference.removeValue();
                }
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("4");
                    recipesReference.setValue("vegan");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("4");
                    recipesReference.removeValue();
                }
            }
        });
        switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("5");
                    recipesReference.setValue("halal");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("5");
                    recipesReference.removeValue();
                }
            }
        });
        switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("6");
                    recipesReference.setValue("kosher");
                }
                else{
                    DatabaseReference recipesReference = FirebaseDatabase.getInstance().getReference().child("Users").child(userID).child("tags");
                    recipesReference = recipesReference.child("6");
                    recipesReference.removeValue();
                }
            }
        });
    }


}
