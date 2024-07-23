package com.lqt.baitap1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class baiTapListViewCB extends AppCompatActivity {

    ListView listView;
    ArrayList<Student> arrStudent = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_tap_list_view_c_b);

        listView = (ListView) findViewById(R.id.listStudent);
        arrStudent.add(new Student("Lê Quang Thọ",2000,"Hưng Yên"));
        arrStudent.add(new Student("Nguyễn Thị Linh",2000,"Hưng Yên"));
        arrStudent.add(new Student("Nguyễn Thị Linh",2000,"Thanh Hóa"));
        arrStudent.add(new Student("Lê Quang Thọ",2000,"Thanh Hóa"));

        ArrayAdapter arrayAdapter = new ArrayAdapter(baiTapListViewCB.this,android.R.layout.simple_list_item_1,arrStudent);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(baiTapListViewCB.this, arrStudent.get(position).getHoten() +"\n" + arrStudent.get(position).getNamsinh()+"\n"+arrStudent.get(position).getDiachi(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(baiTapListViewCB.this,MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}