package com.example.AndroidPaintTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MyView extends View {
    private float x1, y1, x2, y2;
    private boolean paintLine;
    private String sensorInfo;

    private int iteration;

    public MyView(Context context) {
        super(context);

        iteration = 0;

        // Таймеры используются для немгновенных операций и их события
        // обрабатываются вне UI Thread
//        Timer timer;
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                iteration++;
//                postInvalidate();
//            }
//        }, 0, 50);

        // Обратите внимание, что здесь потребуется класс android.os.Handler,
        // а _не_ что-то другое, проверьте
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iteration++;
                invalidate(); // Здесь, в отличие от таймера, можно писать invalidate()

                // Через 100 мс - повторить
                // this относится к объекту, который мы создали через new Runnable()
                // Дословно: повторить это же событие через секунду
                handler.postDelayed(this, 1000);
            }
        }, 0); // Начать через 0 мс


        sensorInfo = "";
        SensorManager sensorManager;
        sensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);

        Sensor sensor;
        sensor = sensorManager.getDefaultSensor(SensorManager.SENSOR_ORIENTATION);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                sensorInfo = "";
                for (int i = 0; i < sensorEvent.values.length; i++)
                    sensorInfo += String.format("%.2f;", sensorEvent.values[i]);
                //invalidate();
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
                // Не используется
            }
        }, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        paintLine = false;
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() >= 2) {
                    x1 = motionEvent.getX(0);
                    y1 = motionEvent.getY(0);
                    x2 = motionEvent.getX(1);
                    y2 = motionEvent.getY(1);
                    paintLine = true;
                } else {
                    paintLine = false;
                }
                invalidate();
                return true;
            }
        });

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint myPaint = new Paint();
        myPaint.setColor(Color.GREEN);
        myPaint.setTextSize(30);
        if (paintLine) {
            canvas.drawLine(x1, y1, x2, y2, myPaint);
        }
        canvas.drawText(String.format("iteration=%d", iteration), 0, 50, myPaint);
        canvas.drawText(String.format("sensor=%s", sensorInfo), 0, 100, myPaint);
    }
}
