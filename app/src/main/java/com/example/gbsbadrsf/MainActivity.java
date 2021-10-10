package com.example.gbsbadrsf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gbsbadrsf.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());



    }
}