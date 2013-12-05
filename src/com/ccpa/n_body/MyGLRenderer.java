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

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES10;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.util.Log;

public class MyGLRenderer implements GLSurfaceView.Renderer { 
	 
	   /*  Called once to set up the view's OpenGL ES environment. */
	   public void onSurfaceCreated(GL10 gl, EGLConfig config) { 
	     gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 
	     gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
	     gl.glEnable(GL10.GL_DEPTH_TEST); 
	   } 

	   /* Called if the geometry of the view changes,
	    *  for example when the device's screen orientation changes.*/
	   public void onSurfaceChanged(GL10 gl, int width, int height) { 
	     gl.glViewport(0, 0, width, height); 
	     float aspect = (float)width / height; 
	     gl.glMatrixMode(GL10.GL_PROJECTION); 
	     gl.glLoadIdentity();
	     gl.glFrustumf(-aspect, aspect, -1.0f, 1.0f, 1.0f, 10.0f); 
	   } 


	   /* Called for each redraw of the view. */
	   public void onDrawFrame(GL10 gl) { 
 	 gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); 
	     gl.glMatrixMode(GL10.GL_MODELVIEW); 
	     gl.glLoadIdentity();

	     gl.glTranslatef(0.0f, 0.0f, -3.0f); 

	     Triangle tr = new Triangle();
	     tr.draw(gl);

	   } 
	  

}