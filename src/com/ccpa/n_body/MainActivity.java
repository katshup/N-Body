package com.ccpa.n_body;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	ImageButton nextButton;
	ImageButton settingsButton;
	ImageButton aboutButton;
	ImageButton tutorialButton;

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

				Intent goToNextActivity = new Intent(arg0.getContext(),
						OpenGL.class);
				startActivity(goToNextActivity);
			}
		});
		
		tutorialButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToNextActivity = new Intent(arg0.getContext(),
						Tutorial.class);
				startActivity(goToNextActivity);
			}
		});
		
		settingsButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToNextActivity = new Intent(arg0.getContext(),
						Settings.class);
				startActivity(goToNextActivity);
			}
		});
		aboutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent goToNextActivity = new Intent(arg0.getContext(),
						About.class);
				startActivity(goToNextActivity);
			}
		});
	}

}
