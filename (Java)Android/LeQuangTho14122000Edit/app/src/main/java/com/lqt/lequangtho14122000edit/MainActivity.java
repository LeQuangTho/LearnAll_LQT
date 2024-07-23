package com.lqt.lequangtho14122000edit;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton buttonAddContact;
    private ListView listViewContact;
    private Tho_Sqlite dataBase;
    private Tho_Adapter contactAdapter;
    private List<Contact_181202289> contactList;
    private final static String NAME_DATABASE = "Tho_Sqlite";
    private final static String NAME_TABLE = "Contact_181202289";
    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        SetDatabase();
        SetListView();
    }

    //Câu 2 Ảnh 3
    private void SetDatabase() {
        dataBase = new Tho_Sqlite(this, NAME_DATABASE, null, 1);
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
        InsertData("4", "Hiếu", "0145635612");
        InsertData("5", "Thọ", "0126425612");
        InsertData("6", "Hùng", "0942135612");
    }

    private void InsertData(String id, String name, String phone) {
        dataBase.Query(String.format("Insert into %s values (%s,'%s','%s');", NAME_TABLE, id, name, phone));
    }

    //Câu 3
    private void SetListView() {
        contactList = new ArrayList<>();
        contactAdapter = new Tho_Adapter(this, R.layout.item_contact, contactList);
        LoadData();
        listViewContact.setAdapter(contactAdapter);
        registerForContextMenu(listViewContact);
        listViewContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mPosition = position;
                return false;
            }
        });
    }

    private void LoadData() {
        if (contactList == null) {
            contactList = new ArrayList<>();
        }
        contactList.clear();
        Cursor cursor = dataBase.GetData("Select * from " + NAME_TABLE);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            contactList.add(new Contact_181202289(id, name, phone));
        }
        Collections.sort(contactList);
        contactAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contact, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_delete:
                ConfirmDelete();
                break;
            case R.id.menu_edit:
                Intent intent = new Intent(MainActivity.this, EditContactActivity.class);
                intent.putExtra("Contact", contactList.get(mPosition));
                startActivity(intent);
        }
        return super.onContextItemSelected(item);
    }

    private void ConfirmDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(null);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DeleteContact();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setTitle("Confirm");
        builder.setMessage("Lê Quang Thọ wants to detele?");
        builder.show();
    }

    private void DeleteContact() {
        dataBase.Query(String.format("DELETE FROM %s WHERE Id = %d;", NAME_TABLE, contactList.get(mPosition).getId()));
        LoadData();
        Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
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