package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModuloActivity extends AppCompatActivity {
    EditText editTextA, editTextM, editTextN;
    TextView textViewBaiToan, textViewResult;
    Button buttonKQ, buttonCls;
    String result = "", et1 = "a =", et2 = "m =", et3 = "n =";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo);
        // Anh xa
        buttonKQ = (Button) findViewById(R.id.buttonSubmit);
        buttonCls = (Button) findViewById(R.id.buttonClear);
        editTextA = (EditText) findViewById(R.id.editTextA);
        editTextM = (EditText) findViewById(R.id.editTextM);
        editTextN = (EditText) findViewById(R.id.editTextN);
        textViewBaiToan = (TextView) findViewById(R.id.textViewBaiToan);
        textViewResult = (TextView) findViewById(R.id.textViewResult);

        // Nhận dữ liệu chuyển activity
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Modulo");
        int val = bundle.getInt("key");
        switch (val) {
            case 0: {
                textViewBaiToan.setText("Tính b = a^m mod n");
                break;
            }
            case 1: {
                textViewBaiToan.setText("Tính x = a^(-1) mod n");
                editTextM.setEnabled(false);
                et2 = "Null";
                break;
            }
            case 2: {
                textViewBaiToan.setText("Tính Hàm Euler");
                editTextM.setEnabled(false);
                editTextA.setEnabled(false);
                et1 = "Null";
                et2 = "Null";
                break;
            }
            case 3: {
                textViewBaiToan.setText("Số dư Trung Hoa\nVD: a1 = 1, a2 = 2, a3 = 3 \n=> input: 1-2-3");
                et1 = "Số PT(x mod m = a) =";
                et2 = "m1-m2-...-mi";
                et3 = "a1-a2-...-mi";
                break;
            }
            case 4: {
                textViewBaiToan.setText("Kiểm tra căn nguyên thủy");
                editTextM.setEnabled(false);
                et2 = "Null";
                break;
            }
            case 5: {
                textViewBaiToan.setText("Logarithm rời rạc: b = a^m mod n");
                et2 = "b =";
                break;
            }

        }
        // set textHint
        editTextA.setHint(et1);
        editTextM.setHint(et2);
        editTextN.setHint(et3);
        // sự kiện click buttonKQ
        buttonKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int aVal = 1, mVal = 1, nVal = 1;
                    int[] Ai = new int[10], Mi = new int[10];
                    aVal = input(editTextA);
                    if (val != 3) {
                        mVal = input(editTextM);
                        nVal = input(editTextN);
                    } else {
                        if (editTextM.getText().toString().trim().length() > 0 && editTextN.getText().toString().trim().length() > 0) {
                            String[] strM = editTextM.getText().toString().trim().split("-");
                            String[] strA = editTextN.getText().toString().trim().split("-");
                            for (int i = 0; i < aVal; i++) {
                                Ai[i] = Integer.parseInt(strA[i]);
                                Mi[i] = Integer.parseInt(strM[i]);
                            }
                        } else {
                            Toast.makeText(ModuloActivity.this, "Không đủ dữ liệu tính toán", Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                    switch (val) {
                        case 0: {
                            result = "Đáp số:" + moduloHaBacLuyThua(aVal, mVal, nVal);
                            break;
                        }
                        case 1: {
                            if (modulo_inverse(aVal, nVal) != -1) {
                                result = "Đáp số: " + modulo_inverse(aVal, nVal);
                            } else {
                                result = "Không có số nghịch đảo!!!";
                            }
                            break;
                        }
                        case 2: {
                            result = "Đáp số: " + phi(nVal);
                            break;
                        }
                        case 3: {
                            result = "Đáp số: " + soDuTrungHoa(Ai, Mi, aVal);
                            break;
                        }
                        case 4: {
                            result = "Đáp số: " + laCanNguyenThuy(aVal, nVal);
                            break;
                        }
                        case 5: {
                            result = "Đáp số: " + logarithmRoiRac(aVal, mVal, nVal);
                            break;
                        }
                        default: {
                            result = "App chưa được viết";
                            break;
                        }

                    }
                    textViewResult.setText(result);
                } catch (Exception e) {
                    Toast.makeText(ModuloActivity.this, "Dữ liệu tính toán không hợp lệ!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // sự kiện click buttonCls
        buttonCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextA.setText("");
                editTextM.setText("");
                editTextN.setText("");
                textViewResult.setText("");
                editTextA.requestFocus();
            }
        });
        // sự kiện thanh cuộn textView
        textViewResult.setMovementMethod(new ScrollingMovementMethod());

    }

    private long moduloHaBacLuyThua(int a, int m, int n) {
        boolean[] isDu = new boolean[100];
        int k = 1;
        while (m > 3) {
            if (m % 2 == 0) {
                m /= 2;
                isDu[k] = false;
            } else {
                m = (m - 1) / 2;
                isDu[k] = true;
            }
            k++;
        }
        long var = ((long) Math.pow(a, m)) % n;
        for (int i = k - 1; i > 0; i--) {
            if (isDu[i]) {
                var = (var * var * a) % n;
            } else {
                var = (var * var) % n;
            }
        }
        return var;

    }

    //
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Hàm Euler
    static int phi(int n) {
        int result = 1;
        for (int i = 2; i < n; i++)
            if (gcd(i, n) == 1)
                result++;
        return result;
    }

    // tính nghịch đảo modulo
    private int modulo_inverse(int a, int n) {
        for (int i = 1; i < n; i++) {
            if (((long) a * i) % n == 1) {
                return i;
            }
        }
        return -1; // not exist
    }

    // Kiểm tra căn nguyên thủy
    private boolean laCanNguyenThuy(int a, int n) {
        int phiN = phi(n);
        if (1 == moduloHaBacLuyThua(a, phiN, n)) {
            for (int i = 1; i < phiN; i++) {
                if (phiN % i == 0) {
                    if (1 == moduloHaBacLuyThua(a, i, n)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    // convert input
    private int input(EditText editText) {
        if (editText.getText().toString().trim().length() > 0) {
            return Integer.parseInt(editText.getText().toString().trim());
        }
        return -1;
    }

    // logarithm rời rạc
    private int logarithmRoiRac(int a, int b, int n) {
        for (int i = 1; i < n; i++) {
            if (b == moduloHaBacLuyThua(a, i, n)) {
                return i;
            }
        }
        return 0;
    }

    // so du Trung Hoa
    private int soDuTrungHoa(int[] a, int[] m, int n) {
        int M = 1;
        for (int i = 0; i < n; i++) {
            M *= m[i];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * (M / m[i]) * modulo_inverse(M / m[i], m[i]);
        }
        return (int) sum % M;
    }

}