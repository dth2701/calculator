package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity {
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);
        textView2 = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
        double result =  intent.getDoubleExtra("result",0);
        textView2.setText(String.valueOf(result));

    }
}