package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewSV;
    EditText filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewSV = (ListView) findViewById(R.id.ListViewCustom);
        filter = (EditText) findViewById(R.id.editTextTextPersonName);

        ArrayList<SinhVien> arrayListSV = new ArrayList<SinhVien>();
        arrayListSV.add(new SinhVien("Nguyen Van An", 2000, R.drawable.a));
        arrayListSV.add(new SinhVien("Bui Tien Bac", 2000, R.drawable.b));
        arrayListSV.add(new SinhVien("Le Quang Duy", 2000, R.drawable.c));
        arrayListSV.add(new SinhVien("Do Xuan Canh", 2000, R.drawable.d));
        arrayListSV.add(new SinhVien("Lieu Viet Hung", 1999, R.drawable.e));
        arrayListSV.add(new SinhVien("Nguyen Viet Dai", 2000, R.drawable.img));
        arrayListSV.add(new SinhVien("Le Quang Tho", 2000, R.drawable.a));
        arrayListSV.add(new SinhVien("Nguyen Duc Phu", 2000, R.drawable.b));

//        ListAdapter listAdapter = new com.example.customlistview.ListAdapter(MainActivity.this, R.layout.activity_dong_sinh_vien, arrayListSV);
        BaseAdapterK listAdapter = new BaseAdapterK(MainActivity.this, arrayListSV);

        listViewSV.setAdapter(listAdapter);
        setTitle("Danh sach sinh vien");
        registerForContextMenu(listViewSV);

        listViewSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Sinh viên " + arrayListSV.get(position).fullName + " sinh năm  " + arrayListSV.get(position).birthYear, Toast.LENGTH_SHORT).show();
            }
        });
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
//        getMenuInflater().inflate(R.menu.menu_context, menu);
        super.onCreateContextMenu(menu, view, menuInfo);
    }


}