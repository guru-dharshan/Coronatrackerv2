package com.example.coronatrackerv2.ADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.coronatrackerv2.DATA.statedata;
import com.example.coronatrackerv2.R;

import java.util.List;

public class myadapterstate extends ArrayAdapter<statedata> {
    private Context context;
    private List<statedata> stateList;
    public myadapterstate(Context context,List<statedata> stateList){
        super(context, R.layout.statelistview,stateList);
        this.context=context;
        this.stateList=stateList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.statelistview,null,true);
        TextView statename=view.findViewById(R.id.statename);

        statename.setText(stateList.get(position).getName());
        return view;
    }

    @Override
    public int getCount() {
        return stateList.size();
    }

    @Nullable
    @Override
    public statedata getItem(int position) {
        return stateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
