package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModuloActivity extends AppCompatActivity {
    private EditText editTextA, editTextM, editTextN;
    private TextView textViewBaiToan, textViewResult;
    private Button buttonKQ, buttonCls;
    private String result = "", et1 = "a =", et2 = "m =", et3 = "n =";
    public TinhModulo modulo = new TinhModulo();
    public Toast toast;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo);
        // Anh xa
        buttonKQ = (Button) findViewById(R.id.buttonSubmit2);
        buttonCls = (Button) findViewById(R.id.buttonClear);
        editTextA = (EditText) findViewById(R.id.editTextA);
        editTextM = (EditText) findViewById(R.id.editTextM);
        editTextN = (EditText) findViewById(R.id.editTextN);
        textViewBaiToan = (TextView) findViewById(R.id.textViewBaiToan2);
        textViewResult = (TextView) findViewById(R.id.textViewResult2);

        toast = Toast.makeText(ModuloActivity.this, "Không đủ dữ liệu tính toán", Toast.LENGTH_SHORT);

        // Nhận dữ liệu chuyển activity
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Modulo");
        int val = bundle.getInt("key");
        switch (val) {
            case 0: {
                textViewBaiToan.setText("Tính lũy thừa modulo  b = a^m mod n");
                break;
            }
            case 1: {
                textViewBaiToan.setText("Tính x = a^(-1) mod n");
                editTextM.setEnabled(false);
                et2 = "";
                break;
            }
            case 2: {
                textViewBaiToan.setText("Tính Hàm Euler(Φ)");
                editTextM.setEnabled(false);
                editTextA.setEnabled(false);
                et1 = "";
                et2 = "";
                break;
            }
            case 3: {
                textViewBaiToan.setText("Số dư Trung Hoa\nVD:\na1 = 1, m1 = 3\na2 = 4, m2 = 1\na3 = 2, m3 = 9\ninput a  : 1-4-2\ninput m: 3-1-9");
                et1 = "Số phương trình";
                et2 = "M";
                et3 = "A";
                break;
            }
            case 4: {
                textViewBaiToan.setText("Kiểm tra căn nguyên thủy");
                editTextM.setEnabled(false);
                et2 = "";
                break;
            }
            case 5: {
                textViewBaiToan.setText("Logarithm rời rạc");
                et2 = "b =";
                break;
            }
            case 6: {
                textViewBaiToan.setText("A1 =(a^x + b^y)mod n\nA2 =(a^x - b^y)mod n\nA3 =(a^x * b^y)mod n\nA4 =(b^y)^(-1)mod n\nA5 =(a^x / b^y)mod n");
                et1 = "a-b";
                et2 = "x-y";
                break;
            }
            default:
                Toast.makeText(ModuloActivity.this, "Chưa có!!!", Toast.LENGTH_SHORT).show();

        }

        // set textHint
        editTextA.setHint(et1);
        editTextM.setHint(et2);
        editTextN.setHint(et3);

        // sự kiện click buttonKQ
        buttonKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
                    int aVal = 1, mVal = 1, nVal = 1;
                    int[] Ai = new int[10], Mi = new int[10];
                    String edtA = editTextA.getText().toString().trim();
                    String edtM = editTextM.getText().toString().trim();
                    String edtN = editTextN.getText().toString().trim();
                    if ((edtA.length() == 0 && val != 2) || (edtM.length() == 0 && val != 1 && val != 2 && val != 4) || edtN.length() == 0) {
                        toast.show();
                        return;
                    }
                    if (val != 3 && val != 6) {
                        mVal = input(edtM);
                        nVal = input(edtN);
                        aVal = input(edtA);
                    } else {
                        if (val == 3) {
                            aVal = input(edtA);
                            String[] strM = edtM.split("-");
                            String[] strA = edtN.split("-");
                            for (int i = 0; i < aVal; i++) {
                                Ai[i] = Integer.parseInt(strA[i]);
                                Mi[i] = Integer.parseInt(strM[i]);
                            }
                        } else {
                            nVal = input(edtN);
                            String[] strM = edtM.split("-");
                            String[] strA = edtA.split("-");
                            for (int i = 0; i < 2; i++) {
                                Ai[i] = Integer.parseInt(strA[i]);
                                Mi[i] = Integer.parseInt(strM[i]);
                            }
                        }
                    }
                    switch (val) {
                        case 0: {
                            result = "Hạ bậc: " + modulo.power(aVal, mVal, nVal) + "\nFermat: " + modulo.Fermat(aVal, mVal, nVal) + "\nEuler: " + modulo.Euler(aVal, mVal, nVal)+ "\nSoDuTH: " + modulo.soDuTrungHoa2(aVal, mVal, nVal);
                            break;
                        }
                        case 1: {
                            if (modulo.modulo_inverse(aVal, nVal) != -1) {
                                result = "Đáp số: " + modulo.modulo_inverse(aVal, nVal);
                            } else {
                                result = "Không có số nghịch đảo!!!";
                            }
                            break;
                        }
                        case 2: {
                            result = "Φ(" + nVal + ") = " + modulo.phi(nVal);
                            break;
                        }
                        case 3: {
                            result = "x = : " + modulo.soDuTrungHoa(Ai, Mi, aVal);
                            break;
                        }
                        case 4: {
                            result = aVal + " " + modulo.isCanNguyenThuy(aVal, nVal) + " Căn nguyên thủy";
                            break;
                        }
                        case 5: {
                            result = "logarithm rời rạc = " + modulo.logarithmRoiRac(aVal, mVal, nVal);
                            break;
                        }
                        case 6: {
                            result = modulo.Modulo(Ai[0], Ai[1], Mi[0], Mi[1], nVal);
                            break;
                        }
                        default: {
                            result = "App chưa được viết";
                            break;
                        }

                    }
                    textViewResult.setText(result);
//                } catch (Exception e) {
//                    Toast.makeText(ModuloActivity.this, "Dữ liệu tính toán không hợp lệ!", Toast.LENGTH_SHORT).show();
//                }

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

    // ktra input
    private int input(String var) {
        if (var.length() > 0) {
            return Integer.parseInt(var);
        }
        return -1;
    }
/*
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

 */

}