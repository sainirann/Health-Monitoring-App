package com.example.healthmonitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {


    EditText weight, height;
    Button calculateBMI;
    TextView bmiValue, bmiLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        weight = findViewById(R.id.weight_bmi);
        height = findViewById(R.id.height_bmi);
        bmiValue = findViewById(R.id.bmi_value);
        bmiLabel = findViewById(R.id.bmi_label);

        calculateBMI = findViewById(R.id.calculate_bmi);

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wt = weight.getText().toString();
                String ht = height.getText().toString();

                if (wt != null && !wt.equals("") && ht != null && !ht.equals("")) {
                    float valueOfWeight = Float.parseFloat(wt);
                    float valueOfHeight = Float.parseFloat(ht);

                    float bmi  = (valueOfWeight / valueOfHeight / valueOfHeight) * 10000;
                    String result;
                    if (bmi <= 15f) {
                        result = getString(R.string.very_severely_underweight);
                    } else if (bmi > 15f && bmi <= 16f) {
                        result = getString(R.string.severely_underweight);
                    } else if (bmi > 16f && bmi <= 18.5f) {
                        result = getString(R.string.underweight);
                    } else if (bmi > 18.5f && bmi <= 25f) {
                        result = getString(R.string.normal);
                    } else if (bmi > 25f && bmi <= 30f) {
                        result = getString(R.string.normal);
                    } else if (bmi > 30f && bmi <= 35f) {
                        result = getString(R.string.obes_class_i);
                    } else if (bmi > 35f && bmi <= 40f) {
                        result = getString(R.string.obes_class_ii);
                    } else {
                        result = getString(R.string.obes_class_iii);
                    }
                    result = bmi + "\n" + result;
                    bmiValue.setText(result);
                    bmiLabel.setVisibility(View.VISIBLE);
                    bmiValue.setVisibility(View.VISIBLE);
                }

            }
        });


    }
}
