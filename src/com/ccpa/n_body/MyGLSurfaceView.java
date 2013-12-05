/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ccpa.n_body;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
//import android.view.MotionEvent;

/**
 * A view container where OpenGL ES graphics can be drawn on screen.
 * This view can also be used to capture touch events, such as a user
 * interacting with drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView implements 
		GestureDetector.OnGestureListener,
		GestureDetector.OnDoubleTapListener{
 
	GestureDetectorCompat gestureDetector;
	Context context;
	
    public MyGLSurfaceView(Context context){
        this(context, null);
    }

	public MyGLSurfaceView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		//gestureDetector = new GestureDetector(context, new GestureListener());
	}

	public MyGLSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		
		// Tell EGL to use a ES 1.0 Context
		setEGLContextClientVersion(1);
		// Set the renderer
		setRenderer(new MyGLRenderer());
		
		gestureDetector = new GestureDetectorCompat(context,this);
		gestureDetector.setOnDoubleTapListener(this);
	}
	/* touch events */
	@Override
	   public boolean onTouchEvent(MotionEvent e){
		   this.gestureDetector.onTouchEvent(e);
		   return super.onTouchEvent(e);
	   }

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		//Toast.makeText(context,"double Tap!",Toast.LENGTH_LONG).show();
		Log.d("Gestures","onLong: " + e.toString());
		//Intent goToNextActivity = new Intent(arg0.getContext(),Compass_Mode.class);
        //startActivity(goToNextActivity);
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}
