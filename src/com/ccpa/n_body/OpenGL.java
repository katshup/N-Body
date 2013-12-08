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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Button;

public class OpenGL extends Activity {

	// private GLSurfaceView mGLView;
	Button nextButton2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.open_gl_view);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		/*
		 * nextButton2 = (Button) findViewById(R.id.button1); // Create a
		 * GLSurfaceView instance and set it // as the ContentView for this
		 * Activity // mGLView = new MyGLSurfaceView(this);
		 * 
		 * nextButton2.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { Intent goToNextActivity =
		 * new Intent(arg0.getContext(), CompassMode.class);
		 * 
		 * startActivity(goToNextActivity); } });
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.remove_last:
			MyGLRenderer.removeLast();
			break;
		case R.id.clear:
			MyGLRenderer.clear();
			break;
		case R.id.pause:
			MyGLRenderer.togglePaused();
			//R.id.pause.setText("derp");
			break;
		case R.id.back_main:
			MyGLRenderer.clear();
			startActivity(new Intent(this, MainActivity.class));
			break;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}

}