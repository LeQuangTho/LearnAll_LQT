package com.lqt.kiemtra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewContact;
    EditText filter;
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    ContactAdapter contactAdapter;
    DataBase dataBase;
    Button buttonThem, buttonXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        contactAdapter = new ContactAdapter(this, contactArrayList, R.layout.row_contact);

        listViewContact.setAdapter(contactAdapter);
        data();
        Listener();
    }

    private void Listener() {
        listViewContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Nhấn nè", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        buttonThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogAdd();

                Intent intent = new Intent(MainActivity.this, ThemMoiActivity.class);
                intent.putExtra("dataBase", (Serializable) dataBase);
                startActivity(intent);
            }
        });

        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông Báo");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("Bạn có muốn xóa dịch vụ này không?");
                builder.setPositiveButton(getString(R.string.title_Co), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        xoa();

                    }
                });

                builder.setNegativeButton(getString(R.string.title_Khong), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
    }

    private void data() {
        //Tạo data base
        dataBase = new DataBase(this, "contact.sqlite", null, 1);

        //Tạo bảng
        dataBase.QueryData("Create Table IF NOT EXISTS Contact(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "HoTen VARCHAR(50)," +
                "SDT VARCHAR(50)," +
                "Checked INTEGER)");

//        dataBase.QueryData("Insert into Contact VALUES(null,'Le Quang Tho', '0125641', 0)");
        loadData();
    }

    private void loadData() {
        Cursor dataContact = dataBase.GetData("select * from Contact");
        contactArrayList.clear();
        while (dataContact.moveToNext()) {
            int id = dataContact.getInt(0);
            String hoten = dataContact.getString(1);
            String sdt = dataContact.getString(2);
            boolean checked;
            if (dataContact.getInt(3) != 0) checked = true;
            else checked = false;
            contactArrayList.add(new Contact(id, checked, hoten, sdt));
            //Toast.makeText(this, "" + id + checked + hoten + sdt, Toast.LENGTH_SHORT).show();
        }
        contactAdapter.notifyDataSetChanged();
    }

    private void AnhXa() {
        listViewContact = (ListView) findViewById(R.id.ListView_Contact);
        filter = (EditText) findViewById(R.id.EditText_Fillter);
        buttonThem = (Button) findViewById(R.id.buttonThem);
        buttonXoa = (Button) findViewById(R.id.buttonXoa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menubar_them) {
            DialogAdd();
        } else if (item.getItemId() == R.id.menubar_xoa) {
            xoa();
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogAdd() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_contact);
        EditText hoten = (EditText) dialog.findViewById(R.id.EditText_add_contact_name);
        EditText sdt = (EditText) dialog.findViewById(R.id.EditText_add_contact_sdt);
        Button add = (Button) dialog.findViewById(R.id.Button_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hoten.getText().toString().equals("") || sdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    dataBase.QueryData("Insert into Contact VALUES(null,'"
                            + hoten.getText().toString() + "', '" + sdt.getText().toString() + "', 0)");
                    Toast.makeText(MainActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    loadData();
                }
            }
        });

        dialog.show();
    }

    private void DialogSua(int p) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_contact);
        EditText hoten = (EditText) dialog.findViewById(R.id.EditText_add_contact_name);
        EditText sdt = (EditText) dialog.findViewById(R.id.EditText_add_contact_sdt);
        Button add = (Button) dialog.findViewById(R.id.Button_add);

        add.setText("Hoàn Tất");
        hoten.setText(contactArrayList.get(p).getHoTen());
        sdt.setText(contactArrayList.get(p).getSdt());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hoten.getText().toString().equals("") || sdt.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Hãy nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    dataBase.QueryData("Update Contact Set HoTen = '"
                            + hoten.getText().toString() + "' SDT = '" + sdt.getText().toString() + "', 0)");
                    Toast.makeText(MainActivity.this, "Đã thêm!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    loadData();
                }
            }
        });

        dialog.show();
    }

    public void sua(int p, boolean ch) {
        int check;
        if (ch) {
            check = 0;
        } else {
            check = 1;
        }
        dataBase.QueryData("Update Contact set Checked = '" + check + "' WHERE id ='" + p + "'");
        loadData();
    }

    private void xoa() {
        Cursor data = dataBase.GetData("select * from Contact");
        contactArrayList.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            String hoten = data.getString(1);
            String sdt = data.getString(2);
            boolean checked;
            if (data.getInt(3) != 0) checked = true;
            else checked = false;
            if (checked) {
                Toast.makeText(this, "Đã Xóa " + id + checked + hoten + sdt, Toast.LENGTH_SHORT).show();
                dataBase.QueryData("delete from Contact where id = '" + id + "'");
            } else {
                contactArrayList.add(new Contact(id, checked, hoten, sdt));
            }
        }
        contactAdapter.notifyDataSetChanged();
    }
}