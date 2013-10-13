package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Context;
import android.os.DropBoxManager.Entry;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter{
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
	public MainAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
		if(convertView==null){
				vi=inflater.inflate(R.layout.list_row,null);
				TextView name = (TextView)vi.findViewById(R.id.textViewlistRow1); 
		        TextView distance = (TextView)vi.findViewById(R.id.textViewlistRow3); 
		        TextView mutFriends = (TextView)vi.findViewById(R.id.textViewlistRow2); 
		        TextView mutClass = (TextView)vi.findViewById(R.id.textViewlistRow4); 
		        TextView mutInterests = (TextView)vi.findViewById(R.id.textViewlistRow5); 
		        ImageView iv =(ImageView)vi.findViewById(R.id.list_image_listRow);
		       
		        HashMap<String, String> entry = new HashMap<String, String>();
		        entry = data.get(position);
		        iv.setImageDrawable(activity.getResources().getDrawable(Integer.parseInt(entry.get("img"))));
		        name.setText(entry.get("name"));
		        distance.setText(entry.get("distance"));
		        mutFriends.setText(entry.get("friends"));
		        mutClass.setText(entry.get("class"));
		        mutInterests.setText(entry.get("int"));
		 
			}
		
        return vi;
	}

}
