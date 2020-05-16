package com.example.gridcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnadd, btnsub, btnmul, btndiv;
    Button[] numButtons = new Button[10];
    EditText edit1, edit2;
    TextView textResult;
    String num1;
    String num2;
    Integer result;
    Integer[] numBtndIDs  = {R.id.Btn0,R.id.Btn1,R.id.Btn2,R.id.Btn3,R.id.Btn4,R.id.Btn5,R.id.Btn6,R.id.Btn7,R.id.Btn8,R.id.Btn9};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.download_logo);
        setTitle("그리드레이아웃 계산기");
        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);
        for(i = 0;i<numBtndIDs.length;i++){
            numButtons[i] = (Button)findViewById(numBtndIDs[i]);
        }
        textResult = (TextView)findViewById(R.id.TextResult);
        btnadd = (Button)findViewById(R.id.BtnAdd);
        btnsub = (Button)findViewById(R.id.BtnSub);
        btndiv = (Button)findViewById(R.id.BtnDiv);
        btnmul = (Button)findViewById(R.id.BtnMul);
        btnsub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.matches("")||num2.matches("")){
                    Toast.makeText(getApplicationContext(),"먼저 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    result = Integer.parseInt(num1) - Integer.parseInt(num2);
                    textResult.setText("계산결과: " + result.toString());
                }

                return false;
            }
        });
        btnmul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.matches("")||num2.matches("")){
                    Toast.makeText(getApplicationContext(),"먼저 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    result = Integer.parseInt(num1) * Integer.parseInt(num2);
                    textResult.setText("계산결과: " + result.toString());
                }
                return false;
            }
        });
        btndiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.matches("")||num2.matches("")){
                    Toast.makeText(getApplicationContext(),"먼저 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    if(Integer.parseInt(num1)==0||Integer.parseInt(num2)==0){
                        Toast.makeText(getApplicationContext(),"나누기에선 0이 불가능합니다", Toast.LENGTH_SHORT).show();
                    }else{
                        result = Integer.parseInt(num1) / Integer.parseInt(num2);
                        textResult.setText("계산결과: " + result.toString());
                    }
                }
                return false;
            }
        });
        btnadd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                if(num1.matches("")||num2.matches("")){
                    Toast.makeText(getApplicationContext(),"먼저 숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    result = Integer.parseInt(num1) + Integer.parseInt(num2);
                    textResult.setText("계산결과: " + result.toString());
                }

                return false;
            }
        });
        for(i = 0;i<numBtndIDs.length;i++){
            final int index;
            index = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edit1.isFocused()==true){
                        num1 = edit1.getText().toString()+numButtons[index].getText().toString();
                        edit1.setText(num1);
                    }else if(edit2.isFocused()==true){
                        num2 = edit2.getText().toString()+numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
