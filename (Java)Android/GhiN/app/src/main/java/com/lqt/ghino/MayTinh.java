package com.lqt.ghino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lqt.ghino.adapter.CustomAdapterListDichVu;
import com.lqt.ghino.model.DichVu;

import java.util.ArrayList;

public class MayTinh extends AppCompatActivity {
    Button button_ThemDV_MT;
    TextView textView_TongTien;

    ArrayList<DichVu> list = new ArrayList<>();
    ListView listDV;

    CustomAdapterListDichVu adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);

        AnhXa();

        Listen();
    }

    private void Listen() {
        adapter = new CustomAdapterListDichVu(this, R.layout.row_dich_vu, list);
        listDV.setAdapter(adapter);

        button_ThemDV_MT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialogAdd = new Dialog(MayTinh.this);
                dialogAdd.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogAdd.setContentView(R.layout.dialog_add_dich_vu);
                dialogAdd.show();

                //Ánh Xạ trong dialog
                EditText editText_TenDichVu = (EditText) dialogAdd.findViewById(R.id.EditText_TenDichVu);
                EditText editText_TienDichVu = (EditText) dialogAdd.findViewById(R.id.EditText_DonGia);

                Button button_Them_DV = (Button) dialogAdd.findViewById(R.id.Button_ThemDichVu);

                //Set sự kiện
                button_Them_DV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (editText_TenDichVu.getText().toString().equals("")) {
                            Toast.makeText(MayTinh.this, "Bạn cần nhập tên dịch vụ!", Toast.LENGTH_SHORT).show();
                        } else if (editText_TienDichVu.getText().toString().equals("")) {
                            Toast.makeText(MayTinh.this, "Bạn cần nhập chi phí cho dịch vụ này!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MayTinh.this, "Đã thêm dịch vụ " + editText_TenDichVu.getText().toString(), Toast.LENGTH_SHORT).show();
                            list.add(new DichVu(editText_TenDichVu.getText().toString(), Integer.parseInt(editText_TienDichVu.getText().toString())));
                            adapter.notifyDataSetChanged();
                            dialogAdd.dismiss();
                            loadTongTien();
                        }
                    }
                });
            }
        });

        listDV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MayTinh.this);
                builder.setTitle("Thông báo?");
                builder.setCancelable(false);
                builder.setMessage("Bạn có muốn xóa dịch vụ "+ list.get(position).getTenDichVu());

                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MayTinh.this, "Đã xóa dịch vụ "+ list.get(position).getTenDichVu(), Toast.LENGTH_SHORT).show();
                        list.remove(position);
                        loadTongTien();
                        adapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton(getString(R.string.title_Khong), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.may_tinh_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_Thoat_MayTinh:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AnhXa() {
        button_ThemDV_MT = findViewById(R.id.Button_ThemDichVu_MT);
        textView_TongTien = findViewById(R.id.TextView_TongTien_MT);
        listDV = findViewById(R.id.ListView_MT);
    }

    private void loadTongTien() {
        int tong = 0;
        for (int i = 0; i < list.size(); i++) {
            tong += list.get(i).getDonGia();
        }

        textView_TongTien.setText("Tổng: " + tong);
    }
}