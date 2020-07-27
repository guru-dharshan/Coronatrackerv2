package com.example.coronatrackerv2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class coronastate extends AppCompatActivity {
    ListView statelistview;
    statedata statedata;
    myadapterstate myadapterstate;
    public static List<statedata> statelist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coronastate);
        statelistview=findViewById(R.id.statelist);

        statelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),statedetails.class).putExtra("position",position));
            }
        });

        String url  = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("regionData");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonstate = jsonArray.getJSONObject(i);

                        String name=jsonstate.getString("region");
                        String active=jsonstate.getString("totalCases");
                        String cured=jsonstate.getString("recovered");
                        String death = jsonstate.getString("deceased");
                        String total  = jsonstate.getString("totalInfected");

                        statedata=new statedata(name,active,cured,death,total);
                        statelist.add(statedata);
                    }
                    myadapterstate=new myadapterstate(coronastate.this,statelist);
                    statelistview.setAdapter(myadapterstate);



                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }


            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(coronastate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}