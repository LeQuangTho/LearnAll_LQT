package com.lqt.congdiem2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SuaActivity extends AppCompatActivity {

    DataBase dataBase = new DataBase(this, "vetau.sqlite", null, 1);
    EditText editTextStaFrom, editTextStaTo, editTextMoney;
    CheckBox checkBoxDou;
    Button button;
    VeTau veTau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua);

        AnhXa();

        load();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ch;
                if (checkBoxDou.isChecked()) {
                    ch = 1;
                }else ch = 0;
                dataBase.QueryData("update VeTau set staFrom = '" + editTextStaFrom.getText() + "', staTo ='" + editTextStaTo.getText() + "', Money = " + editTextMoney.getText() + ", DOU = " + ch + " where ID = " + veTau.getID());
                startActivity(new Intent(SuaActivity.this, MainActivity.class));
            }
        });
    }

    private void load() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        veTau = (VeTau) bundle.getSerializable("data");

        editTextStaFrom.setText("" + veTau.getStaFROM());
        editTextStaTo.setText("" + veTau.getStaTO());
        editTextMoney.setText("" + veTau.getMONEY());
        checkBoxDou.setChecked(veTau.isDUO());
    }

    private void AnhXa() {
        editTextStaFrom = (EditText) findViewById(R.id.editText_staFrom);
        editTextStaTo = (EditText) findViewById(R.id.editText_staTo);
        editTextMoney = (EditText) findViewById(R.id.editText_Money);
        checkBoxDou = (CheckBox) findViewById(R.id.checkbox_DOU);
        button = (Button) findViewById(R.id.buttonSua);
    }
}