package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PlanMyTrip extends AppCompatActivity {
    String places[]=new String[4];
    int array[]={0,0,0,0};
    Button plantrip;
    int current_city=0;
    EditText duration,currcity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_my_trip);
        places[0]="Mumbai";
        places[1]="Chennai";
        places[2]="Hyderabad";
        places[3]="Kolkata";
        plantrip=(Button)findViewById(R.id.plantrip);
        duration=(EditText)findViewById(R.id.duration);
        currcity=(EditText)findViewById(R.id.currcity);
        try
        {

            String x=currcity.getText().toString();
            if(x=="Chennai")
                current_city=1;
            else if(x=="Hyderabad")
                current_city=2;
            else if(x=="Kolkata")
                current_city=3;
        }
        catch(Exception e){}


    }


    public void checkbox_clicked(View v) {
        //code to check if this checkbox is checked!
        Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_LONG).show();
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){
            if(checkBox.getText().toString()=="Mumbai")
                array[0]=1;
            else if(checkBox.getText().toString()=="Chennai")
                array[1]=1;
            else if(checkBox.getText().toString()=="Hyderabad")
                array[2]=1;
            else if(checkBox.getText().toString()=="Kolkata")
                array[3]=1;
        }
    }
    public void planmytrip(View v)
    {
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        Intent myIntent = new Intent(PlanMyTrip.this, Prims.class);
        myIntent.putExtra("cities", array); //Optional parameters
        myIntent.putExtra("current_city",Integer.toString(current_city));
        myIntent.putExtra("duration",duration.getText().toString());
        startActivity(myIntent);
    }

}
