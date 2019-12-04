package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    Spinner mSpinnerLocation;
    ImageView btnAdd;
    ViewFlipper vFlipper;

    DatabaseReference dblocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int image [] ={R.drawable.football,R.drawable.yogachild,R.drawable.abakobwabako,R.drawable.allgames};


        dblocation = FirebaseDatabase.getInstance().getReference("locations");

        mSpinnerLocation = (Spinner)findViewById(R.id.spinnerLocation);
        btnAdd = (ImageView)findViewById(R.id.searchBtn);
        vFlipper = (ViewFlipper) findViewById(R.id.v_flipper);

        for (int images:image){
            flipperImages(images);
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLocation();


                String chosenLotion = mSpinnerLocation.getSelectedItem().toString();

                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                intent.putExtra("location",chosenLotion);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_recents:
                        Intent intn = new Intent(HomeActivity.this,HomeActivity.class);
                        startActivity(intn);
                        break;
                    case R.id.action_favorites:
                        Toast.makeText(HomeActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_nearby:
                        Toast.makeText(HomeActivity.this, "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }
    public void addLocation() {
        String spinnerVlu = mSpinnerLocation.getSelectedItem().toString();

        if (!TextUtils.isEmpty(spinnerVlu)){
            String id = dblocation.push().getKey();
            Location locationAdr = new Location(id,spinnerVlu);
            dblocation.child(id).setValue(locationAdr);
        }
        else{
            Toast.makeText(this, "you should select your location", Toast.LENGTH_SHORT).show();
        }

    }
    public void flipperImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        vFlipper.addView(imageView);
        vFlipper.setFlipInterval(1000);//2sec
        vFlipper.setAutoStart(true);

        //animation

        vFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        vFlipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
}
