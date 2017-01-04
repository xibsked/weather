package com.sked.weather.browse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sked.weather.BaseActivity;
import com.sked.weather.R;

import butterknife.BindView;


public class WebViewActivity extends BaseActivity {
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private ActionBar actionBar;
    @BindView(R.id.webView)
    WebView webView;
    private MenuItem goForward;
    private MenuItem goBack;
    private String currentUrl;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        toolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        actionBar.setTitle(title);
        currentUrl = url;
        webView.loadUrl(url);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new QuartzWebViewClient());
        webView.setWebChromeClient(new QuartzWebChromeClient());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web, menu);
        goForward = menu.findItem(R.id.forward);
        goBack = menu.findItem(R.id.back);
        goForward.setEnabled(false);
        goBack.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            webView.loadUrl("about:blank");
            finish();
        } else if (item.getItemId() == R.id.forward)
            webView.goForward();
        else if (item.getItemId() == R.id.back)
            webView.goBack();
        else if (item.getItemId() == R.id.info) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentUrl));
            startActivity(browserIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }

    private class QuartzWebViewClient extends WebViewClient {
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            currentUrl = url;
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            currentUrl = request.getUrl().toString();
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    private class QuartzWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
            if (newProgress == 100) {
                progressBar.setVisibility(View.INVISIBLE);
                goBack.setEnabled(webView.canGoBack());
                goForward.setEnabled(webView.canGoForward());
            } else progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            actionBar.setTitle(title);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

    }
}
