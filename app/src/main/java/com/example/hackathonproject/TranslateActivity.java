package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hackathonproject.Translation;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TranslateActivity extends AppCompatActivity {

    EditText input;
    TextView target;
    Spinner choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        input = (EditText)findViewById(R.id.input_text);
        target = (TextView)findViewById(R.id.target);
        choice = (Spinner)findViewById(R.id.picker);
    }

    public void go(View view){
        String text = input.getText().toString();
        String language = choice.getSelectedItem().toString();

        target.setText(Translation.translate(text, language));


    }


}
