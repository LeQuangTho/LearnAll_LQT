package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MaHoaCoDienActivity extends AppCompatActivity {
    private EditText editTextInputK, editTextInputM;
    private Button buttonKQ1;
    private Switch switchGiaiMa;
    private TextView textViewBaiToan, textViewResult1;
    private String ipM, ipK, maTranKhoa;
    private int valueList;
    private ArrayList<Integer> arrayList = new ArrayList<>();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_hoa_co_dien);
        // Ánh xạ
        buttonKQ1 = (Button) findViewById(R.id.buttonSubmit1);
        editTextInputM = findViewById(R.id.editTextInputM);
        editTextInputK = findViewById(R.id.editTextInputK);
        textViewBaiToan = findViewById(R.id.textViewBaiToan1);
        textViewResult1 = findViewById(R.id.textViewResult1);
        switchGiaiMa = findViewById(R.id.switchGiaiMa);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MaHoaCoDien");
        valueList = bundle.getInt("key");
        switch (valueList) {
            case 0: {
                textViewBaiToan.setText("Mật mã CAESAR");
                editTextInputK.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            }
            case 1: {
                textViewBaiToan.setText("Mật mã VIGENERE – Lặp khóa");
                break;
            }
            case 2: {
                textViewBaiToan.setText("Mật mã VIGENERE – Auto khóa");
                break;
            }
            case 3: {
                textViewBaiToan.setText("Mã hóa Chữ Đơn");
                break;
            }
            case 4: {
                textViewBaiToan.setText("Mật mã ma trận khóa PLAYFAIR");
                break;
            }
            case 5: {
                textViewBaiToan.setText("Mật mã Hoán Vị");
                editTextInputK.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            }
            default:
                Toast.makeText(this, "Chưa có!!!", Toast.LENGTH_SHORT).show();

        }
        switchGiaiMa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editTextInputM.setText(textViewResult1.getText().toString().trim());
            }
        });
        buttonKQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextInputM.getText().toString().length() > 0 && editTextInputK.getText().toString().length() > 0) {
                    ipM = editTextInputM.getText().toString().trim().toUpperCase();
                    ipK = editTextInputK.getText().toString().trim().toUpperCase();
                    editTextInputK.setText(ipK);
                    editTextInputM.setText(ipM);
                    switch (valueList) {
                        case 0: {
                            if (switchGiaiMa.isChecked()) {
                                textViewResult1.setText(caesarGM());
                            } else {
                                textViewResult1.setText(caesar());
                            }
                            break;
                        }
                        case 1: {
                            if (switchGiaiMa.isChecked()) {
                                textViewResult1.setText(videnereLKGM());
                            } else {
                                textViewResult1.setText(videnereLK());
                            }
                            break;
                        }
                        case 2: {
                            if (switchGiaiMa.isChecked()) {
                                textViewResult1.setText(videnereAutoKGM());
                            } else {
                                textViewResult1.setText(videnereAutoK());
                            }
                            break;
                        }
                        case 3: {
                            if (switchGiaiMa.isChecked()) {
                                textViewResult1.setText(maHoaChuDonGM());
                            } else {
                                textViewResult1.setText(maHoaChuDon());
                            }
                            break;
                        }
                        case 4: {
                            textViewResult1.setText(Playfair());
                            textViewBaiToan.setText("Mật mã ma trận khóa PLAYFAIR\n" + maTranKhoa);

                            break;
                        }
                        case 5: {
                            textViewResult1.setText(maHoaHoanVi());
                            break;
                        }
                        default:
                            Toast.makeText(MaHoaCoDienActivity.this, "Chưa có!!!" + valueList, Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(MaHoaCoDienActivity.this, "Vui lòng nhập vào dữ liệu tính toán" + valueList, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // Mã hóa
    private String caesar() {
        String value = "";
        int key = Integer.parseInt(ipK);
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) + key;
            if (var > 90) {
                var -= 26;
            }
            value += String.valueOf((char) var);
        }
        return value;
    }

    // Giải mã
    private String caesarGM() {
        String value = "";
        int key = Integer.parseInt(ipK);
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) - key;
            if (var < 65) {
                var += 26;
            }
            value += String.valueOf((char) var);
        }
        return value;
    }

    private String videnereLK() {
        String value = "";
        while (ipK.length() < ipM.length()) {
            ipK += ipK;
        }
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) + (int) ipK.charAt(i) - 65;
            if (var > 90) {
                var -= 26;
            }
            value += String.valueOf((char) var);
        }
        return value;
    }

    private String videnereLKGM() {
        String value = "";
        while (ipK.length() < ipM.length()) {
            ipK += ipK;
        }
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) - (int) ipK.charAt(i) + 65;
            if (var < 65) {
                var += 26;
            }
            value += String.valueOf((char) var);
        }
        return value;
    }

    private String videnereAutoK() {
        String value = "";
        ipK += ipM;
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) + (int) ipK.charAt(i) - 65;
            if (var > 90) {
                var -= 26;
            }
            value += String.valueOf((char) var);
        }
        return value;
    }

    private String videnereAutoKGM() {
        String value = "";
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) - (int) ipK.charAt(i) + 65;
            if (var < 65) {
                var += 26;
            }
            value += String.valueOf((char) var);
            ipK += String.valueOf((char) var);
        }
        return value;
    }

    private String maHoaChuDon() {
        String value = "";
        for (int i = 0; i < ipM.length(); i++) {
            int var = (int) ipM.charAt(i) - 65;
            value += ipK.charAt(var);
        }
        return value;
    }

    private String maHoaChuDonGM() {
        String value = "";
        for (int i = 0; i < ipM.length(); i++) {
            for (int j = 0; j < ipK.length(); j++) {
                if (ipM.charAt(i) == ipK.charAt(j)) {
                    int var = j + 65;
                    value += String.valueOf((char) var);
                }

            }
        }
        return value;
    }

    private String maHoaHoanVi() {
        String value = "";
        int key = Integer.parseInt(ipK);
        for (int i = 0; i < key; i++)
            for (int j = i; j < ipM.length(); j += key) {
                value += ipM.charAt(j);
            }
        return value;
    }

    private String Playfair() {
        String value = "";
        maTranKhoa = "";
        arrayList.removeAll(arrayList);
        // tạo bảng Key

        for (int i = 0; i < ipK.length(); i++) {
            int val = (int) ipK.charAt(i);
            if (val == 74) val = 73;
            if (!arrayList.contains(val)) {
                arrayList.add(val);
            }
        }
        int k = 65;
        while (arrayList.size() < 25) {
            if (!arrayList.contains(k) && k != 74) {
                arrayList.add(k);
            }
            k++;
        }
        // in ma tran Khóa
        for (int i = 0; i < 25; i++) {
            if ((i + 1) % 5 == 0) {
                maTranKhoa += String.valueOf((char) (int) arrayList.get(i)) + "\n";
            } else {
                maTranKhoa += String.valueOf((char) (int) arrayList.get(i)) + " | ";
            }
        }

        // xử lý
        k = 0;
        while (k <= ipM.length() - 1) {
            int a, b, c;
            a = arrayList.indexOf((int) ipM.charAt(k));
            // xử lý ký tự trùng lặp aa->ax a; xx -> xq x
            if ((int) ipM.charAt(k) != 88) {
                c = arrayList.indexOf(88);
            } else {
                c = arrayList.indexOf(81);
            }
            // kiểm soát ký tự cuối
            if (k < ipM.length() - 1) {
                b = arrayList.indexOf((int) ipM.charAt(k + 1));
            } else {
                b = c;
            }
            // convert
            if (a == b) { // 2 ký tự trùng nhau
                k++;
                value += covertCustom(a, c);
            } else { // 2 ký tự khác nhau
                value += covertCustom(a, b);
                k += 2;
            }
        }
        return value;
    }

    private String covertCustom(int a, int b) {
        String str = "";
        int[][] Key = new int[5][5];
        int x1, x2, y1, y2, k = 0;
        int[][] intKey = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Key[i][j] = arrayList.get(k);
                k++;
            }
        }
        x1 = intKey[a][0];
        x2 = intKey[b][0];
        y1 = intKey[a][1];
        y2 = intKey[b][1];

        if (y1 == y2) { // trùng hàng
            if (x1 == 4) x1 = 0;
            else x1++;
            if (x2 == 4) x2 = 0;
            else x2++;
        } else {
            if (x1 == x2) { // trùng cột
                if (y1 == 4) y1 = 0;
                else y1++;
                if (y2 == 4) y2 = 0;
                else y2++;
            } else {
                int tg = y1;
                y1 = y2;
                y2 = tg;
            }
        }

        str += String.valueOf((char) Key[x1][y1]);
        str += String.valueOf((char) Key[x2][y2]);

        return str;
    }

    private String PlayfairGM() {
        String value = "";
        maTranKhoa = "";
        arrayList.removeAll(arrayList);
        // tạo bảng Key

        for (int i = 0; i < ipK.length(); i++) {
            int val = (int) ipK.charAt(i);
            if (val == 74) val = 73;
            if (!arrayList.contains(val)) {
                arrayList.add(val);
            }
        }
        int k = 65;
        while (arrayList.size() < 25) {
            if (!arrayList.contains(k) && k != 74) {
                arrayList.add(k);
            }
            k++;
        }
        // in ma tran Khóa
        for (int i = 0; i < 25; i++) {
            if ((i + 1) % 5 == 0) {
                maTranKhoa += String.valueOf((char) (int) arrayList.get(i)) + "\n";
            } else {
                maTranKhoa += String.valueOf((char) (int) arrayList.get(i)) + " | ";
            }
        }

        // xử lý
        k = 0;
        while (k <= ipM.length() - 1) {
            int a, b, c;
            a = arrayList.indexOf((int) ipM.charAt(k));

            if ((int) ipM.charAt(k) != 88) {
                c = arrayList.indexOf(88);
            } else {
                c = arrayList.indexOf(81);
            }

            if (k < ipM.length() - 1) {
                b = arrayList.indexOf((int) ipM.charAt(k + 1));
            } else {
                b = c;
            }

            if (a == b) {
                k++;
                value += covertCustomGM(a, c);
            } else {
                value += covertCustomGM(a, b);
                k += 2;
            }
        }
        return value;
    }

    private String covertCustomGM(int a, int b) {
        String str = "";
        int[][] Key = new int[5][5];
        int x1, x2, y1, y2, k = 0;
        int[][] intKey = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Key[i][j] = arrayList.get(k);
                k++;
            }
        }
        x1 = intKey[a][0];
        x2 = intKey[b][0];
        y1 = intKey[a][1];
        y2 = intKey[b][1];

        if (y1 == y2) { // trùng hàng
            if (x1 == 0) x1 = 4;
            else x1--;
            if (x2 == 0) x2 = 4;
            else x2--;
        } else {
            if (x1 == x2) { // trùng cột
                if (y1 == 0) y1 = 4;
                else y1--;
                if (y2 == 0) y2 = 4;
                else y2--;
            } else {
                int tg = y1;
                y1 = y2;
                y2 = tg;
            }
        }

        str += String.valueOf((char) Key[x1][y1]);
        str += String.valueOf((char) Key[x2][y2]);

        return str;
    }


}