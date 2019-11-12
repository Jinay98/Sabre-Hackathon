package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hackathonproject.Translation;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

public class TranslateActivity extends AppCompatActivity {

    EditText input;
    TextView target;
    Spinner choice;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        input = (EditText)findViewById(R.id.input_text);
        target = (TextView)findViewById(R.id.target);
        choice = (Spinner)findViewById(R.id.picker);

        requestQueue = Volley.newRequestQueue(this);
    }

    public void go(View view) throws UnsupportedEncodingException {
        String text = input.getText().toString();
        String language = choice.getSelectedItem().toString();
        String url = "http://192.168.29.184:8000/translate/" + text.replaceAll(" ", "%20") + "/" + "mr/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        byte[] bytes = response.toString().getBytes(StandardCharsets.UTF_8);
                        String text = new String(bytes, StandardCharsets.UTF_8);
                        System.out.println(text);
                        target.setText(text);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());

                    }
                });
        ///target.setText(Translation.translate(text, language));
        requestQueue.add(jsonObjectRequest);

    }


}
