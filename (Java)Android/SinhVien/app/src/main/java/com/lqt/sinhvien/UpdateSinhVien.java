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
import com.lqt.sinhvien.model.SinhVien;

import java.util.HashMap;
import java.util.Map;

public class UpdateSinhVien extends AppCompatActivity {

    private EditText editTextHoTen, editTextNamSinh, editTextDiaChi;
    private Button buttonAdd, buttonCancel;
    private String urlUpdate = "http://192.168.1.103/android/update.php";
    private String id ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sinh_vien);
        AnhXa();

        HungDuLieu();

        SuKienPhim(urlUpdate);
    }

    private void SuKienPhim(String url) {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue = Volley.newRequestQueue(UpdateSinhVien.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("success"))
                            Toast.makeText(UpdateSinhVien.this, "Success", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(UpdateSinhVien.this, "Phát sinh lỗi không mong muốn! Hãy thử lại.", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateSinhVien.this, "Phát sinh lỗi không mong muốn! Hãy thử lại.", Toast.LENGTH_SHORT).show();
                        Log.e("LoiUpdate", error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("idSinhVien", id);
                        params.put("hoTenSinhVien", editTextHoTen.getText().toString());
                        params.put("namSinhSinhVien", editTextNamSinh.getText().toString());
                        params.put("diaChiSinhVien", editTextDiaChi.getText().toString());
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
                startActivity(new Intent(UpdateSinhVien.this, MainActivity.class));
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void HungDuLieu() {
        Intent intent = getIntent();
        SinhVien sinhVien = (SinhVien) intent.getSerializableExtra("dataSinhVienUpdate");
        id += sinhVien.getIdSinhVien();
        editTextHoTen.setText(sinhVien.getHoTenSinhVien());
        editTextNamSinh.setText(""+sinhVien.getNamSinhSinhVien());
        editTextDiaChi.setText(sinhVien.getDiaChiSinhVien());
    }

    private void AnhXa() {
        editTextHoTen = (EditText) findViewById(R.id.editText_udHoTen);
        editTextNamSinh = (EditText) findViewById(R.id.editText_udNamSinh);
        editTextDiaChi = (EditText) findViewById(R.id.editText_udDiaChi);
        buttonAdd = (Button) findViewById(R.id.button_udSinhVien);
        buttonCancel = (Button) findViewById(R.id.button_udhuySinhVien);
    }
}