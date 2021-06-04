package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pastry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Pastry.this, MainActivity.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }

    public void OrderNowPastry(View view) {
        Intent intent = new Intent(Pastry.this, OrderNowPastry.class);
        startActivity(intent);
        finish();
    }

}