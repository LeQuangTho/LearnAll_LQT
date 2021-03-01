package com.example.appmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Anh xa
        buttonNext = (Button) findViewById(R.id.buttonNext);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NextActivity.class);

                Bundle bundle = new Bundle();
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString().trim());

                bundle.putString("name", name);
                bundle.putInt("age", age);

                intent.putExtra("hello", bundle);

                startActivity(intent);
            }
        });

    }
}