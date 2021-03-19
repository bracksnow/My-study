package com.example.myfavoritesong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Switch startSwitch;
    TextView startText;
    TextView select;
    RadioGroup radioButtons;
    RadioButton first;
    RadioButton second;
    RadioButton third;
    ImageView elbum;
    Button end;
    Button rollback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("좋아하는 노래는?");
        startSwitch = findViewById(R.id.start);
        select  = findViewById(R.id.select);
        radioButtons = findViewById(R.id.radioButtons);
        first = findViewById(R.id.songOne);
        second = findViewById(R.id.songTwo);
        third = findViewById(R.id.songOne);
        elbum = findViewById(R.id.songImage);
        end = findViewById(R.id.end);
        rollback = findViewById(R.id.rollback);

        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if (ischecked) {
                    select.setVisibility(View.VISIBLE);
                    radioButtons.setVisibility(View.VISIBLE);
                }
                else{
                    select.setVisibility(View.GONE);
                    radioButtons.setVisibility(View.GONE);
                    radioButtons.clearCheck();
                    elbum.setVisibility(View.GONE);

                }
            }
        });
        radioButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id==R.id.songOne){
                    elbum.setVisibility(View.VISIBLE);
                    elbum.setImageResource(R.drawable.dolphin);
                }else if(id==R.id.songTwo){
                    elbum.setVisibility(View.VISIBLE);
                    elbum.setImageResource(R.drawable.secret);
                }else{
                    elbum.setVisibility(View.VISIBLE);
                    elbum.setImageResource(R.drawable.fire);

                }

            }
        });
        rollback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSwitch.setChecked(false);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
