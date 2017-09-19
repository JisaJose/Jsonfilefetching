package com.example.jsonfilefetching;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String JSON_STRING;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getjson(View view){
new BgTask().execute();

    }

    class BgTask extends AsyncTask<Void,Void,String>{
        String json_url;
        @Override
        protected void onPreExecute() {
           json_url="https://shopicruit.myshopify.com/admin/orders.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6"
            ;
        }



        @Override
        protected  String doInBackground(Void... params) {
            try {
                URL url= new URL(json_url);

                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((json_url =bufferedReader.readLine() )!=null)
                {
stringBuilder.append(json_url+ "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  stringBuilder.toString().trim();
            } catch (MalformedURLException e) {


                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView =  (TextView)findViewById(R.id.textView);
            textView.setText(s);
            JSON_STRING = s;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    public  void displayjson(View view){
        if(JSON_STRING==null){
            Toast.makeText(getApplicationContext(),"no json",Toast.LENGTH_LONG).show();
        }
else{
            Intent intent= new Intent(this,Dsplaylistview.class );
            intent.putExtra("jsondat",JSON_STRING);
            startActivity(intent);
        }

    }
}//https://www.youtube.com/watch?v=KSX4zIhiZlM
