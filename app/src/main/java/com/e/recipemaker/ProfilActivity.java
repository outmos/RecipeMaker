package com.e.recipemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

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
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userID = user.getUid();
        //System.out.println("id:"+ userID);

        ref.child(userID).addValueEventListener((new ValueEventListener() {;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //System.out.print("zdzdz" + dataSnapshot.getKey());
                for (DataSnapshot child : dataSnapshot.child("recipes").getChildren()) {
                    //System.out.println("key:"+child.getValue(String.class));
                    recipes.append(child.getValue(String.class) + " \n "); // j'ai changé dansa plus de clé et donc ca marche
                }

                //System.out.println(dataSnapshot.child("tags").exists());
                for (DataSnapshot child : dataSnapshot.child("tags").getChildren()) {
                    preferences.append(child.getValue(String.class) + " \n ");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));
    }
}
