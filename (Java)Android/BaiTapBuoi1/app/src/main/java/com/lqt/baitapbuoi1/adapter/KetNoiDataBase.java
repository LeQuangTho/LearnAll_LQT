package com.lqt.baitapbuoi1.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.lqt.baitapbuoi1.R;

public class KetNoiDataBase extends AppCompatActivity {

    Button buttonSave, buttonCancel;
    ListView list;

    EditText editTextNameNote, editTextContentNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_noi_data_base);
        AnhXa();
        
    }

    private void AnhXa() {
        buttonSave = (Button) findViewById(R.id.Button_Save);
        buttonCancel = (Button) findViewById(R.id.Button_Cancel);
        list = (ListView) findViewById(R.id.ListView_DataBase);

        editTextNameNote = (EditText) findViewById(R.id.EditText_NameNote);
        editTextContentNote = (EditText) findViewById(R.id.EditText_ContentNote);
    }
}