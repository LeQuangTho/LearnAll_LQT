package com.lqt.duynguyenhairsalon.Activities.Login;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;
import com.lqt.duynguyenhairsalon.Model.Config;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONArray;

import java.util.concurrent.TimeUnit;

public class EnterPhoneNumberLoginActivity extends AppCompatActivity {
    /*
     * Country Code Phone sẽ có các bản cập nhật. chú í cập nhật giả sử như việc format
     * số diện thoại khi Việt Nam đổi dầu số 03 và 08.
     * */
    //View
    private CountryCodePicker countryCodePicker;
    private ImageView imageViewCheck;
    private EditText editTextPhone;
    private Button buttonNext;
    private ImageView imageViewBack;

    //Param
    private static final String TAG = EnterPhoneNumberLoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_number_login);

        initView();

        SetCountryCodePicker();

        SetListenerActivity();
    }

    private void SetListenerActivity() {
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SetNext();
            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void SetNext() {
        String url = Config.LOCALHOST + "GetCheckUser.php?UserName=" + countryCodePicker.getFullNumber();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() == 0) {
                    GoToEnterOTP();
                } else {
                    try {
                        String pass = response.getJSONObject(0).getString("Password");
                        GoToLogin(pass);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });

        requestQueue.add(request);
    }

    private void GoToLogin(String pass) {
        Intent intent = new Intent(EnterPhoneNumberLoginActivity.this, LoginWithPhoneNumberActivity.class);
        intent.putExtra("PhoneNumber", countryCodePicker.getFullNumberWithPlus());
        intent.putExtra("Password", pass);
        startActivity(intent);
    }

    private void GoToEnterOTP() {
        PhoneAuthProvider.getInstance()
                .verifyPhoneNumber(countryCodePicker.getFullNumberWithPlus()
                        , 60
                        , TimeUnit.SECONDS
                        , EnterPhoneNumberLoginActivity.this
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
                                Intent intent = new Intent(EnterPhoneNumberLoginActivity.this, EnterOTPActivity.class);
                                intent.putExtra("PhoneNumber", countryCodePicker.getFullNumberWithPlus());
                                intent.putExtra("VerificationId", verificationId);
                                startActivity(intent);
                            }
                        });
    }

    private void SetCountryCodePicker() {
        //Nối CountCode với EditText để nó check
        countryCodePicker.registerCarrierNumberEditText(editTextPhone);

        countryCodePicker.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if (isValidNumber == false) {
                    imageViewCheck.setImageResource(R.drawable.ic_remove);
                    buttonNext.setEnabled(false);
                    buttonNext.setBackgroundResource(R.drawable.background_view_disible);
                } else {
                    imageViewCheck.setImageResource(R.drawable.check);
                    buttonNext.setEnabled(true);
                    buttonNext.setBackgroundResource(R.drawable.background_topup);
                }
            }
        });

        editTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count != 0) imageViewCheck.setVisibility(View.VISIBLE);
                else imageViewCheck.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editTextPhone.setImeActionLabel("Xong", KeyEvent.KEYCODE_ENTER);

        editTextPhone.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (buttonNext.isEnabled()) {
                        SetNext();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void initView() {
        countryCodePicker = findViewById(R.id.countryCodePicker);
        imageViewCheck = findViewById(R.id.imageView_Check);
        editTextPhone = findViewById(R.id.editText_Phone);
        buttonNext = findViewById(R.id.button_Next);
        imageViewBack = findViewById(R.id.imageView_Back);

        editTextPhone.requestFocus();
    }
}