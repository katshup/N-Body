package com.admiralFedora.n_body;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ccpa.n_body.R;


public class License extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		ActionBar actionbar = getActionBar();
		actionbar.setTitle(" ");
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.license);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case android.R.id.home:
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}