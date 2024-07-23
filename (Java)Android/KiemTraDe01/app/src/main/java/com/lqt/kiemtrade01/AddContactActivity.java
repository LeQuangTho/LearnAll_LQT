package com.lqt.kiemtrade01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {
    private EditText editTextName, editTextPhone;
    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        initView();

        listenerActivity();
    }

    private void listenerActivity() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextName.getText().toString().isEmpty() || editTextPhone.getText().toString().isEmpty()){
                    Toast.makeText(AddContactActivity.this, "Bạn phải nhập đủ tên và số điện thoại!", Toast.LENGTH_SHORT).show();
                }else {
                    if (editTextPhone.getText().toString().length() < 10 || editTextPhone.getText().toString().length() > 12) {
                        Toast.makeText(AddContactActivity.this, "Số điện thoại không hợp lệ!", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("Name", editTextName.getText().toString());
                        intent.putExtra("Phone", editTextPhone.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }

    private void initView() {
        editTextName = (EditText) findViewById(R.id.editText_Name);
        editTextPhone = (EditText) findViewById(R.id.editText_Phone);
        buttonAdd = (Button) findViewById(R.id.button_AddContact);
    }
}