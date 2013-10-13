package com.example.androidapp;

import java.util.ArrayList;

import com.example.androidapp.ProfileActivity.Adapter1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FilterScreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listlayout1);
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.addAll(MainData.getAllClassList());
		ArrayList<String> myList1 = new ArrayList<String>();
		myList1.addAll(MainData.getAllInterestList());
        
	    ListView lv = (ListView)findViewById(R.id.listViewFilterClassMenu);
	    Adapter1 myarrayAdapter = new Adapter1(this, android.R.layout.simple_list_item_1, myList);
	    lv.setAdapter(myarrayAdapter);
	    
	    ListView lv1 = (ListView)findViewById(R.id.listViewFilterInterestMenu);
	    Adapter1 myarrayAdapter1 = new Adapter1(this, android.R.layout.simple_list_item_1, myList1);
	    lv1.setAdapter(myarrayAdapter1);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filter_screen, menu);
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
