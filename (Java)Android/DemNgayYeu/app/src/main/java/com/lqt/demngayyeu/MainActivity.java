//https://www.youtube.com/watch?v=B1ZFfJG5CKE&ab_channel=TinCoder
package com.lqt.demngayyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.lqt.demngayyeu.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;



public class MainActivity extends AppCompatActivity {

    ImageView imgHinhTraiTim,imgAnhTho,imgAnhLinh;
    TextView txtNgayYeu;
    Calendar calendar1,calendar2;
    SimpleDateFormat dateFormat;
    LinearLayout layoutMain;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_CAMERA2 = 1234;

    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared = getSharedPreferences("ngayYeu",MODE_PRIVATE);
        AnhXa();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Anima();
        soNgayDaLuu();


        txtNgayYeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });

        imgAnhTho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonAnh();
            }
        });

        imgAnhLinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonAnh2();
            }
        });
    }

    private void soNgayDaLuu() {
        calendar1 = Calendar.getInstance();
        Date now = new Date();
        int ngay = calendar1.get(Calendar.DATE);
        int thang = calendar1.get(Calendar.MONTH);
        int nam = calendar1.get(Calendar.YEAR);
        calendar1.set(shared.getInt("namBD", nam), shared.getInt("thangBD",thang),shared.getInt("ngayBD",ngay));
        int NgayYeu = (int) ((now.getTime()-calendar1.getTimeInMillis())/(1000*60*60*24));
        txtNgayYeu.setText(NgayYeu+"\nDay");
    }

    private void Anima() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scal_anim);
        imgHinhTraiTim.startAnimation(animation);
    }

    private void AnhXa() {
        imgHinhTraiTim = (ImageView) findViewById(R.id.imgHinhTraiTim);
        txtNgayYeu = (TextView) findViewById(R.id.txtNgayYeu);
        layoutMain = (LinearLayout) findViewById(R.id.layoutMain);
        imgAnhTho = (ImageView) findViewById(R.id.imgHinhTho);
        imgAnhLinh = (ImageView) findViewById(R.id.imgHinhLinh);
    }

    private void chonNgay(){
        calendar1 = Calendar.getInstance();
        int ngay = calendar1.get(Calendar.DATE);
        int thang = calendar1.get(Calendar.MONTH);
        int nam = calendar1.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar1.set(year,month,dayOfMonth);
                        //editText.setText(dateFormat.format(calendar1.getTime()));
                        Date now = new Date();
                        //SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss dd/MM/yyy");
                        int soNgay = (int) ((now.getTime()-calendar1.getTimeInMillis())/(1000*60*60*24));
                        txtNgayYeu.setText(soNgay+"\nDay");
                        //luu ngay đã chon
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putString("NgayYeu", soNgay+"\nDay");
                        editor.putInt("ngayBD", dayOfMonth);
                        editor.putInt("thangBD", month);
                        editor.putInt("namBD", nam);

                        editor.commit();
                    }
                }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void showMenu(){
        PopupMenu menu = new PopupMenu(this, txtNgayYeu);

        menu.getMenuInflater().inflate(R.menu.popup_menu, menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mnThayDoiNen:
                        //chỗ này để test
                        //requestpermissions();
                        Toast.makeText(MainActivity.this, "Bố mày chưa làm \n xong chức năng này", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnThayDoiNS:
                        chonNgay();
                        break;
                }
                return false;
            }
        });
        menu.show();
    }

//    private void requestpermissions() {
//        PermissionListener permissionlistener = new PermissionListener() {
//            @Override
//            public void onPermissionGranted() {
//                openImagePicker();
//            }
//
//            @Override
//            public void onPermissionDenied(List<String> deniedPermissions) {
//                Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
//            }
//        };
//        TedPermission.with(this)
//                .setPermissionListener(permissionlistener)
//                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
//                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
//                .check();
//    }
//
//    private void openImagePicker() {
//        TedBottomPicker.OnImageSelectedListener listener = new TedBottomPicker.OnImageSelectedListener() {
//            @Override
//            public void onImageSelected(Uri uri) {
//                try {
//                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver() ,uri);
//                    //imgAnhTho.setImageBitmap(bitmap);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(MainActivity.this)
//                .setOnImageSelectedListener(listener)
//                .create();
//        tedBottomPicker.show(getSupportFragmentManager());
//    }
//
    private void chonAnh() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_CAMERA);
    }

    private void chonAnh2() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_CAMERA2);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode== REQUEST_CODE_CAMERA && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }
        else if(requestCode== REQUEST_CODE_CAMERA2 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_CAMERA2);
        }
        else{
            Toast.makeText(this, "Bạn chưa cấp quyền mở camera", Toast.LENGTH_SHORT).show();
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null)
        {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imgAnhTho.setImageBitmap(bitmap);
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                imgAnhTho.setImageBitmap(bitmap);
                imgAnhTho.setImageURI(uri);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else if(requestCode == REQUEST_CODE_CAMERA2 && resultCode == RESULT_OK && data != null)
        {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                imgAnhTho.setImageBitmap(bitmap);
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                imgAnhTho.setImageBitmap(bitmap);
                imgAnhLinh.setImageURI(uri);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}