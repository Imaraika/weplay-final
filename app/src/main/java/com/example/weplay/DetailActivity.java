package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailActivity extends AppCompatActivity {
    ImageView mGround;
    TextView mDescription;
    TextView mLocation;
    ImageView mBackbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        mGround = findViewById(R.id.ivImage);
        mDescription = findViewById(R.id.tvDescription);
        mLocation = findViewById(R.id.tvlocation);
        mBackbtn = findViewById(R.id.mBackButton);

        mBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mGround.setImageResource(mBundle.getInt("Image"));
            mDescription.setText(mBundle.getString("Description"));
            mLocation.setText(mBundle.getString("location"));
        }
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom2_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_post:
                        Intent intn = new Intent(DetailActivity.this,PostBlogActivity.class);
                        startActivity(intn);
                        break;
                    case R.id.action_events:
                        Intent eveIntent = new Intent(DetailActivity.this,EventActivity.class);
                        startActivity(eveIntent);
                        break;
                    case R.id.action_teams:
                        Intent tmIntent = new Intent(DetailActivity.this,TeamActivity.class);
                        startActivity(tmIntent);                        break;
                }
                return true;
            }
        });

    }
}
