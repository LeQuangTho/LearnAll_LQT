package com.lqt.baitapcontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSearch;
    private ListView listViewContact;
    private FloatingActionButton buttonAdd;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;
    private Database database;
    private static final String NAME_DATABASE = "Contact.sqlite";
    private static final String NAME_TABLE = "Contact";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "name";
    private static final String COLUMN_NAME_3 = "phonenumber";
    private static final String COLUMN_NAME_4 = "status";
    private Contact mContactSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        SetDataBase();

        SetListView();

        SetListener();
    }

    private void SetDataBase() {
        database = new Database(this, NAME_DATABASE, null, 1);

        database.Query(String.format("CREATE TABLE IF NOT EXISTS %s (%s INTEGER PRIMARY KEY, %s NVARCHAR(30), %s NARCHAR(12), %s INTEGER);"
                , NAME_TABLE
                , COLUMN_NAME_1
                , COLUMN_NAME_2
                , COLUMN_NAME_3
                , COLUMN_NAME_4));

        //InsertExample();
    }

    private void InsertExample() {
        InsertData(1, "Duong", "0989786760", false);
        InsertData(2, "Tho", "0989786760", false);
        InsertData(3, "Huy", "0989786760", false);
        InsertData(4, "Hieu", "0989786760", false);
    }

    private void InsertData(int id, String name, String phonenumber, boolean status) {
        database.Query(String.format("INSERT INTO %s VALUES ('%d','%s', '%s', '%d')"
                , NAME_TABLE
                , id
                , name
                , phonenumber
                , status ? 1 : 0));
    }

    //Lấy dữ liệu từ Sqlite ra ArrayList
    private void SetListData(){
        if(contactList == null){
            contactList = new ArrayList<>();
        }

        contactList.clear();

        Cursor cursor = database.GetData(String.format("SELECT * FROM %s", NAME_TABLE));
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phonenumber = cursor.getString(2);
            boolean status = cursor.getString(3).equals("1");

            contactList.add(new Contact(id, name, phonenumber, status));
        }

        Collections.sort(contactList);
        contactAdapter.notifyDataSetChanged();
    }

    //Để hiển thị list view
    private void SetListView() {
        contactList = new ArrayList<>();

        contactAdapter = new ContactAdapter(contactList, this, R.layout.item_contact);

        listViewContact.setAdapter(contactAdapter);

        registerForContextMenu(listViewContact);

        SetListData();
    }


    //Hàm xử lí tất cả sự kiện trong Activty
    private void SetListener() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

        listViewContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contactList.get(position).setStatus(!contactList.get(position).isStatus());
                contactAdapter.notifyDataSetChanged();
            }
        });
        listViewContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mContactSelected = contactList.get(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contact, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Edit:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);

                //Chuyền Object giữa Activity thì Object đó phải implement Serializable
                intent.putExtra("ContactSelected", mContactSelected);
                startActivity(intent);

                break;
            case R.id.menu_delete:
                ConfirmDelete();
                break;
        }

        return super.onContextItemSelected(item);
    }

    //Hiện diaglog hỏi xem muốn xóa không
    private void ConfirmDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bạn có muốn xóa liên hệ này không");
        //khởi tạo nút Ok và xóa
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DeleteData();
            }
        });

        // Tạo nút cancel
        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    //Hàm này để xóa dữ liệu trong SQLite
    private void DeleteData() {
        database.Query(String.format("DELETE FROM %s WHERE %s = '%d';", NAME_TABLE, COLUMN_NAME_1, mContactSelected.getId()));
        SetListData();
    }

    //Sau khi lo
    @Override
    protected void onResume() {
        super.onResume();
        SetListData();
    }

    private void initView() {
        editTextSearch = (EditText) findViewById(R.id.editText_Search);
        listViewContact = (ListView) findViewById(R.id.listView_Cantact);
        buttonAdd = (FloatingActionButton) findViewById(R.id.button_Add);
    }
}