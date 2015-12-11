package com.a4s.coffeesample.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
//
import com.a4s.coffeesample.GestureListener;
import com.a4s.sdk.plugins.annotations.UseA4S;

import com.a4s.coffeesample.R;
import com.ad4screen.sdk.A4S;
import com.ad4screen.sdk.InApp;

@UseA4S public class ManyActivity extends FragmentActivity
{
	private GestureDetector mGestureDetector;
	int leftpos;
	int toppos;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.many_fragments_activity);
		//
		//Unlock in-app and push notifications
		//Any waiting in app and rich push will be displayed
		A4S.get(this).setPushNotificationLocked(false);
		A4S.get(this).setInAppDisplayLocked(false);
		//
		// Code to position message
		A4S.get(this).setInAppReadyCallback(false, new A4S.Callback<InApp>()
		{
			@Override
			public void onResult(InApp inApp)
			{






				//		if(inApp.getDisplayTemplate().contains("com_ad4screen")) {
				if(inApp.getDisplayTemplate().contains("a4s_info")) {


					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
																				   ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP);

					params.setMargins(leftpos,toppos,0,0);
					//
					//TextView tvbody = (TextView) findViewById(R.id.com_ad4screen_sdk_title);
					//tvbody.setText("My Data");
					TextView tv = (TextView) findViewById(R.id.textView);
					int i = inApp.getContainer();

					//TextView tvbody = (TextView)findViewById(inApp.getContainer()).findViewById(R.id.textView);
					//						tvbody.setText("mother fucker");


					A4S.get(getApplicationContext()).setOverlayPosition(params);
				}


			}

			@Override
			public void onError(int i, String s)
			{

			}
		}, R.layout.com_ad4screen_sdk_overlay);

		A4S.get(getApplicationContext()).setInAppDisplayedCallback(new A4S.Callback<InApp>()
		{
			@Override
			public void onResult(InApp inApp)
			{
				TextView tv = (TextView) findViewById(R.id.textView);
				int i = inApp.getContainer();
				View view = findViewById(inApp.getContainer());
				tv.setText("mother fucker");
				RelativeLayout rr = (RelativeLayout) findViewById(R.id.inf_triangle);
				rr.setVisibility(View.GONE);
				//TextView tvbody = (TextView)findViewById(inApp.getContainer()).findViewById(R.id.textView);
				//tvbody.setText("mother fucker");
			}

			@Override
			public void onError(int i, String s)
			{

			}
		});

		// Bind the gestureDetector to GestureListener
		mGestureDetector = new GestureDetector(this, new GestureListener());
	}

	// onTouch() method gets called each time you perform any touch event with screen
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		//method onTouchEvent of GestureDetector class Analyzes the given motion event
		//and if applicable triggers the appropriate callbacks on the GestureDetector.OnGestureListener supplied.
		//Returns true if the GestureDetector.OnGestureListener consumed the event, else false.

		boolean eventConsumed = mGestureDetector.onTouchEvent(event);
		if (eventConsumed)
		{
			Toast.makeText(this, GestureListener.currentGestureDetected, Toast.LENGTH_LONG).show();
			return true;
		}
		else
		{
			return false;
		}
	}

}
