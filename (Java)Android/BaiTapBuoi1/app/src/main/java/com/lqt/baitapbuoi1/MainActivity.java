package com.lqt.baitapbuoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tinh;
                try {
                    tinh = Integer.parseInt(editText1.getText().toString()) + Integer.parseInt(editText2.getText().toString());
                    textView.setText(""+ tinh);
                } catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "bạn chưa nhập đủ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void AnhXa() {
        editText1 = (EditText) findViewById(R.id.txtSo1);
        editText2 = (EditText) findViewById(R.id.txtSo2);
        textView = (TextView) findViewById(R.id.txtKetQua);
        button = (Button) findViewById(R.id.btTinh);
    }
}