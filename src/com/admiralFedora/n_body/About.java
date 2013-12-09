package com.admiralFedora.n_body;

import com.ccpa.n_body.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.about);
	}
	
}