package com.lqt.phamvantien_made;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DataBase database;
    private static final String NAME_DATABASE = "Sqlite_13082000";
    private static final String NAME_TABLE = "Taxi_MaDe";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "soxe";
    private static final String COLUMN_NAME_3 = "quangduong";
    private static final String COLUMN_NAME_4 = "dongia";
    private static final String COLUMN_NAME_5 = "khuyenmai";

    private ListView listView;
    private FloatingActionButton buttonAdd;
    private List<Taxi_MaDe> listData;
    private Adapter_MaDe adapter;
    private Taxi_MaDe dataSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        SetDataBase();
        SetListView();
        SetEvent();
    }
    //Bài 2 ảnh 3
    private void SetDataBase() {
        database = new DataBase(this, NAME_DATABASE, null, 1);
        database.Query(String.format("CREATE TABLE IF NOT EXISTS %s (" +
                        " %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s NVARCHAR(30)," +
                        " %s REAL," +
                        " %s INTEGER," +
                        " %s INTEGER);"
                , NAME_TABLE
                , COLUMN_NAME_1
                , COLUMN_NAME_2
                , COLUMN_NAME_3
                , COLUMN_NAME_4
                , COLUMN_NAME_5));

        //Kể từ lần 2 thì đóng dòng này lại
//        InsertExample();
    }

    //Bài 2 ảnh 4
    private void InsertExample() {
        InsertDataBase("30T-129.84", 124.124, 100000, 0);
        InsertDataBase("29T-129.84", 212.21, 100000, 5);
        InsertDataBase("30T-153.41", 124.22, 21000, 10);
        InsertDataBase("22T-184.12", 124.1, 23000, 20);
        //Dữ liệu bản ghi yêu cầu
        InsertDataBase("Mã Đề", 124.124, 300000, 0);
        InsertDataBase("89T-112.84", 15.124, 100000, 0);
    }

    private void InsertDataBase(String soxe, double quangduong, int dongia, int khuyenmai) {
        String sql = String.format(Locale.US, "INSERT INTO %s VALUES (null,'%s','%f','%d','%d')"
                , NAME_TABLE
                , soxe
                , quangduong
                , dongia
                , khuyenmai
        );
        database.Query(sql);
    }
    //Bài 3 ảnh 2
    private void SetListView() {
        listData = new ArrayList<>();
        adapter = new Adapter_MaDe(this, R.layout.item_list, listData);

        listView.setAdapter(adapter);
        LoadData();
        registerForContextMenu(listView);
    }

    private void LoadData() {
        listData.clear();
        Cursor cursor = database.GetData("SELECT * FROM " + NAME_TABLE);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String soxe = cursor.getString(1);
            double quangduong = cursor.getFloat(2);
            int dongia = cursor.getInt(3);
            int khuyenmai = cursor.getInt(4) ;

            listData.add(new Taxi_MaDe(id, soxe, quangduong, dongia, khuyenmai));
        }

        //Sort ở đây
        Collections.sort(listData);
        adapter.notifyDataSetChanged();
    }
    //Bài 4 Ảnh 2
    private void SetEvent(){
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
            case R.id.menu_delete:
                break;
            case R.id.menu_edit:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("data", dataSelected);
                startActivity(intent);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    private void InitView() {
        listView = (ListView) findViewById(R.id.listView);
        buttonAdd = (FloatingActionButton) findViewById(R.id.button_Add);
    }
}