package com.lqt.lequangtho14122000edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContactActivity extends AppCompatActivity {

    private EditText editTextName, editTextPhone, editTextId;
    private Button buttonAdd, buttonBack;
    private Tho_Sqlite dataBase;
    private final static String NAME_DATABASE = "Tho_Sqlite";
    private final static String NAME_TABLE = "Contact_181202289";
    Contact_181202289 contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        initView();
        GetData();
        SetListenerActivity();
    }

    private void GetData() {
        Intent intent = getIntent();
        contact = (Contact_181202289) intent.getSerializableExtra("Contact");
        editTextId.setText(""+ contact.getId());
        editTextName.setText(""+ contact.getName());
        editTextPhone.setText(""+ contact.getPhoneNumber());
    }

    private void SetListenerActivity() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().isEmpty()
                        || editTextPhone.getText().toString().isEmpty()
                        || editTextId.getText().toString().isEmpty()) {
                    Toast.makeText(EditContactActivity.this, "Bạn phải nhập đủ id, tên và số điện thoại!", Toast.LENGTH_SHORT).show();
                } else {
                    if (checkId(Integer.parseInt(editTextId.getText().toString().trim()))) {
                        if (editTextPhone.getText().toString().length() < 10 || editTextPhone.getText().toString().length() > 12) {
                            Toast.makeText(EditContactActivity.this, "Số điện thoại không hợp lệ!", Toast.LENGTH_SHORT).show();
                        } else {
                            int id = Integer.parseInt(editTextId.getText().toString().trim());
                            String name = editTextName.getText().toString();
                            String phone = editTextPhone.getText().toString();
                            dataBase.Query(String.format("UPDATE %s SET Id = %d, Name = '%s', PhoneNumber = '%s' WHERE Id = %d;"
                                    , NAME_TABLE, id, name, phone, contact.getId()));
                            finish();
                        }
                    } else {
                        editTextId.setText("");
                        Toast.makeText(EditContactActivity.this, "Id này đã tồn tại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean checkId(int id) {
        dataBase = new Tho_Sqlite(this, NAME_DATABASE, null, 1);
        Cursor cursor = dataBase.GetData(String.format("select * from %s where Id = %d AND NOT Id = %d", NAME_TABLE, id, contact.getId()));
        return !cursor.moveToNext();
    }

    private void initView() {
        editTextName = (EditText) findViewById(R.id.editText_Name);
        editTextPhone = (EditText) findViewById(R.id.editText_Phone);
        editTextId = (EditText) findViewById(R.id.editText_Id);
        buttonAdd = (Button) findViewById(R.id.button_EditContact);
        buttonBack = (Button) findViewById(R.id.button_Back);
    }
}