package com.lqt.baitapintent2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText_HoTen, editText_NamSinh, editText_DiemToan, editText_DiemVan;
    Spinner spinner_KhuVuc;
    TextView textView_TongDiem;
    Button button_Send;

    ArrayAdapter<String> adapter;
    final static int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ListenSend();
    }

    private void ListenSend() {
        button_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("data_Ten", editText_HoTen.getText().toString());
                bundle.putString("data_NamSinh", editText_NamSinh.getText().toString());
                bundle.putString("data_DiemToan", editText_DiemToan.getText().toString());
                bundle.putString("data_DiemVan", editText_DiemVan.getText().toString());
                bundle.putString("data_KhuVuc", spinner_KhuVuc.getSelectedItem().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == MainActivity2.RESULT_CODE) {
            textView_TongDiem.setText(""+ data.getStringExtra("data_Re"));
            textView_TongDiem.setVisibility(View.VISIBLE);
        }

    }

    private void AnhXa() {
        editText_HoTen = (EditText) findViewById(R.id.EditText_HoTen);
        editText_NamSinh = (EditText) findViewById(R.id.EditText_NamSinh);
        editText_DiemToan = (EditText) findViewById(R.id.EditText_DiemToan);
        editText_DiemVan = (EditText) findViewById(R.id.EditText_DiemVan);
        spinner_KhuVuc = (Spinner) findViewById(R.id.Spinner_KhuVuc);
        textView_TongDiem = (TextView) findViewById(R.id.TextView_TongDiem);
        button_Send = (Button) findViewById(R.id.Button_Send);

        ArrayList<String> list = new ArrayList<>();
        list.add("Khu Vực 1");
        list.add("Khu Vực 2");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner_KhuVuc.setAdapter(adapter);
    }
}