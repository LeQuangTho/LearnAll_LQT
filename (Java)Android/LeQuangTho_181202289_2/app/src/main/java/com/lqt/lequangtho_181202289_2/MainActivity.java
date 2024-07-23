package com.lqt.lequangtho_181202289_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Câu 2. Ảnh 2
    private FloatingActionButton buttonAddContact;
    private ListView listViewContact;
    private LeQuangTho_DataBase dataBase;
    private LeQuangTho_Adapter contactAdapter;
    private List<Contact_Tho> contactList;
    private final static String NAME_DATABASE = "LeQuangTho_Sqlite";
    private final static String NAME_TABLE = "Contact_Tho";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        SetDatabase();
        SetListView();
        SetListenerActivity();
    }

    //Câu 2 Ảnh 3
    private void SetDatabase() {
        dataBase = new LeQuangTho_DataBase(this, NAME_DATABASE, null, 1);
        dataBase.Query("Create Table IF NOT EXISTS " + NAME_TABLE +
                "(Id INTEGER PRIMARY KEY," +
                " Name NVARCHAR(30), " +
                " PhoneNumber NVARCHAR(12))");
        //InsertExamples();
    }
    private void InsertExamples() {
        InsertData("1", "Duy", "0123435612");
        InsertData("2", "Tiến", "0123435612");
        InsertData("3", "Tùng", "0123535612");
        InsertData("4", "Thọ", "0126425612");
        InsertData("5", "Hiếu", "0145635612");
        InsertData("6", "Hùng", "0942135612");
    }
    private void InsertData(String id, String name, String phone) {
        dataBase.Query(String.format("Insert into %s values (%s,'%s','%s');",NAME_TABLE, id, name, phone));
    }

    //Câu 3
    private void SetListView() {
        contactList = new ArrayList<>();
        contactAdapter = new LeQuangTho_Adapter(this, R.layout.item_contact, contactList);
        LoadData();
        listViewContact.setAdapter(contactAdapter);
    }
    private void LoadData() {
        if(contactList == null){
            contactList = new ArrayList<>();
        }
        contactList.clear();
        Cursor cursor = dataBase.GetData("Select * from " + NAME_TABLE);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            contactList.add(new Contact_Tho(id, name, phone));
        }
        Collections.sort(contactList);
        contactAdapter.notifyDataSetChanged();
    }

    //Câu 4
    private void SetListenerActivity() {
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddContactActivity.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    private void initView() {
        buttonAddContact = (FloatingActionButton) findViewById(R.id.button_Add);
        listViewContact = (ListView) findViewById(R.id.listView_Contact);
    }
}