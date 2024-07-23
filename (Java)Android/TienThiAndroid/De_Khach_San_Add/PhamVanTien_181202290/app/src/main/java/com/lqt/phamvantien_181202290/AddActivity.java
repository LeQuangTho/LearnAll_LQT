package com.lqt.phamvantien_181202290;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AddActivity extends AppCompatActivity {
    private DataBase database;
    private static final String NAME_DATABASE = "PhamVanTien_DB";
    private static final String NAME_TABLE = "HoaDon_PhamVanTien";
    private Button buttonAdd, buttonBack;

    private EditText editText_HoTenKhach, editText_SoPhong, editText_DonGia, editText_SoNgay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        InitView();
        SetEvent();
    }

    private void SetEvent() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hotenkhach = editText_HoTenKhach.getText().toString();
                int sophong = Integer.parseInt(editText_SoPhong.getText().toString());
                int dongia = Integer.parseInt(editText_DonGia.getText().toString());
                int songay = Integer.parseInt(editText_SoNgay.getText().toString());

                InsertDataBase(hotenkhach, sophong, dongia, songay);
                Toast.makeText(AddActivity.this, "Đã Thêm", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    //Bài 5 ảnh 3
    private void InsertDataBase(String name, int sophong, int dongia, int songay) {
        database = new DataBase(this, NAME_DATABASE, null, 1);
        String sql = String.format(Locale.US, "INSERT INTO %s VALUES (null,'%s','%d','%d','%d')"
                , NAME_TABLE
                , name
                , sophong
                , dongia
                , songay
        );
        database.Query(sql);
    }

    private void InitView() {
        editText_HoTenKhach = findViewById(R.id.editText_HoTenKhach);
        editText_SoPhong = findViewById(R.id.editText_SoPhong);
        editText_DonGia = findViewById(R.id.editText_DonGia);
        editText_SoNgay = findViewById(R.id.editText_SoNgay);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack = findViewById(R.id.button_Back);
    }
}