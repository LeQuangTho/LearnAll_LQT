package com.lqt.sinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.sinhvien.model.CustumAdapterListViewSinhVien;
import com.lqt.sinhvien.model.SinhVien;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView listViewSinhVien;
    List<SinhVien> listSinhVien;
    CustumAdapterListViewSinhVien adapterListViewSinhVien;
    private String urlDelete = "http://192.168.1.103/android/delete.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        listSinhVien = new ArrayList<SinhVien>();

        adapterListViewSinhVien = new CustumAdapterListViewSinhVien(this, listSinhVien, R.layout.row_sinh_vien);
        listViewSinhVien.setAdapter(adapterListViewSinhVien);
        ReadJson("http://192.168.1.103/android/sinhvien.php");
//        ReadJson("http://thormobile.epizy.com/sinhvien.php");
//        ReadJson("https://602cc13830ba7200172235b7.mockapi.io/student");
//        ReadJson("https://github.com/LeQuangTho/Dev/blob/master/sinhvien.php");

        SuKienListView();
    }

    private void SuKienListView() {
        listViewSinhVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UpdateSinhVien.class);
                SinhVien sinhVien = listSinhVien.get(i);

                intent.putExtra("dataSinhVienUpdate", sinhVien);

                startActivity(intent);
            }
        });

        listViewSinhVien.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                DeleteSinhVien(listSinhVien.get(i).getIdSinhVien(), i);
                return false;
            }
        });
    }

    private void DeleteSinhVien(int id, int position) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("success")) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    listSinhVien.remove(position);
                    adapterListViewSinhVien.notifyDataSetChanged();
                } else
                    Toast.makeText(MainActivity.this, "Phát sinh lỗi không mong muốn! Hãy thử lại.", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Phát sinh lỗi không mong muốn! Hãy thử lại.", Toast.LENGTH_SHORT).show();
                Log.e("LoiXoa", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("idSinhVien", "" + id);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void AnhXa() {
        listViewSinhVien = (ListView) findViewById(R.id.ListView_Sinhvien);
    }


    private void ReadJson(String url) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("response", response.toString());

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        listSinhVien.add(new SinhVien(jsonObject.getInt("ID"), jsonObject.getInt("NamSinh"), jsonObject.getString("HoTen"), jsonObject.getString("DiaChi")));
                        adapterListViewSinhVien.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

//    private void ReadJson(String url){
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("ket", response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_sv) {
            startActivity(new Intent(MainActivity.this, AddSinhVien.class));
        }
        return super.onOptionsItemSelected(item);
    }
}