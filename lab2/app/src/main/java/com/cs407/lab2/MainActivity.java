package com.cs407.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.myTextField);
//        Toast.makeText(MainActivity.this, myTextField.getText().toString(), Toast.LENGTH_LONG).show();
//        Log.i("INFO", "Button Pressed");
        goToActivity(myTextField.getText().toString());
    }

    public void goToActivity(String s){
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}