package com.lqt.phamvantien_181202290;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//Bài 5 ảnh 1
public class AddActivity extends AppCompatActivity {
    private DataBase database;
    private static final String NAME_DATABASE = " Sqlite_181202290";
    private static final String NAME_TABLE = "Taxi_PhamVanTien";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "soxe";
    private static final String COLUMN_NAME_3 = "quangduong";
    private static final String COLUMN_NAME_4 = "dongia";
    private static final String COLUMN_NAME_5 = "khuyenmai";

    private EditText editText_SoXe, editText_QuangDuong, editText_DonGia, editText_KhuyenMai;
    private Button buttonAdd, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();

        SetEvent();
    }
//Bài 5 ảnh 2
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
                String soxe = editText_SoXe.getText().toString();
                double quangduong = Double.parseDouble(editText_QuangDuong.getText().toString());
                int dongia =  Integer.parseInt(editText_DonGia.getText().toString());
                int khuyenmai = Integer.parseInt(editText_KhuyenMai.getText().toString());

                InsertDataBase(soxe,quangduong,dongia,khuyenmai);
                Toast.makeText(AddActivity.this, "Đã Thêm", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    //Bài 5 ảnh 3
    private void InsertDataBase(String soxe, double quangduong, int dongia, int khuyenmai) {
        database = new DataBase(this, NAME_DATABASE, null, 1);
        String sql = String.format(Locale.US, "INSERT INTO %s VALUES (null,'%s','%f','%d','%d')"
                , NAME_TABLE
                , soxe
                , quangduong
                , dongia
                , khuyenmai
        );
        database.Query(sql);
    }

    private void initView() {
        editText_SoXe = (EditText) findViewById(R.id.editText_SoXe);
        editText_QuangDuong = (EditText) findViewById(R.id.editText_QuanagDuong);
        editText_DonGia = (EditText) findViewById(R.id.editText_DonGia);
        editText_KhuyenMai = (EditText) findViewById(R.id.editText_KhuyenMai);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonBack = (Button) findViewById(R.id.button_Back);
    }
}