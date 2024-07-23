package com.lqt.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemSuaXoaLV extends AppCompatActivity {
    ListView listView;
    ArrayList<Student> arrStudent = new ArrayList<>();
    Button button;
    EditText ed1,ed2,ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua_xoa_l_v);

        listView = (ListView) findViewById(R.id.listStudent2);
        button = (Button) findViewById(R.id.btSubmit);
        ed1 = (EditText) findViewById(R.id.tbNhapHoTen);
        ed2 = (EditText) findViewById(R.id.tbNhapTuoi) ;
        ed3 = (EditText) findViewById(R.id.tbNhapDC) ;

        arrStudent.add(new Student("Lê Quang Thọ",2000,"Hưng Yên"));
        arrStudent.add(new Student("Nguyễn Thị Linh",2000,"Hưng Yên"));
        arrStudent.add(new Student("Nguyễn Thị Linh",2000,"Thanh Hóa"));
        arrStudent.add(new Student("Lê Quang Thọ",2000,"Thanh Hóa"));

        ArrayAdapter arrayAdapter = new ArrayAdapter(ThemSuaXoaLV.this,android.R.layout.simple_list_item_1,arrStudent);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ThemSuaXoaLV.this, arrStudent.get(position).getHoten() +"\n" + arrStudent.get(position).getNamsinh()+"\n"+arrStudent.get(position).getDiachi(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ThemSuaXoaLV.this,MainActivity.class);
                startActivity(intent);
                return false;
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = ed1.getText().toString();
                int tuot = Integer.parseInt(ed2.getText().toString());
                String diachi = ed3.getText().toString();

                arrStudent.add(new Student(hoten,tuot,diachi));
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}