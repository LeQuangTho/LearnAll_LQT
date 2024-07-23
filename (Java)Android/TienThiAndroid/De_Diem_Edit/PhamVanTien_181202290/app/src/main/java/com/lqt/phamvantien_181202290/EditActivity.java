package com.lqt.phamvantien_181202290;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class EditActivity extends AppCompatActivity {

    private DataBase database;
    private static final String NAME_DATABASE = "Sqlite_MaDe";
    private static final String NAME_TABLE = "ThiSinh_MaDe";
    private static final String COLUMN_NAME_1 = "SDB";
    private static final String COLUMN_NAME_2 = "HoTen";
    private static final String COLUMN_NAME_3 = "Toan";
    private static final String COLUMN_NAME_4 = "Ly";
    private static final String COLUMN_NAME_5 = "Hoa";

    private EditText editText_HoTen, editText_Toan, editText_Ly, editText_Hoa;
    private Button buttonAdd, buttonBack;
    private ThiSinh_13072000 data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        InitView();
        SetData();
        SetEvent();
    }

    private void SetData() {
        editText_HoTen.setText("" + data.getHoTen());
        editText_Toan.setText("" + data.getToan());
        editText_Ly.setText("" + data.getLy());
        editText_Hoa.setText("" + data.getHoa());
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
                String hoten = editText_HoTen.getText().toString();
                double toan = Double.parseDouble(editText_Toan.getText().toString());
                double ly = Double.parseDouble(editText_Ly.getText().toString());
                double hoa = Double.parseDouble(editText_Hoa.getText().toString());

                UpdateDataBase(data.getSBD(), hoten, toan, ly, hoa);
                Toast.makeText(EditActivity.this, "Đã sửa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    //Bài 5 ảnh 3
    private void UpdateDataBase(String sbd, String hoten, double toan, double ly, double hoa) {
        database = new DataBase(this, NAME_DATABASE, null, 1);
        String sql = String.format(Locale.US, "UPDATE %s SET %s = '%s', %s = '%f', %s = '%f', %s = '%f' WHERE %s = '%s';"
                , NAME_TABLE
                , COLUMN_NAME_2, hoten
                , COLUMN_NAME_3, toan
                , COLUMN_NAME_4, ly
                , COLUMN_NAME_5, hoa
                , COLUMN_NAME_1, sbd
        );
        database.Query(sql);
    }

    private void InitView() {
        editText_HoTen = findViewById(R.id.editText_HoTen);
        editText_Toan = findViewById(R.id.editText_Toan);
        editText_Ly = findViewById(R.id.editText_Ly);
        editText_Hoa = findViewById(R.id.editText_Hoa);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack = findViewById(R.id.button_Back);

        data = (ThiSinh_13072000) getIntent().getSerializableExtra("data");
    }
}