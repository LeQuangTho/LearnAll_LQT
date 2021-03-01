package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListMenuActivity extends AppCompatActivity {
    ListView listView;
    String[] maHoa = {"Mã hóa CAESAR", "Mã hóa VIGENERE_LK", "Mã hóa VIGENERE_AK", "Mã hóa Chữ Đơn", "Mã hóa Ma Trận khóa PLAYFAIR", "Mã hóa Hoán Vị"};
    String[] modulo = {"Hạ bậc lũy thừa", "Tìm nghịch đảo", "Hàm EULER", "Số dư Trung Hoa", "Kiểm tra Căn Nguyên Thủy", "LOGARITHM rời rạc"};
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
//            Toast.makeText(ListMenuActivity.this, "01", Toast.LENGTH_SHORT).show();
            inputListView(maHoa);

        } else {
            if (val == 2) {
                inputListView(modulo);
//                Toast.makeText(ListMenuActivity.this, itemMenus.get(1).getName(), Toast.LENGTH_SHORT).show();
            }

        }

        CustomListAdapter adapter = new CustomListAdapter(ListMenuActivity.this, R.layout.activity_list_menu, itemMenus);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (val) {
                    case 1: {
//                        intentView(position, ModuloActivity.class);
                        break;
                    }
                    case 2: {
                        intentView(position, ModuloActivity.class);
                        break;
                    }
                }
            }
        });


    }


    private void intentView(int val, Class cls) {
        Intent intent = new Intent(ListMenuActivity.this, cls);
        Bundle bundle = new Bundle();
        bundle.putInt("key", val);
        intent.putExtra("Modulo", bundle);
        startActivity(intent);
    }

    private void inputListView(String[] arrS) {
        for (int i = 0; i < arrS.length; i++) {
            itemMenus.add(new itemMenu(arrS[i]));
        }
    }

}