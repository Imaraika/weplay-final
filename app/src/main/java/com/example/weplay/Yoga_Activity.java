package com.example.weplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;

public class Yoga_Activity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.yoga2, R.drawable.yoga1, R.drawable.yoga3, R.drawable.yogachild,
            R.drawable.yogagacuriro,R.drawable.imyitozo, R.drawable.yoga2, R.drawable.yoga1, R.drawable.yogagacuriro, R.drawable.yogachild};

    String[] hsesRoad = {"707 Kicukiro Ave", "2206 gisz ruhango GD","2816 Beletoire Ave", "8227 Folcroft kigali", "9227 lene KK","707 Kicukiro Ave",
            "2206 gisz ruhango GD","2816 Beletoire Ave", "8227 Folcroft kigali", "9227 lene KK",};



    @BindView(R.id.listView) ListView listOfbasketballplayground;
//    @BindView(R.id.display_Location_TextView) TextView dispLocationText;
//    @BindView(R.id.imageViewoflist) ImageView img;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_);

//        img = (ImageView) findViewById(R.id.imageViewoflist) ;
//        dispLocationText = (TextView) findViewById(R.id.display_Location_TextView);
        listOfbasketballplayground = (ListView) findViewById(R.id.listView);

        Yoga_Activity.CustomerAdapter customerAdapter = new Yoga_Activity.CustomerAdapter();
        listOfbasketballplayground.setAdapter(customerAdapter);


        listOfbasketballplayground.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(Yoga_Activity.this, "My Playground ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                intent.putExtra("image",IMAGES[position]);
                intent.putExtra("name",hsesRoad[position]);
                startActivity(intent);

            }

        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
//        dispLocationText.setText("Houses available at " + location);

    }

    class CustomerAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView img = (ImageView)convertView.findViewById(R.id.imageViewoflist);
            TextView textView_Road = (TextView)convertView.findViewById(R.id.textView_Road);
//             TextView textView_descr = (TextView)convertView.findViewById(R.id.textView_descrp);
            img.setImageResource(IMAGES[i]);

//             iimm.setImageResource(IMAGES[i]);
            textView_Road.setText(hsesRoad[i]);
//             textView_descr.setText(hsesRoad[i]);

            return convertView;
        }
    }
}

