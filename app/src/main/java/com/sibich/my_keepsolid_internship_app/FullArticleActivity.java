package com.sibich.my_keepsolid_internship_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FullArticleActivity extends AppCompatActivity {

    private static final String EXTRA_URL = "full_article_url";

    private String url;
    private WebView webView;

    public static Intent newIntent(Context packageContext, String url) {
        Intent i = new Intent(packageContext, FullArticleActivity.class);
        i.putExtra(EXTRA_URL, url);
        return i;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_article);

        url = getIntent().getStringExtra(EXTRA_URL);

        webView = (WebView) findViewById(R.id.wv_full_article_web_page);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}
