package com.lqt.baitap2_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<HinhAnh> hinhAnhs;
    OVuongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        gridView.setAdapter(adapter);
    }

    private void AnhXa() {
        gridView = (GridView) findViewById(R.id.gvOVuong);

        hinhAnhs = new ArrayList<>();
        hinhAnhs.add(new HinhAnh("1"));
        hinhAnhs.add(new HinhAnh("2"));
        hinhAnhs.add(new HinhAnh("3"));
        hinhAnhs.add(new HinhAnh("4"));
        hinhAnhs.add(new HinhAnh("5"));
        hinhAnhs.add(new HinhAnh("6"));
        hinhAnhs.add(new HinhAnh("7"));
        hinhAnhs.add(new HinhAnh("8"));
        hinhAnhs.add(new HinhAnh("9"));

        adapter = new OVuongAdapter(this,R.layout.o_vuong,hinhAnhs);
    }
}