package com.lqt.phamvantien_181202290;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSearch;
    private ListView listView;
    private FloatingActionButton buttonAdd;
    private DataBase dataBase;
    private static final String NAME_DATABASE = "PhamVanTien_DB";
    private static final String NAME_TABLE = "HoaDon_PhamVanTien";
    private static final String COLUMN_NAME_1 = "ID";
    private static final String COLUMN_NAME_2 = "HoTenKhach";
    private static final String COLUMN_NAME_3 = "SoPhong";
    private static final String COLUMN_NAME_4 = "DonGia";
    private static final String COLUMN_NAME_5 = "SoNgay";

    private List<HoaDon_PhamVanTien> listData;
    private PhamVanTien_Adapter adapter;

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
                        " %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s NVARCHAR(30)," +
                        " %s INTEGER," +
                        " %s INTEGER," +
                        " %s INTEGER);"
                , NAME_TABLE
                , COLUMN_NAME_1
                , COLUMN_NAME_2
                , COLUMN_NAME_3
                , COLUMN_NAME_4
                , COLUMN_NAME_5));
        //Kể từ lần 2 thì đóng dòng này lại
        //InsertExample();
    }

    private void InsertExample() {

        InsertDataBase("Thọ", 11, 100000, 1);
        InsertDataBase("Duy", 22, 330000, 2);
        InsertDataBase("Hiếu", 15 , 123000, 3);
        InsertDataBase("Hùng", 13,350000, 4);
        //Bản ghi số 5
        InsertDataBase("Phạm Văn Tiến", 125, 154000, 5);
        InsertDataBase("Phú", 151, 120000, 4);

    }

    private void InsertDataBase(String name, int sophong, int dongia, int songay) {
        String sql = String.format(Locale.US,"INSERT INTO %s VALUES (null,'%s','%d','%d','%d')"
                , NAME_TABLE
                , name
                , sophong
                , dongia
                , songay
        );
        dataBase.Query(sql);
    }

    private void SetListView(){
        listData = new ArrayList<>();
        adapter = new PhamVanTien_Adapter(this, R.layout.item_list, listData);

        listView.setAdapter(adapter);
        LoadData();
    }

    private void LoadData() {
        listData.clear();
        Cursor cursor = dataBase.GetData("SELECT * FROM " + NAME_TABLE);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String hotenkhach = cursor.getString(1);
            int sophong = cursor.getInt(2);
            int dongia = cursor.getInt(3);
            int songay = cursor.getInt(4) ;

            listData.add(new HoaDon_PhamVanTien(id, hotenkhach, sophong, dongia, songay));
        }

        //Sort ở đây
        Collections.sort(listData);
        adapter.notifyDataSetChanged();
    }

    private void ListenEventActivity() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });
    }

    private void InitView() {
          editTextSearch = findViewById(R.id.editText_Search);
          listView = findViewById(R.id.listView);
          buttonAdd = findViewById(R.id.button_Add);
    }
    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }
}