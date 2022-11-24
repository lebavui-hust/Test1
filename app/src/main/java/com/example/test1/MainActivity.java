package com.example.test1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editParam1, editParam2;
    TextView textNumber;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("TAG", "onCreate");

        findViewById(R.id.button_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.setData(Uri.parse("https://hust.edu.vn"));
                intent.putExtra("STRING_VALUE", "Hello");
                intent.putExtra("INT_VALUE", 123);
                intent.putExtra("FLOAT_VALUE", 3.14f);

                startActivity(intent);
            }
        });

        findViewById(R.id.button_web).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hust.edu.vn"));
                startActivity(intent);
            }
        });

        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0987654321"));
                startActivity(intent);
            }
        });

        findViewById(R.id.button_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Uri uri = Uri.parse("https://hust.edu.vn");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0987654321"));
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//                intent.putExtra(SearchManager.QUERY, "HUST");
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
//                intent.setType("application/pdf");
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent, 456);

//                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0987654321"));
//                intent.putExtra("sms_body", "Day la tin nhan thu nghiem.");
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/pictures/*");
//                startActivityForResult(intent, 789);

//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/1"));
//                startActivity(intent);

//                Uri uri = Uri.parse(ContactsContract.Contacts.CONTENT_URI + "/" + "1");
//                Intent intent = new Intent(Intent.ACTION_EDIT, uri);
//                startActivity(intent);

//                Uri uri = Uri.parse("geo:0,0?q=HUST");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

//                Uri uri = Uri.parse("http://maps.google.com/maps?"
//                        + "saddr=21.00295,105.84761&daddr=21.02413,105.84145");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

                String emailSubject = "Department Meeting";
                String emailText = "We’ll discuss the new project on Tue. at 9:00am @ room BU344";
                String[] emailReceiverList = {"v.matos@csuohio.edu"};

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("vnd.android.cursor.dir/email");
                intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailText);

                startActivity(intent);
            }
        });

        editParam1 = findViewById(R.id.edit_param_1);
        editParam2 = findViewById(R.id.edit_param_2);

        findViewById(R.id.button_calc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double param1 = Double.parseDouble(editParam1.getText().toString());
                double param2 = Double.parseDouble(editParam2.getText().toString());

                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                intent.putExtra("PARAM1", param1);
                intent.putExtra("PARAM2", param2);
                startActivityForResult(intent, 123);
            }
        });

        count = 0;
        textNumber = findViewById(R.id.text_number);
        textNumber.setText(String.valueOf(count));

        findViewById(R.id.button_increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textNumber.setText(String.valueOf(count));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.v("TAG", "Result here");
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 123) {
            if (resultCode == Activity.RESULT_OK) {
                double result = data.getDoubleExtra("RESULT", 0.0);
                Log.v("TAG", "Result: " + result);
            } else {
                Log.v("TAG", "Result: Failed");
            }
        } if (requestCode == 456) {
            if (resultCode == Activity.RESULT_OK) {
                Log.v("TAG", data.toString());
            }
        }  if (requestCode == 789) {
            if (resultCode == Activity.RESULT_OK) {
                Log.v("TAG", data.toString());
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v("TAG", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v("TAG", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("TAG", "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("TAG", "onSaveInstanceState");

        outState.putInt("COUNT", count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v("TAG", "onRestoreInstanceState");

        count = savedInstanceState.getInt("COUNT", 0);
        textNumber.setText(String.valueOf(count));
    }
}