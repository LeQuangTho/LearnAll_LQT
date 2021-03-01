package com.example.appmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView = (TextView) findViewById(R.id.textView);
        Intent myIntent = getIntent();
        try {
//            Bundle myBundle = myIntent.getBundleExtra("hello");
//            String name = myBundle.getString("name");
//            int age = myBundle.getInt("age");
//            textView.setText("Name: " + name + "\nAge: " + age);
//
            Bundle myBundle = myIntent.getBundleExtra("Sum");
            Double stn = myBundle.getDouble("stn");
            Double sth = myBundle.getDouble("sth");
//            textView.setText("Sum: " + (stn + sth));

            ptb2(stn,sth);

        }catch (Exception e){
            Toast.makeText(NextActivity.this, "Error",Toast.LENGTH_SHORT).show();
        }



    }
    public void ptb2(double a, double b){
        if (a == 0 ){
            if (b == 0){
                textView.setText("Vô số nghiệm!");
            }else {
                textView.setText("Vô nghiệm!");
            }
        }else{
            textView.setText("Nghiệm: " + (-b/a));
        }
    }
}