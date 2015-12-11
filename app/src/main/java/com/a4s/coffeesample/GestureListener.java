/*
 * Created on 08/12/15, 17:36
 *
 * Copyright(c) 2015 PagesJaunes, SoLocal Group - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited. Proprietary and confidential
 *
 */
package com.a4s.coffeesample;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * //TODO : Add a class header comments
 * <p>
 * created on 08/12/15
 *
 * @author donnchafinlaypj
 * @version //TODO : add version
 */
public class GestureListener  extends GestureDetector.SimpleOnGestureListener
{
	public static String currentGestureDetected;

	// Override s all the callback methods of GestureDetector.SimpleOnGestureListener
	@Override
	public boolean onSingleTapUp(MotionEvent ev) {
		currentGestureDetected=ev.toString();

		return true;
	}
	@Override
	public void onShowPress(MotionEvent ev) {
		currentGestureDetected=ev.toString();

	}
	@Override
	public void onLongPress(MotionEvent ev) {
		currentGestureDetected=ev.toString();

	}
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		currentGestureDetected=e1.toString()+ "  "+e2.toString();

		return true;
	}
	@Override
	public boolean onDown(MotionEvent ev) {
		currentGestureDetected=ev.toString();

		return true;
	}
	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		currentGestureDetected=e1.toString()+ "  "+e2.toString();
		return true;
	}
}
