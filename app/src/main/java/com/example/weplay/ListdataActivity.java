package com.example.weplay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ListdataActivity extends AppCompatActivity {
    TextView listdata;
    ImageView detailimageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


//        listdata= findViewById(R.id.listdata);
        detailimageView = findViewById(R.id.imageViewdetail);

        Intent intent = getIntent();
        int receivedImage = intent.getIntExtra("image",0);
        String receivedName =  intent.getStringExtra("name");


//        listdata.setText(receivedName);
        detailimageView.setImageResource(receivedImage);
        //enable back Button
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void browser1(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
        this.startActivity(Intent.createChooser(emailIntent, null));
    }

    public void browser2(View view){
        String PhoneNum = "+250 787971925";
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(PhoneNum.trim())));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    public void browser3(View view){
        Intent browser4Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Omoyi"));
        startActivity(browser4Intent);
    }
}

