package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.chloe.Config;
import com.example.chloe.R;

public class DetailPilihan extends AppCompatActivity {
    public  static  final String EXTRA_LINK = "ekstra_link";
    public  static  final String EXTRA_PILIHAN = "ekstra_pilihan";
    public TextView tvDetail,tvPataniTim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pilihan);
        getSupportActionBar().hide();
        tvDetail = findViewById(R.id.detail);
        tvPataniTim = findViewById(R.id.patani_tim);

        if(getIntent().getStringExtra(EXTRA_PILIHAN).equalsIgnoreCase("rekomendasi")){
            tvPataniTim.setVisibility(View.GONE);
        }
        tvDetail.setText(getIntent().getStringExtra(EXTRA_PILIHAN));
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(Config.WEB_URL+getIntent().getStringExtra(EXTRA_LINK));
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if( URLUtil.isNetworkUrl(url) ) {
                    return false;
                }
                if (appInstalledOrNot(url)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity( intent );
                } else {
                    // do something if app is not installed
                }
                return true;
            }

        });
    }
    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }

}
