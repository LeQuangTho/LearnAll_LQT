package com.lqt.baitapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText_HoTen, editText_Tuoi;
    Spinner spinner_Que;
    Button button_Send;
    ImageView imageView_Avatar, imageView1, imageView2, imageView3;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    int ID_Anh = R.drawable.anh1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        Listen_Send();

    }

    private void Listen_Send() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Anh = R.drawable.anh1;
                imageView_Avatar.setImageResource(ID_Anh);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Anh = R.drawable.anh2;
                imageView_Avatar.setImageResource(ID_Anh);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID_Anh = R.drawable.ic_launcher_foreground;
                imageView_Avatar.setImageResource(ID_Anh);
            }
        });

        //Gửi Activity
        button_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageView_Avatar == null || editText_HoTen == null || editText_Tuoi == null || spinner_Que == null) {
                    Toast.makeText(MainActivity.this, "Bạn chưa điền đủ thông tin.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("data_ten", editText_HoTen.getText().toString());
                    bundle.putString("data_tuoi", editText_Tuoi.getText().toString());
                    bundle.putString("data_Que", spinner_Que.getSelectedItem().toString());
                    bundle.putInt("data_Anh", ID_Anh);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    private void AnhXa() {
        editText_HoTen = (EditText) findViewById(R.id.EditText_HoTen);
        editText_Tuoi = (EditText) findViewById(R.id.EditText_Tuoi);
        spinner_Que = (Spinner) findViewById(R.id.Spinner_Que);
        button_Send = (Button) findViewById(R.id.Button_Send);
        imageView_Avatar = (ImageView) findViewById(R.id.ImageView_Avatar);

        imageView1 = (ImageView) findViewById(R.id.ImageView_1);
        imageView2 = (ImageView) findViewById(R.id.ImageView_2);
        imageView3 = (ImageView) findViewById(R.id.ImageView_3);

        list = new ArrayList<String>();
        list.add("Hưng Yên");
        list.add("Thanh Hóa");
        list.add("Hà Nội");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner_Que.setAdapter(adapter);

    }
}