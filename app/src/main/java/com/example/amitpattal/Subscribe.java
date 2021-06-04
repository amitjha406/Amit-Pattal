package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Subscribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Subscribe.this, Cakes.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}