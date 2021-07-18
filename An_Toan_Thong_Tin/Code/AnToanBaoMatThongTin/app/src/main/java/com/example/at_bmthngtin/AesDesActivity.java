package com.example.at_bmthngtin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class AesDesActivity extends AppCompatActivity {
    int valueList;
    public Des des = new Des();
    public Aes aes = new Aes();
    public Switch aSwitchGiaiMa4;
    public TextView textViewResult4;
    public Button buttonSummit4, buttonClean;
    public EditText editTextK, editTextM;
    //    public String M = "950FB522A6E2B1DB";
    public String M = "3243F6A8885A308D313198A2E0370734";
    //    public String key = "3513784465A003DD";
    public String key = "2B7E151628AED2A6ABF7158809CF4F3C";
    public Toast toast;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes_des);
        editTextK = findViewById(R.id.editTextAesDesK);
        editTextM = findViewById(R.id.editTextAesDesM);
        buttonClean = findViewById(R.id.buttonClean4);
        buttonSummit4 = findViewById(R.id.buttonSubmit4);
        textViewResult4 = findViewById(R.id.textViewResult4);
        aSwitchGiaiMa4 = findViewById(R.id.switchGiaiMa4);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("AesDes");
        valueList = bundle.getInt("key");

        buttonSummit4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                M = editTextM.getText().toString().toUpperCase();
                key = editTextK.getText().toString().toUpperCase();
                if (M.length() == 0 && key.length() == 0) {
                    toast = Toast.makeText(AesDesActivity.this, "Dữ liệu đầu vào không chính xác", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                switch (valueList) {
                    // Des ------------------------------------------------------------------------------------------
                    case 0: {
                        String txtResult = "", C, GiaiMa, Ci, Di, M2;

                        // C[i] D[i]
                        Ci = des.permutation(des.PC1, key).substring(0, 7);
                        Di = des.permutation(des.PC1, key).substring(7, 14);
                        txtResult += "C[0] =     " + Ci.toUpperCase() + "\nD[0] =     " + Di.toUpperCase() + "\n";
                        for (int i = 0; i < 16; i++) {
                            Ci = des.leftCircularShift(Ci, des.sBit[i]);
                            Di = des.leftCircularShift(Di, des.sBit[i]);
                            txtResult += "\nC[" + (i + 1) + "] =     " + Ci.toUpperCase() + "\nD[" + (i + 1) + "] =     " + Di.toUpperCase() + "\n";
                        }

                        // K[i]
                        String keys[] = des.getKeys(key);
                        for (int i = 0; i < 16; i++) {
                            txtResult += "\nK[" + i + "] =     " + keys[i].toUpperCase();
                        }

                        // L[i] R[i]
                        M2 = des.permutation(des.IP, M); // thực hiện hoán vị IP  đối với M
                        txtResult += "\n\nL[0] =     " + M2.substring(0, 8).toUpperCase() + "\nR[0] =     " + M2.substring(8, 16).toUpperCase() + "\n";
                        for (int i = 0; i < 16; i++) {
                            M2 = des.round(M2, keys[i], i); // thực hiện 16 vòng lặp tìm L16 và R16
                            txtResult += "\nL[" + (i + 1) + "] =     " + M2.substring(0, 8).toUpperCase() + "\nR[" + (i + 1) + "] =     " + M2.substring(8, 16).toUpperCase() + "\n";
                        }

                        //
                        if (aSwitchGiaiMa4.isChecked()) {
                            GiaiMa = des.decrypt(M, key).toUpperCase();
                            textViewResult4.setText("Giải mã: " + GiaiMa + "\n\nChi tiết:\n" + txtResult);
                        } else {
                            C = des.encrypt(M, key).toUpperCase();
                            textViewResult4.setText("Bản mã C = " + C + "\n\nChi tiết:\n" + txtResult);
                        }
                        break;

                    }

                    // Aes ------------------------------------------------------------------------------------------
                    case 1: {
                        String txtResult = "";
                        String[] w = {key.substring(0, 8), key.substring(8, 16), key.substring(16, 24), key.substring(24, 32)};
                        String[] state = {M.substring(0, 8), M.substring(8, 16), M.substring(16, 24), M.substring(24, 32)};
                        String[] w2 = new String[44];
                        w2[0] = w[0];
                        w2[1] = w[1];
                        w2[2] = w[2];
                        w2[3] = w[3];
                        txtResult += "w0 = " + w2[0] + "\nw1 = " + w2[1] + "\nw2 = " + w2[2] + "\nw3 = " + w2[3] + "\n";

                        for (int i = 4; i < 44; i++) {
                            if (i % 4 == 0)
                                w2[i] = aes.xor(aes.G(w2[i - 1], i / 4), w2[i - 4]);
                            else {
                                w2[i] = aes.xor(w2[i - 1], w2[i - 4]);
                            }
                            txtResult = txtResult + ("w" + i + " = " + w2[i].toUpperCase() + "\n");

                        }
//                        String[] var = aes.AddRoundKey(state, w);
//                        var = aes.SubBytes(var);
//                        var = aes.ShiftRows(var);
//                        var = aes.MixColumns(var);
                        String[] var = aes.MahoaAES(state, w);
                        textViewResult4.setText("Bản mã:\n" + var[0].toUpperCase() + "\n" + var[1].toUpperCase() + "\n" + var[2].toUpperCase() + "\n" + var[3].toUpperCase() + "\n\n" + txtResult);
                        break;
                    }
                }

            }
        });
        textViewResult4.setMovementMethod(new ScrollingMovementMethod());
        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextM.setText("");
                editTextK.setText("");
                editTextK.requestFocus();
            }
        });

    }


}