package com.lqt.ghino;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.lqt.ghino.adapter.CustomAdapterListNguoiNo;
import com.lqt.ghino.model.DichVu;
import com.lqt.ghino.model.NguoiNo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    private static final int REQUEST_CODE_THEM = 1234;
    private static final int RESULT_CODE_SUA = 12345;
    private static final int RESULT_CODE_XOA = 1111;

    DataBase dataBase;
    ImageView imageView_Logo;
    ListView listView_NguoiNo;
    EditText search;
    CustomAdapterListNguoiNo adapter;
    ArrayList<NguoiNo> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        //taoDataBase();
        listen();
        /*
        test listView();
        for (int i =0;i<10;i++){
            list.add(new NguoiNo("a", "a","a", new ArrayList<DichVu>()));
        }*/
        adapter = new CustomAdapterListNguoiNo(this, list, R.layout.row_nguoi_no);
        listView_NguoiNo.setAdapter(adapter);



        /*listView_NguoiNo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo?");
                builder.setCancelable(false);
                builder.setMessage("Bạn có muốn xóa "+ list.get(position).getTenNguoiNo());
                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Bạn đã xóa con nợ " + list.get(position).getTenNguoiNo(), Toast.LENGTH_SHORT).show();
                        list.remove(position);
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
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Bắt sự kiện cho menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_Them_No:
                Intent intent = new Intent(MainActivity.this, ThemNo.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.option_Thoat:
                Intent endApp = new Intent(Intent.ACTION_MAIN); // khởi tạo Intent với giá trị khởi tạo là main
                endApp.addCategory(Intent.CATEGORY_HOME);   // add category với Intent là home
                startActivity(endApp);   // chạy
                finish();   //xóa activity khỏi stack
                break;
            case R.id.option_May_Tinh:
                Intent intentMayTinh = new Intent(MainActivity.this, MayTinh.class);
                startActivity(intentMayTinh);
            case R.id.option_Cai_Dat:
                //TODO
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE & resultCode == ThemNo.RESULT_CODE) {
            NguoiNo nguoiNo = (NguoiNo) data.getSerializableExtra("Data");
            list.add(nguoiNo);
            Toast.makeText(this, "Bạn đã thêm " + nguoiNo.getTenNguoiNo(), Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        } else if (requestCode == REQUEST_CODE & resultCode == RESULT_CODE_SUA) {
            NguoiNo nguoiNo = (NguoiNo) data.getSerializableExtra("Data_Sua_Xong");
            int Index = data.getIntExtra("Index_Sua_Xong", 0);
            list.set(Index, nguoiNo);
            Toast.makeText(this, "Bạn đã thêm " + nguoiNo.getTenNguoiNo(), Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        } else if (requestCode == REQUEST_CODE & resultCode == RESULT_CODE_XOA) {
            int Index_Xoa = data.getIntExtra("Index_Xoa", 0);
            list.remove(Index_Xoa);
            String Ten_Xoa = data.getStringExtra("Ten_Xoa");
            Toast.makeText(this, "Bạn xóa nợ của " + Ten_Xoa, Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
    }

    private void listen() {
        //sự kiện item click
        listView_NguoiNo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SuaNo.class);
                intent.putExtra("Data_Sua", list.get(position));
                intent.putExtra("Index_Sua", position);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        //cho Animation chạy
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        imageView_Logo.startAnimation(animation);

        //TODO
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void AnhXa() {
        imageView_Logo = (ImageView) findViewById(R.id.ImageView_Logo);
        listView_NguoiNo = (ListView) findViewById(R.id.ListView_Nguoi_No);
        search = (EditText) findViewById(R.id.filter);
    }

    private void taoDataBase() {
        //tạo DataBase
        dataBase = new DataBase(this, "GhiNo.sqlite", null, 1);
        //tạo bảng
        dataBase.QueryData("Create table IF NOT EXISTS GhiNo(Id Integer Primary Key AUTOINCREMENT, TenNguoiNo nvarchar(50))");
        //dataBase.QueryData("insert into GhiNo Values (null,'test lần đầu')");
        Cursor khoanno = dataBase.getData("select * from GhiNo");

        while (khoanno.moveToNext()) {
            String ten = khoanno.getString(1);
            Toast.makeText(this, ten, Toast.LENGTH_SHORT).show();
        }
    }
}