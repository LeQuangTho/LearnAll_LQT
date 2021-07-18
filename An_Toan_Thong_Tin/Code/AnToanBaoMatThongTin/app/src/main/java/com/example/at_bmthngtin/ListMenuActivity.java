package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMenuActivity extends AppCompatActivity {
    ListView listView;
    String[] maHoa = {"Mã hóa CAESAR", "Mã hóa VIGENERE_LK", "Mã hóa VIGENERE_AK", "Mã hóa Chữ Đơn", "Mã hóa Ma Trận khóa PLAYFAIR", "Mã hóa Hoán Vị"};
    String[] modulo = {"Tính Modulo", "Nghịch đảo Modulo", "Hàm Euler(Φ)", "Số dư Trung Hoa", "Căn nguyên thủy", "Logarithm rời rạc", "Modulo cơ bản"};
    String[] maHoaModulo = {"Diffie-Hellman", "RSA - Bài toán 1", "RSA - Bài toán 2", "Mật mã ElGamal", "CHỮ KÝ ĐIỆN TỬ DSA"};
    String[] AesDes = {"Des", "Aes"};
    ArrayList<itemMenu> itemMenus = new ArrayList<itemMenu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        // Anh xa
        listView = (ListView) findViewById(R.id.listView);
        //
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("KatoIT");
        int val = bundle.getInt("key");
        if (val == 1) {
            inputListView(maHoa);

        } else {
            if (val == 2) {
                inputListView(modulo);
            } else {
                if (val == 3) {
                    inputListView(maHoaModulo);
                } else {
                    if (val == 4) {
                        inputListView(AesDes);
                    }
                }
            }
        }

        CustomListAdapter adapter = new CustomListAdapter(ListMenuActivity.this, R.layout.activity_list_menu, itemMenus);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (val) {
                    case 1: {
                        intentView(position, MaHoaCoDienActivity.class, "MaHoaCoDien");
                        break;
                    }
                    case 2: {
                        intentView(position, ModuloActivity.class, "Modulo");
                        break;
                    }
                    case 3: {
                        intentView(position, MaHoaModuloActivity.class, "MaHoaModulo");
                        break;
                    }
                    case 4: {
                        intentView(position, AesDesActivity.class, "AesDes");
                        break;
                    }
                }
            }
        });


    }


    private void intentView(int val, Class cls, String str) {
        Intent intent = new Intent(ListMenuActivity.this, cls);
        Bundle bundle = new Bundle();
        bundle.putInt("key", val);
        intent.putExtra(str, bundle);
        startActivity(intent);
    }

    private void inputListView(String[] arrS) {
        for (int i = 0; i < arrS.length; i++) {
            itemMenus.add(new itemMenu(arrS[i]));
        }
    }

}