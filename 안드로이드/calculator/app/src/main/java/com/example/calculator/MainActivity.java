package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button AddButton;
    Button SubButton;
    Button MulButton;
    Button DivButton;
    EditText edit1, edit2;
    TextView TextResult;
    String num1, num2;
    Integer result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        AddButton = (Button) findViewById(R.id.btnAdd);
        SubButton = (Button) findViewById(R.id.btnSub);
        MulButton= (Button) findViewById(R.id.btnMul);
        DivButton = (Button) findViewById(R.id.btnDiv);
        TextResult = (TextView) findViewById(R.id.TextResult);

        AddButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)+Integer.parseInt(num2);
                TextResult.setText("계산결과: "+result.toString());
                return false;
            }
        });
        SubButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)-Integer.parseInt(num2);
                TextResult.setText("계산결과: "+result.toString());
                return false;
            }
        });
        MulButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)*Integer.parseInt(num2);
                TextResult.setText("계산결과: "+result.toString());
                return false;
            }
        });
        DivButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)/Integer.parseInt(num2);
                TextResult.setText("계산결과: "+result.toString());
                return false;
            }
        });



    }
}
