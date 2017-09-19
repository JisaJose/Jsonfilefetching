package com.example.jsonfilefetching;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Dsplaylistview extends AppCompatActivity {
String JSON_STRING;
   JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsplaylistview);
        contactAdapter = new ContactAdapter(this,R.layout.rowlayout);
        listView= (ListView) findViewById(R.id.listview);
        listView.setAdapter(contactAdapter);
        JSON_STRING = getIntent().getExtras().getString("jsondat");
        try {
            jsonObject = new JSONObject(JSON_STRING);
            jsonArray = jsonObject.getJSONArray("orders");

            int count =0;
            String name,email_id,created_at,updated_at,token,user_id,id;
            while(count <jsonObject.length()){
               JSONObject jo =jsonArray.getJSONObject(count);
                id= jo.getString("id");
                email_id=jo.getString("email");
                created_at=jo.getString("created_at");
                updated_at = jo.getString("updated_at");
                name=jo.getString("name");
                token=jo.getString("token");
                user_id=jo.getString("user_id");
Contacts contacts = new Contacts(name,email_id,created_at,updated_at,token,user_id,id);
                contactAdapter.add(contacts);
               count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
