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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;
import android.util.Log;

import com.arshajii.nbody.backend.Universe;
import com.arshajii.nbody.backend.Vec;

public class MyGLRenderer implements GLSurfaceView.Renderer {

	private static final List<BodyRendering> bodies = Collections
			.synchronizedList(new ArrayList<BodyRendering>());

	private static final Universe universe = new Universe();

	private static boolean paused = false;

	/* Called once to set up the view's OpenGL ES environment. */
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(.2f, .2f, .2f, 1.0f);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
		gl.glEnable(GL10.GL_DEPTH_TEST);
	}

	/*
	 * Called if the geometry of the view changes, for example when the device's
	 * screen orientation changes.
	 */
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		Log.d("Surface", width + ", " + height);
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(0, width, height, 0, -1, 1);

		universe.addWalls(width, 0, height, 0);
	}

	/* Called for each redraw of the view. */
	public void onDrawFrame(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();

		synchronized (bodies) {
			for (BodyRendering dr : bodies) {
				dr.draw(gl);
			}
		}

		if (!paused) {
			universe.step();
		}
	}

	public static void addCircle(float xPos, float yPos, float SCALE, float R, float G, float B) {
		bodies.add(new BodyRendering(universe, xPos, yPos, SCALE, R, G, B));
	}

	/*public static void addCircle(float xPos, float yPos) {
		addCircle(xPos, yPos, 0, 0);
	}*/

	public static void togglePaused() {
		paused = !paused;
	}

	public static void removeLast() {
		if (!bodies.isEmpty())
			bodies.remove(bodies.size() - 1);
	}

	public static void clear() {
		bodies.clear();
		universe.clear();
	}

	public void moveAll(float x, float y) {
		universe.moveAll(new Vec(x, y));
	}

}
