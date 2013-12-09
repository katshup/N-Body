package com.ccpa.n_body;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Tutorial extends Activity {
	ImageButton enterSimul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.tutorial);

		enterSimul = (ImageButton) findViewById(R.id.enterSimul);
		
		enterSimul.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent goToNextActivity = new Intent(arg0.getContext(),
						OpenGL.class);
				startActivity(goToNextActivity);
			}

		});

	}
}