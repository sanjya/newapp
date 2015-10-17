package com.example.testapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;


public class MainActivity extends Activity 
{

	private PendingIntent pendingIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Calendar calendar = Calendar.getInstance();

		
		//set notification for date --> 8th January 2015 at 9:06:00 PM
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.YEAR, 2015);
		calendar.set(Calendar.DAY_OF_MONTH, 20);

		calendar.set(Calendar.HOUR_OF_DAY, 8);
		calendar.set(Calendar.MINUTE, 29);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.AM_PM,Calendar.AM);

		Intent myIntent = new Intent(MainActivity.this, MyReceiver.class);
		pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent,0);

		AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

	} //end onCreate





}