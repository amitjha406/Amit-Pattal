package com.example.amitpattal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class OrderNow extends AppCompatActivity {

    public static final String PAYTM_PACKAGE_NAME="net.one97.paytm";
    public static String payerName,vpa,msgNote,status,sendAmount;
    Uri uri;
    String name="Amit Jha",upiId="amitjha0@ybl";

    RadioGroup radioGroup;
    EditText note;
    TextView amount,msg;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);

        radioGroup =findViewById(R.id.radioGroup2);
        amount=findViewById(R.id.textView4);
        pay=findViewById(R.id.payNow);
        msg=findViewById(R.id.msg);
        note=findViewById(R.id.note);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        amount.setText("500");
                        break;
                    case  R.id.radioButton2:
                        amount.setText("1000");
                        break;
                    case  R.id.radioButton3:
                        amount.setText("1500");
                        break;
                }
            }
        });


        pay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                payerName=name;
                vpa=upiId;
                sendAmount=amount.getText().toString();
                msgNote=note.getText().toString();

                if(payerName!=null && vpa!=null && sendAmount!=null && msgNote!=null){
                    uri=getPayTmUri(payerName,vpa,msgNote,sendAmount);;
                    payWithPayTm(PAYTM_PACKAGE_NAME);
                }
                else{
                    Toast.makeText(OrderNow.this,"Please fill all data",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private static Uri getPayTmUri(String name,String upiId,String note,String amount){
        return new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa",upiId)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cur","INR")
                .build();
    }

    private void payWithPayTm(String packageName){

        if(isAppInstalled(this, packageName)){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(uri);
            i.setPackage(packageName);
            startActivityForResult(i,0);
        }else{
            Toast.makeText(this,"Paytm is not installed ",Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean isAppInstalled(Context context, String packageName){
        try {
            context.getPackageManager().getApplicationInfo(packageName,0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(data!=null){
            status=data.getStringExtra("Status").toLowerCase();

        }
        if(RESULT_OK ==resultCode && status.equals("success")){
            Toast.makeText(OrderNow.this,"Transaction Successful " +data.getStringExtra("ApprovalRefNo"),Toast.LENGTH_SHORT).show();
            msg.setText("Transaction successful of INR " + sendAmount);
            msg.setTextColor(Color.GREEN);
        }
        else{
            Toast.makeText(OrderNow.this,"Transaction failed ",Toast.LENGTH_SHORT).show();
            msg.setText("Transaction failed of INR " + sendAmount);
            msg.setTextColor(Color.RED);
        }
    }



    @Override
    public void onBackPressed() {
        Intent intent = new Intent(OrderNow.this, Cakes.class);
        startActivity(intent);
        finish();
        // Add the Back key handler here.
    }
}