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
        System.out.println("id:"+ userID);

        ref.child(userID).child("recipes").addValueEventListener((new ValueEventListener() {;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.print("zdzdz" + dataSnapshot.getKey());
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    System.out.println("key:"+child.getValue(String.class));
                    recipes.append(child.getValue(String.class) + " \n "); // j'ai changé dansa plus de clé et donc ca marche
                }

                System.out.println(dataSnapshot.child("tags").exists());
                for (DataSnapshot child : dataSnapshot.child("tags").getChildren()) {
                    System.out.println(child.getValue(String.class));
                }
                //String value2 = dataSnapshot.child("tags").get firebase y Value(String.class);
                //System.out.println("attention" + value2);
                //preferences.setText("pref");
                //preferences.setText(value2); // si tu fais ca ca va poser problème à cause de la clé
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }));
    }
}
