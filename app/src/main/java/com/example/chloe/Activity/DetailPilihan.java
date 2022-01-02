package com.example.chloe.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chloe.Config;
import com.example.chloe.R;
import com.google.android.gms.vision.clearcut.LogUtils;

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
        myWebView.setWebViewClient(new myWebClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl(Config.WEB_URL+getIntent().getStringExtra(EXTRA_LINK));
    }
    public class myWebClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i("E:",url);
            if (url.contains("shopee.co.id")) {
                PackageManager pm = getPackageManager();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if(isPackageInstalled("com.shopee.id",pm)){
                    intent.setPackage("com.shopee.id");
                }else{
                    intent.setPackage("com.android.chrome");
                }
                startActivity(intent);
                return true;
            }
            if (url.contains("www.tokopedia.com")) {
                PackageManager pm = getPackageManager();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                if(isPackageInstalled("com.tokopedia.tkpd",pm)){
                    intent.setPackage("com.tokopedia.tkpd");
                }else{
                    intent.setPackage("com.android.chrome");
                }
                startActivity(intent);
                return true;
            }
            return false;
        }
    }
    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
