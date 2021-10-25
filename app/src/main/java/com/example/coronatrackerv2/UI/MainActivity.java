package com.example.coronatrackerv2.UI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coronatrackerv2.R;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView todaycase,totalcase,todaydeath,totaldeath,todayrecovery,totalrecovery,crictical,test,active;
    Intent intent,send,a;
public void trackcountries(View view){
    startActivity(intent);

}
public void trackstate(View view){
    startActivity(a);

}
public void callhelp(View view){

    Uri number = Uri.parse("tel:+91-11-23978046");
    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
    startActivity(callIntent);
}
public void shareData(View view){
    String message= "WORLD WIDE (CORONA CASE DATA)\n"+"Today Case: "+todaycase.getText().toString()+"\n"+"Total Case: "+totalcase.getText().toString()+"\n"+"Today Deaths: "+todaydeath.getText().toString()+"\n"+"Total Death: "
            +totaldeath.getText().toString()+"\n"+"Today Recovered cases: "+todayrecovery.getText().toString()+"\n"+"Total Recovered cases: "+todayrecovery.getText().toString()+"\n"+active.getText().toString()
            +"\n"+test.getText().toString()+"\n"+crictical.getText().toString();
    send.setAction(Intent.ACTION_SEND);
    send.putExtra(Intent.EXTRA_TEXT,message);
    send.setType("text/plain");
    startActivity(send);



}
public void covidmap(View view){
    Uri gmmIntentUri = Uri.parse("geo:0,0?q=covid testing lab");
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
    mapIntent.setPackage("com.google.android.apps.maps");
    startActivity(mapIntent);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = new Intent();
        intent = new Intent(getApplicationContext(), coronacountry.class);
        todaycase=findViewById(R.id.todaycase);
        totalcase=findViewById(R.id.totalcases);
        todaydeath=findViewById(R.id.todaydeath);
        totaldeath=findViewById(R.id.totaldeath);
        todayrecovery=findViewById(R.id.todayrecovery);
        totalrecovery=findViewById(R.id.totalrecovery);
        test=findViewById(R.id.test);
        active=findViewById(R.id.active);
        crictical=findViewById(R.id.serious);
        a = new Intent(getApplicationContext(), coronastate.class);

        String url  = "https://corona.lmao.ninja/v2/all/";



        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());



                    todaycase.setText(jsonObject.getString("todayCases"));
                    totalcase.setText(jsonObject.getString("cases"));
                    todaydeath.setText(jsonObject.getString("todayDeaths"));
                    totaldeath.setText(jsonObject.getString("deaths"));
                    todayrecovery.setText(jsonObject.getString("todayRecovered"));
                    totalrecovery.setText(jsonObject.getString("recovered"));
                    test.setText("TEST:"+jsonObject.getString("tests"));
                    active.setText("ACTIVE:"+jsonObject.getString("active"));
                    crictical.setText("CRITICAL:"+jsonObject.getString("critical"));

                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }
}