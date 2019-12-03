package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

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

        int image [] ={R.drawable.bascketbal,R.drawable.allgamesandroid,R.drawable.bascketbal,R.drawable.allgames};


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
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void addLocation() {
        String spinnerVlu = mSpinnerLocation.getSelectedItem().toString();

        if (!TextUtils.isEmpty(spinnerVlu)){
            String id = dblocation.push().getKey();
            Location locationAdr = new Location(id,spinnerVlu);
            dblocation.child(id).setValue(locationAdr);
            Toast.makeText(this, "the location has been added", Toast.LENGTH_SHORT).show();
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
