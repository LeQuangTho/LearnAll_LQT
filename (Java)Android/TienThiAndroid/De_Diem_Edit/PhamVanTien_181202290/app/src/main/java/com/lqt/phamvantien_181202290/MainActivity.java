package com.lqt.phamvantien_181202290;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Double2;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSearch;
    private ListView listView;
    private DataBase dataBase;
    private static final String NAME_DATABASE = "Sqlite_MaDe";
    private static final String NAME_TABLE = "ThiSinh_MaDe";
    private static final String COLUMN_NAME_1 = "SDB";
    private static final String COLUMN_NAME_2 = "HoTen";
    private static final String COLUMN_NAME_3 = "Toan";
    private static final String COLUMN_NAME_4 = "Ly";
    private static final String COLUMN_NAME_5 = "Hoa";

    private List<ThiSinh_13072000> listData;
    private Adapter_MaDe adapter;
    private ThiSinh_13072000 dataSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        SetDataBase();
        SetListView();
        ListenEventActivity();
    }

    private void SetDataBase() {
        dataBase = new DataBase(this, NAME_DATABASE, null, 1);
        dataBase.Query(String.format("CREATE TABLE IF NOT EXISTS %s (" +
                        " %s NVARCHAR(10) PRIMARY KEY," +
                        " %s NVARCHAR(30)," +
                        " %s REAL," +
                        " %s REAL," +
                        " %s REAL);"
                , NAME_TABLE
                , COLUMN_NAME_1
                , COLUMN_NAME_2
                , COLUMN_NAME_3
                , COLUMN_NAME_4
                , COLUMN_NAME_5));
        //Kể từ lần 2 thì đóng dòng này lại
//        InsertExample();
    }

    private void InsertExample() {
        //Bản ghi số 1
        InsertDataBase("GHA1", "Phạm Văn Tiến", 10.0, 9.5, 5.0);
        InsertDataBase("GHA2", "Nguyên Văn Duy", 8.5, 9.0, 7.0);
        InsertDataBase("GHA3", "Lê Minh Hiếu", 4.0, 7.4, 5.0);
        InsertDataBase("GHA4", "Lê Quang Thọ", 10.0, 10.0, 10.0);
        InsertDataBase("GHA5", "Trần Văn Hùng", 10.0, 7.8, 7.1);
        InsertDataBase("GHA6", "Nguyễn Đức Phú", 9.0, 9.5, 7.0);
    }

    private void InsertDataBase(String sbd, String name, double toan, double ly, double hoa) {
        String sql = String.format(Locale.US,"INSERT INTO %s VALUES ('%s','%s', '%f' , '%f' , '%f')"
                , NAME_TABLE
                , sbd
                , name
                , toan
                , ly
                , hoa
        );
        dataBase.Query(sql);
    }

    private void SetListView() {
        listData = new ArrayList<>();
        adapter = new Adapter_MaDe(this, R.layout.item_list, listData);

        listView.setAdapter(adapter);
        LoadData();
        registerForContextMenu(listView);
    }

    private void LoadData() {
        listData.clear();
        Cursor cursor = dataBase.GetData("SELECT * FROM " + NAME_TABLE);

        while (cursor.moveToNext()) {
            String sbd = cursor.getString(0);
            String hoten = cursor.getString(1);
            double toan = cursor.getDouble(2);
            double ly =  cursor.getDouble(3);
            double hoa = cursor.getDouble(4);

            listData.add(new ThiSinh_13072000(sbd, hoten, toan, ly, hoa));
        }

        //Sort ở đây
        Collections.sort(listData);
        adapter.notifyDataSetChanged();
    }

    private void ListenEventActivity() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataSelected = listData.get(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_list, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("data", dataSelected);
                startActivity(intent);
                break;
            case R.id.menu_delete:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    private void InitView() {
        editTextSearch = findViewById(R.id.editText_Search);
        listView = findViewById(R.id.listView);
    }
}