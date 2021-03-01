package com.example.timekeeping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ImageButton buttonAdd, buttonSetting;
    TextView textViewDate;
    EditText editTextCong, editTextTangCa, editTextTien;
    DatePickerDialog datePickerDialog;
    String currentDate = new SimpleDateFormat("dd / MM / yyyy", Locale.getDefault()).format(new Date());
    String currentMonth = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
    String currentDay = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
    String currentYear = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh Xa
        buttonAdd = (ImageButton) findViewById(R.id.imageButtonAdd);
        buttonSetting = (ImageButton) findViewById(R.id.imageButtonSetting);
        textViewDate = (TextView) findViewById(R.id.textViewDate);
        editTextCong = (EditText) findViewById(R.id.editTextCong);
        editTextTangCa = (EditText) findViewById(R.id.editTextTangCa);
        editTextTien = (EditText) findViewById(R.id.editTextTongTien);
        listView = (ListView) findViewById(R.id.listView);
        //
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(8, 2.5, "01 / 01 / 2021"));
        items.add(new Item(0, 0.0, "02 / 01 / 2021"));
        items.add(new Item(4, 0.0, "03 / 01 / 2021"));
        items.add(new Item(8, 1.5, "04 / 01 / 2021"));
        items.add(new Item(8, 1.0, "05 / 01 / 2021"));
        items.add(new Item(8, 1.0, "06 / 01 / 2021"));
        items.add(new Item(8, 1.0, "07 / 01 / 2021"));
        items.add(new Item(8, 1.0, "08 / 01 / 2021"));

        CustomArrayAdapter adapter = new CustomArrayAdapter(MainActivity.this, R.layout.activity_item_list_view, items);
        listView.setAdapter(adapter);
//
        //
        //
        textViewDate.setText(currentDate);
        // su kien Click textViewDate
        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textViewDate.setText(dayOfMonth + " / " + (month + 1) + " / " + year);
                    }
                }, Integer.parseInt(currentYear), Integer.parseInt(currentMonth) - 1, Integer.parseInt(currentDay));
                datePickerDialog.show();
//                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });

        // su kien Click buttonAdd
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.show();
            }
        });

        // su kien Click buttonSetting
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // su kien Click Item ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}