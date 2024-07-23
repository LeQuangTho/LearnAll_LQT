package com.lqt.duynguyenhairsalon.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lqt.duynguyenhairsalon.Activities.Login.CustomerDetailActivity;
import com.lqt.duynguyenhairsalon.R;

public class HistoryCutActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private TextView textViewShowDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_cut);

        initView();

        ListenActivity();
    }

    private void ListenActivity() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryCutActivity.this, CustomerDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        textViewShowDetail = findViewById(R.id.textView_ShowDetail);
    }
}