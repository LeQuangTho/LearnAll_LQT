package com.lqt.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Student student = new Student("Lê Quang Thọ", 2000,"Hưng Yên");
        Toast.makeText(this, student.getHoten() +"\n" + student.getNamsinh()+"\n"+student.getDiachi(), Toast.LENGTH_SHORT).show();

        button2 = (Button) findViewById(R.id.trang2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,baiTapListViewCB.class);
                startActivity(intent);
            }
        });

        button3 = (Button) findViewById(R.id.trang3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThemSuaXoaLV.class);
                startActivity(intent);
            }
        });

        button4 = (Button) findViewById(R.id.trang4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,banTraiCay.class);
                startActivity(intent);
            }
        });
    }
}