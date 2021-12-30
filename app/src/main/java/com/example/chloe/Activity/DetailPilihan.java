package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.chloe.Config;
import com.example.chloe.R;

public class DetailPilihan extends AppCompatActivity {
    public  static  final String EXTRA_LINK = "ekstra_link";
    public  static  final String EXTRA_PILIHAN = "ekstra_pilihan";
    public TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pilihan);
        getSupportActionBar().hide();
        tvDetail = findViewById(R.id.detail);

        tvDetail.setText(getIntent().getStringExtra(EXTRA_PILIHAN));
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(Config.WEB_URL+getIntent().getStringExtra(EXTRA_LINK));

    }
}