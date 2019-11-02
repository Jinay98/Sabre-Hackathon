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
                place.setUrl("https://firebasestorage.googleapis.com/v0/b/hackathonproject-28ef7.appspot.com/o/mumbai.jpg?alt=media&token=3e20bcdb-fd22-4f4b-9d98-ef0313f2ef24");
                reff.push().setValue(place);
                Toast.makeText(AddPlace.this,"data inserted",Toast.LENGTH_LONG).show();
            }
        });

    }
}