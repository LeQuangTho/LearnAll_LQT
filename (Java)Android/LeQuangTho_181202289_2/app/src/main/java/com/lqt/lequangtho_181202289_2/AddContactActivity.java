package com.lqt.lequangtho_181202289_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//Câu 5
public class AddContactActivity extends AppCompatActivity {
    private EditText editTextName, editTextPhone, editTextId;
    private Button buttonAdd, buttonBack;
    private LeQuangTho_DataBase dataBase;
    private final static String NAME_DATABASE = "LeQuangTho_Sqlite";
    private final static String NAME_TABLE = "Contact_Tho";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initView();
        SetListenerActivity();
    }
    private void SetListenerActivity() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextName.getText().toString().isEmpty()
                        || editTextPhone.getText().toString().isEmpty()
                        || editTextId.getText().toString().isEmpty()) {
                    Toast.makeText(AddContactActivity.this, "Bạn phải nhập đủ id, tên và số điện thoại!", Toast.LENGTH_SHORT).show();
                } else {
                    if (checkId(Integer.parseInt(editTextId.getText().toString().trim()))) {
                        if (editTextPhone.getText().toString().length() < 10 || editTextPhone.getText().toString().length() > 12) {
                            Toast.makeText(AddContactActivity.this, "Số điện thoại không hợp lệ!", Toast.LENGTH_SHORT).show();
                        } else {
                            int id = Integer.parseInt(editTextId.getText().toString().trim());
                            String name = editTextName.getText().toString();
                            String phone = editTextPhone.getText().toString();
                            dataBase.Query(String.format("Insert into %s values (%d , '%s', '%s')", NAME_TABLE, id, name, phone));
                            finish();
                        }
                    }else {
                        editTextId.setText("");
                        Toast.makeText(AddContactActivity.this, "Id này đã tồn tại", Toast.LENGTH_SHORT).show();
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
        dataBase = new LeQuangTho_DataBase(this, NAME_DATABASE, null, 1);

        Cursor cursor = dataBase.GetData(String.format("select * from %s where Id = %d", NAME_TABLE, id));
        return !cursor.moveToNext();
    }
    private void initView() {
        editTextName = (EditText) findViewById(R.id.editText_Name);
        editTextPhone = (EditText) findViewById(R.id.editText_Phone);
        editTextId = (EditText) findViewById(R.id.editText_Id);
        buttonAdd = (Button) findViewById(R.id.button_AddContact);
        buttonBack = (Button) findViewById(R.id.button_Back);
    }
}