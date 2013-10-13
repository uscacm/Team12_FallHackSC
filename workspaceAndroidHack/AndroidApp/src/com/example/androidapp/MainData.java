package com.example.androidapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainData {
	public static ArrayList<String> getAllClassList(){
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("CS 530");
		myList.add("CS 558");
		myList.add("CS 545");
		myList.add("CS 571");
		myList.add("CS 533");
		myList.add("CS 402");
		return myList;
	}
	public static ArrayList<String> getAllInterestList(){
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("FOOTBALL");
		myList.add("BIKING");
		myList.add("TRECKING");
		myList.add("SINGING");
		myList.add("TENNIS");
		myList.add("SOCCER");
		return myList;
	}
	public static ArrayList<String> getClassListBasedOnId(int id){
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("CS 530");
		myList.add("CS 558");
		myList.add("CS 545");
		myList.add("CS 571");
		myList.add("CS 533");
		myList.add("CS 402");
		
		return myList;
	}
	public static ArrayList<String> getIntrestListBasedOnId(int id){
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("FOOTBALL");
		myList.add("BIKING");
		myList.add("SWIMMING");
		myList.add("TENNIS");
		return myList;
	}
    public static ArrayList<HashMap<String, String>> getData(){
	   
	   ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String,String>>();
	   final HashMap<String, String> mp1 = new HashMap<String, String>();
	   mp1.put("name", "Pallav Rustogi");
	   mp1.put("distance", "15 mts");
	   mp1.put("friends", "12");
	   mp1.put("class", "3");
	   mp1.put("int", "6");
	   mp1.put("img",String.valueOf(R.drawable.photo));
	   
	   al.add(mp1);
	   
	   HashMap<String, String> mp2 = new HashMap<String, String>();
	   mp2.put("name", "Kalyanaraman");
	   mp2.put("distance", "16 mts");
	   mp2.put("friends", "22");
	   mp2.put("class", "1");
	   mp2.put("int", "8");
	   mp2.put("img",String.valueOf(R.drawable.kalyan));
	   
	   al.add(mp2);
	   
	   HashMap<String, String> mp3 = new HashMap<String, String>();
	   mp3.put("name", "Rezaul");
	   mp3.put("distance", "20 mts");
	   mp3.put("friends", "3");
	   mp3.put("class", "3");
	   mp3.put("int", "1");
	   mp3.put("img",String.valueOf(R.drawable.rezaul));
	   
	   al.add(mp3);
	   
	   HashMap<String, String> mp4 = new HashMap<String, String>();
	   mp4.put("name", "Sandeep");
	   mp4.put("distance", "20 mts");
	   mp4.put("friends", "12");
	   mp4.put("class", "3");
	   mp4.put("int", "6");
	   mp4.put("img",String.valueOf(R.drawable.sandy));
	   
	   al.add(mp4);
	   
	   
	   HashMap<String, String> mp5 = new HashMap<String, String>();
	   mp5.put("name", "Vinay Gonuguntla");
	   mp5.put("distance", "23 mts");
	   mp5.put("friends", "41");
	   mp5.put("class", "0");
	   mp5.put("int", "15");
	   mp5.put("img",String.valueOf(R.drawable.vinay));
	   
	   al.add(mp5);
	   
	   
	return al;
	   
   }
}
