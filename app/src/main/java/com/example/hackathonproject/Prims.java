package com.example.hackathonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;

public class Prims extends AppCompatActivity {
    int order[]={0,0,0,0};
    TextView city1,city2,city3,city4,day1,day2,day3,day4;
    String days="";
    HashMap<Integer,String> hashMap=new HashMap<Integer, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prims);
        Intent intent = getIntent();
        int startcity=0;
        try {
            startcity=Integer.parseInt(intent.getStringExtra("current_city"));
        }
        catch(Exception e){};
        //String value = intent. //if it's a string you stored.
        int[][] matrix={
            {100,10,20,30},
            {10,100,60,70},
            {20,60,100,45},
            {30,42,83,100},
        };
        solve(matrix,startcity);
        city1=(TextView)findViewById(R.id.city1);
        city2=(TextView)findViewById(R.id.city2);
        city3=(TextView)findViewById(R.id.city3);
        city4=(TextView)findViewById(R.id.city4);
        city1.setText(hashMap.get(order[0]));
        city2.setText(hashMap.get(order[1]));
        city3.setText(hashMap.get(order[2]));
        city4.setText(hashMap.get(order[3]));
        day1=(TextView)findViewById(R.id.day1);
        day2=(TextView)findViewById(R.id.day2);
        day3=(TextView)findViewById(R.id.day3);
        day4=(TextView)findViewById(R.id.day4);
        Toast.makeText(this.getApplication(), days+" Helloo Anirudh", Toast.LENGTH_LONG).show();
        printSubSets(4,Integer.parseInt(intent.getStringExtra("duration")),"");
        try {


            day1.setText(Character.toString(days.charAt(0)));
            day2.setText(Character.toString(days.charAt(1)));
            day3.setText(Character.toString(days.charAt(2)));
            day4.setText(Character.toString(days.charAt(3)));
        }
        catch(Exception e){};
        Toast.makeText(this.getApplication(), days, Toast.LENGTH_LONG).show();


    }

    public void printSubSets(int N, int curr, String res){
        if(curr==0){
            days=res;
            //Toast.makeText(getApplication(), res, Toast.LENGTH_LONG).show();
            return;
        }

        for (int i = 1; i <=N ; i++) {
            if(i<=curr){
                printSubSets(N, curr-i, res+i);

            }
            if(i==3)
                break;
        }
    }
    public static int getMin(int[] array)
    {
        int min=0;
        for(int i=1;i<array.length;i++)
        {
            if(array[i]<array[min])
                min=i;
        }
        return min;
    }

    public void solve(int[][] array,int start)
    {

        order[1]=start;
        String ans=hashMap.get(start)+" ";
        hashMap.put(0,"Mumbai");
        hashMap.put(1,"Chennai");
        hashMap.put(2,"Hyderabad");
        hashMap.put(3,"Kolkata");
        int j=start;
        int visited[]={0,0,0,0};
        visited[start]=1;
        int minimum=0;
        order[0]=start;
        for(int i=0;i<3;i++)
        {
            int[] temp=array[j];
            while(true)
            {
                minimum=getMin(temp);
                if(visited[minimum]==1)
                    array[j][minimum]=1000;
                else
                    break;
            }
            ans=ans+" "+ hashMap.get(minimum);
            order[i+1]=minimum;
            j=getMin(temp);
        }
        //Toast.makeText(this.getApplicationContext(), ans, Toast.LENGTH_LONG).show();
    }
}
