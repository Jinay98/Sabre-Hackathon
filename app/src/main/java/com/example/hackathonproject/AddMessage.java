package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AddMessage extends AppCompatActivity {
    EditText name,nationality,content;
    Button addmsg;
    DatabaseReference reff;
    Message message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_message);
        final Date currentTime = Calendar.getInstance().getTime();
        name=findViewById(R.id.name);
        nationality=findViewById(R.id.nationality);
        content=findViewById(R.id.content);
        addmsg=findViewById(R.id.btn);
        message=new Message();
        reff= FirebaseDatabase.getInstance().getReference().child("Message");
        addmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString().trim();
                String no=nationality.getText().toString().trim();
                String d=content.getText().toString().trim();
                message.setName(n);
                message.setNationality(no);
                message.setContent(d);
                message.setDate(String.valueOf(currentTime));

                reff.push().setValue(message);
                Toast.makeText(AddMessage.this,"Message Sent",Toast.LENGTH_LONG).show();
            }
        });
    }
}
