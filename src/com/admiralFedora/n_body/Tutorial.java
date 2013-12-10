package com.admiralFedora.n_body;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ccpa.n_body.R;

public class Tutorial extends Activity {
	ImageButton enterSimul;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.tutorial);
		ActionBar actionbar = getActionBar();
		actionbar.setTitle(" ");
		actionbar.setDisplayHomeAsUpEnabled(true);

		enterSimul = (ImageButton) findViewById(R.id.enterSimul);
		
		enterSimul.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(arg0.getContext(),OpenGL.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				Toast.makeText(arg0.getContext(),"Check out the settings page for more fun!", Toast.LENGTH_LONG).show();
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