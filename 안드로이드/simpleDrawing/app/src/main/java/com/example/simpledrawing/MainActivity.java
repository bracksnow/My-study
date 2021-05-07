package com.example.simpledrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final static int LINE = 1, CIRCLE = 2, RECTANGLE = 3;
    static int curShape = LINE;
    static int curColor = Color.DKGRAY;
    static int round;
    static int style = 0;//채워서 그리기는 1 선으로 그리기는 0

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("간단 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 그리기");
        menu.add(0, 2, 0, "원 그리기");
        menu.add(0, 3, 0, "사각형 그리기");
        SubMenu sMenu = menu.addSubMenu("사각형 모서리 둥근 정도 고르기");
        sMenu.add(0, 4, 0, "20");
        sMenu.add(0, 5, 0, "40");
        sMenu.add(0, 6, 0, "80");
        SubMenu sMenu1 = menu.addSubMenu("채우기 여부");
        sMenu1.add(0, 7, 0, "선만 그리기");
        sMenu1.add(0, 8, 0, "내부 채우서 그리기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case 1:
                curShape = LINE; // 선
                return true;
            case 2:
                curShape = CIRCLE; // 원
                return true;
            case 3:
                curShape = RECTANGLE; // 사각형
                return true;
            case 4:
                round = 20;
                return true;
            case 5:
                round = 40;
                return true;
            case 6:
                round = 80;
                return true;
            case 7:
                style = 0;
                return true;
            case 8:
                style = 1;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {
        int startX = -1, startY = -1, stopX = -1, stopY = -1;
        Path path = new Path();

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    path.moveTo(startX, startY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    path.lineTo(stopX, stopY);
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();
                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(curColor);

            switch (curShape) {
                case LINE:
                    canvas.drawPath(path, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2)
                            + Math.pow(stopY - startY, 2));
                    switch (style){
                        case 0:
                            paint.setStyle(Paint.Style.STROKE);
                            canvas.drawCircle(startX, startY, radius, paint);
                            break;
                        case 1:
                            paint.setStyle(Paint.Style.FILL);
                            canvas.drawCircle(startX, startY, radius, paint);
                            break;
                    }
                    break;
                case RECTANGLE:
                    RectF rect = new RectF(startX, startY, stopX, stopY);
                    switch(round){
                        case 20:
                            switch (style){
                                case 0:
                                    paint.setStyle(Paint.Style.STROKE);
                                    canvas.drawRoundRect(rect,20,20, paint);
                                    break;
                                case 1:
                                    paint.setStyle(Paint.Style.FILL);
                                    canvas.drawRoundRect(rect,20,20, paint);
                                    break;
                            }
                            canvas.drawRoundRect(rect,20,20, paint);
                            break;
                        case 40:
                            switch (style){
                                case 0:
                                    paint.setStyle(Paint.Style.STROKE);
                                    canvas.drawRoundRect(rect,40,40, paint);
                                    break;
                                case 1:
                                    paint.setStyle(Paint.Style.FILL);
                                    canvas.drawRoundRect(rect,40,40, paint);
                                    break;
                            }
                            break;
                        case 80:
                            switch (style){
                                case 0:
                                    paint.setStyle(Paint.Style.STROKE);
                                    canvas.drawRoundRect(rect,80,80, paint);
                                    break;
                                case 1:
                                    paint.setStyle(Paint.Style.FILL);
                                    canvas.drawRoundRect(rect,80,80, paint);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }

    }
}
