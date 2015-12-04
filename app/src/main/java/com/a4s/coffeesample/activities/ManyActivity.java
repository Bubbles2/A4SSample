package com.a4s.coffeesample.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//
import com.a4s.sdk.plugins.annotations.UseA4S;

import com.a4s.coffeesample.R;
import com.ad4screen.sdk.A4S;

@UseA4S
public class ManyActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.many_fragments_activity);
        //
        //Unlock in-app and push notifications
        //Any waiting in app and rich push will be displayed
        A4S.get(this).setPushNotificationLocked(false);
        A4S.get(this).setInAppDisplayLocked(false);
    }
}
