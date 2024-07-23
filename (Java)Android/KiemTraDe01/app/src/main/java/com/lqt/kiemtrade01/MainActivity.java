package com.lqt.kiemtrade01;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonAddContact, buttonDeleteContact;
    private RecyclerView recyclerViewContact;
    private EditText editTextFilter;
    private DataBase dataBase;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;
    private final static String NAME_DATABASE = "contact.sqlite";
    private final static String NAME_TABLE = "Contact";
    private final static int REQUEST_CODE = 1412;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setDatabase();

        setRecyclerView();

        setListenerActivity();
    }

    private void setListenerActivity() {
        buttonAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddContactActivity.class), REQUEST_CODE);
            }
        });

        buttonDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDelete();
            }
        });

        //Phải tạo ra một input filter cho EditText như đưới đây
        //https://stackoverflow.com/questions/30259294/how-to-filter-the-input-of-edittext
        InputFilter inputFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                contactAdapter.getFilter().filter(source.toString());
                return null;
            }
        };
        editTextFilter.setFilters(new InputFilter[]{inputFilter});
    }


    private void DialogDelete() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_delete);
        Button buttonNo = (Button) dialog.findViewById(R.id.button_No);
        Button buttonYes = (Button) dialog.findViewById(R.id.button_Yes);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        dialog.show();
    }

    private void deleteContact() {
        int sumComtact = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).isStatus()) {
                DeleteContactWithId(contactList.get(i).getId());
                sumComtact++;
            }
        }
        LoadListContact();
        Toast.makeText(this, "Đã xóa " + sumComtact + " Contact", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    private void DeleteContactWithId(int id) {
        dataBase.Query("DELETE FROM " + NAME_TABLE + " WHERE Id = '" + id + "';");
    }

    private void setRecyclerView() {
        contactAdapter = new ContactAdapter(this, new ContactAdapter.IClickContactRecyclerView() {
            @Override
            public void OnClickItemClick(int position) {
                UpdateStatusContact(position, !contactList.get(position).isStatus());
                contactList.get(position).setStatus(!contactList.get(position).isStatus());
                contactAdapter.notifyDataSetChanged();
            }

            @Override
            public void OnContextMenuDeleteContact(int position) {
                DeleteContactWithId(position);
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                LoadListContact();
            }

            @Override
            public void OnContextMenuEditContact(int position) {
                Toast.makeText(MainActivity.this, "Nhấn nút sửa", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerViewContact.setLayoutManager(layoutManager);
        AutoAdd();
        LoadListContact();
        //contactList.add(new Contact(1, "Lê Quang Thọ", "0973271208", false));
        contactAdapter.setData(contactList);
        recyclerViewContact.setAdapter(contactAdapter);
    }

    private void setDatabase() {
        dataBase = new DataBase(this, NAME_DATABASE, null, 1);

        dataBase.Query("Create Table IF NOT EXISTS " + NAME_TABLE +
                "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " Name NVARCHAR(30), " +
                " PhoneNumber NVARCHAR(12)," +
                " Status INTEGER DEFAULT 0)");
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
            boolean status = String.valueOf(cursor.getInt(3)).equals("1");

            contactList.add(new Contact(id, name, phone, status));
        }
        //sort nề
        Collections.sort(contactList);
        contactAdapter.notifyDataSetChanged();
    }

    private void initView() {
        buttonAddContact = (Button) findViewById(R.id.button_AddContact);
        buttonDeleteContact = (Button) findViewById(R.id.button_DeleteContact);
        recyclerViewContact = (RecyclerView) findViewById(R.id.recyclerViewContact);
        editTextFilter = (EditText) findViewById(R.id.editText_Filter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("Name");
            String phone = data.getStringExtra("Phone");
            Log.e("insert", name + phone);
            insertContact(name, phone);
            LoadListContact();
        }
    }

    private void UpdateStatusContact(int position, boolean status) {
        String sql = "UPDATE " + NAME_TABLE +
                " SET Status =  " + (status ? "0" : "1") +
                " WHERE Id = " + position + ";";
        dataBase.Query(sql);
        Log.e("status", (status ? "0" : "1"));
    }

    private void insertContact(String name, String phone) {
        String sql = "Insert into " + NAME_TABLE + " values (null, '" +
                name + "', '" +
                phone + "', null)";
        dataBase.Query(sql);
    }

    private void AutoAdd() {
        insertContact("Tùng", "0973271281");
        insertContact("Tiến", "0973273432");
        insertContact("Hiếu", "0973274323");
        insertContact("Duy", "0973212342");
        insertContact("Lê Quang Thọ", "181202289");
        insertContact("Hùng", "0973271123");
    }
}