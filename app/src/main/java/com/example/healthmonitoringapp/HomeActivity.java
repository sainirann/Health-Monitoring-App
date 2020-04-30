package com.example.healthmonitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void bmiCalculator(View view) {
        startActivity(new Intent(this, BMICalculator.class));
    }

    public void healthCalculator(View view) {
        startActivity(new Intent(this, HealthIndex.class));
    }
}
