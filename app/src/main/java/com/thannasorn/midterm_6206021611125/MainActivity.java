package com.thannasorn.midterm_6206021611125;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LayoutInflater layoutInflater;
    View toastLayout;
    private Button btnCalGpa, btnCalText, btnSlide, btnAbout, btnQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = getLayoutInflater();
        toastLayout = layoutInflater.inflate(R.layout.about_layout, (ViewGroup) findViewById(R.id.myAbout));

        btnCalGpa = (Button) findViewById(R.id.btnCalGpa);
        btnCalGpa.setOnClickListener(this);
        btnCalText = (Button) findViewById(R.id.btnCalText);
        btnCalText.setOnClickListener(this);
        btnSlide = (Button) findViewById(R.id.btnSlide);
        btnSlide.setOnClickListener(this);
        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(this);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCalGpa){
            Intent launchGpa = new Intent(MainActivity.this, startcalGpa.class);
            startActivity(launchGpa);
        }
        else if (id == R.id.btnCalText){
            Intent launchVat = new Intent(MainActivity.this, Cal_Text.class);
            startActivity(launchVat);
        }
        else if (id == R.id.btnSlide){
            Intent launchSlide = new Intent(MainActivity.this, Slide.class);
            startActivity(launchSlide);
        }
        else if (id == R.id.btnAbout){
            Toast toastCustom;
            toastCustom = Toast.makeText(this, "Custom", Toast.LENGTH_SHORT);
            toastCustom.setGravity(Gravity.CENTER, 0, 0);
            toastCustom.setView( toastLayout );
            toastCustom.show();
        }
        else if (id == R.id.btnQuit){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("Exit");
            builder.setMessage("Are you sure you want to leave ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    finish();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
    }
}


