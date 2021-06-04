package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CAKES(View view) {
        Intent intent = new Intent(MainActivity.this, LoadingScreen.class);
        startActivity(intent);
        finish();
    }


    public void Pastry(View view) {
        Intent intent = new Intent(MainActivity.this, Pastry.class);
        startActivity(intent);
        finish();
    }

    public void decoratives(View view) {
        Intent intent = new Intent(MainActivity.this, Decoratives.class);
        startActivity(intent);
        finish();
    }
}