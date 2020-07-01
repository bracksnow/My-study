package com.example.finishday;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class RecommandActivity extends Activity {//라디오그룹의 버튼들을 누르면 수면에 좋은 음식, 안좋은 음식, 좋은 습관이 나옮
    LinearLayout habit, goodfood, badfood;
    RadioGroup group1;
    RadioButton radioArray[] = new RadioButton[3];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommand);
        group1 = (RadioGroup) findViewById(R.id.rGroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.radio0);
        radioArray[1] = (RadioButton) findViewById(R.id.radio1);
        radioArray[2] = (RadioButton) findViewById(R.id.radio2);
        habit = (LinearLayout) findViewById(R.id.habit);
        goodfood = (LinearLayout) findViewById(R.id.goodfood);
        badfood = (LinearLayout) findViewById(R.id.badood);
        final LinearLayout[] layout = {habit, goodfood, badfood};
        for (int i = 0; i < radioArray.length; i++) {//라디오 버튼을 누를 때마다 for문이 돌아감
            final int index; // 주의! 꼭 필요함.
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(index==2){//3번 누르면 배열 인덱스 2번째에 저장된 수면에 안 좋은 음식이 보임
                        layout[2].setVisibility(android.view.View.VISIBLE);
                        layout[1].setVisibility(View.GONE);//invisible는 공간은 차지하고 안 보이는 형태라 공간조차 차지하지 않도록 변경
                        layout[0].setVisibility(View.GONE);
                    }else if(index==1){//2번 누르면 배열 인덱스 1번째에 저장된 수면에 좋은 음식이 보임
                        layout[2].setVisibility(View.GONE);
                        layout[1].setVisibility(android.view.View.VISIBLE);
                        layout[0].setVisibility(View.GONE);

                    }else if(index==0){{//1번 누르면 배열 인덱스 0번째에 저장된 수면에 좋은 습관이 보임
                        layout[2].setVisibility(View.GONE);
                        layout[1].setVisibility(View.GONE);
                        layout[0].setVisibility(android.view.View.VISIBLE);
                    }}
                }
            });
        }

    }
}
