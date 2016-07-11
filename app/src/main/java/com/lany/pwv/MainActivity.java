package com.lany.pwv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.url_input);
        mEditText.setText("http://www.baidu.com");
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = mEditText.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, Web1Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = mEditText.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, Web2Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
