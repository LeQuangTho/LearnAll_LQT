package com.lqt.baitapintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView textView_HoTen, textView_NamSinh, textView_TinhDiem;
    Button button_Back;
    final static int RESULT_CODE = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();

        Hung();

        Listen_Back();
    }

    private void Listen_Back() {
        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("data_Re", textView_TinhDiem.getText().toString());
                setResult(RESULT_CODE, intent);
                finish();
            }
        });


    }

    private void Hung() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        textView_HoTen.setText(""+ bundle.getString("data_Ten"));
        textView_NamSinh.setText(""+ bundle.getString("data_NamSinh"));

        int diemUT;
        if(bundle.getString("data_KhuVuc").contains("Khu Vực 1")){
            diemUT = 1;
        }
        else {
            diemUT = 2;
        }
        double tinhDiem = Double.parseDouble(bundle.getString("data_DiemToan"))
                + Double.parseDouble(bundle.getString("data_DiemVan")) + diemUT;
        textView_TinhDiem.setText(""+ tinhDiem);

    }

    private void AnhXa() {
        textView_HoTen = (TextView) findViewById(R.id.TextView_HoTen);
        textView_NamSinh = (TextView) findViewById(R.id.TextView_NamSinh);
        textView_TinhDiem = (TextView) findViewById(R.id.TextView_TinhDiem);
        button_Back = (Button) findViewById(R.id.Button_Back);
    }
}