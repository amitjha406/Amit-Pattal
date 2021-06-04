package com.example.amitpattal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Cakes.this, MainActivity.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }

    public void OrderNow(View view) {
        Intent intent = new Intent(Cakes.this, OrderNow.class);
        startActivity(intent);
        finish();
    }

    public void Subscribe(View view) {
        Intent intent = new Intent(Cakes.this, Subscribe.class);
        startActivity(intent);
        finish();
    }
}