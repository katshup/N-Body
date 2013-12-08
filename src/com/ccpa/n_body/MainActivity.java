package com.ccpa.n_body;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	ImageButton nextButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		setContentView(R.layout.getstarted_fullscreen);

		nextButton = (ImageButton) findViewById(R.id.start);

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

				Intent goToNextActivity = new Intent(arg0.getContext(),
						OpenGL.class);
				startActivity(goToNextActivity);
			}
		});
	}

}
