package com.example.appmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListViewArrayAdapterActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_array_adapter);

        // Ánh xạ
        listView = (ListView) findViewById(R.id.ListViewCustom);

        ArrayList<SinhVien> arrayListSinhVien = new ArrayList<SinhVien>();

        arrayListSinhVien.add(new SinhVien("Nguyen Van An", 2000));
        arrayListSinhVien.add(new SinhVien("Bui Tien Bac", 2000));
        arrayListSinhVien.add(new SinhVien("Le Quang Duy", 2000));
        arrayListSinhVien.add(new SinhVien("Do Xuan Canh", 2000));
        arrayListSinhVien.add(new SinhVien("Lieu Viet Hung", 1999));
        arrayListSinhVien.add(new SinhVien("Nguyen Viet Dai", 2000));
        arrayListSinhVien.add(new SinhVien("Le Quang Tho", 2000));
        arrayListSinhVien.add(new SinhVien("Nguyen Duc Phu", 2000));

        // Adapter
        ArrayAdapterSinhVien arrayAdapterSV = new ArrayAdapterSinhVien(CustomListViewArrayAdapterActivity.this, R.layout.item_sinh_vien, arrayListSinhVien);
        listView.setAdapter(arrayAdapterSV);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListViewArrayAdapterActivity.this, "Item " + (position + 1) + " " + arrayAdapterSV.getItem(position).getFullName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}