package com.example.uptext;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<My> {
    private int resourceId;
    public MyAdapter(Context context,int textViewResousceId,List<My> objects) {
		super (context,textViewResousceId,objects);
		resourceId=textViewResousceId;
	}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	My my =getItem(position);
    	View view=LayoutInflater.from(getContext()).inflate(resourceId, null);
    	TextView myName=(TextView)view.findViewById(R.id.my_name);
    	myName.setText(my.getName());   
    	return view;
    }
}
