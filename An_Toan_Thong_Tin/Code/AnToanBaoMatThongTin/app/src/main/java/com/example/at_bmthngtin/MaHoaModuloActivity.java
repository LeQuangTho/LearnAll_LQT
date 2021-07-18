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

public class MaHoaModuloActivity extends AppCompatActivity {

    public EditText editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5;
    public Button buttonSubmit3, buttonClean3;
    public TextView textViewResult3, textViewBaiToan3, textView1, textView2, textView3, textView4, textView5;
    public TinhModulo modulo = new TinhModulo();
    public int val, number1, number2, number3, number4, number5, numberHm;
    public Toast toast;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_hoa_modulo);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        editTextNumber5 = findViewById(R.id.editTextNumber5);
        textViewResult3 = findViewById(R.id.textViewResult3);
        textViewBaiToan3 = findViewById(R.id.textViewBaiToan3);
        buttonSubmit3 = findViewById(R.id.buttonSubmit3);
        buttonClean3 = findViewById(R.id.buttonClean3);
        textView1 = findViewById(R.id.textViewNumber1);
        textView2 = findViewById(R.id.textViewNumber2);
        textView3 = findViewById(R.id.textViewNumber3);
        textView4 = findViewById(R.id.textViewNumber4);
        textView5 = findViewById(R.id.textViewNumber5);
        //
        textViewResult3.setMovementMethod(new ScrollingMovementMethod());

        // Nhận dữ liệu chuyển activity
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MaHoaModulo");
        val = bundle.getInt("key");
        switch (val) {
            case 0: {
                textViewBaiToan3.setText("Trao đổi khóa Diffie-Hellman\nq - là số nguyên tố\na - là Căn nguyên thủy của q\nChọn xA, xB\nyA = a^xA mod q\nyB = a^xB mod q\nKa = yB^xA mod q\nKb = yA^xB mod q");
                editHintText("q = ", "a = ", "xA = ", "xB = ", "Null");
                break;
            }
            case 1: {
                textViewBaiToan3.setText("Thuật toán RSA - Bài toán 1\np,q là 2 số nguyên tố khác nhau\nn = p*q\nChọn e (gcd(e,Φn) = 1; 1 < e < Φn)\nd = e^(-1) mod Φn\nPU = { e, n }\nPR = { d, n }\n Bản gốc: M < n\nDùng khóa Riêng để mã hóa(PR)  \nC = M^d mod n\nDùng khóa Chung để giải mã(PU)\nM = C^e mod n");
                editHintText("p = ", "q = ", "e = ", "M = ", "Null");

                break;
            }
            case 2: {
                textViewBaiToan3.setText("Thuật toán RSA - Bài toán 2\np,q là 2 số nguyên tố khác nhau\nn = p*q\nChọn e (gcd(e,Φn) = 1; 1 < e < Φn)\nd = e^(-1) mod Φn\nPU = { e, n }\nPR = { d, n }\n Bản gốc: M < n\nDùng khóa Chung để mã hóa(PU)\nC = M^e mod n\nDùng khóa Riêng để giải mã(PR)  \nM = C^d mod n");
                editHintText("p = ", "q = ", "e = ", "M = ", "Null");
                break;
            }
            case 3: {
                textViewBaiToan3.setText("Mật mã ElGamal\nq - là số nguyên tố\na - là Căn nguyên thủy của q\nChọn xA < q-1\nyA = a^xA mod q\nPU = { q, a, yA}\n Bản gốc: M < q\n Mã hóa:\n Chọn k < q\n K = yA^k mod q\nC1 = a^k mod q\nC2 = K*M mod q\nGiải mã:\nK = C1^xA mod q\n M = (C2*K^(-1)) mod q");
                editHintText("q = ", "a = ", "xA = ", "k = ", "M = ");
                break;
            }
            case 4: {
                textViewBaiToan3.setText("Chữ ký điện tử DSA");
                editHintText("p = ", "q = ", "h-H(M) = ", "xA = ", "k = ");
                break;
            }
            default:
                toast = Toast.makeText(MaHoaModuloActivity.this, "Chưa có!!!", Toast.LENGTH_SHORT);
                toast.show();

        }
        editVisibilityTextView(false);

        // Click Button Clean
        buttonClean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clean();
            }
        });
        // Click Button Ket Qua
        buttonSubmit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    toast = Toast.makeText(MaHoaModuloActivity.this, "Nhập chưa đủ dữ kiện đề bài!!!", Toast.LENGTH_SHORT);
                    String edt1, edt2, edt3, edt4, edt5;
                    edt1 = editTextNumber1.getText().toString();
                    edt2 = editTextNumber2.getText().toString();
                    edt3 = editTextNumber3.getText().toString();
                    edt4 = editTextNumber4.getText().toString();
                    edt5 = editTextNumber5.getText().toString();
                    if (edt1.length() == 0 || edt2.length() == 0 || edt3.length() == 0 || edt4.length() == 0) {
                        toast.show();
                    } else {
                        if (edt5.length() == 0 && (val == 4 || val == 3)) {
                            toast.show();
                        } else {
                            if (edt5.length() != 0 && (val == 4 || val == 3)) {
                                number5 = Integer.parseInt(edt5);
                                if (val == 4) {
                                    number3 = Integer.parseInt(edt3.split("-")[0]);
                                    numberHm = Integer.parseInt(edt3.split("-")[1]);
                                } else {
                                    number3 = Integer.parseInt(edt3);
                                }
                            } else {
                                number3 = Integer.parseInt(edt3);
                            }
                        }
                        editVisibilityTextView(true);
                        number1 = Integer.parseInt(edt1);
                        number2 = Integer.parseInt(edt2);
                        number4 = Integer.parseInt(edt4);
                        switch (val) {
                            case 0: {
                                textViewResult3.setText(Diffie_Hellman(number1, number2, number3, number4));
                                break;
                            }
                            case 1: {
                                textViewResult3.setText(RSA_BT1(number1, number2, number3, number4));
                                break;
                            }
                            case 2: {
                                textViewResult3.setText(RSA_BT2(number1, number2, number3, number4));
                                break;
                            }
                            case 3: {
                                textViewResult3.setText(ElGamal(number1, number2, number3, number4, number5));
                                break;
                            }
                            case 4: {
                                textViewResult3.setText(ChuKyDienTu(number1, number2, number3, number4, number5, numberHm));
                                break;
                            }

                            default:
                                Toast.makeText(MaHoaModuloActivity.this, "Chưa có!!!", Toast.LENGTH_SHORT).show();

                        }
                    }
                } catch (Exception e) {
                    toast = Toast.makeText(MaHoaModuloActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public void Clean() {
        editVisibilityTextView(false);
        editTextNumber1.setText("");
        editTextNumber1.requestFocus();
        editTextNumber2.setText("");
        editTextNumber3.setText("");
        editTextNumber4.setText("");
        editTextNumber5.setText("");
    }

    public void editVisibilityTextView(Boolean isVisibility) {
        if (isVisibility) {
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.VISIBLE);
        } else {
            textView1.setVisibility(View.GONE);
            textView2.setVisibility(View.GONE);
            textView3.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);
        }
        if ((val == 3 || val == 4) && isVisibility) {
            textView5.setVisibility(View.VISIBLE);
        } else {
            textView5.setVisibility(View.GONE);
        }

    }

    public void editHintText(String ed1, String ed2, String ed3, String ed4, String ed5) {
        editTextNumber1.setHint(ed1);
        editTextNumber2.setHint(ed2);
        editTextNumber3.setHint(ed3);
        editTextNumber4.setHint(ed4);
        editTextNumber5.setHint(ed5);
        textView1.setText(ed1);
        textView2.setText(ed2);
        textView3.setText(ed3);
        textView4.setText(ed4);
        textView5.setText(ed5);

        if (ed5.equals("Null")) {
            editTextNumber5.setVisibility(View.GONE);
            textView5.setVisibility(View.GONE);
        } else {
            editTextNumber5.setVisibility(View.VISIBLE);
        }

    }

    public String Diffie_Hellman(int q, int a, int xA, int xB) {
        String result3;
        long yA, yB, Ka, Kb;
        if (xA < q && xB < q && modulo.isPrime(q) && modulo.isCanNguyenThuy(a, q) && a < q) {
            yA = modulo.power(a, xA, q);
            yB = modulo.power(a, xB, q);
            Ka = modulo.power((int) yB, xA, q);
            Kb = modulo.power((int) yA, xB, q);
            result3 = "yA = " + yA + "\nKa = " + Ka + "\nyB = " + yB + "\nKb = " + Kb;
        } else {
            result3 = "Dữ liệu vào không chính xác!";
        }
        return result3;
    }

    // Dùng khóa riêng để mã hóa và khóa chung để giải mã
    private String RSA_BT1(int p, int q, int e, int Ma) {
        String result3;
        int n, nPhi, d;
        long Mb, C;
        if (p != q && modulo.isPrime(q) && modulo.isPrime(p)) {
            n = p * q;
            nPhi = (p - 1) * (q - 1);
            if (1 < e && e < nPhi && modulo.gcd(nPhi, e) == 1) {
                d = modulo.modulo_inverse(e, nPhi);
                C = modulo.power(Ma, d, n); // Dùng khóa riêng để mã hóa
                Mb = modulo.power((int) C, e, n); // Khóa chung để giải mã
                result3 = "PU = {" + e + ", " + n + "}\nPR = {" + d + ", " + n + "}\nC = " + C + "\nM(B) = " + Mb;
            } else {
                result3 = "e Không hợp lệ!!!";
            }
        } else {
            result3 = "Dữ liệu vào không chính xác!";
        }
        return result3;
    }

    // Dùng khóa chung để mã hóa và khóa riêng để giải mã
    private String RSA_BT2(int p, int q, int e, int Ma) {
        String result3;
        int n, nPhi, d;
        long Mb, C;
        if (p != q && modulo.isPrime(q) && modulo.isPrime(p)) {
            n = p * q;
            nPhi = (p - 1) * (q - 1);
            if (1 < e && e < nPhi && modulo.gcd(nPhi, e) == 1) {
                d = modulo.modulo_inverse(e, nPhi);
                C = modulo.power(Ma, e, n); // Dùng khóa chung để mã hóa
                Mb = modulo.power((int) C, d, n); // Khóa riêng để giải mã
                result3 = "PU = {" + e + ", " + n + "}\nPR = {" + d + ", " + n + "}\nC = " + C + "\nM(B) = " + Mb;
            } else {
                result3 = "e Không hợp lệ!!!" + e;
            }
        } else {
            result3 = "Dữ liệu vào không chính xác!";
        }
        return result3;
    }

    private String ElGamal(int q, int a, int xA, int k, int M) {
        String result3;
        long yA, Kb, C1, C2, Ka, Ma;
        if (modulo.isPrime(q) && modulo.isCanNguyenThuy(a, q) && a < q && xA < q - 1 && M < q && k < q) {
            yA = modulo.power(a, xA, q);
            Kb = modulo.power((int) yA, k, q);
            C1 = modulo.power(a, k, q);
            C2 = modulo.power((int) Kb * M, 1, q);
            Ka = modulo.power((int) C1, xA, q);
            int var = modulo.modulo_inverse((int) Ka, q);
            Ma = modulo.power((int) C2 * var, 1, q);
            result3 = "PU = {q, a, YA}\nyA = " + yA + "}\nC1 = " + C1 + "\nC2 = " + C2 + "\nKb = " + Kb + "\nKa = " + Ka + "\nMa = " + Ma;
        } else {
            result3 = "Dữ liệu vào không chính xác!";
        }
        return result3;
    }

    private String ChuKyDienTu(int p, int q, int h, int xA, int k, int hm) {
        long g, yA, r, s, var1, u1, u2, v, var3, var4;
        int HHH = hm;
        int var2, w;
        if (xA < q && xA > 0 && h > 1 && h < p - 1 && modulo.power(h, (int) ((p - 1) / q), q) > 1 && modulo.isPrime(p) && modulo.isPrime(q) && (p - 1) % q == 0) {
            g = modulo.power(h, (p - 1) / q, p);
            yA = modulo.power((int) g, xA, p);
            var1 = modulo.power((int) g, k, p);
            r = modulo.power((int) var1, 1, q);
            var2 = modulo.modulo_inverse(k, q);
            s = modulo.power((int) (var2 * (HHH + xA * r)), 1, q); // Chú ý HHH
            w = modulo.modulo_inverse((int) s, q);
            u1 = modulo.power((int) (HHH * w), 1, q); // Chú ý HHH
            u2 = modulo.power((int) (r * w), 1, q);
            var3 = modulo.power((int) g, (int) u1, p);
            var4 = modulo.power((int) yA, (int) u2, p);

            v = modulo.power((int) (var3 * var4), 1, q);
            return "v =  " + v + "\nr = " + r + "\ns = " + s + "\nyA = " + yA + "\nu1 = " + u1 + "\nu2 = " + u2 + "\nw = " + w + "\ng = " + g +"g^k mod p " + var1 + "k^-1 mod q " + var2 + " " + var3 + " " + var4;
        } else {
            return "Dữ liệu vào không chính xác!";
        }
    }


}