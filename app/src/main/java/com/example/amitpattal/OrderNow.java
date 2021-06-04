package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class OrderNow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderNow.this, Cakes.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}