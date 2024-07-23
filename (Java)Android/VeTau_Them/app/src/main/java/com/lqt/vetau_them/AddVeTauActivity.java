package com.lqt.vetau_them;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddVeTauActivity extends AppCompatActivity {

    private EditText editTextGaDi;
    private EditText editTextGaDen;
    private EditText editTextDonGia;
    private RadioGroup radioGroupKhuHoi;
    private Button buttonAdd;
    private Button buttonBack;
    private DataBase dataBase;
    private static final String NAME_DATABASE = "VeTau.sqlite";
    private static final String NAME_TABLE = "VeTau";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ve_tau);

        initView();

        SetListenActivity();
    }

    private void SetListenActivity() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckEmpty()) {
                    Toast.makeText(AddVeTauActivity.this, "Bạn phải điền đầy đủ thông tin chứ!", Toast.LENGTH_SHORT).show();
                } else {
                    AddVeTau();
                    Toast.makeText(AddVeTauActivity.this, "Đã Thêm", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }

    private void AddVeTau() {
        dataBase = new DataBase(this, NAME_DATABASE, null, 1);
        String gadi = editTextGaDi.getText().toString();
        String gaden = editTextGaDen.getText().toString();
        int dongia = Integer.parseInt(editTextDonGia.getText().toString());
        boolean khuhoi = false;
        switch (radioGroupKhuHoi.getCheckedRadioButtonId()) {
            case R.id.radioButton_KhuHoi:
                khuhoi = true;
                break;
            case R.id.radioButton_MotChieu:
                khuhoi = false;
                break;
        }

        String sql = String.format("INSERT INTO %s VALUES (null,'%s','%s','%d','%d')"
                , NAME_TABLE
                , gadi
                , gaden
                , dongia
                , (khuhoi ? 1 : 0)
        );
        dataBase.Query(sql);
    }

    private boolean CheckEmpty() {
        if (editTextGaDen.getText().toString().isEmpty()
                || editTextGaDi.getText().toString().isEmpty()
                || editTextDonGia.getText().toString().isEmpty()
                || radioGroupKhuHoi.getCheckedRadioButtonId() == -1) {
            return true;
        } else {
            return false;
        }
    }

    private void initView() {
        editTextGaDi = (EditText) findViewById(R.id.editText_GaDi);
        editTextGaDen = (EditText) findViewById(R.id.editText_GaDen);
        editTextDonGia = (EditText) findViewById(R.id.editText_DonGia);
        radioGroupKhuHoi = (RadioGroup) findViewById(R.id.radioGroup_KhuHoi);
        buttonAdd = (Button) findViewById(R.id.button_Yes);
        buttonBack = (Button) findViewById(R.id.button_Cancel);
    }
}