package com.lqt.phamvantien_13082000;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
//Bài 2 ảnh 2
public class MainActivity extends AppCompatActivity {

    private DataBase database;
    private static final String NAME_DATABASE = "Database_65";
    private static final String NAME_TABLE = " Taxi_13082000";
    private static final String COLUMN_NAME_1 = "id";
    private static final String COLUMN_NAME_2 = "soxe";
    private static final String COLUMN_NAME_3 = "quangduong";
    private static final String COLUMN_NAME_4 = "dongia";
    private static final String COLUMN_NAME_5 = "khuyenmai";

    private ListView listView;
    private List<Taxi_13082000> listData;
    private Adapter_13082000 adapter;
    private Taxi_13082000 dataSelected;

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
    private void InsertExample() {
        InsertDataBase("30T-129.84", 124.124, 100, 0);
        InsertDataBase("29T-129.84", 212.21, 200, 5);
        InsertDataBase("30T-153.41", 124.22, 2100, 10);
        InsertDataBase("22T-184.12", 124.1, 2300, 20);
        //Dữ liệu bản ghi số 5 yêu cầu
        InsertDataBase("Mã đề 65", 124.124, 3000, 0);
        InsertDataBase("89T-112.84", 15.124, 1500, 0);
    }
    //Bài 2 ảnh 4
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

    //Bài 4 Ảnh 1
    private void SetListView() {
        listData = new ArrayList<>();
        adapter = new Adapter_13082000(this, R.layout.item_list, listData);

        listView.setAdapter(adapter);
        LoadData();
        //Nhấn lâu ở đây hiển thị context menu
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
            int khuyenmai = cursor.getInt(4);

            listData.add(new Taxi_13082000(id, soxe, quangduong, dongia, khuyenmai));
        }

        //Sort ở đây
        Collections.sort(listData);
        adapter.notifyDataSetChanged();
    }
//Bài 4 ảnh 2
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_list, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:
                break;
            case R.id.menu_delete:
                ShowDialog();
                break;
        }
        return super.onContextItemSelected(item);
    }
//Bai 5 ảnh 1
    private void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setNegativeButton("Cancel", null);
        double sum = (dataSelected.getDonGia() * dataSelected.getQuangDuong() * (100 - dataSelected.getKhuyenMai()) / 100);
        int count = 0;
        for (int i = 0; i < listData.size(); i++) {
            if (listData.get(i).getId() != dataSelected.getId()) {
                Taxi_13082000 taxi = listData.get(i);
                if ((taxi.getDonGia() * taxi.getQuangDuong() * (100 - taxi.getKhuyenMai()) / 100) < sum) {
                    count++;
                }
            }
        }
        double newsum = Math.round(sum *1000);
        builder.setTitle("Bạn có muốn xóa " + count + " hóa đơn < " + newsum/1000 + " ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DeleteData();
            }
        });
        builder.show();
    }
//Bài 5 ảnh 2
    private void DeleteData() {
        double sum = (dataSelected.getDonGia() * dataSelected.getQuangDuong() * (100 - dataSelected.getKhuyenMai()) / 100);
        for (int i = 0; i < listData.size(); i++) {
            if (listData.get(i).getId() != dataSelected.getId()) {
                Taxi_13082000 taxi = listData.get(i);
                if ((taxi.getDonGia() * taxi.getQuangDuong() * (100 - taxi.getKhuyenMai()) / 100) < sum) {
                    database.Query(String.format(Locale.US, "DELETE FROM %s WHERE %s = %d"
                            , NAME_TABLE
                            , COLUMN_NAME_1, listData.get(i).getId()));
                }
            }
        }

        LoadData();
    }
    //Bai 5 ảnh 3
    private void SetEvent() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dataSelected = listData.get(position);
                return false;
            }
        });
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
    }
}