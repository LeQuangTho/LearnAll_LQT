package com.lqt.duynguyenhairsalon.Activities.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.lqt.duynguyenhairsalon.R;

import java.util.concurrent.TimeUnit;

public class EnterOTPActivity extends AppCompatActivity {

    //View
    private EditText editTextCode1, editTextCode2, editTextCode3, editTextCode4, editTextCode5, editTextCode6;
    private Button buttonConfirm;
    private ImageView imageViewBack;
    private TextView textViewReSend;

    //Param
    private String phoneNumber;
    private String verificationId;
    private static final String TAG = EnterOTPActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_o_t_p);

        initView();

        SetChangeEditTextCode();

        SetButtonConfirm();

        SetListenerActivity();
    }

    private void SetListenerActivity() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewReSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance()
                        .verifyPhoneNumber(phoneNumber
                                , 60
                                , TimeUnit.SECONDS
                                , EnterOTPActivity.this
                                , new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        Log.e(TAG, e.getMessage());
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String newVerificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        verificationId = newVerificationId;
                                        Toast.makeText(EnterOTPActivity.this, "Gửi mã OTP", Toast.LENGTH_SHORT).show();
                                    }
                                });
            }
        });
    }

    private void SetButtonConfirm() {
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToSetPassword();
            }
        });

    }

    private void SetChangeEditTextCode() {
        editTextCode1.requestFocus();
        editTextCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    editTextCode2.requestFocus();
                    checkCode();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });
        editTextCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    editTextCode3.requestFocus();
                    checkCode();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });

        editTextCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    editTextCode4.requestFocus();
                    checkCode();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });
        editTextCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    editTextCode5.requestFocus();
                    checkCode();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });
        editTextCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    editTextCode6.requestFocus();
                    checkCode();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });
        editTextCode6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                checkCode();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkCode();
            }

            @Override
            public void afterTextChanged(Editable s) {
                checkCode();
            }
        });

        editTextCode6.setImeActionLabel("Xong", KeyEvent.KEYCODE_ENTER);
        editTextCode6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (buttonConfirm.isEnabled()) {
                        GoToSetPassword();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void GoToSetPassword() {
        if (checkCode()) {
            String verifi = editTextCode1.getText().toString().trim()
                    + editTextCode2.getText().toString().trim()
                    + editTextCode3.getText().toString().trim()
                    + editTextCode4.getText().toString().trim()
                    + editTextCode5.getText().toString().trim()
                    + editTextCode6.getText().toString().trim();

            if (verificationId != null) {
                PhoneAuthCredential authCredential = PhoneAuthProvider.getCredential(verificationId, verifi);

                FirebaseAuth.getInstance().signInWithCredential(authCredential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(EnterOTPActivity.this, SetPasswordActivity.class);
                                    intent.putExtra("PhoneNumber", phoneNumber);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(EnterOTPActivity.this, "Mã xác thực không đúng", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }
    }

    private boolean checkCode() {
        if (!editTextCode1.getText().toString().isEmpty() &&
                !editTextCode2.getText().toString().isEmpty() &&
                !editTextCode3.getText().toString().isEmpty() &&
                !editTextCode4.getText().toString().isEmpty() &&
                !editTextCode5.getText().toString().isEmpty() &&
                !editTextCode6.getText().toString().isEmpty()) {
            buttonConfirm.setBackgroundResource(R.drawable.background_topup);
            buttonConfirm.setEnabled(true);
            return true;
        } else {
            buttonConfirm.setBackgroundResource(R.drawable.background_view_disible);
            buttonConfirm.setEnabled(false);
            return false;
        }
    }

    private void initView() {
        phoneNumber = getIntent().getStringExtra("PhoneNumber");
        verificationId = getIntent().getStringExtra("VerificationId");
        editTextCode1 = findViewById(R.id.editText_Code1);
        editTextCode2 = findViewById(R.id.editText_Code2);
        editTextCode3 = findViewById(R.id.editText_Code3);
        editTextCode4 = findViewById(R.id.editText_Code4);
        editTextCode5 = findViewById(R.id.editText_Code5);
        editTextCode6 = findViewById(R.id.editText_Code6);
        buttonConfirm = findViewById(R.id.button_Confirm);
        imageViewBack = findViewById(R.id.imageView_Back);
        textViewReSend = findViewById(R.id.textView_ReSend);

        final int[] i = {60};
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewReSend.setText(getString(R.string.gui_lai) + "(" + (i[0]--) + ")");
            }

            @Override
            public void onFinish() {
                textViewReSend.setText(getString(R.string.gui_lai));
                textViewReSend.setTextColor(Color.WHITE);
                textViewReSend.setEnabled(true);
            }
        }.start();
    }
}