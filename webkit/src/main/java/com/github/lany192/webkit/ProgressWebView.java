package com.github.lany192.webkit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Custom progress webView
 */
public class ProgressWebView extends WebView {
	private ProgressBar mProgressBar;

	public ProgressWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 8);
		mProgressBar.setLayoutParams(layoutParams);
		Drawable drawable = context.getResources().getDrawable(R.drawable.web_progress_bar_states);
		mProgressBar.setProgressDrawable(drawable);
		addView(mProgressBar);
		setWebChromeClient(new WebChromeClient());
		this.setWebViewClient(new WebViewClient() {
			//防止加载网页时调起系统浏览器
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		WebSettings webSetting = this.getSettings();
		webSetting.setJavaScriptEnabled(true);
		webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
		webSetting.setAllowFileAccess(true);
		webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		webSetting.setSupportZoom(true);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setUseWideViewPort(true);
		webSetting.setSupportMultipleWindows(true);
		// webSetting.setLoadWithOverviewMode(true);
		webSetting.setAppCacheEnabled(true);
		// webSetting.setDatabaseEnabled(true);
		webSetting.setDomStorageEnabled(true);
		webSetting.setGeolocationEnabled(true);
		webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
		// webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
		webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
		// webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
		setClickable(true);
	}

	public class WebChromeClient extends android.webkit.WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				mProgressBar.setVisibility(GONE);
			} else {
				if (mProgressBar.getVisibility() == GONE)
					mProgressBar.setVisibility(VISIBLE);
				mProgressBar.setProgress(newProgress);
			}
			super.onProgressChanged(view, newProgress);
		}
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
		lp.x = l;
		lp.y = t;
		mProgressBar.setLayoutParams(lp);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}