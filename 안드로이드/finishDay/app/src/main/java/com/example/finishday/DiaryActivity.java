package com.example.finishday;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class DiaryActivity extends Activity {

    DatePicker datePicker;
    TextView viewDatePick;
    EditText edtDiary;
    Button btnSave;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        viewDatePick = (TextView) findViewById(R.id.viewDatePick);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnSave = (Button) findViewById(R.id.btnSave);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);//현재 년도
        int cMonth = cal.get(Calendar.MONTH);//현재 월
        int cDay = cal.get(Calendar.DAY_OF_MONTH);//현재 날짜
        checkedDay(cYear, cMonth, cDay);


        // datePicker.init(연도,달,일)를 통해서 초기화
        //만일 datepicker에 아무것도 안 넣으면 자동으로 현재 날짜들로 초기화
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {//날짜가 변경되면 자동실행
                // 이미 선택한 날짜에 일기가 있는지 없는지 확인
                checkedDay(year, monthOfYear, dayOfMonth);
            }
        });

        // 저장/수정 버튼 누르면 실행되는 리스너
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDiary(fileName);
            }
        });
    }

    // 일기 파일 읽기
    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        // 파일 이름을 만듦
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";
        FileInputStream fis = null;//fileinputstream으로 파일 읽기
        try {
            fis = openFileInput(fileName);
            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();
            String str = new String(fileData, "UTF-8");
            edtDiary.setText(str);
            btnSave.setText("수정하기");
        } catch (Exception e) {
            edtDiary.setText("");
            btnSave.setText("새 일기 저장");
            e.printStackTrace();
        }
    }

    // 일기 저장하는 메소드
    @SuppressLint("WrongConstant")
    private void saveDiary(String readDay) {
        FileOutputStream fos = null;
        try {
            //fileoutput을 이용해 파일 저장
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = edtDiary.getText().toString();
            fos.write(content.getBytes());
            fos.close();//fileoutputstream 작업종료
            Toast.makeText(getApplicationContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();
        } catch (Exception e) { // Exception - 에러 종류 제일 상위
            e.printStackTrace();
        }
    }
}


