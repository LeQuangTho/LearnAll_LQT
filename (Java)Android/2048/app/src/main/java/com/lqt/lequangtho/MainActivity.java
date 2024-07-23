package com.lqt.lequangtho;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btClickMe;
    TextView txtTest;
    FrameLayout frameLayout;
    GestureDetector gestureDetector;

    int SWIPE_THRESHOLD = 100;
    int SWIPE_VELOCITY_THRESHOLD = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTest = (TextView) findViewById(R.id.Ten);
        btClickMe = (Button) findViewById(R.id.abc);
        frameLayout = (FrameLayout) findViewById(R.id.main);

        btClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionActivity.class);
                startActivity(intent);
            }
        });

        gestureDetector = new GestureDetector(this,new myGesture());
        frameLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    class myGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() - e1.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                Toast.makeText(MainActivity.this, "Trái Sang Phải", Toast.LENGTH_SHORT).show();
            }
            else if (e1.getX() - e2.getX() > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD)
            {
                Toast.makeText(MainActivity.this, "Phải Sang Trái", Toast.LENGTH_SHORT).show();
            }
            else if (e2.getY() - e1.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD)
            {
                Toast.makeText(MainActivity.this, "Trên Xuống", Toast.LENGTH_SHORT).show();
            }

            else if (e1.getY() - e2.getY() > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD)
            {
                Toast.makeText(MainActivity.this, "Dưới Lên", Toast.LENGTH_SHORT).show();
            }

            txtTest.setText(""+ e1.getX() +" và " + e2.getX() +"\n"+ e1.getY() +" và " + e2.getY());

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
