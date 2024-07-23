package com.lqt.ghino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private ImageButton imageButton_List, imageButton_Calculator, imageButton_More;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AnhXa();

        imageButton_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        imageButton_Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MayTinh.class));
            }
        });

        imageButton_More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                Toast.makeText(HomeActivity.this, "Chưa làm xong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa() {
        imageButton_List = (ImageButton) findViewById(R.id.button_List) ;
        imageButton_Calculator = (ImageButton) findViewById(R.id.button_Calculator);
        imageButton_More = (ImageButton) findViewById(R.id.button_More);
    }
}