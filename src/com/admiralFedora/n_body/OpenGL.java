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

import com.ccpa.n_body.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class OpenGL extends Activity {

	Random rand = new Random();
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
		ActionBar actionbar = getActionBar();
		actionbar.setTitle(" ");
		actionbar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		MenuItem newColor = menu.getItem(2);
		// we can hide the new color option based on what the user has selected in the settings
		if(globalVar.uniformColor)
		{
			newColor.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			newColor.setVisible(true);
		}
		else
		{
			newColor.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
			newColor.setVisible(false);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			onBackPressed();
			break;
		case R.id.clear:
			MyGLRenderer.clear();
			break;
		case R.id.pause:
			MyGLRenderer.togglePaused();
			// dynamically changing the icons
			if(MyGLRenderer.paused)
			{
				item.setIcon(R.drawable.play_ico);
			}
			else
			{
				item.setIcon(R.drawable.pause_ico);
			}
			//R.id.pause.setText("derp");
			break;
		case R.id.newColor:
			if(globalVar.uniformColor){
			globalVar.colorRed = (rand.nextFloat());
			globalVar.colorGreen = (rand.nextFloat());
			globalVar.colorBlue = (rand.nextFloat());
			}
			else
			{
				// Ali please do a Toast here
				// Maybe move it to the Settings page
			}
			break;
		case R.id.settingsPage:
			Intent intent = new Intent(this,Settings.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			intent.putExtra("activity", "OpenGL");
			startActivity(intent);
			break;
		case R.id.endSimul:
			MyGLRenderer.clear();
			Intent intent2 = new Intent(this,MainActivity.class);
			intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent2);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}

		return true;
	}
	

}