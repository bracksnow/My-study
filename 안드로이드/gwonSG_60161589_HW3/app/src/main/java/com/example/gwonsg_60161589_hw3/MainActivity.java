package com.example.gwonsg_60161589_hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText edtAngle;
    ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("권선구 과제3 좋아하는 음식 고르기");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView.setRotation(Float.parseFloat(edtAngle.getText()
                        .toString()));
                return true;
            case R.id.item1:
                imageView.setImageResource(R.drawable.chicken);
                return true;
            case R.id.item2:
                imageView.setImageResource(R.drawable.pizza);
                return true;
            case R.id.item3:
                imageView.setImageResource(R.drawable.hamburger);
                return true;
        }
        return false;
    }
}