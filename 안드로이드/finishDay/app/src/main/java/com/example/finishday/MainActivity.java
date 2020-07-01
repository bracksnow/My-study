package com.example.finishday;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;//음악을 재샏하기 위한 미디어플레이어 사용
    Button startButton;// 시작버튼
    Button stopButton;//종료버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("하마");
        ImageView rain = (ImageView) findViewById(R.id.imagerain);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(rain);//GIF파일을 적용하기 위한 코드
        Glide.with(this).load(R.drawable.rain).into(gifImage);//rain이라는 GIF파일을 적용한다는 의미
        startButton = (Button) findViewById(R.id.start);
        stopButton = (Button) findViewById(R.id.stop);
        startButton.setOnClickListener(new View.OnClickListener() {//음악재생버튼을 누르면 미디어플레이어가 시작
            @Override
            public void onClick(View view) {
                mediaPlayer  = MediaPlayer.create(MainActivity.this,R.raw.rainysound);//미디어플레이어 객체 생성
                mediaPlayer.start();//미디어 플레이어 시작
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {//종료버튼을 누르면 미디어플레이어가 멈춤
            @Override
            public void onClick(View view) {//음악중지버튼을 누르면 미디어플레이어 멈춤
                mediaPlayer.stop();
                mediaPlayer.reset();//미디어플레이어 객체를 초기화
            }
        });
    }
    @Override
    protected void onDestroy() {//미디어플레이어가 리소스를 잡아먹기 때문에 앱이 종료시에 미디어플레이어가
        super.onDestroy();
        // MediaPlayer 해지
        if(mediaPlayer != null) {//미디어 플레이어가 남아있으면
            mediaPlayer.release();//리소스를 잡아먹지 않도록 완전 파괴
            mediaPlayer = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//메뉴를 생성하는 부분
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//switch문를 사용해 time은 대화상자, diary와 recommand를 누르면 새로운 액티비티들을 띄움
        switch (item.getItemId()) {
            case R.id.time:
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);//현재 시간
                int minute = mcurrentTime.get(Calendar.MINUTE);//현재 분
                TimePickerDialog mTimePicker;//대화상자의 종류 중에 시간을 지정하는 대화상자사용
                mTimePicker = new TimePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        selectedHour = selectedHour-8;//추천 취침시간은 8시간을 기준
                        if(selectedHour<0){//24시간 기준이기 때문에 음수가 나오는 경우에는 +24를 해 시간을 변환
                            selectedHour=selectedHour+24;
                        }
                        Toast.makeText(getApplicationContext(),"(24시간 기준) "+selectedHour + "시 " + selectedMinute + "에는 취침하세요", Toast.LENGTH_SHORT).show();

                    }
                }, hour, minute, true);//시간은 24시간을 시준
                mTimePicker.setTitle("기상시간을 입력하세요");
                mTimePicker.show();

                return true;
            case R.id.diary:
                Intent intent = new Intent(getApplicationContext(),DiaryActivity.class);
                startActivity(intent);//DiaryActivity라는 액티비티를 띄움
                return true;
            default:
                Intent intent1 = new Intent(getApplicationContext(),RecommandActivity.class);
                startActivity(intent1);//Recommand라는 액티비티를 띄움
                return false;
        }
    }
}
