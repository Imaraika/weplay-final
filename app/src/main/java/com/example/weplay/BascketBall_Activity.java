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
import butterknife.ButterKnife;

public class BascketBall_Activity extends AppCompatActivity {
    int[] IMAGES = {R.drawable.basckbal2, R.drawable.basckbal2, R.drawable.basckbal2, R.drawable.basckbal2,
            R.drawable.basckbal2,R.drawable.basckbal2, R.drawable.basckbal2, R.drawable.basckbal2, R.drawable.elitbako, R.drawable.basckbal2};

    String[] hsesRoad = {"707 Kicukiro Ave", "2206 gisz ruhango GD","2816 Beletoire Ave", "8227 Folcroft kigali", "9227 lene KK","707 Kicukiro Ave",
            "2206 gisz ruhango GD","2816 Beletoire Ave", "8227 Folcroft kigali", "9227 nyamirambo NY",};



    @BindView(R.id.listView) ListView listOfbasketballplayground;
    @BindView(R.id.display_Location_TextView) TextView dispLocationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bascket_ball_);
        ButterKnife.bind(this);


//       img = (ImageView) findViewById(R.id.imageViewoflist) ;
        dispLocationText = (TextView) findViewById(R.id.display_Location_TextView);
        listOfbasketballplayground = (ListView) findViewById(R.id.listView);

        BascketBall_Activity.CustomerAdapter customerAdapter = new BascketBall_Activity.CustomerAdapter();
        listOfbasketballplayground.setAdapter(customerAdapter);


        listOfbasketballplayground.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(BascketBall_Activity.this, "My Playground ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
                intent.putExtra("image",IMAGES[position]);
                intent.putExtra("name",hsesRoad[position]);
                startActivity(intent);

            }

        });
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        dispLocationText.setText("Playground available at " + location);

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

