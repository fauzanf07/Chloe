package com.example.chloe.Activity;

import static com.example.chloe.R.color.dark_green;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chloe.R;
import com.example.chloe.Splash.SplashScreen;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        CardView indoorDaun = findViewById(R.id.indoor_daun);
        CardView indoorBunga = findViewById(R.id.indoor_bunga);
        CardView outdoorDaun = findViewById(R.id.outdoor_daun);
        CardView outdoorBunga = findViewById(R.id.outdoor_bunga);
        indoorDaun.setOnClickListener(this);
        indoorBunga.setOnClickListener(this);
        outdoorDaun.setOnClickListener(this);
        outdoorBunga.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String extra;
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        if(v.getId() == R.id.indoor_daun){
            intent.putExtra(ListActivity.EXTRA_KATEGORI, "indoor_daun");
        }
        if(v.getId() == R.id.indoor_bunga){
            intent.putExtra(ListActivity.EXTRA_KATEGORI, "indoor_bunga");
        }
        if(v.getId() == R.id.outdoor_daun){
            intent.putExtra(ListActivity.EXTRA_KATEGORI, "outdoor_daun");
        }
        if(v.getId() == R.id.outdoor_bunga){
            intent.putExtra(ListActivity.EXTRA_KATEGORI, "outdoor_bunga");
        }
        startActivity(intent);
    }
}