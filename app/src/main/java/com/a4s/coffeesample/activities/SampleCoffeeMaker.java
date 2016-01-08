package com.a4s.coffeesample.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a4s.coffeesample.R;
import com.a4s.sdk.plugins.annotations.UseA4S;
import com.ad4screen.sdk.A4S;
import com.ad4screen.sdk.InApp;
import com.ad4screen.sdk.Tag;

import java.util.HashMap;

@UseA4S
//@Tag(name = "CoffeeMaker")
public class SampleCoffeeMaker extends Activity {
	Button but;
	int leftpos;
	int toppos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sample_coffee_maker);
		setTitle("View : CoffeeMaker");


		//Unlock in-app and push notifications
		//Any waiting in app and rich push will be displayed
		A4S.get(this).setPushNotificationLocked(false);
		A4S.get(this).setInAppDisplayLocked(false);

		//
		//A4S.get(this).trackEvent(1002, "Comments2");
		//A4S.get(this).trackEvent(1001, "Comments");
		//A4S.get(this).trackEvent(1005, "Comments");
		new Thread(new CheckForEvents(this)).start();

// Get width A4S approach
//		A4S.get(context).setInAppDisplayedCallback(new Callback<InApp>() {
//			@Override
//			public void onResult(InApp result) {
//				final View inAppDisplayedView = findViewById(R.id.ibev1);
//				if (inAppDisplayedView) {
//					inAppDisplayedView.post(new Runnable() {
//						@Override
//						public void run() {
//							int width = inAppDisplayedView.getWidth();
//							Toast.makeText(context, "Width of inAppDisplayedView: " + width, Toast.LENGTH_SHORT).show();
//						}
//					});
//				}
//			}
//
//			...
//		});

		//


		//A4S.get(this).putState("HappyHour","DF");


		// Code to position message



//		A4S.get(this).setInAppReadyCallback(false, new A4S.Callback<InApp>()
//		{
//
//
//
//			@Override
//			public void onResult(InApp inApp)
//			{
//		//		if(inApp.getDisplayTemplate().contains("com_ad4screen")) {
//				//In-App id
//				String id = inApp.getId();
//				String dname = inApp.getDisplayTemplate();
//				//In-App custom parameters
//				HashMap<String,String> customParameters = inApp.getCustomParameters();
//
//					if(inApp.getDisplayTemplate().contains("a4s_info")) {
//
//
//						FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//																				   ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP);
//
//						//params.setMargins(leftpos,toppos+400,0,0);
//						params.setMargins(400,400,0,0);
//					//
//					//TextView tvbody = (TextView) findViewById(R.id.com_ad4screen_sdk_title);
//					//tvbody.setText("My Data");
//						TextView tv = (TextView) findViewById(R.id.textView);
//						int i = inApp.getContainer();
//
//						//TextView tvbody = (TextView)findViewById(inApp.getContainer()).findViewById(R.id.textView);
////						tvbody.setText("mother fucker");
//
//						A4S.get(getApplicationContext()).setOverlayPosition(params);
//				}
//
//
//			}
//
//			@Override
//			public void onError(int i, String s)
//			{
//				String ss = "ss";
//			}
//			// This is how we can overlay multiple messages
//		}, R.layout.com_ad4screen_sdk_overlay);
//
//		A4S.get(getApplicationContext()).setInAppDisplayedCallback(new A4S.Callback<InApp>()
//		{
//			@Override
//			public void onResult(InApp inApp)
//			{
//
//				//
//				TextView tv = (TextView) findViewById(R.id.textView);
//				int i = inApp.getContainer();
//				View view = findViewById(inApp.getContainer());
//				tv.setText("This is my commercial message \n we need to have a commercial \n it should appear on multiple lines");
//
//				//findViewById(inApp.get)
//
//				//TextView tvbody = (TextView)findViewById(inApp.getContainer()).findViewById(R.id.textView);
//				//tvbody.setText("mother fucker");
//			}
//
//			@Override
//			public void onError(int i, String s)
//			{
//
//			}
//		});
//
//		findViewById(R.id.btnStartBrew).setOnClickListener(new OnClickListener()
//		{
//			@Override
//			public void onClick(View v)
//			{
//				A4S.get(SampleCoffeeMaker.this).trackEvent(Long.parseLong("1000"), "Start");
//				startActivity(new Intent(SampleCoffeeMaker.this, SampleMakeCoffee.class));
//			}
//		});
	}
	//
	// Menu
	//

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_coffee_maker, menu);
		return true;
	}

	@Override
	protected void onResume()
	{
		super.onResume();

	}
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
		int xy[] = new int[2];
		//but.getLocationInWindow(xy);
		Button but = (Button) findViewById(R.id.btnShowList);


		but.getLocationOnScreen(xy);
		int h = but.getHeight();
		int ha = but.getMeasuredHeight();
		leftpos = xy[0];
		toppos = xy[1];
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.menu_coffee_settings) {
			startActivity(new Intent(this, SampleSettings.class));
			return true;
		}

		return false;
	}
	public void showList(View view)
	{
		Intent list = new Intent(this,ManyActivity.class);
		startActivity(list);
	}

	public void closeindow(View view)
	{
		A4S.get(this).setView("XXX");
	}

	private class CheckForEvents implements Runnable {
		// This does
		Context c;

		public CheckForEvents(Context c)
		{
			this.c = c;
		}

		@Override
		public void run() {
			// this code is in a thread for when we manage message prioritys
			// because we will need to wait for a call back
			A4S.get(c).trackEvent(1001, "Comments");
			A4S.get(c).trackEvent(1002, "Comments");
			A4S.get(c).trackEvent(1003, "Comments");
			//
			// Set Screen position , Field contents do not seem to be available here
			A4S.get(c).setInAppReadyCallback(false, new A4S.Callback<InApp>()
			{
				@Override
				public void onResult(InApp inApp)
				{
					//
					HashMap<String,String> s = inApp.getCustomParameters();
					//
					if(inApp.getDisplayTemplate().contains("a4s_info"))
					{
						FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP);
						params.setMargins(40, 400, 0, 0);
						A4S.get(getApplicationContext()).setOverlayPosition(params);
					}
				}

				@Override
				public void onError(int i, String s)
				{

				}
			});

			A4S.get(c).setInAppDisplayedCallback(new A4S.Callback<InApp>(){

				@Override
				public void onResult(InApp inApp)
				{
//	Test dynamic settings code is ok
//					HashMap<String,String> sss = inApp.getCustomParameters();
//					TextView tvbody = (TextView) ((SampleCoffeeMaker) c).findViewById(R.id.textViewDF1);
//					tvbody.setText("This message has been modified in code");
//					//
//					Display display = getWindowManager().getDefaultDisplay();
//					// Need to measure parent first
//					View s2 = findViewById(R.id.msg_block); // Screen is a container layout
//					s2.measure(display.getWidth(), display.getHeight());
//					View c = findViewById(R.id.textViewDF1);
//					int w = c.getMeasuredWidth();
//					// Get real density this is probably better for conversion
//					float den = c.getResources().getDisplayMetrics().density;
//					// Convert to DP
//					DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
//					int dp = Math.round(c.getMeasuredWidth() / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
//					String s = "ss";
				}

				@Override
				public void onError(int i, String s)
				{

				}
			});


		}

	}
}
