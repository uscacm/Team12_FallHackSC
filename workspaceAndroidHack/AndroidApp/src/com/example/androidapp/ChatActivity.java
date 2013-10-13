package com.example.androidapp;

import java.util.ArrayList;

import com.example.androidapp.FilterScreenActivity.Adapter1;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity {
	ArrayList<String> myList = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_chat);
		
		final Button send = (Button) findViewById(R.id.buttonSend);
		final EditText message = (EditText) findViewById(R.id.editTextMulti);
		
send.setOnClickListener(
		new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (message.getText() != null && message.getText().length() > 0) 
				{
					try{
					ParseObject obj = new ParseObject("Chat");
					obj.put("from", ParseUser.getCurrentUser());
					obj.put("message", message.getText().toString());
					
					//obj.put("message", message.getText());
					obj.saveInBackground();
					message.setText("");
					}catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			}
		});

myList.add("ME:Hi How are you Doing");
myList.add("SANDEEP:I am great how are you?");
myList.add("ME:Want to meet to discuss 402");
myList.add("SANDEEP:sure where do we meet");
myList.add("ME:SGM sounds good");
ListView lv = (ListView)findViewById(R.id.listViewChat);
Adapter1 myarrayAdapter = new Adapter1(this, android.R.layout.simple_list_item_1, myList);
lv.setAdapter(myarrayAdapter);

}
					
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
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
