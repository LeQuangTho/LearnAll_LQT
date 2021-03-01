package com.example.appmenu;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SumActivity extends AppCompatActivity {
    TextView textViewKQ;
    EditText editTextSTN, editTextSTH;
    Button buttonSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        // Ánh xạ
        buttonSum = (Button) findViewById(R.id.buttonSum);
        textViewKQ = (TextView) findViewById(R.id.textViewKetQua);
        editTextSTN = (EditText) findViewById(R.id.editTextSoThuNhat);
        editTextSTH = (EditText) findViewById(R.id.editTextSoThuHai);
        // Bắt sự kiện
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double stn, sth, tong;
                if (editTextSTN.getText().toString().trim().length() > 0 && editTextSTH.getText().toString().trim().length() > 0) {
                    stn = Double.parseDouble(editTextSTN.getText().toString().trim());
                    sth = Double.parseDouble(editTextSTH.getText().toString().trim());
//                    tong = stn + sth;
//                    textViewKQ.setText("" + tong);
                    Intent intent = new Intent(SumActivity.this, NextActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("stn",stn);
                    bundle.putDouble("sth",sth);
                    intent.putExtra("Sum", bundle);
                    startActivity(intent);
                } else {
                    Toast.makeText(SumActivity.this, "Chưa đủ dữ liệu!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
