package com.thannasorn.midterm_6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cal_Text extends AppCompatActivity implements View.OnClickListener {

    private Button calText, btnBack1;
    private EditText amount, son, Insamount, Intamount;
    private TextView show1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_text);

        amount = (EditText) findViewById(R.id.amount);
        son = (EditText) findViewById(R.id.son);
        Insamount = (EditText) findViewById(R.id.Insamount);
        Intamount = (EditText) findViewById(R.id.Intamount);

        calText = (Button) findViewById(R.id.calTax);
        calText.setOnClickListener(this);
        btnBack1 = (Button) findViewById(R.id.btnBack1);
        btnBack1.setOnClickListener(this);

        show1 = (TextView) findViewById(R.id.show1);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnBack1){
            Toast.makeText(Cal_Text.this, "Exit Tax", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}