package com.lqt.vetau_them;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EditVeTauActivity extends AppCompatActivity {

    private EditText editTextGaDi;
    private EditText editTextGaDen;
    private EditText editTextDonGia;
    private RadioGroup radioGroupKhuHoi;
    private Button buttonAdd;
    private Button buttonBack;
    private DataBase dataBase;
    private VeTau veTauSelected;
    private static final String NAME_DATABASE = "VeTau.sqlite";
    private static final String NAME_TABLE = "VeTau";
    private static final String COLUMN_NAME_1 = "ID_VeTau";
    private static final String COLUMN_NAME_2 = "GaDi";
    private static final String COLUMN_NAME_3 = "GaDen";
    private static final String COLUMN_NAME_4 = "DonGia";
    private static final String COLUMN_NAME_5 = "KhuHoi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ve_tau);

        initView();

        SetData();

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
                    Toast.makeText(EditVeTauActivity.this, "Bạn phải điền đầy đủ thông tin chứ!", Toast.LENGTH_SHORT).show();
                } else {
                    EditVeTau();
                    Toast.makeText(EditVeTauActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private void EditVeTau() {
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

        String sql = String.format("UPDATE %s SET %s = '%s', %s = '%s', %s = %d, %s = %d WHERE %s = %d;"
                , NAME_TABLE
                , COLUMN_NAME_2, gadi
                , COLUMN_NAME_3, gaden
                , COLUMN_NAME_4, dongia
                , COLUMN_NAME_5, (khuhoi ? 1 : 0)
                , COLUMN_NAME_1, veTauSelected.getID_VeTau()
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

    private void SetData() {
        editTextGaDi.setText(veTauSelected.getGaDi());
        editTextGaDen.setText(veTauSelected.getGaDen());
        editTextDonGia.setText(""+veTauSelected.getDonGia());
        if (veTauSelected.isKhuHoi()){
            radioGroupKhuHoi.check(R.id.radioButton_KhuHoi);
        }else{
            radioGroupKhuHoi.check(R.id.radioButton_MotChieu);
        }
    }

    private void initView() {
        editTextGaDi = (EditText) findViewById(R.id.editText_GaDi);
        editTextGaDen = (EditText) findViewById(R.id.editText_GaDen);
        editTextDonGia = (EditText) findViewById(R.id.editText_DonGia);
        radioGroupKhuHoi = (RadioGroup) findViewById(R.id.radioGroup_KhuHoi);
        buttonAdd = (Button) findViewById(R.id.button_Yes);
        buttonBack = (Button) findViewById(R.id.button_Cancel);

        veTauSelected = (VeTau) getIntent().getSerializableExtra("VeTau");
    }
}