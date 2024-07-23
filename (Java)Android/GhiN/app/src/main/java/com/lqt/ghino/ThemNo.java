package com.lqt.ghino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.lqt.ghino.model.NguoiNo;

import java.util.ArrayList;

public class ThemNo extends AppCompatActivity {

    public static final int RESULT_CODE = 2000;

    EditText editText_Ten, editText_SDT, editText_NgayNo;
    TextView textView_TongTien;
    Button button_Luu, button_Them;
    ListView listView_DichVu;

    ArrayList<DichVu> list = new ArrayList<>();
    CustomAdapterListDichVu adapter;

    //DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_no);
        AnhXa();

        TestList();

        //Set sự kiện thêm dịch vụ
        ListenAdd();

        //Thêm người nợ
        AddConNo();
    }


    private void AddConNo() {
    }

    private void ListenAdd() {
        button_Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialogAdd = new Dialog(ThemNo.this);
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
                            Toast.makeText(ThemNo.this, "Bạn cần nhập tên dịch vụ!", Toast.LENGTH_SHORT).show();
                        } else if (editText_TienDichVu.getText().toString().equals("")) {
                            Toast.makeText(ThemNo.this, "Bạn cần nhập chi phí cho dịch vụ này!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ThemNo.this, "Đã thêm dịch vụ " + editText_TenDichVu.getText().toString(), Toast.LENGTH_SHORT).show();
                            list.add(new DichVu(editText_TenDichVu.getText().toString(), Integer.parseInt(editText_TienDichVu.getText().toString())));
                            adapter.notifyDataSetChanged();
                            dialogAdd.dismiss();
                            loadTongTien();
                        }
                    }
                });
            }
        });
    }

    private void TestList() {

        adapter = new CustomAdapterListDichVu(this, R.layout.row_dich_vu, list);
        listView_DichVu.setAdapter(adapter);

        listView_DichVu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThemNo.this);
                builder.setTitle("Thông Báo");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Bạn có muốn xóa dịch vụ này không?");
                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ThemNo.this, "Bạn đã xóa dịch vụ " + list.get(position), Toast.LENGTH_SHORT).show();
                        list.remove(position);
                        loadTongTien();
                        //Cập nhật lại dữ liệu
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

        button_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_Ten.getText().toString().equals("")) {
                    Toast.makeText(ThemNo.this, "Bạn cần nhập tên người nợ!", Toast.LENGTH_SHORT).show();
                } else if (editText_SDT.getText().toString().equals("")) {
                    Toast.makeText(ThemNo.this, "Bạn cần nhập SĐT người nợ!", Toast.LENGTH_SHORT).show();
                } else if (editText_NgayNo.getText().toString().equals("")) {
                    Toast.makeText(ThemNo.this, "Bạn cần nhập ngày nợ!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Data", new NguoiNo(editText_Ten.getText().toString()
                            , editText_SDT.getText().toString()
                            , editText_NgayNo.getText().toString(), list));
                    setResult(RESULT_CODE, intent);
                    finish();
                }
            }
        });
    }

    private void loadTongTien() {
        int tong = 0;
        for (int i = 0; i < list.size(); i++) {
            tong += list.get(i).getDonGia();
        }

        textView_TongTien.setText("Tổng: " + tong);
    }

    private void AnhXa() {
        editText_Ten = (EditText) findViewById(R.id.EditText_Ten);
        editText_SDT = (EditText) findViewById(R.id.EditText_SDT);
        editText_NgayNo = (EditText) findViewById(R.id.EditText_NgayNo);

        textView_TongTien = (TextView) findViewById(R.id.TextView_TongTien);

        button_Luu = (Button) findViewById(R.id.Button_Luu);
        button_Them = (Button) findViewById(R.id.Button_Them);

        listView_DichVu = (ListView) findViewById(R.id.ListView_Dich_Vu);
    }
}