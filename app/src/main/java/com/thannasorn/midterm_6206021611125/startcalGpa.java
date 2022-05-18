package com.thannasorn.midterm_6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class startcalGpa extends AppCompatActivity implements View.OnClickListener {

    private Button calGpa, btnBack;
    private EditText grade1, grade2, grade3, grade4, grade5;
    private TextView show;

    String Edit1, Edit2, Edit3, Edit4, Edit5;
    double point1, point2, point3, point4 , point5 ,credit = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startcal_gpa);

        grade1 = (EditText) findViewById(R.id.grade1);
        grade2 = (EditText) findViewById(R.id.grade2);
        grade3 = (EditText) findViewById(R.id.grade3);
        grade4 = (EditText) findViewById(R.id.grade4);
        grade5 = (EditText) findViewById(R.id.grade5);

        calGpa = (Button) findViewById(R.id.calGpa);
        calGpa.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        show = (TextView) findViewById(R.id.show);
    }

    @Override
    public void onClick(View v){
        Edit1 = grade1.getText().toString();
        Edit2 = grade2.getText().toString();
        Edit3 = grade3.getText().toString();
        Edit4 = grade4.getText().toString();
        Edit5 = grade5.getText().toString();

        int id = v.getId();
        if (id == R.id.btnBack){
            Toast.makeText(startcalGpa.this, "Exit Grade", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (Edit1.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (Edit2.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (Edit3.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (Edit4.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (Edit5.equals("")){
            Toast.makeText(this , "กรุณากรอกข้อมูล" , Toast.LENGTH_SHORT).show();
            return;
        }
        else if (id == R.id.calGpa){
            credit = 0;

            point1 = calPoint(grade1);
            point2 = calPoint(grade2);
            point3 = calPoint(grade3);
            point4 = calPoint(grade4);
            point5 = calPoint(grade5);

            double totalPoint = point1 + point2 + point3 + point4 + point5;
            double totalGpa   = totalPoint / credit;
            DecimalFormat decFormat = new DecimalFormat("##.00");
            if(totalGpa < 1.25 ){
                show.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Retire");
                show.setBackgroundColor(Color.RED);
            }
            else if (totalGpa >= 1.25 && totalGpa <= 1.99){
                show.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Probation");
                show.setBackgroundColor(Color.parseColor("#FF9800"));
            }
            else if (totalGpa >= 2.00 && totalGpa <=4.00 ){
                show.setText("Points : " + decFormat.format(totalPoint)
                        + "\nCredits : " + decFormat.format(credit)
                        + "\nGPA : " + decFormat.format(totalGpa)
                        + "\nStatus : Normal");
                show.setBackgroundColor(Color.GREEN);
            }

        }
    }

    public double calPoint(EditText input){
        String GPA = input.getText().toString();
        double point = 0;

        if (GPA.equals("A")) {
            point = 4.0 *3 ;
            credit += 3;
        }
        else if (GPA.equals("B+")) {
            point = 3.5 *3 ;
            credit += 3;

        }
        else if (GPA.equals("B")) {
            point = 3.0 *3;
            credit += 3;

        }
        else if (GPA.equals("C+")) {
            point = 2.5 *3;
            credit += 3;

        }
        else if (GPA.equals("C")) {
            point = 2.0 *3 ;
            credit += 3;

        }
        else if (GPA.equals("D+")) {
            point = 1.5 *3;
            credit += 3;

        }
        else if (GPA.equals("D")) {
            point = 1.0 *3;
            credit += 3;

        }
        else {
            point = 0;
            credit += 3;
        }
        return point;
    }
}