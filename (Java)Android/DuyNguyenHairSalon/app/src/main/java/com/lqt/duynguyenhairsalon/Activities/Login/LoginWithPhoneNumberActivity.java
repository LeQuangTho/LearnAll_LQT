package com.lqt.duynguyenhairsalon.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.lqt.duynguyenhairsalon.Activities.Home.MainActivity;
import com.lqt.duynguyenhairsalon.Activities.Login.ResetPass.ResetEnterOTPActivity;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import java.util.concurrent.TimeUnit;

public class LoginWithPhoneNumberActivity extends AppCompatActivity {

    //View
    private EditText editTextPhoneNumber, editTextPassword;
    private TextView textViewForgetPassword;
    private Button buttonLogin;
    private ImageView imageViewBack;

    //Param
    private String phoneNumber = "";
    private String password = "";
    private static final String TAG = LoginWithPhoneNumberActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_phone_number);

        initView();

        SetLogin();

        EventActivity();
    }

    private void EventActivity() {
        textViewForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendOTP();
            }
        });
    }

    private void SendOTP() {
        PhoneAuthProvider.getInstance()
                .verifyPhoneNumber(phoneNumber
                        , 60
                        , TimeUnit.SECONDS
                        , LoginWithPhoneNumberActivity.this
                        , new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Log.e(TAG, e.getMessage());
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                Intent intent = new Intent(LoginWithPhoneNumberActivity.this, ResetEnterOTPActivity.class);
                                intent.putExtra("PhoneNumber", phoneNumber);
                                intent.putExtra("VerificationId", verificationId);
                                startActivity(intent);
                            }
                        });
    }

    private void SetLogin() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.equals(editTextPassword.getText().toString())) {
                    DataLocalManager.setPrefUserName("" + phoneNumber);
                    DataLocalManager.setPrefIsLogged(true);
                    if (phoneNumber.equals("+84973271208")) {
                        DataLocalManager.setPrefIsAdmin(true);
                    }

                    finish();
                    startActivity(new Intent(LoginWithPhoneNumberActivity.this, MainActivity.class));
                    finishAffinity();
                } else {
                    Toast.makeText(LoginWithPhoneNumberActivity.this, "Mã PIN không chính xác", Toast.LENGTH_SHORT).show();
                    editTextPassword.setText("");
                }
            }
        });
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextPassword.getText().toString().length() < 6) {
                    buttonLogin.setEnabled(false);
                    buttonLogin.setBackgroundResource(R.drawable.background_view_disible);
                    editTextPassword.setError("Mã PIN 6 số");
                } else {
                    buttonLogin.setEnabled(true);
                    buttonLogin.setBackgroundResource(R.drawable.background_topup);
                    editTextPassword.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        editTextPhoneNumber = findViewById(R.id.editText_Phone);
        editTextPassword = findViewById(R.id.editText_Password);
        buttonLogin = findViewById(R.id.button_Login);
        textViewForgetPassword = findViewById(R.id.textView_ForgetPassword);
        imageViewBack = findViewById(R.id.imageView_Back);

        phoneNumber = getIntent().getStringExtra("PhoneNumber");
        password = getIntent().getStringExtra("Password");

        editTextPhoneNumber.setText(phoneNumber);
        editTextPassword.requestFocus();
    }
}