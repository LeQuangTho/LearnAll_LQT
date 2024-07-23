package com.lqt.vetau_them;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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

    private ListView listViewVeTau;
    private EditText editTextSearching;
    private FloatingActionButton buttonAdd;
    private DataBase dataBase;
    private List<VeTau> veTauList;
    private VeTauAdapter veTauAdapter;
    private VeTau veTauSelect;
    private static final String NAME_DATABASE = "VeTau.sqlite";
    private static final String NAME_TABLE = "VeTau";
    private static final String COLUMN_NAME_1 = "ID_VeTau";
    private static final String COLUMN_NAME_2 = "GaDi";
    private static final String COLUMN_NAME_3 = "GaDen";
    private static final String COLUMN_NAME_4 = "DonGia";
    private static final String COLUMN_NAME_5 = "KhuHoi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inintView();

        SetDataBase();

        SetDataListView();

        SetListenerActivity();
    }

    private void SetListenerActivity() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddVeTauActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadData();
    }

    private void SetDataBase() {
        dataBase = new DataBase(this, NAME_DATABASE, null, 1);

        dataBase.Query(String.format("CREATE TABLE IF NOT EXISTS %s (" +
                        " %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " %s NVARCHAR(30)," +
                        " %s NVARCHAR(30)," +
                        " %s INTEGER," +
                        " %s INTEGER);"
                , NAME_TABLE
                , COLUMN_NAME_1
                , COLUMN_NAME_2
                , COLUMN_NAME_3
                , COLUMN_NAME_4
                , COLUMN_NAME_5));

        //InsertExample();
    }

    private void InsertExample() {
        InsertDataBase("", "Hải Phòng", 100000, false);
        InsertDataBase("Hà Nội", "Hải Phòng", 100000, false);
        InsertDataBase("Hà Nội", "Hải Phòng", 100000, false);
        InsertDataBase("Hà Nội", "Hải Phòng", 100000, false);
        InsertDataBase("Hà Nội", "Hải Phòng", 100000, false);
    }

    private void InsertDataBase(String gadi, String gaden, int dongia, boolean khuhoi) {
        String sql = String.format("INSERT INTO %s VALUES (null,'%s','%s','%d','%d')"
                , NAME_TABLE
                , gadi
                , gaden
                , dongia
                , (khuhoi ? 1 : 0)
        );
        dataBase.Query(sql);
    }

    private void SetDataListView() {
        veTauList = new ArrayList<>();
        veTauAdapter = new VeTauAdapter(R.layout.item_vetau, veTauList, this);
        LoadData();
        listViewVeTau.setAdapter(veTauAdapter);

        listViewVeTau.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                veTauSelect = veTauList.get(position);
                return false;
            }
        });

        registerForContextMenu(listViewVeTau);
    }

    private void LoadData() {
        if (veTauList == null) {
            veTauList = new ArrayList<>();
        }
        veTauList.clear();
        Cursor cursor = dataBase.GetData("SELECT * FROM " + NAME_TABLE);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String gadi = cursor.getString(1);
            String gaden = cursor.getString(2);
            int dongia = cursor.getInt(3);
            boolean khuhoi = cursor.getInt(4) == 0 ? false : true;

            veTauList.add(new VeTau(id, gadi, gaden, dongia, khuhoi));
        }

        //Sort ở đây
        Collections.sort(veTauList);
        veTauAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_vetau, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sua:
                Intent intent = new Intent(MainActivity.this, EditVeTauActivity.class);
                intent.putExtra("VeTau", veTauSelect);
                startActivity(intent);
                break;
            case R.id.menu_xoa:
                ConfirmDelete();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void ConfirmDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bạn có chắc chắn muốn xóa không?");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DeleteVeTau();
            }
        });

        builder.show();
    }

    private void DeleteVeTau() {
        dataBase.Query(String.format("DELETE FROM %s WHERE %s = %d;", NAME_TABLE, COLUMN_NAME_1, veTauSelect.getID_VeTau()));
        LoadData();
        Toast.makeText(this, "Đã Xóa!", Toast.LENGTH_SHORT).show();
    }

    private void inintView() {
        listViewVeTau = (ListView) findViewById(R.id.listView_VeTau);
        editTextSearching = (EditText) findViewById(R.id.editText_Searching);
        buttonAdd = (FloatingActionButton) findViewById(R.id.buttonAdd);
    }
}