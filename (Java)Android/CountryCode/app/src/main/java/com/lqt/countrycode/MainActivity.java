package com.lqt.countrycode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    CountryCodePicker countryCodePicker;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodePicker = (CountryCodePicker) findViewById(R.id.countryCodePicker);
        editText = (EditText) findViewById(R.id.editTextPhone);
        imageView = (ImageView) findViewById(R.id.check);

        //Nối CountCode với EditText để nó check
        countryCodePicker.registerCarrierNumberEditText(editText);

        //Bắt đầu check

        countryCodePicker.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if(isValidNumber == false){
                    imageView.setImageResource(R.drawable.remove);
                }else{
                    imageView.setImageResource(R.drawable.check);
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != 0) imageView.setVisibility(View.VISIBLE);
                else imageView.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}