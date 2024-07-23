package com.lqt.ghino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import com.lqt.ghino.model.NguoiNo;

import java.util.ArrayList;

public class SuaNo extends AppCompatActivity {
    EditText editText_Ten_SuaNo, editText_SDT_SuaNo, editText_NgayNo_SuaNo;
    TextView textView_TongTien_SuaNo;
    Button button_Luu_SuaNo, button_Them_SuaNo;
    ListView listView_DichVu_SuaNo;

    ArrayList<DichVu> listDV;
    CustomAdapterListDichVu adapter;

    int Index_Sua;

    private static final int RESULT_CODE = 12345;
    private static final int RESULT_CODE_XOA = 1111;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_no);

        AnhXa();

        //Hứng dữ liệu từ Activity main
        HungDuLieu();

        ListenNut();
    }

    private void ListenNut() {
        button_Luu_SuaNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_Ten_SuaNo.getText().toString().equals("")) {
                    Toast.makeText(SuaNo.this, "Bạn cần nhập tên người nợ!", Toast.LENGTH_SHORT).show();
                } else if (editText_SDT_SuaNo.getText().toString().equals("")) {
                    Toast.makeText(SuaNo.this, "Bạn cần nhập SĐT người nợ!", Toast.LENGTH_SHORT).show();
                } else if (editText_NgayNo_SuaNo.getText().toString().equals("")) {
                    Toast.makeText(SuaNo.this, "Bạn cần nhập ngày nợ!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Data_Sua_Xong", new NguoiNo(editText_Ten_SuaNo.getText().toString()
                            , editText_SDT_SuaNo.getText().toString()
                            , editText_NgayNo_SuaNo.getText().toString(), listDV));
                    intent.putExtra("Index_Sua_Xong", Index_Sua);
                    setResult(RESULT_CODE, intent);
                    finish();
                }
            }
        });

        button_Them_SuaNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialogAdd = new Dialog(SuaNo.this);
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
                            Toast.makeText(SuaNo.this, "Bạn cần nhập tên dịch vụ!", Toast.LENGTH_SHORT).show();
                        } else if (editText_TienDichVu.getText().toString().equals("")) {
                            Toast.makeText(SuaNo.this, "Bạn cần nhập chi phí cho dịch vụ này!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SuaNo.this, "Đã thêm dịch vụ " + editText_TenDichVu.getText().toString(), Toast.LENGTH_SHORT).show();
                            listDV.add(new DichVu(editText_TenDichVu.getText().toString(), Integer.parseInt(editText_TienDichVu.getText().toString())));
                            adapter.notifyDataSetChanged();
                            dialogAdd.dismiss();
                            loadTongTien();
                        }
                    }
                });
            }
        });

        listView_DichVu_SuaNo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SuaNo.this);
                builder.setTitle("Thông Báo");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Bạn có muốn xóa dịch vụ này không?");
                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SuaNo.this, "Bạn đã xóa dịch vụ " + listDV.get(position), Toast.LENGTH_SHORT).show();
                        listDV.remove(position);
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
    }

    private void HungDuLieu() {
        Intent intent = getIntent();
        NguoiNo nguoiNo = (NguoiNo) intent.getSerializableExtra("Data_Sua");
        editText_Ten_SuaNo.setText(nguoiNo.getTenNguoiNo());
        editText_SDT_SuaNo.setText(nguoiNo.getSdtNguoiNo());
        editText_NgayNo_SuaNo.setText(nguoiNo.getNgayNo());
        listDV = nguoiNo.getListDV();

        adapter = new CustomAdapterListDichVu(SuaNo.this, R.layout.row_dich_vu, listDV);
        listView_DichVu_SuaNo.setAdapter(adapter);
        listView_DichVu_SuaNo.setEnabled(false);

        Index_Sua = intent.getIntExtra("Index_Sua",0);

        loadTongTien();

        listView_DichVu_SuaNo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sua_nguoi_no_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.SWITCH_Sua:
                editText_Ten_SuaNo.setEnabled(true);
                editText_SDT_SuaNo.setEnabled(true);
                editText_NgayNo_SuaNo.setEnabled(true);

                button_Luu_SuaNo.setEnabled(true);
                button_Them_SuaNo.setEnabled(true);

                listView_DichVu_SuaNo.setEnabled(true);
                break;
            case R.id.SWITCH_Call:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + editText_SDT_SuaNo.getText().toString()));
                startActivity(intent);
            case R.id.SWITCH_Delete:
                Intent intentXoa = new Intent();
                intentXoa.putExtra("Index_Xoa", Index_Sua);
                intentXoa.putExtra("Ten_Xoa", editText_Ten_SuaNo.getText().toString());
                setResult(RESULT_CODE_XOA, intentXoa);

                finish();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AnhXa() {
        editText_Ten_SuaNo = (EditText) findViewById(R.id.EditText_Ten_SuaNo);
        editText_SDT_SuaNo = (EditText) findViewById(R.id.EditText_SDT_SuaNo);
        editText_NgayNo_SuaNo = (EditText) findViewById(R.id.EditText_NgayNo_SuaNo);

        textView_TongTien_SuaNo = (TextView) findViewById(R.id.TextView_TongTien_SuaNo);

        button_Luu_SuaNo = (Button) findViewById(R.id.Button_Luu_SuaNo);
        button_Them_SuaNo = (Button) findViewById(R.id.Button_Them_SuaNo);

        listView_DichVu_SuaNo = (ListView) findViewById(R.id.ListView_Dich_Vu_SuaNo);
    }

    private void loadTongTien() {
        int tong = 0;
        for (int i = 0; i < listDV.size(); i++) {
            tong += listDV.get(i).getDonGia();
        }

        textView_TongTien_SuaNo.setText("Tổng: " + tong);
    }
}