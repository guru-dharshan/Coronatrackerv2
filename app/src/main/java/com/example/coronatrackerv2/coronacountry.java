package com.example.coronatrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.TextView;
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

public class coronacountry extends AppCompatActivity {
   ListView countrylist;
   countrydata countrydata;
   myadaptercountry myadaptercountry;
    public static List<countrydata> countryModelsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coronacountry);
        countrylist=findViewById(R.id.countrylist);



        countrylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),countrydetails.class).putExtra("position",position));
            }
        });
        String url  = "https://corona.lmao.ninja/v2/countries/";



        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String countryName = jsonObject.getString("country");
                        String cases = jsonObject.getString("cases");
                        String todayCases = jsonObject.getString("todayCases");
                        String deaths = jsonObject.getString("deaths");
                        String todayDeaths = jsonObject.getString("todayDeaths");
                        String recovered = jsonObject.getString("recovered");
                        String todayRecovered = jsonObject.getString("todayRecovered");
                        String active = jsonObject.getString("active");
                        String critical = jsonObject.getString("critical");
                        String tests = jsonObject.getString("tests");

                        JSONObject object = jsonObject.getJSONObject("countryInfo");
                        String flag = object.getString("flag");

                        countrydata = new countrydata(flag, countryName, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered, active, critical, tests);
                        countryModelsList.add(countrydata);


                    }
                    myadaptercountry = new myadaptercountry(coronacountry.this,countryModelsList);
                    countrylist.setAdapter(myadaptercountry);


                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(coronacountry.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
                RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        }
    }
