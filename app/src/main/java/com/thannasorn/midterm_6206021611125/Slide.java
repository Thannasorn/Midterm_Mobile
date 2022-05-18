package com.thannasorn.midterm_6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Slide extends AppCompatActivity implements View.OnClickListener{

    private Button btnPrev , btnNext ,btnShowBack;
    private ImageView showImage;

    private  int[] images = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04,
            R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08 , R.drawable.pic09, R.drawable.pic10};
    private int pos = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnShowBack = (Button) findViewById(R.id.btnBack2);

        showImage = (ImageView) findViewById(R.id.pic);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnShowBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnNext){
            if(pos > 9){
                pos = 0;

            }
            showImage.setImageResource(images[pos]);
            pos++;
        }
        else if (id ==R.id.btnPrev){
            if(pos < 0){
                pos = 9;
            }
            showImage.setImageResource(images[pos]);
            pos--;
        }
        else if (id ==R.id.btnBack2){
            Toast.makeText(this , "Exit Slide" , Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}