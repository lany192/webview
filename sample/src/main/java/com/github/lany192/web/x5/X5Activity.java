package com.github.lany192.web.x5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lany192.web.R;
import com.github.lany192.x5web.X5WebView;

public class X5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5);
        X5WebView webView = (X5WebView) findViewById(R.id.web_view);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);
    }
}