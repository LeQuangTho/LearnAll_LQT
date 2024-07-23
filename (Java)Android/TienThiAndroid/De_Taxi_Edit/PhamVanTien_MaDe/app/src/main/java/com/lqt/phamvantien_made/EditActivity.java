package com.lqt.phamvantien_made;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class EditActivity extends AppCompatActivity {

    private DataBase database;
    private static final String NAME_DATABASE = "Sqlite_13082000";
    private static final String NAME_TABLE = "Taxi_MaDe";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "soxe";
    private static final String COLUMN_NAME_3 = "quangduong";
    private static final String COLUMN_NAME_4 = "dongia";
    private static final String COLUMN_NAME_5 = "khuyenmai";

    private EditText editText_SoXe, editText_QuangDuong, editText_DonGia, editText_KhuyenMai;
    private Button buttonAdd, buttonBack;
    private Taxi_MaDe data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        InitView();
        SetData();
        SetEvent();
    }

    private void SetData() {
        editText_SoXe.setText("" + data.getSoXe());
        editText_QuangDuong.setText("" + data.getQuangDuong());
        editText_DonGia.setText("" + data.getDonGia());
        editText_KhuyenMai.setText("" + data.getKhuyenMai());
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
                int dongia = Integer.parseInt(editText_DonGia.getText().toString());
                int khuyenmai = Integer.parseInt(editText_KhuyenMai.getText().toString());

                UpdateDataBase(data.getId(), soxe, quangduong, dongia, khuyenmai);
                Toast.makeText(EditActivity.this, "Đã sửa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    //Bài 5 ảnh 3
    private void UpdateDataBase(int id, String soxe, double quangduong, int dongia, int khuyenmai) {
        database = new DataBase(this, NAME_DATABASE, null, 1);
        String sql = String.format(Locale.US, "UPDATE %s SET %s = '%s', %s = '%f', %s = '%d', %s = '%d' WHERE %s = '%d';"
                , NAME_TABLE
                , COLUMN_NAME_2, soxe
                , COLUMN_NAME_3, quangduong
                , COLUMN_NAME_4, dongia
                , COLUMN_NAME_5, khuyenmai
                , COLUMN_NAME_1, id
        );
        database.Query(sql);
    }

    private void InitView() {
        editText_SoXe = findViewById(R.id.editText_SoXe);
        editText_QuangDuong = findViewById(R.id.editText_QuanagDuong);
        editText_DonGia = findViewById(R.id.editText_DonGia);
        editText_KhuyenMai = findViewById(R.id.editText_KhuyenMai);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack = findViewById(R.id.button_Back);

        data = (Taxi_MaDe) getIntent().getSerializableExtra("data");
    }
}