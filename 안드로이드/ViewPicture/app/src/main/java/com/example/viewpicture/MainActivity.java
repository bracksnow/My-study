package com.example.viewpicture;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
public class MainActivity extends AppCompatActivity {
    Button btnstart, btnend;
    ViewFlipper vflipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("여행 가고 싶은 나라");

        btnstart = (Button)findViewById(R.id.Btnstart);
        btnend = (Button) findViewById(R.id.Btnend);
        vflipper = (ViewFlipper) findViewById(R.id.viewFlipper1);

        vflipper.setFlipInterval(1000);

        btnstart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                vflipper.startFlipping();
                return false;
            }
        });
        btnend.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                vflipper.stopFlipping();
                return false;
            }
        });
    }
}
