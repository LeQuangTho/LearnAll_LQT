package com.lqt.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class ThemMoiActivity extends AppCompatActivity {

    DataBase dataBase;
    EditText editTextName, editTextContact;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi);
        Intent intent = getIntent();
        dataBase = new DataBase(this, "contact.sqlite", null, 1);

        AnhXa();
        mListen();
    }

    private void mListen() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().equals("") || editTextContact.getText().toString().equals("")) {
                    Toast.makeText(ThemMoiActivity.this, "Hãy nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    dataBase.QueryData("Insert into Contact VALUES(null,'"
                            + editTextName.getText().toString() + "', '" + editTextContact.getText().toString() + "', 0)");
                    Toast.makeText(ThemMoiActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ThemMoiActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void AnhXa() {
        editTextName = (EditText) findViewById(R.id.editText_add_contact_name);
        editTextContact = (EditText) findViewById(R.id.editText_add_contact_sdt);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
    }
}