package com.lqt.baitapbuoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.lqt.baitapbuoi1.adapter.CustomBaseAdapter;
import com.lqt.baitapbuoi1.model.CauThu;

import java.util.ArrayList;

public class ActivityCauThu extends AppCompatActivity {

    CustomBaseAdapter adapter;
    ArrayList<CauThu> cauThus;

    ListView listView;
    EditText find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_thu);
        AnhXa();
        cauThus = new ArrayList<>();
        cauThus.add(new CauThu("a", R.drawable.cr7));
        cauThus.add(new CauThu("c", R.drawable.m10));
        cauThus.add(new CauThu("b", R.drawable.s11));
        adapter = new CustomBaseAdapter(ActivityCauThu.this, R.layout.row_cau_thu, cauThus);

        listView.setAdapter(adapter);

        find.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.ListView_CauThu);
        find = (EditText) findViewById(R.id.filter);
    }
}