package com.example.coronatrackerv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class statedetails extends AppCompatActivity {
    Integer positionstate;
    Intent send1;
    TextView name,active,cured,death,total;
    public void sharedata1(View view){
        String message=name.getText().toString()+" Corona Case Data \n"+active.getText().toString()+"\n"+total.getText().toString()+"\n"+cured.getText().toString()+"\n"+death.getText().toString();
        send1.setAction(Intent.ACTION_SEND);
        send1.putExtra(Intent.EXTRA_TEXT,message);
        send1.setType("text/plain");
        startActivity(send1);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statedetails);
        Intent intent = getIntent();
        send1=new Intent();
        positionstate = intent.getIntExtra("position",0);
        name=findViewById(R.id.statename);
        active=findViewById(R.id.stateactive);
        cured=findViewById(R.id.statecured);
        death=findViewById(R.id.statedeath);
        total=findViewById(R.id.statetotal);

        name.setText("Region :"+coronastate.statelist.get(positionstate).getName());
        active.setText("Total Case :"+coronastate.statelist.get(positionstate).getActive());
        death.setText("Death :"+coronastate.statelist.get(positionstate).getDeath());
        cured.setText("Cured :"+coronastate.statelist.get(positionstate).getCured());
        total.setText("Total Infected :"+coronastate.statelist.get(positionstate).getTotal());

    }
}