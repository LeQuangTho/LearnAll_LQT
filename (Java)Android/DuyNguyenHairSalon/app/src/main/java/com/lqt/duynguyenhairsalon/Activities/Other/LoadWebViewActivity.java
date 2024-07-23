package com.lqt.duynguyenhairsalon.Activities.Other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.lqt.duynguyenhairsalon.R;

public class LoadWebViewActivity extends AppCompatActivity {

    private WebView webView;

    private ImageView imageView;

    private String link = "https://youtu.be/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_web_view);

        initView();

        init();

        Listen();

    }

    private void Listen() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        Intent intent = getIntent();
        link = intent.getStringExtra("LINK");

        //để web được load trong app không bị bay ra ngoài
        webView.setWebViewClient(new WebViewClient());

        //load nó lên
        webView.loadUrl(link);

        //truyền vào setting của trang web
        WebSettings webSettings = webView.getSettings();

        //cho phép zoom trang web
        webSettings.setBuiltInZoomControls(true);

        //với một số trang web có thanh zoom control nên ta ẩn nó đi
        webSettings.setDisplayZoomControls(false);

        //cho phép nhận các sự kiện
        webSettings.setJavaScriptEnabled(true);

        //bật API lưu trữ DOM có được
        webSettings.setDomStorageEnabled(true);
    }

    private void initView() {
        webView = findViewById(R.id.webView);
        imageView = findViewById(R.id.imageViewBack);
    }
}