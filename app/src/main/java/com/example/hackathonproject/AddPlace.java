package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlace extends AppCompatActivity {
    EditText name,noofdays,desc;
    Button addplace;
    DatabaseReference reff;
    Place place;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        name=findViewById(R.id.name);
        noofdays=findViewById(R.id.noofdays);
        desc=findViewById(R.id.desc);
        addplace=findViewById(R.id.btn);
        place=new Place();
        reff= FirebaseDatabase.getInstance().getReference().child("Place");
        addplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString().trim();
                String no=noofdays.getText().toString().trim();
                String d=desc.getText().toString().trim();
                place.setName(n);
                place.setNoofdays(no);
                place.setDesc(d);
                reff.push().setValue(place);
                Toast.makeText(AddPlace.this,"data inserted",Toast.LENGTH_LONG).show();
            }
        });

    }
}