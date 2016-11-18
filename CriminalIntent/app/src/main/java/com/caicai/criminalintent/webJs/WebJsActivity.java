package com.caicai.criminalintent.webJs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.caicai.criminalintent.R;

public class WebJsActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView mWebView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_js);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        mWebView = (WebView) findViewById(R.id.myWebView);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JsInteration(), "control");
        mWebView.setWebChromeClient(new WebChromeClient() {
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                testMethod(mWebView);
            }
        });
        mWebView.loadUrl("file:///android_asset/js_java_interaction.html");
    }

    private void testMethod(WebView webView) {
        String call = "javascript:sayHello()";
        call = "javascript:alertMessage(\"" + "content" + "\")";
        call = "javascript:toastMessage(\"" + "content" + "\")";
        call = "javascript:sumToJava(1,2)";
        webView.loadUrl(call);
    }

    @Override
    public void onClick(View v) {
        mWebView.loadUrl("javascript:alertMessage('hello word')");
    }

    public class JsInteration {
        @JavascriptInterface
        public void toastMessage(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
        }

        @JavascriptInterface
        public void onSumResult(int result) {
            Log.e("caicai", "onSumResult result=" + result);
        }
        @JavascriptInterface
        public void showMessage(final String result) {
            button.post(new Runnable() {
                @Override
                public void run() {
                    button.setText(result);
                }
            });
        }
    }
}
