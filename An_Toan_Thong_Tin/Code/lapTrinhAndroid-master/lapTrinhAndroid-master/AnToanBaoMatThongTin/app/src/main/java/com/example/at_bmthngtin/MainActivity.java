package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonSo1, buttonSo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSo1 = (Button) findViewById(R.id.buttonSo1);
        buttonSo2 = (Button) findViewById(R.id.buttonSo2);


        buttonSo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentView(1);
            }
        });

        buttonSo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentView(2);
            }
        });

    }

    private void intentView(int val) {
        Intent intent = new Intent(MainActivity.this, ListMenuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("key", val);
        intent.putExtra("KatoIT", bundle);
        startActivity(intent);
    }
}