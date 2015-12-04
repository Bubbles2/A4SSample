package com.a4s.coffeesample.activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;
import android.widget.TextView;

import com.a4s.coffeesample.R;

import java.util.ArrayList;

public class MyListActivity extends Activity
{
	String[] teams ;
	ListView lv;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_list);
		//
		lv = (ListView) findViewById(R.id.listView);
		//lv.setAdapter();
		teams = getResources().getStringArray(R.array.teams);
		//
		for (int i = 0; i < teams.length; i++) {
			//
			TextView tv = new TextView(this);
			tv.setText(teams[i]);
			lv.addView(tv);
			//

		}


	}

}
