package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView locationEdit;
    TextView dispLocationText;
    String SpinnerValue;
    String[] SPINNERVALUES = {"BASKETBALL","VOLLEYBALL","FOOTBALL","YOGA","RUGBY","GIMY","TENNIS","CHILD"};
    Spinner spinner;
    Button GOTO;
    Intent intent;
    ViewFlipper vFlipper;
    ViewPager viewPager;
    List<model> models;
    Adapter adapter;
    Integer color []= null;
    RecyclerView mRecyclerView;
    List< PlaygroundData > mGroundList;
    PlaygroundData mGroundData;
    ImageView mBackbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBackbtn = findViewById(R.id.mBackButton);

        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mGroundList = new ArrayList<>();
        mGroundData = new PlaygroundData("Rose", getString(R.string.description_flower_rose),
                R.drawable.kigalichild);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Carnation", getString(R.string.description_flower_carnation),
                R.drawable.elitbako);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Tulip", getString(R.string.description_flower_tulip),
                R.drawable.kigalichild);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Daisy", getString(R.string.description_flower_daisy),
                R.drawable.kigalifoot);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Sunflower", getString(R.string.description_flower_sunflower),
                R.drawable.rg);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Daffodil", getString(R.string.description_flower_daffodil),
                R.drawable.tedipark);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Gerbera", getString(R.string.description_flower_gerbera),
                R.drawable.elitbako);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Orchid", getString(R.string.description_flower_orchid),
                R.drawable.kigalichild);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Iris", getString(R.string.description_flower_iris),
                R.drawable.tedipark);
        mGroundList.add(mGroundData);
        mGroundData = new PlaygroundData("Lilac", getString(R.string.description_flower_lilac),
                R.drawable.tedipark);
        mGroundList.add(mGroundData);

        Adapter myAdapter = new Adapter(MainActivity.this, mGroundList);
        mRecyclerView.setAdapter(myAdapter);

        locationEdit = (TextView) findViewById(R.id.locationEditText);
//        dispLocationText = (TextView) findViewById(R.id.textView1_dispLocationText);
//        spinner = (Spinner) findViewById(R.id.spinner2);
//        GOTO = (Button) findViewById(R.id.searchbtn);


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);
//// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
//        //Adding setOnItemSelectedListener method on spinner.
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//
//                SpinnerValue = (String) spinner.getSelectedItem();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        locationEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String chosenbaskLotion = locationEdit.getText().toString();

                Intent playgIntent = new Intent(MainActivity.this,BascketBall_Activity.class);
                playgIntent.putExtra("location",chosenbaskLotion);
                startActivity(playgIntent);
            }
        });


//        GOTO.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                switch(SpinnerValue){
//
//                    case "BASKETBALL":
//                       Intent intent = new Intent(MainActivity.this, BascketBall_Activity.class);
//                        startActivity(intent);
//                        break;
//
//                    case "VOLLEYBALL":
//                        intent = new Intent(MainActivity.this, VolleyBall_Activity.class);
//                        startActivity(intent);
//                        break;
//
//                    case "FOOTBALL":
//                        intent = new Intent(MainActivity.this, Football_Activity.class);
//                        startActivity(intent);
//                        break;
//                    case "YOGA":
//                        intent = new Intent(MainActivity.this, Yoga_Activity.class);
//                        startActivity(intent);
//                        break;
//                    case "CHILD":
//                        intent = new Intent(MainActivity.this, Child_Activity.class);
//                        startActivity(intent);
//                        break;
//                    case "GIMY":
//                        intent = new Intent(MainActivity.this, Gimy_Activity.class);
//                        startActivity(intent);
//                        break;
//                    case "RUGBY":
//                        intent = new Intent(MainActivity.this, Rugby_Activity.class);
//                        startActivity(intent);
//                        break;
//                    case "TENNIS":
//                        intent = new Intent(MainActivity.this, Tennis_Activity.class);
//                        startActivity(intent);
//                        break;
//
//
//
//                }
//            }
//        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        locationEdit.setText(location);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        Intent intn = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intn);
                        break;
                    case R.id.action_account:
                        Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_nearby:
                        Toast.makeText(MainActivity.this, "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        mBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

