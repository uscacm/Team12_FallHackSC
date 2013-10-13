package com.example.androidapp;

import java.util.Locale;

import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.listlayout);
        
		
		//Change the pager title color
	//	PagerTitleStrip titleStrip =(PagerTitleStrip) findViewById(R.id.pager_title_strip);
	//	titleStrip.setTextColor(getResources().getColor(R.color.text));
		
		ListView lv = (ListView) findViewById(R.id.listView1);
		//String[] array={"test","test2"}; 
		//ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
		MainAdapter ma = new MainAdapter(this, MainData.getData());
		lv.setAdapter(ma);
		
		lv.setOnItemClickListener(new OnItemClickListener() {@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			 Intent i = new Intent(MainActivity.this,ProfileActivity.class);
			 i.putExtra("position",position);
			 startActivity(i); 
		}
		});
		
		
		Button ib  =(Button) findViewById(R.id.buttonFilter);
		
	    ib.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 Intent i = new Intent(getApplicationContext(),FilterScreenActivity.class);
				 startActivity(i);
			}
		});
			

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
	/*	mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter); */
		addLocationListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean addLocationListener(){
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		boolean gps_enabled = false;
		boolean network_enabled = false;
		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
			@Override
		    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
				Log.d("RegisterLocation:", location.getLongitude() + "" +location.getLatitude());
				RegisterNewLocation(location);
		    }
			@Override
		    public void onStatusChanged(String provider, int status, Bundle extras) {
				
			}
			@Override
		    public void onProviderEnabled(String provider) {}
			@Override
		    public void onProviderDisabled(String provider) {}
		    
		  };
		  
		try{
			gps_enabled=locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		}
		catch(Exception ex){
			
		}
	    try{
	    	network_enabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	    }
	    catch(Exception ex){
	    	
	    }
		  
	    if(network_enabled) 
			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 60000, 0, locationListener);
	    else if(gps_enabled)
	    	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 0, locationListener);
	    else {}
	    
	   
	    return true;
	}
	
	
	public void RegisterNewLocation(Location location){
		
		/*
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Register Location" + location.getLatitude()).setTitle("Location");
		AlertDialog dialog = builder.create();
		dialog.show();
		*/
		ParseObject newLocation = new ParseObject("UserLocations");
		newLocation.put("user", ParseUser.getCurrentUser()); 
		newLocation.put("location", new ParseGeoPoint(location.getLatitude(), location.getLongitude()));
		newLocation.saveInBackground();
	}
	
	

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
