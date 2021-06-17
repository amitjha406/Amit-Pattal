package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderNow extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);

        radioGroup =findViewById(R.id.radioGroup2);
        textView=findViewById(R.id.textView4);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        textView.setText("500");
                        break;
                    case  R.id.radioButton2:
                        textView.setText("1000");
                        break;
                    case  R.id.radioButton3:
                        textView.setText("1500");
                        break;
                }
            }
        });

        Button buttonPay= findViewById(R.id.button);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderNow.this, Cakes.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}