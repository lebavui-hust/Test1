package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Intent intent = getIntent();
        double param1 = intent.getDoubleExtra("PARAM1", 0.0);
        double param2 = intent.getDoubleExtra("PARAM2", 0.0);
        if (param2 == 0)
        {
            TextView textLog = findViewById(R.id.text_log);
            textLog.setText("Param 1: " + param1 + "\nParam 2: " + param2 + "\nResult: Failed");
            setResult(Activity.RESULT_CANCELED);
        }
        else
        {
            double result = param1 / param2;

            TextView textLog = findViewById(R.id.text_log);
            textLog.setText("Param 1: " + param1 + "\nParam 2: " + param2 + "\nResult: " + result);

            intent.putExtra("RESULT", result);
            setResult(Activity.RESULT_OK, intent);
        }

        findViewById(R.id.button_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}