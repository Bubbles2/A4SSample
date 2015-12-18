package com.a4s.coffeesample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

@UseA4S
@Tag(name = "CoffeeMaker")
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

		A4S.get(this).putState("Happy","HappyHour");


		// Code to position message


//
//		A4S.get(this).setInAppReadyCallback(false, new A4S.Callback<InApp>()
//		{
//			@Override
//			public void onResult(InApp inApp)
//			{
//		//		if(inApp.getDisplayTemplate().contains("com_ad4screen")) {
//					if(inApp.getDisplayTemplate().contains("a4s_info")) {
//
//
//						FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//																				   ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP);
//
//						params.setMargins(leftpos,toppos,0,0);
//					//
//					//TextView tvbody = (TextView) findViewById(R.id.com_ad4screen_sdk_title);
//					//tvbody.setText("My Data");
//						TextView tv = (TextView) findViewById(R.id.textView);
//						int i = inApp.getContainer();
//
//						//TextView tvbody = (TextView)findViewById(inApp.getContainer()).findViewById(R.id.textView);
////						tvbody.setText("mother fucker");
//
//
//				//	A4S.get(getApplicationContext()).setOverlayPosition(params);
//				}
//
//
//			}
//
//			@Override
//			public void onError(int i, String s)
//			{
//
//			}
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
}
