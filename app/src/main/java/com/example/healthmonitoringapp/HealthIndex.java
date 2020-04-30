package com.example.healthmonitoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class HealthIndex extends AppCompatActivity {

    EditText ageOfUser;
    int age;

    TextView healthView, healthLabel;

    Button calculateIndex, getAdvice;

    RadioGroup waterRadioGr, exerciseRadioGr, dietRadioGr, walkRadioGr, diabeticRadioGr, lifestyleRadioGr;
    RadioGroup lifeBalanceRadioGr, stressRadioGr,  alcoholRadioGr, smokeRadioGr;
    RadioButton waterRadio, exerciseRadio, dietRadio, walkRadio, lifestyleRadio, diabeticRadio;
    RadioButton lifebalanceRadio, stressRadio,  alcoholRadio, smokeRadio;

    float waterVal, exerciseVal, dietVal, walkVal, alcoholVal, smokeVal, lifestyleVal, diabeticVal, lifeBalanceVal, stressVal;

    double healthIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_index);

        ageOfUser = findViewById(R.id.age_user);
        waterRadioGr = findViewById(R.id.water_radio_group);
        exerciseRadioGr = findViewById(R.id.exercise_radio_group);
        dietRadioGr = findViewById(R.id.diet_radio_group);
        walkRadioGr = findViewById(R.id.walk_radio_group);
        lifestyleRadioGr = findViewById(R.id.lifestyle_radio_group);
        diabeticRadioGr = findViewById(R.id.diabetic_radio_group);
        alcoholRadioGr = findViewById(R.id.alcohol_radio_group);
        stressRadioGr = findViewById(R.id.stress_radio_group);
        smokeRadioGr = findViewById(R.id.smoke_radio_group);
        lifeBalanceRadioGr = findViewById(R.id.work_life_balance_radio_group);

        healthView = findViewById(R.id.health_value);
        healthLabel = findViewById(R.id.health_label);
        calculateIndex = findViewById(R.id.calculate_health_index);
        getAdvice = findViewById(R.id.get_advice);

        calculateIndex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Map<String, Integer> scaleMapper = new HashMap<>();
                Map<String, Integer> negativeFactorMapper = new HashMap<>();

                scaleMapper.put("Less than 1 Litre", 1);
                scaleMapper.put("1 Litre", 2);
                scaleMapper.put("2 Litre", 3);
                scaleMapper.put("Greater than or equal to 3 Litre", 5);

                scaleMapper.put("Less than an hour", 1);
                scaleMapper.put("One Hour", 2);
                scaleMapper.put("Two Hour", 3);
                scaleMapper.put("Greater than or equal to Three Hour", 5);

                scaleMapper.put("One", 1);
                scaleMapper.put("Two", 2);
                scaleMapper.put("Three", 3);
                scaleMapper.put("Four", 4);
                scaleMapper.put("Five", 5);

                scaleMapper.put("Yes", 1);
                scaleMapper.put("No", 5);

                negativeFactorMapper.put("One", 5);
                negativeFactorMapper.put("Two", 4);
                negativeFactorMapper.put("Three", 3);
                negativeFactorMapper.put("Four", 2);
                negativeFactorMapper.put("Five", 1);



                waterRadio = findViewById(waterRadioGr.getCheckedRadioButtonId());
                exerciseRadio = findViewById(exerciseRadioGr.getCheckedRadioButtonId());
                dietRadio = findViewById(dietRadioGr.getCheckedRadioButtonId());
                walkRadio = findViewById(walkRadioGr.getCheckedRadioButtonId());
                lifestyleRadio = findViewById(lifestyleRadioGr.getCheckedRadioButtonId());
                diabeticRadio = findViewById(diabeticRadioGr.getCheckedRadioButtonId());
                alcoholRadio = findViewById(alcoholRadioGr.getCheckedRadioButtonId());
                stressRadio = findViewById(stressRadioGr.getCheckedRadioButtonId());
                smokeRadio = findViewById(smokeRadioGr.getCheckedRadioButtonId());
                lifebalanceRadio = findViewById(lifeBalanceRadioGr.getCheckedRadioButtonId());

                waterVal = scaleMapper.get(waterRadio.getText().toString());
                exerciseVal = scaleMapper.get(exerciseRadio.getText().toString());
                dietVal = scaleMapper.get(dietRadio.getText().toString());
                walkVal = scaleMapper.get(walkRadio.getText().toString());
                lifestyleVal = scaleMapper.get(lifestyleRadio.getText().toString());
                lifeBalanceVal = scaleMapper.get(lifebalanceRadio.getText().toString());
                diabeticVal = scaleMapper.get(diabeticRadio.getText().toString());
                alcoholVal = negativeFactorMapper.get(alcoholRadio.getText().toString());
                stressVal = negativeFactorMapper.get(stressRadio.getText().toString());
                smokeVal = negativeFactorMapper.get(smokeRadio.getText().toString());

                age = Integer.parseInt(ageOfUser.getText().toString());

                findHealthIndex();

                healthView.setText("Congrats \n Your are " + String.valueOf(healthIndex) + "%");
                healthLabel.setVisibility(View.VISIBLE);
                healthView.setVisibility(View.VISIBLE);
            }
        });


    }

    public void findHealthIndex() {

        healthIndex = 2 * (waterVal + exerciseVal + dietVal + walkVal + lifestyleVal + lifeBalanceVal + diabeticVal
                + (alcoholVal * (age < 40 ? 0.5 : 0.95))
                + (stressVal * (age < 40 ? 0.5 : 0.95))
                + (smokeVal * (age < 40 ? 0.5 : 0.95)));
    }
}
