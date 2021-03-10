package br.dev.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.web_view);


        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);

        // Check options WebSetting as needed
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");
        webView.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //TODO: Initialization of the page if any code is needed
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //TODO: Page loaded if some code is needed
                super.onPageFinished(view, url);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                //TODO: Error handling, such as: no connection for example
                /**
                 *Generic error
                 *public static final int ERROR_UNKNOWN = -1;
                 *Server or proxy hostname lookup failed
                 *public static final int ERROR_HOST_LOOKUP = -2;
                 *Unsupported authentication scheme (not basic or digest)
                 *public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
                 *User authentication failed on server
                 *public static final int ERROR_AUTHENTICATION = -4;
                 *User authentication failed on proxy
                 *public static final int ERROR_PROXY_AUTHENTICATION = -5;
                 *Failed to connect to the server
                 *public static final int ERROR_CONNECT = -6;
                 *Failed to read or write to the server
                 *public static final int ERROR_IO = -7;
                 *Connection timed out
                 *public static final int ERROR_TIMEOUT = -8;
                 *Too many redirects
                 *public static final int ERROR_REDIRECT_LOOP = -9;
                 *Unsupported URI scheme
                 *public static final int ERROR_UNSUPPORTED_SCHEME = -10;
                 *Failed to perform SSL handshake
                 *public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
                 *Malformed URL
                 *public static final int ERROR_BAD_URL = -12;
                 *Generic file error
                 *public static final int ERROR_FILE = -13;
                 *File not found
                 *public static final int ERROR_FILE_NOT_FOUND = -14;
                 *Too many requests during this load
                 *public static final int ERROR_TOO_MANY_REQUESTS = -15;
                 *Resource load was canceled by Safe Browsing
                 *public static final int ERROR_UNSAFE_RESOURCE = -16;
                 */
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                //TODO: Error handling, such as: statusCode for example @param statusCode the status code needs
                // to be in the ranges [100, 299], [400, 599].
                super.onReceivedHttpError(view, request, errorResponse);
            }

        });
    }


    @Override
    public void onBackPressed() {

        //Control go back to your WebView
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    //In case it is necessary to check if there is an internet connection
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}