package com.e.recipemaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Recipe> recipes;
    RecyclerViewAdapter adapter;
    ProgressDialog progressDialog;
    EditText search;
    ChipGroup chipGroup;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.recicler_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Auto Chef");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this,1);
        recyclerView.setLayoutManager((gridLayoutManager));

        search = findViewById(R.id.search);

        chipGroup = findViewById(R.id.filter_chip_group);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Items ...");
        recipes = new ArrayList<>();

        adapter = new RecyclerViewAdapter(HomeActivity.this, recipes);
        recyclerView.setAdapter(adapter);

        DatabaseReference myRef;
        myRef = FirebaseDatabase.getInstance().getReference("Recipes");
        progressDialog.show();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    recipes.clear();
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){
                        Recipe recipe = itemSnapshot.getValue(Recipe.class);
                        recipes.add(recipe);
                    }
                    adapter.notifyDataSetChanged();
                    progressDialog.dismiss();

                } else {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                progressDialog.dismiss();
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                ArrayList<Recipe> filterList = new ArrayList<>();

                for(Recipe recipe: recipes) {
                    if(recipe.getName().toLowerCase().contains(editable.toString().toLowerCase())){
                        filterList.add(recipe);
                    }
                }

                adapter.filteredList(filterList);
            }
        });

        for(int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    ArrayList<String> tags = new ArrayList<>();

                    for(int i = 0; i < chipGroup.getChildCount(); i++) {

                        Chip chip = (Chip) chipGroup.getChildAt(i);
                        if (chip.isChecked()) {
                            tags.add(chip.getChipText().toString());
                            System.out.println(chip.getChipText().toString());
                        }
                    }

                    ArrayList<Recipe> filterList = new ArrayList<>();

                    if(tags.size() > 0) {
                        for(Recipe recipe: recipes) {
                            if(recipe.getTags().containsAll(tags)){
                                filterList.add(recipe);
                            }
                        }
                    }
                    else {
                        filterList = recipes;
                    }

                    adapter.filteredList(filterList);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.logout){
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}