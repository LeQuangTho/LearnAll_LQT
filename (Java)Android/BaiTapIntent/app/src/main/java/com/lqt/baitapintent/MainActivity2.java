package com.lqt.baitapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView_HoTen, textView_Tuoi, textView_Que;
    ImageView imageView_Avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        textView_HoTen.setText(bundle.getString("data_ten"));
        textView_Tuoi.setText(bundle.getString("data_tuoi"));
        textView_Que.setText(bundle.getString("data_Que"));
        imageView_Avatar.setImageResource(bundle.getInt("data_Anh"));
    }

    private void AnhXa() {
        textView_HoTen = (TextView) findViewById(R.id.TextView_HoTen);
        textView_Tuoi = (TextView) findViewById(R.id.TextView_Tuoi);
        textView_Que = (TextView) findViewById(R.id.TextView_Que2);
        imageView_Avatar = (ImageView) findViewById(R.id.ImageView_Avatar2);
    }
}