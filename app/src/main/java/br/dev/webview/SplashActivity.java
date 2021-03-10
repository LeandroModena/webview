package br.dev.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.imageView);

        // Set your imageViem for a SplashActivity here our in xml file

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }, 2000);
    }
}
