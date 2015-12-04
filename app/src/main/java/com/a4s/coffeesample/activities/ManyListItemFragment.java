package com.a4s.coffeesample.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a4s.coffeesample.R;

public class ManyListItemFragment extends Fragment {

    private final static String TAG = ManyListItemFragment.class.getSimpleName();
    private final static String COUNT = "COUNT";

    private static int viewsCreated = 0;

    public ManyListItemFragment(){
        setArguments(new Bundle());
    }

    private TextView count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sis) {
        super.onCreateView(inflater, container, sis); // I want LoggedFragment's side effect
        View view;
        // Multi Layout
            String fdtype = getArguments().getString("fdtype");
            if (fdtype=="Happy Hour" )
        {
             view = inflater.inflate(R.layout.many_fragments_list_item_a4s, container, false);
        }
        else
        {
            view = inflater.inflate(R.layout.many_fragments_list_item, container, false);
        }
        count = TextView.class.cast(view.findViewById(R.id.count));
        Log.i(TAG, "viewsCreated=" + (++viewsCreated));
        updateUi();
        return view;
    }

    private void updateUi(){
        if (count!=null)
            count.setText(""+getCount());
    }

    public int getCount(){
        return getArguments().getInt(COUNT);
    }

    public void setCount(int count){
        getArguments().putInt(COUNT,count);
        updateUi();
    }
}
