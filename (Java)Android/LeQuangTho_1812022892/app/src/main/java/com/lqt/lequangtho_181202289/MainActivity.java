package com.lqt.lequangtho_181202289;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Bai 2 Ảnh 2
public class MainActivity extends AppCompatActivity {

    private SQLite_181202289 database;
    private static final String NAME_DATABASE = "Sqlite_181202289";
    private static final String NAME_TABLE = "Taxi_LeQuangTho";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "soxe";
    private static final String COLUMN_NAME_3 = "quangduong";
    private static final String COLUMN_NAME_4 = "dongia";
    private static final String COLUMN_NAME_5 = "khuyenmai";

    private ListView listViewTaxi;
    private FloatingActionButton buttonAdd;
    private List<Taxi_LeQuangTho> listTaxi;
    private Adapter_181202289 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        SetDataBase();
        SetListView();
        SetEvent();
    }
    //Bài 2 ảnh 3
    private void SetDataBase() {
        database = new SQLite_181202289(this, NAME_DATABASE, null, 1);
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
        //Dữ liệu bản ghi yêu cầu
        InsertDataBase("67", 124.124, 300000, 0);
        InsertDataBase("22T-184.12", 124.1, 23000, 20);
        InsertDataBase("89T-112.84", 15.124, 100000, 0);
    }

    private void InsertDataBase(String soxe, double quangduong, int dongia, int khuyenmai) {
        String sql = String.format("INSERT INTO %s VALUES (null,'%s','%f','%d','%d')"
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
        listTaxi = new ArrayList<>();
        adapter = new Adapter_181202289(this, R.layout.item_taxi, listTaxi);

        listViewTaxi.setAdapter(adapter);
        LoadData();
    }

    private void LoadData() {
        listTaxi.clear();
        Cursor cursor = database.GetData("SELECT * FROM " + NAME_TABLE);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String soxe = cursor.getString(1);
            double quangduong = cursor.getFloat(2);
            int dongia = cursor.getInt(3);
            int khuyenmai = cursor.getInt(4) ;

            listTaxi.add(new Taxi_LeQuangTho(id, soxe, quangduong, dongia, khuyenmai));
        }

        //Sort ở đây
        Collections.sort(listTaxi);
        adapter.notifyDataSetChanged();
    }
    //Bài 4 Ảnh 2
    private void SetEvent(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    private void initView() {
        listViewTaxi = (ListView) findViewById(R.id.listView_Taxi);
        buttonAdd = (FloatingActionButton) findViewById(R.id.button_Add);
    }
}