package com.lqt.congdiem1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    int check;
    DataBase dataBase;
    private List<SanPham> sanPhamArrayList = new ArrayList<>();
    private CustomAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        adapter = new CustomAdapter(this, sanPhamArrayList, R.layout.item_san_pham);

        listView.setAdapter(adapter);

        listen();

        data();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                check = sanPhamArrayList.get(position).getID();
                return false;
            }
        });
        registerForContextMenu(listView);
    }

    private void listen() {
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                return true;
//            }
//        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_xoa:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Bạn có muốn xóa dịch vụ này không?");
                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        xoa(check);
                    }
                });

                builder.setNegativeButton(getString(R.string.title_Khong), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            case R.id.menu_sua:
                break;
        }
        return super.onContextItemSelected(item);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listView);
    }

    private void data() {
        //Tạo data base
        dataBase = new DataBase(this, "contact.sqlite", null, 1);

        //Tạo bảng
        dataBase.QueryData("Create Table IF NOT EXISTS SanPham(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name VARCHAR(50)," +
                "Money INTEGER," +
                "KM INTEGER)");
        dataBase.QueryData("Insert into SanPham VALUES(null,'Nguyen Thi Linh', '10000', 1)");
        dataBase.QueryData("Insert into SanPham VALUES(null,'Nguyen Thi Linh', '10000', 1)");
        dataBase.QueryData("Insert into SanPham VALUES(null,'Nguyen Thi Linh', '10000', 1)");
        loadData();
    }

    private void loadData() {
        Cursor dataContact = dataBase.GetData("select * from SanPham");
        sanPhamArrayList.clear();
        while (dataContact.moveToNext()) {
            int ID = dataContact.getInt(0);
            String Name = dataContact.getString(1);
            int Money = dataContact.getInt(2);
            boolean KM;
            if (dataContact.getInt(3) != 0) KM = true;
            else KM = false;
            sanPhamArrayList.add(new SanPham(ID, Name, Money, KM));
            Toast.makeText(this, "" + ID + Name + Money, Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }
    private void xoa(int check) {
        Cursor data = dataBase.GetData("select * from SanPham");
        sanPhamArrayList.clear();
        while (data.moveToNext()) {
            int ID = data.getInt(0);
            String Name = data.getString(1);
            int Money = data.getInt(2);
            boolean KM;
            if (data.getInt(3) != 0) KM = true;
            else KM = false;
                Toast.makeText(this, "Đã Xóa " + Name, Toast.LENGTH_SHORT).show();
                dataBase.QueryData("delete from SanPham where ID = '" + check + "'");
                sanPhamArrayList.add(new SanPham(ID, Name, Money, KM));
        }
        adapter.notifyDataSetChanged();
    }
}