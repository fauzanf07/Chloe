package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chloe.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();
    }
}