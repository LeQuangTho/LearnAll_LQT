package com.lqt.baitapbuoi1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;
import com.lqt.baitapbuoi1.adapter.ContactAdapter;
import com.lqt.baitapbuoi1.model.Contact;
import com.lqt.baitapbuoi1.model.detailContact;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CustomListView extends AppCompatActivity {

    ListView listView;
    Button addContact;
    Random random = new Random();
    EditText filter;
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        AnhXa();

        int[] listImage = new int[]{R.drawable.contact1,
                R.drawable.contact2,
                R.drawable.contact3};

        LoadTheFirst(contactArrayList, listImage);

    }

    private void LoadTheFirst(ArrayList<Contact> contactArrayList, int[] listImage) {
        contactArrayList.add(new Contact(listImage[random.nextInt(listImage.length)], "Người Yêu ", "0966846355", new detailContact("Hưng Yên", "lequangtho@gamil.com", "Thor")));

        for (int i = 1; i < 20; i++) {
            contactArrayList.add(new Contact(listImage[random.nextInt(listImage.length)], "Người Yêu " + i, "09" + (random.nextInt((99999999-10000000))+10000000), new detailContact("Hưng Yên", "lequangtho@gamil.com", "Thor")));
        } 

        contactAdapter = new ContactAdapter(this, R.layout.row_list_contact, contactArrayList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contactArrayList.get(position);

                Intent intent = new Intent(CustomListView.this, DetailContact.class);
                Bundle bundle = new Bundle();
                detailContact detailContact = contact.getDetail();

                bundle.putInt("Image_Contact", contact.getImage());
                bundle.putString("Name_Contact", contact.getName());
                bundle.putString("Phone_Number_Contact", contact.getNumPhone());
                bundle.putString("Dia_Chi", detailContact.getDiachi());
                bundle.putString("Cong_Ty", detailContact.getCongty());
                bundle.putString("Email", detailContact.getEmail());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Contact contact = contactArrayList.get(position);
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getNumPhone())));

                return false;
            }
        });
        listView.setAdapter(contactAdapter);

        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CustomListView.this.contactAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.lv_contact);
        addContact = (Button) findViewById(R.id.add_contact);
        filter = (EditText) findViewById(R.id.filter);
    }
}