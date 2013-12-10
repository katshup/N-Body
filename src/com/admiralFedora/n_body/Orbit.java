package com.admiralFedora.n_body;

import com.ccpa.n_body.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Orbit extends Activity {

	ImageButton nextButton;
	ImageButton settingsButton;
	ImageButton aboutButton;
	ImageButton tutorialButton;

	@Override
	public void onBackPressed(){
		android.os.Process.killProcess(android.os.Process.myPid());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// this toggles full screen
		/*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  */
		
		setContentView(R.layout.getstarted_fullscreen);

		nextButton = (ImageButton) findViewById(R.id.start);
		settingsButton = (ImageButton) findViewById(R.id.settings);
		aboutButton = (ImageButton) findViewById(R.id.about);
		tutorialButton = (ImageButton)findViewById(R.id.tutorial);
		
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(arg0.getContext(),OpenGL.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		tutorialButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(arg0.getContext(),Tutorial.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		
		settingsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(arg0.getContext(),Settings.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.putExtra("activity", "mainMenu");
				startActivity(intent);
			}
		});
		aboutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(arg0.getContext(),About.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}

}
