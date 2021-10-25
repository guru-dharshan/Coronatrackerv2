package com.example.coronatrackerv2.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coronatrackerv2.R;

public class countrydetails extends AppCompatActivity {
    private  int positionCountry;
    Intent send1;
    TextView todaycase,totalcase,todaydeath,totaldeath,todayrecovery,totalrecovery,crictical,test,active,country;
    public void sharedata1(View view){
            String message= country.getText().toString()+"  (Corona Cases Data)"+"\n"+"Today Case: "+todaycase.getText().toString()+"\n"+"Total Case: "+totalcase.getText().toString()+"\n"+"Today Deaths: "+todaydeath.getText().toString()+"\n"+"Total Death: "
                    +totaldeath.getText().toString()+"\n"+"Today Recovered cases: "+todayrecovery.getText().toString()+"\n"+"Total Recovered cases: "+todayrecovery.getText().toString()+"\n"+active.getText().toString()
                    +"\n"+test.getText().toString()+"\n"+crictical.getText().toString();
            send1.setAction(Intent.ACTION_SEND);
            send1.putExtra(Intent.EXTRA_TEXT,message);
            send1.setType("text/plain");

            startActivity(send1);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrydetails);
        send1=new Intent();
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);
        country=findViewById(R.id.textView11);
        todaycase=findViewById(R.id.todaycase);
        totalcase=findViewById(R.id.totalcases);
        todaydeath=findViewById(R.id.todaydeath);
        totaldeath=findViewById(R.id.totaldeath);
        todayrecovery=findViewById(R.id.todayrecovery);
        totalrecovery=findViewById(R.id.totalrecovery);
        test=findViewById(R.id.test);
        active=findViewById(R.id.active);
        crictical=findViewById(R.id.serious);

        country.setText(coronacountry.countryModelsList.get(positionCountry).getCountry());
        totalcase.setText(coronacountry.countryModelsList.get(positionCountry).getCases());
        totalrecovery.setText(coronacountry.countryModelsList.get(positionCountry).getRecovered());
        crictical.setText("CRITICAL: "+ coronacountry.countryModelsList.get(positionCountry).getCritical());
        active.setText("ACTIVE: "+ coronacountry.countryModelsList.get(positionCountry).getActive());
        todaycase.setText(coronacountry.countryModelsList.get(positionCountry).getTodayCases());
        totaldeath.setText(coronacountry.countryModelsList.get(positionCountry).getDeaths());
        todaydeath.setText(coronacountry.countryModelsList.get(positionCountry).getTodayDeaths());
        todayrecovery.setText(coronacountry.countryModelsList.get(positionCountry).getTodayRecovered());
        test.setText("TEST: "+ coronacountry.countryModelsList.get(positionCountry).getTests());


    }
}