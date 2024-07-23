package com.lqt.baitapbuoi1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailContact extends AppCompatActivity {

    TextView nameContact, phoneNumberContact, diaChiContact, congTyContact, emailContact;
    ImageView imgContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        AnhXa();

        Load();
    }

    private void Load() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            nameContact.setText(bundle.getString("Name_Contact",""));
            phoneNumberContact.setText(bundle.getString("Phone_Number_Contact",""));
            diaChiContact.setText(bundle.getString("Dia_Chi",""));
            congTyContact.setText(bundle.getString("Cong_Ty",""));
            emailContact.setText(bundle.getString("Email",""));
            imgContact.setImageResource(bundle.getInt("Image_Contact"));
        }
    }

    private void AnhXa() {
        nameContact = (TextView) findViewById(R.id.name_contact);
        phoneNumberContact = (TextView) findViewById(R.id.phone_number_contact);
        imgContact = (ImageView) findViewById(R.id.img_detail_contact);
        diaChiContact = (TextView) findViewById(R.id.dia_chi_contact);
        congTyContact = (TextView) findViewById(R.id.cong_ty_contact);
        emailContact = (TextView) findViewById(R.id.email_contact);
    }
}