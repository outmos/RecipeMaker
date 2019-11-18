package com.e.recipemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilActivity extends AppCompatActivity {

    private TextView recipes;
    private TextView preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users");
        recipes =  findViewById(R.id.textView3);
        preferences = findViewById(R.id.textView5);
        ref.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("recipes").getValue(String.class);
                recipes.setText(value); // j'ai changé dans firebase y a plus de clé et donc ca marche
                String value2 = dataSnapshot.child("tags").getValue(String.class);
                //preferences.setText(value2); # si tu fais ca ca va poser problème à cause de la clé
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));
    }
}
