package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText firstInteger = findViewById(R.id.firstInteger);
        EditText secondInteger = findViewById(R.id.secondInteger);

        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button multiplyButton = findViewById(R.id.multiplyButton);
        Button divideButton = findViewById(R.id.divideButton);

        plusButton.setOnClickListener(v -> calculationFunction("add", firstInteger, secondInteger));
        minusButton.setOnClickListener(v -> calculationFunction("subtract", firstInteger, secondInteger));
        multiplyButton.setOnClickListener(v -> calculationFunction("multiply", firstInteger, secondInteger));
        divideButton.setOnClickListener(v -> calculationFunction("divide", firstInteger, secondInteger));
    }
    private void calculationFunction(String operation, EditText firstInteger, EditText secondInteger) {
        if (TextUtils.isEmpty(firstInteger.getText().toString()) || TextUtils.isEmpty(secondInteger.getText().toString())) {
            Toast.makeText(this, "Please enter both numbers!", Toast.LENGTH_SHORT).show();
            return;
        }
        double firstNum, secondNum;

        //Case: Textfield should only accept integers
        try {
            // Convert EditText to integers
            firstNum = Double.parseDouble(firstInteger.getText().toString());
            secondNum = Double.parseDouble(secondInteger.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid numbers!", Toast.LENGTH_SHORT).show();
            return;
        }
        double result = 0;

        switch (operation) {
            case "add":
                result = firstNum + secondNum;
                break;
            case "minus":
                result = firstNum - secondNum;
                break;
            case "multiply":
                result = firstNum * secondNum;
                break;
            case "divide":
                //Case: Divide by Zero
                if (secondNum == 0) {
                    Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = firstNum / secondNum;
                break;
            default:
                Toast.makeText(this, "Invalid operation!", Toast.LENGTH_SHORT).show();
                return;
        }
        Intent intent = new Intent(this, CalculatorActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}