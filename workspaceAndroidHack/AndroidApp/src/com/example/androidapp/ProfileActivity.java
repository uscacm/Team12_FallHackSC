package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.profileview);
		
		
		Intent intent = getIntent();
		int position = intent.getExtras().getInt("position");
		ArrayList<HashMap<String, String>> al = MainData.getData();
		HashMap<String, String> map = al.get(position);
		TextView name = (TextView)findViewById(R.id.textViewName);
		name.setText(map.get("name"));
		
		TextView distance = (TextView)findViewById(R.id.textViewDistance);
		distance.setText(map.get("distance"));
		
		ImageView img = (ImageView)findViewById(R.id.imageViewProfile);
		img.setImageDrawable(this.getResources().getDrawable(Integer.parseInt(map.get("img"))));
		
		ArrayList<String> myList = MainData.getClassListBasedOnId(position);
		myList.addAll(MainData.getIntrestListBasedOnId(position));
        
	    ListView lv = (ListView)findViewById(R.id.listViewclass_int);
	    Adapter1 myarrayAdapter = new Adapter1(this, android.R.layout.simple_list_item_1, myList);
	    lv.setAdapter(myarrayAdapter);
	    
	    
	    Button but = (Button) findViewById(R.id.buttonstartChat);
	    but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(getApplicationContext(),ChatActivity.class);
				 startActivity(i);
			}
		});
	    
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	  public class Adapter1 extends ArrayAdapter<String> {

		    public Adapter1(Context context, int resID, ArrayList<String> items) {
		        super(context, resID, items);                       
		    }

		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        View v = super.getView(position, convertView, parent);
		      
		            ((TextView) v).setTextColor(getResources().getColor(R.color.text)); 
		            ((TextView) v).setTextSize(20); 
		    
		        return v;
		    }

		}
}
