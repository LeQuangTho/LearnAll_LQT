package com.example.chmcng;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    RadioButton rbCo, rbKhong;
    Button button, buttonThem;
    TimePickerDialog time;
    DatePickerDialog day;
    TextView textViewDate, textViewTangCa;
    String currentDate = new SimpleDateFormat("dd - MM - yyyy", Locale.getDefault()).format(new Date());
    String currentMonth = new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
    String currentDay = new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
    String currentYear = new SimpleDateFormat("yyyy", Locale.getDefault()).format(new Date());
    String error1 = "Error: Lỗi ghi file!!!", error2 = "Error: Lỗi đọc file!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        buttonThem = (Button) findViewById(R.id.buttonThem);
        textViewDate = (TextView) findViewById(R.id.textViewDay);
        textViewTangCa = (TextView) findViewById(R.id.textViewTangCa);
        listView = (ListView) findViewById(R.id.ListView);
        rbCo = (RadioButton) findViewById(R.id.radioButtonCo);
        rbKhong = (RadioButton) findViewById(R.id.radioButtonKhong);

        ArrayList<String> arrayList = new ArrayList<String>();

//        saveData("Note.txt", "");
        arrayList = readData("Note.txt");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        textViewDate.setText(currentDate + " ");
        listView.setAdapter(adapter);

        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textViewDate.setText(dayOfMonth + " - " + (month+1) + " - " + year);
                    }
                },Integer.parseInt(currentYear),Integer.parseInt(currentMonth)-1,Integer.parseInt(currentDay) );
                day.show();
                Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
            }
        });
        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String var = textViewDate.getText().toString() + "   | ";
                if (rbCo.isChecked()) {
                    var += "X |  ";
                } else {
                    var += "O |  ";
                }
                var += "    Tăng ca: ";
                if (textViewTangCa.getText().toString().length() > 0) {
                    var += textViewTangCa.getText().toString();
                } else {
                    var += "Không";
                }
                saveData("Note.txt", var + "\n");

                finish();
                startActivity(getIntent());
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                time = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textViewTangCa.setText(hourOfDay + "h " + minute + "p");
                    }
                }, 2, 30, false);
                time.show();
            }
        });
    }

    private void saveData(String file, String data) {
        try {
            // Open Stream to write file.
            FileOutputStream out = this.openFileOutput(file, MODE_APPEND);
            // Ghi dữ liệu.
            out.write(data.getBytes());
            out.close();
            Toast.makeText(this, "Đã lưu!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, error1 + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private ArrayList<String> readData(String file) {
        ArrayList<String> array = new ArrayList<String>();
        try {
            // Open stream to read file.
            FileInputStream in = this.openFileInput(file);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String s = null;
            while ((s = br.readLine()) != null) {
                array.add(s);
            }
            return array;

        } catch (Exception e) {
            Toast.makeText(this, error2 + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return array;
    }
}