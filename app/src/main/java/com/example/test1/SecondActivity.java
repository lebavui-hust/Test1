package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        Log.v("TAG", uri.toString());

        String stringValue = intent.getStringExtra("STRING_VALUE");
        int intValue = intent.getIntExtra("INT_VALUE", 0);
        float floatValue = intent.getFloatExtra("FLOAT_VALUE", 0f);

        Log.v("TAG", "stringValue: " + stringValue);
        Log.v("TAG", "intValue: " + intValue);
        Log.v("TAG", "floatValue: " + floatValue);

        findViewById(R.id.button_3rd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}