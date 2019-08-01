package com.huske.sharedexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {
private WebView webView;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.webbase);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://console.firebase.google.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {


        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else if (webView.canGoBack()){
            webView.goBack();
            back_pressed = System.currentTimeMillis();
        }



        /*if(webView.canGoBack()){
            webView.goBack();
        } else {
            super.onBackPressed();
        */}
    }

