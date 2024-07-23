package com.lqt.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AddSinhVien extends AppCompatActivity {

    private EditText editTextHoTen, editTextNamSinh, editTextDiaChi;
    private Button buttonAdd, buttonCancel;
    private String urlInsert = "http://192.168.1.103/android/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinh_vien);
        AnhXa();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten =""+editTextHoTen.getText().toString().trim();
                String namsinh =""+editTextNamSinh.getText().toString().trim();
                String diachi =""+editTextDiaChi.getText().toString().trim();
                if(hoten.isEmpty() || namsinh.isEmpty() || diachi.isEmpty()){
                    Toast.makeText(AddSinhVien.this, "Vui long nhap day du thong tin", Toast.LENGTH_SHORT).show();
                } else {
                    themSinhVien(urlInsert);
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void themSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(AddSinhVien.this, "Thanh Cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddSinhVien.this, MainActivity.class));
                }else{
                    Toast.makeText(AddSinhVien.this, "Loi", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Loi_add", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("hotenSV",""+editTextHoTen.getText().toString().trim());
                param.put("namsinhSV",""+editTextNamSinh.getText().toString().trim());
                param.put("diachiSV",""+editTextDiaChi.getText().toString().trim());
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        editTextHoTen = (EditText) findViewById(R.id.EditText_addHoTen);
        editTextNamSinh =(EditText) findViewById(R.id.EditText_addNamSinh);
        editTextDiaChi= (EditText) findViewById(R.id.EditText_adDiaChi);
        buttonAdd = (Button) findViewById(R.id.Button_addSinhVien);
        buttonCancel = (Button) findViewById(R.id.Button_huySinhVien);
    }
}