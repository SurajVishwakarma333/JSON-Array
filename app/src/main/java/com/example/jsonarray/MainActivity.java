package com.example.jsonarray;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*   Let's take another example of json array/parsing.

        { "Employee" :
           [
            {"id":"101","name":"Suraj Vishwakarma","salary":"50000"},
            {"id":"102","name":"Rohit Jaiswal","salary":"60000"}
           ]
        }               */

        TextView output = (TextView) findViewById(R.id.textView1);

        String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Suraj Vishwakarma\",\"salary\":\"50000\"}," +
                                        "{\"id\":\"102\",\"name\":\"Rohit Jaiswal\",\"salary\":\"60000\"}] }";

        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "LIST "+i+" : \n\n id= "+ id +" \n\n Name= "+ name +" \n\n Salary= "+ salary +" \n\n\n\n\n ";
            }
            output.setText(data);
        } catch (JSONException e) {e.printStackTrace();}
    }
}