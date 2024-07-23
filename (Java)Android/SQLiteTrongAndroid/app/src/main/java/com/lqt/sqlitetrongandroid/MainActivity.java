package com.lqt.sqlitetrongandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.lqt.sqlitetrongandroid.model.CustumAdapter2;
import com.lqt.sqlitetrongandroid.model.MyDBHelper;

public class MainActivity extends AppCompatActivity {
    EditText editText_ID, editText_HoTen, editText_NamSinh;
    Button button_Insert, button_Update, button_Delete,button_Load;
    MyDBHelper myDBHelper;
    ListView listViewSV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ListNut();
    }

    private void ListNut() {
        button_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long rerultAdd = myDBHelper.Insert(Integer.parseInt(editText_ID.getText().toString()), editText_HoTen.getText().toString(), Integer.parseInt(editText_NamSinh.getText().toString()));
                if (rerultAdd == -1)
                    Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });

        button_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long rerultUpdate = myDBHelper.Update(Integer.parseInt(editText_ID.getText().toString()), editText_HoTen.getText().toString(), Integer.parseInt(editText_NamSinh.getText().toString()));
                if (rerultUpdate == 0) {
                    Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                } else if (rerultUpdate == 1) {
                    Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Không có Id nào như thế", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long rerultDelete = myDBHelper.Delete(Integer.parseInt(editText_ID.getText().toString()));
                if (rerultDelete == 0) {
                    Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                } else if (rerultDelete == 1) {
                    Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Không có Id nào như thế", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = myDBHelper.Load();
                CustumAdapter2 custumAdapter2 = new CustumAdapter2(MainActivity.this, R.layout.row_sv, cursor,0);
//                cursor.moveToFirst();
//                while (!cursor.isAfterLast()){
//                    buffer.append(cursor.getInt(cursor.getColumnIndex(MyDBHelper.getId())));
//                    buffer.append(cursor.getString(cursor.getColumnIndex(MyDBHelper.getHoTen())));
//                    buffer.append(cursor.getInt(cursor.getColumnIndex(MyDBHelper.getNamSinh())));
//                    Toast.makeText(MainActivity.this, ""+buffer, Toast.LENGTH_SHORT).show();
//                    cursor.moveToNext();
//                }
            listViewSV.setAdapter(custumAdapter2);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myDBHelper.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myDBHelper.closeDB();
    }

    private void AnhXa() {
        editText_ID = (EditText) findViewById(R.id.editText_ID);
        editText_HoTen = (EditText) findViewById(R.id.editText_HoTen);
        editText_NamSinh = (EditText) findViewById(R.id.editText_NamSinh);
        button_Insert = (Button) findViewById(R.id.button_Insert);
        button_Update = (Button) findViewById(R.id.button_Update);
        button_Delete = (Button) findViewById(R.id.button_Delete);
        button_Load = (Button) findViewById(R.id.button_Load);
        myDBHelper = new MyDBHelper(MainActivity.this);
        listViewSV = (ListView) findViewById(R.id.listView_SV);

    }
}