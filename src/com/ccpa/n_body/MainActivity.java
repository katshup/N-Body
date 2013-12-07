package com.ccpa.n_body;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button nextButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		nextButton = (Button) findViewById(R.id.button1);

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
