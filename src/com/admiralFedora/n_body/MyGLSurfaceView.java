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
package com.admiralFedora.n_body;

import java.util.Random;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * A view container where OpenGL ES graphics can be drawn on screen. This view
 * can also be used to capture touch events, such as a user interacting with
 * drawn objects.
 */
public class MyGLSurfaceView extends GLSurfaceView {

	Random n = new Random();
	// the user picks the size. defaults to 10
	public static int size = 10;
	private static final float VSCALE = 2E8f;

	GestureDetector gestureDetector;
	Context context;

	public MyGLSurfaceView(Context context) {
		this(context, null);
	}

	public MyGLSurfaceView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyGLSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);

		// Tell EGL to use a ES 1.0 Context
		setEGLContextClientVersion(1);
		//setEGLConfigChooser(new MultisampleConfigChooser());

		setRenderer(new MyGLRenderer());
		setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);

		gestureDetector = new GestureDetector(context, new GestureListener(this));
		// gestureDetector.setOnDoubleTapListener(this);
	}

	/* touch events */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		//Log.d("OnTouchEvent","touch");
		return this.gestureDetector.onTouchEvent(e);
	}


	private class GestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
		private MyGLSurfaceView view;

		public GestureListener(MyGLSurfaceView view) {
			// TODO Auto-generated constructor stub
			this.view = view;
		}

		@Override
		public void onLongPress(MotionEvent e) {
			if(!globalVar.uniformSize){
				if(!globalVar.uniformColor){
					//                                        SCALE        Red                 Green               Blue
					MyGLRenderer.addCircle(e.getX(), e.getY(), size+(((n.nextFloat()))*10), ((n.nextFloat()))*2, ((n.nextFloat()))/4, ((n.nextFloat()))/4, true);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e.getX(), e.getY(), size+(((n.nextFloat()))*10), globalVar.colorRed*2, globalVar.colorGreen/4, globalVar.colorBlue/4, true);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
			else
			{
				if(!globalVar.uniformColor){
					MyGLRenderer.addCircle(e.getX(), e.getY(),size+(((n.nextFloat()))*10), ((n.nextFloat()))*2, ((n.nextFloat()))/4, ((n.nextFloat()))/4, true);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e.getX(), e.getY(), size+(((n.nextFloat()))*10), globalVar.colorRed*2, globalVar.colorGreen/4, globalVar.colorBlue/4, true);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
		}
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			Log.d("OnFling",String.valueOf(velocityX));
			if(!globalVar.uniformSize){
				if(!globalVar.uniformColor){
					//                                                                                      SCALE                           Red                 Green               Blue
					MyGLRenderer.addCircle(e1.getX(), e1.getY(), velocityX / VSCALE, velocityY / VSCALE, ((n.nextFloat() * size) + 3), ((n.nextFloat()))/4, ((n.nextFloat())), ((n.nextFloat())));
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e1.getX(), e1.getY(), velocityX / VSCALE, velocityY / VSCALE, ((n.nextFloat() * size) + 3), globalVar.colorRed/4, globalVar.colorGreen, globalVar.colorBlue);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
			else
			{
				if(!globalVar.uniformColor){
					MyGLRenderer.addCircle(e1.getX(), e1.getY(), velocityX / VSCALE, velocityY / VSCALE, size+3, ((n.nextFloat()))/4, ((n.nextFloat())), ((n.nextFloat())));
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e1.getX(), e1.getY(), velocityX / VSCALE, velocityY / VSCALE, size+3, globalVar.colorRed/4, globalVar.colorGreen, globalVar.colorBlue);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
			return true; 
		}

		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
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
			if(!globalVar.uniformSize){
				if(!globalVar.uniformColor){
					//                                             SCALE                           Red                 Green               Blue
					MyGLRenderer.addCircle(e.getX(), e.getY(), ((n.nextFloat() * size) + 3), ((n.nextFloat()))/4, ((n.nextFloat())), ((n.nextFloat())));
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e.getX(), e.getY(), ((n.nextFloat() * size) + 3), globalVar.colorRed/4, globalVar.colorGreen, globalVar.colorBlue);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
			else
			{
				if(!globalVar.uniformColor){
					MyGLRenderer.addCircle(e.getX(), e.getY(), size+3, ((n.nextFloat()))/4, ((n.nextFloat())), ((n.nextFloat())));
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
				else
				{
					MyGLRenderer.addCircle(e.getX(), e.getY(), size+3, globalVar.colorRed/4, globalVar.colorGreen, globalVar.colorBlue);
					//Log.d("Circle", e.getX() + ", " + e.getY());
					requestRender();
				}
			}
			return true;
		}
	}
}
