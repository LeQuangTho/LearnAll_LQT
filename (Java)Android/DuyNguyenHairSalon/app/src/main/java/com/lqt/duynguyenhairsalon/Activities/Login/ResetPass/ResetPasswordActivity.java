package com.lqt.duynguyenhairsalon.Activities.Login.ResetPass;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Activities.Home.MainActivity;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import java.util.HashMap;
import java.util.Map;

public class ResetPasswordActivity extends AppCompatActivity {

    //Vỉew
    private ImageView imageViewBack;
    private EditText editTextPhone, editTextPassword, editTextConfirmPassword;
    private Button buttonConfirmPassword;

    //Param
    private static final String TAG = ResetPasswordActivity.class.getName();
    private String url = Config.LOCALHOST + "UpdatePassAccount.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        initView();

        SetDataPhone();

        SetListenerActivity();
    }

    private void SetDataPhone() {
        String phoneNumber = getIntent().getStringExtra("PhoneNumber");

        editTextPhone.setText(phoneNumber);
    }

    private void SetListenerActivity() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonConfirmPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoneLogin();
            }
        });

        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextPassword.getText().toString().length() < 6) {
                    editTextPassword.setError("Nhập đủ 6 số");
                } else {
                    editTextPassword.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())) {
                    editTextConfirmPassword.setError("Mã PIN không khớp!");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextConfirmPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER
                        && event.getAction() == KeyEvent.ACTION_DOWN
                        && editTextConfirmPassword
                        .getText()
                        .toString()
                        .equals(editTextPassword.getText().toString())) {
                    DoneLogin();
                    return true;

                }

                return false;
            }
        });
    }

    private void DoneLogin() {
        if (editTextConfirmPassword.getText().toString().equals(editTextPassword.getText().toString())) {
            SiginToServer();
        }
    }

    private void SiginToServer() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("successful")) {
                    DataLocalManager.setPrefIsLogged(true);
                    DataLocalManager.setPrefUserName("" + editTextPhone.getText());
                    if (editTextPhone.getText().toString().equals("+84973271208")) {
                        DataLocalManager.setPrefIsAdmin(true);
                    }
                    Toast.makeText(ResetPasswordActivity.this, "Đổi mã PIN thành công!", Toast.LENGTH_SHORT).show();

                    finish();
                    startActivity(new Intent(ResetPasswordActivity.this, MainActivity.class));
                    finishAffinity();
                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Lỗi! Vui lòng thử lại sau.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("UserName", getIntent().getStringExtra("PhoneNumber"));
                param.put("Password", editTextPassword.getText().toString());

                return param;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageView_Back);
        editTextPhone = findViewById(R.id.editText_Phone);
        editTextPassword = findViewById(R.id.editText_Password);
        editTextConfirmPassword = findViewById(R.id.editText_ConfirmPassword);
        buttonConfirmPassword = findViewById(R.id.button_ConfirmPassword);

        editTextPassword.setHint("Nhập mã PIN mới...");
        editTextConfirmPassword.setHint("Nhập lại mã PIN mới...");
    }
}
