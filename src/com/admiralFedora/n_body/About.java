package com.admiralFedora.n_body;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.ccpa.n_body.R;


public class About extends Activity {

	ImageButton licenseButt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		ActionBar actionbar = getActionBar();
		actionbar.setTitle(" ");
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.about);
		
		licenseButt = (ImageButton) findViewById(R.id.licenseButt);
		licenseButt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(arg0.getContext(),License.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}

		});
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