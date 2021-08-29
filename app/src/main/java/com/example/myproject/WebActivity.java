package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.Objects;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_web);


        Intent intent = getIntent();

        if(intent != null){
            String url = intent.getStringExtra("url");
            webView = findViewById(R.id.webView);
            webView.loadUrl(url);
        }
        else Toast.makeText(this, "Try Again!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onBackPressed() {

        if(webView.canGoBack()) webView.goBack();

        else super.onBackPressed();
    }
}