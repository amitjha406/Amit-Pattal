package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Decoratives extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoratives);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Decoratives.this, MainActivity.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}