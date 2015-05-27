package com.lany.webviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WebActivity extends Activity {
	protected ProgressWebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);

		mWebView = (ProgressWebView) findViewById(R.id.baseweb_webview);
		mWebView.getSettings().setJavaScriptEnabled(true);

		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		if (url != null) {
			mWebView.loadUrl(url);
		}
	}
}
