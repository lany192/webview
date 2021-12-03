package com.github.lany192.web;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.github.lany192.web.webkit.Web1Activity;
import com.github.lany192.web.webkit.Web2Activity;
import com.github.lany192.web.x5.X5Activity;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.url_input);
        mEditText.setText("https://www.qq.com/");
        findViewById(R.id.button1).setOnClickListener(v -> {
            String url = mEditText.getText().toString().trim();
            Intent intent = new Intent(this, Web1Activity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        });
        findViewById(R.id.button2).setOnClickListener(v -> {
            String url = mEditText.getText().toString().trim();
            Intent intent = new Intent(this, Web2Activity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        });
        findViewById(R.id.button3).setOnClickListener(v -> {
            String url = mEditText.getText().toString().trim();
            Intent intent = new Intent(this, X5Activity.class);
            intent.putExtra("url", url);
            startActivity(intent);
        });
    }
}
