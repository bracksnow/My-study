package com.example.androidversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Button endButton, undoButton;
    ImageView imgAndroid;
    RadioGroup group;
    RadioButton oreo, pie, Q;
    Switch agreeSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.download_logo);
        setTitle("안드로이드 사진보기");
        text1 = (TextView) findViewById(R.id.Start);
        text2 = (TextView) findViewById(R.id.Like);
        agreeSwitch = (Switch) findViewById(R.id.Agree);
        group = (RadioGroup) findViewById(R.id.VersionGroup);
        oreo = (RadioButton) findViewById(R.id.Oreo);
        pie = (RadioButton) findViewById(R.id.Pie);
        Q = (RadioButton) findViewById(R.id.Q);
        endButton = (Button) findViewById(R.id.End);
        undoButton = (Button) findViewById(R.id.Undo);
        imgAndroid = (ImageView)findViewById(R.id.Picture);
        final int[] picture = {R.drawable.oreo,R.drawable.pie,R.drawable.q};

        agreeSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    text2.setVisibility(View.VISIBLE);
                    group.setVisibility(View.VISIBLE);
                    imgAndroid.setVisibility(View.VISIBLE);
                    endButton.setVisibility(View.VISIBLE);
                    undoButton.setVisibility(View.VISIBLE);
                }
                else if(checked==false){
                    text2.setVisibility(View.INVISIBLE);
                    group.setVisibility(View.INVISIBLE);
                    endButton.setVisibility(View.INVISIBLE);
                    undoButton.setVisibility(View.INVISIBLE);
                    imgAndroid.setVisibility(View.INVISIBLE);
                }
            }
        });
        oreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAndroid.setImageResource(picture[0]);
            }
        });
        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAndroid.setImageResource(picture[1]);
            }
        });
        Q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAndroid.setImageResource(picture[2]);
            }
        });
        endButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                finish();
                return false;
            }
        });
        undoButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                text2.setVisibility(View.INVISIBLE);
                group.setVisibility(View.INVISIBLE);
                endButton.setVisibility(View.INVISIBLE);
                undoButton.setVisibility(View.INVISIBLE);
                imgAndroid.setImageResource(0);
                imgAndroid.setVisibility(View.INVISIBLE);
                group.clearCheck();
                agreeSwitch.setChecked(false);
                return false;
            }
        });
    }
}
