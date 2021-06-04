package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class introductoryActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=4000;


    ImageView logo,background;
   // LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        logo=findViewById(R.id.logo);
        background=findViewById(R.id.background);
       // lottie=findViewById(R.id.lottie);

        background.animate().translationY(-1800).setDuration(2000).setStartDelay(2000);
        logo.animate().translationY(2500).setDuration(2000).setStartDelay(3000);
        //lottie.animate().translationY(1400).setDuration(2000).setStartDelay(8000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(introductoryActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}