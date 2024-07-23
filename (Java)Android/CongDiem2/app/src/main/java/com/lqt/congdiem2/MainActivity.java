package com.lqt.congdiem2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int checkDel;
    private int posi;
    private ListView listView;
    private DataBase dataBase;
    private CustomAdapter customAdapter;
    private List<VeTau> veTauList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        customAdapter = new CustomAdapter(this, veTauList, R.layout.item_ve_tau);

        listView.setAdapter(customAdapter);

        listen();

        data();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                checkDel = veTauList.get(position).getID();
                posi = position;
                return false;
            }
        });
        registerForContextMenu(listView);
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
                        xoa(checkDel);
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
                Intent intent = new Intent(MainActivity.this, SuaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", veTauList.get(posi));
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    private void data() {
        dataBase = new DataBase(this, "vetau.sqlite", null, 1);

        //Tạo bảng
        dataBase.QueryData("Create Table IF NOT EXISTS VeTau(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "staFrom VARCHAR(50)," +
                "staTo VARCHAR(50)," +
                "Money INTEGER," +
                "DOU INTEGER)");
//        dataBase.QueryData("Insert into VeTau VALUES(null,'Ha Noi', 'Hung Yen',50000, 0)");
        loadData();
    }

    private void loadData() {
        Cursor dataVeTau = dataBase.GetData("select * from VeTau");
        veTauList.clear();
        while (dataVeTau.moveToNext()) {
            int ID = dataVeTau.getInt(0);
            String staFrom = dataVeTau.getString(1);
            String staTo = dataVeTau.getString(2);
            int Money = dataVeTau.getInt(3);
            boolean DOU;
            if (dataVeTau.getInt(4) != 0) DOU = true;
            else DOU = false;
            veTauList.add(new VeTau(ID, staFrom, staTo, Money, DOU));
            Toast.makeText(this, "" + ID, Toast.LENGTH_SHORT).show();
        }
        customAdapter.notifyDataSetChanged();
    }

    private void listen() {

    }

    private void xoa(int check) {
        Cursor data = dataBase.GetData("select * from VeTau");
        veTauList.clear();
        while (data.moveToNext()) {
            int ID = data.getInt(0);
            String staFrom = data.getString(1);
            String staTo = data.getString(2);
            int Money = data.getInt(3);
            boolean DOU;
            if (data.getInt(4) != 0) DOU = true;
            else DOU = false;
            Toast.makeText(this, "Đã Xóa " + ID, Toast.LENGTH_SHORT).show();

            if (ID == checkDel) {
                dataBase.QueryData("delete from VeTau where ID = '" + check + "'");
            } else veTauList.add(new VeTau(ID, staFrom, staTo, Money, DOU));
        }
        customAdapter.notifyDataSetChanged();
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listView_VeTau);
    }
}