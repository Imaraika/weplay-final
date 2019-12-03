package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int image [] ={R.drawable.bascketbal,R.drawable.allgamesandroid,R.drawable.bascketbal,R.drawable.allgames};

        models = new ArrayList<>();
        models.add(new model(R.drawable.abakobwabako,"bascketball"));
        models.add(new model(R.drawable.yoga3,"allballs"));
        models.add(new model(R.drawable.yogachild,"allgames"));
        models.add(new model(R.drawable.football,"football"));
        models.add(new model(R.drawable.abakobwabako,"bascketball"));
        models.add(new model(R.drawable.bako,"allballs"));
        models.add(new model(R.drawable.vv,"allgames"));
        models.add(new model(R.drawable.kigalichild,"football"));

        adapter = new Adapter(models,this);
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0){
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 1){
                    Intent intentinnt = new Intent(MainActivity.this,Yoga_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 2){
                    Intent intentinnt = new Intent(MainActivity.this,Yoga_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 3){
                    Intent intentinnt = new Intent(MainActivity.this,Football_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 4){
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
                else if (position == 5){
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
               else if (position == 6){
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }
               else       if (position == 7){
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }

                else{
                    Intent intentinnt = new Intent(MainActivity.this,BascketBall_Activity.class);
                    startActivity(intentinnt);
                    Toast.makeText(MainActivity.this, "one item has been clicked", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenting = new Intent(MainActivity.this,BascketBall_Activity.class);
                startActivity(intenting);
            }
        });

        locationEdit = (TextView) findViewById(R.id.locationEditText);
//        dispLocationText = (TextView) findViewById(R.id.textView1_dispLocationText);
        spinner = (Spinner) findViewById(R.id.spinner2);
        GOTO = (Button) findViewById(R.id.searchbtn);
        vFlipper = (ViewFlipper) findViewById(R.id.v_flipper);

        for (int images:image){
            flipperImages(images);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //Adding setOnItemSelectedListener method on spinner.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                SpinnerValue = (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        locationEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String chosenbaskLotion = locationEdit.getText().toString();

                Intent playgIntent = new Intent(MainActivity.this,BascketBall_Activity.class);
                playgIntent.putExtra("location",chosenbaskLotion);
                startActivity(playgIntent);
            }
        });


        GOTO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch(SpinnerValue){

                    case "BASKETBALL":
                       Intent intent = new Intent(MainActivity.this, BascketBall_Activity.class);
                        startActivity(intent);
                        break;

                    case "VOLLEYBALL":
                        intent = new Intent(MainActivity.this, VolleyBall_Activity.class);
                        startActivity(intent);
                        break;

                    case "FOOTBALL":
                        intent = new Intent(MainActivity.this, Football_Activity.class);
                        startActivity(intent);
                        break;
                    case "YOGA":
                        intent = new Intent(MainActivity.this, Yoga_Activity.class);
                        startActivity(intent);
                        break;
                    case "CHILD":
                        intent = new Intent(MainActivity.this, Child_Activity.class);
                        startActivity(intent);
                        break;
                    case "GIMY":
                        intent = new Intent(MainActivity.this, Gimy_Activity.class);
                        startActivity(intent);
                        break;
                    case "RUGBY":
                        intent = new Intent(MainActivity.this, Rugby_Activity.class);
                        startActivity(intent);
                        break;
                    case "TENNIS":
                        intent = new Intent(MainActivity.this, Tennis_Activity.class);
                        startActivity(intent);
                        break;



                }
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        locationEdit.setText(location);

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

