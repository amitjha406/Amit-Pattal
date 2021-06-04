package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class OrderNowPastry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now_pastry);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderNowPastry.this, Pastry.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}