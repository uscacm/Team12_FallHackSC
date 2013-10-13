package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class IntandClassAdapter extends BaseAdapter{
	 private Activity activity;
	    private ArrayList<HashMap<String, String>> data;
	    private static LayoutInflater inflater=null;
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	public IntandClassAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		if(convertView==null){
				vi=inflater.inflate(R.layout.list_row2,null);
			/*	TextView name = (TextView)vi.findViewById(R.id.textView1); 
		        TextView genre = (TextView)vi.findViewById(R.id.textView2); 
		        TextView year = (TextView)vi.findViewById(R.id.textView3); 
		        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image);
		        
		        HashMap<String, String> entry = new HashMap<String, String>();
		        entry = data.get(position);
		
		        name.setText(entry.get("name"));
		        genre.setText(entry.get("genre"));
		        year.setText(entry.get("year"));
		        int lncnt =entry.get("name").length();
		        if(lncnt>25){
		        	name.setTextSize(8);
		        }*/
			}
		
        return vi;
	}

}
