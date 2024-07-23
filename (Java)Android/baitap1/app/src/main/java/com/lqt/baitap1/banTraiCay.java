package com.lqt.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class banTraiCay extends AppCompatActivity {
    ListView lvBanTraiCay;
    ArrayList<TraiCay> traiCayArrayList;
    TraiCayAdapter traiCayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_trai_cay);
        AnhXa();
        lvBanTraiCay.setAdapter(traiCayAdapter);
    }

    private void AnhXa() {
        lvBanTraiCay = (ListView) findViewById(R.id.lvBanTraiCay);
        traiCayArrayList = new ArrayList<>();
        traiCayArrayList.add(new TraiCay("Dưa Hấu","Vô Cùng Ngon Nhé", R.drawable.duahau));
        traiCayArrayList.add(new TraiCay("Dâu Tây","Vô Cùng Ngon Nè", R.drawable.dautay));
        traiCayArrayList.add(new TraiCay("Thanh Long","Như C**", R.drawable.thanhlong));
        traiCayArrayList.add(new TraiCay("Dưa Hấu","Vô Cùng Ngon Nhé", R.drawable.duahau));
        traiCayArrayList.add(new TraiCay("Dâu Tây","Vô Cùng Ngon Nè", R.drawable.dautay));
        traiCayArrayList.add(new TraiCay("Thanh Long","Như C**", R.drawable.thanhlong));

        traiCayAdapter = new TraiCayAdapter(this, R.layout.line_trai_cay, traiCayArrayList);
    }
}