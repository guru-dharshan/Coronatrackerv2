package com.example.coronatrackerv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class myadaptercountry extends ArrayAdapter<countrydata> {
    private Context context;
    private List<countrydata> countryModelsList;

    public myadaptercountry(Context context, List<countrydata> countryModelsList ) {
        super(context,R.layout.countrylist,countryModelsList);
       this.context=context;
       this.countryModelsList=countryModelsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countrylist,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(countryModelsList.get(position).getCountry());
        Glide.with(context).load(countryModelsList.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelsList.size();
    }

    @Nullable
    @Override
    public countrydata getItem(int position) {
        return countryModelsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
