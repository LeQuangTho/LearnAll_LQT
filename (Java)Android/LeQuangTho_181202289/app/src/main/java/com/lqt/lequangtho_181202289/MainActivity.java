package com.lqt.lequangtho_181202289;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton buttonAddContact;
    private RecyclerView recyclerViewContact;
    private EditText editTextFilter;
    private Tho_DataBase dataBase;
    private LeQuangTho_Adapter contactAdapter;
    private List<Contact_LeQuangTho> contactList;
    private final static String NAME_DATABASE = "LeQuangTho_Sqlite.sqlite";
    private final static String NAME_TABLE = "Contact_Tho";
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        SetDatabase();
        SetRecyclerView();
        SetListenActivity();
    }

    private void SetDatabase() {
        dataBase = new Tho_DataBase(this, NAME_DATABASE, null, 1);

        dataBase.Query("Create Table IF NOT EXISTS " + NAME_TABLE +
                "(Id INTEGER PRIMARY KEY," +
                " Name NVARCHAR(30), " +
                " PhoneNumber NVARCHAR(12))");
        AutoAdd();
    }

    private void AutoAdd() {
//        insertContact(1,"Tùng", "0973271281");
//        insertContact(2,"Tiến", "0973273432");
//        insertContact(3,"Hiếu", "0973274323");
//        insertContact(4,"Duy", "0973212342");
//        insertContact(5,"Lê Quang Thọ", "181202289");
//        insertContact( 6,"Hùng", "0973271123");
    }

    private void insertContact(int Id, String name, String phone) {
        String sql = String.format("Insert into %s values (%d , '%s', '%s')", NAME_TABLE, Id, name, phone);
        dataBase.Query(sql);
    }

    private void SetRecyclerView() {
        contactAdapter = new LeQuangTho_Adapter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewContact.setLayoutManager(layoutManager);
        LoadListContact();
        contactAdapter.setData(contactList);
        recyclerViewContact.setAdapter(contactAdapter);
    }

    private void LoadListContact() {
        Cursor cursor = dataBase.GetData("Select * from " + NAME_TABLE);
        if (contactList == null) {
            contactList = new ArrayList<>();
        }
        contactList.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            contactList.add(new Contact_LeQuangTho(id, name, phone));
        }
        //sort nề
        Collections.sort(contactList);
        contactAdapter.notifyDataSetChanged();
    }

    private void SetListenActivity() {
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
        LoadListContact();
    }

    private void initView() {
        buttonAddContact = (FloatingActionButton) findViewById(R.id.button_AddContact);
        recyclerViewContact = (RecyclerView) findViewById(R.id.recyclerViewContact);
        editTextFilter = (EditText) findViewById(R.id.editText_Filter);
    }
}