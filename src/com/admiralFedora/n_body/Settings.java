package com.admiralFedora.n_body;

import java.util.Random;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.arshajii.nbody.backend.Const;
import com.ccpa.n_body.R;

public class Settings extends Activity{
	Random rand = new Random();
	
	SeekBar gravConstant;
	SeekBar massSize;
	CheckBox uniformSize, uniformColor, realism;
	ImageButton enterSimul, reset, colorSchemeButt, uniSizeButt, realismButt;
	// this will let us keep track of where we came from
	String activity;
	// have this variable prevents us from getting stuck in a screen loop
	boolean comeFromGL = false;
	
	@Override
	public void onBackPressed(){
		// we need to force the menu in OpenGL to be created again when we leave settings
		if(activity.equals("OpenGL") && !comeFromGL)
		{
			comeFromGL = true;
			Intent intent = new Intent(getApplicationContext(),OpenGL.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
		else
		{
			super.onBackPressed();
		}
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			Intent intent = getIntent();
			activity = intent.getStringExtra("activity");
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
			ActionBar actionbar = getActionBar();
			actionbar.setTitle(" ");
			actionbar.setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.settings);

		gravConstant = (SeekBar) findViewById(R.id.gravConstant);
		massSize = (SeekBar) findViewById(R.id.massSize);
		uniformSize = (CheckBox) findViewById(R.id.uniformSize);
		uniformColor = (CheckBox) findViewById(R.id.uniformColor);
		enterSimul = (ImageButton) findViewById(R.id.enterSimul);
		reset = (ImageButton) findViewById(R.id.reset);
		colorSchemeButt = (ImageButton) findViewById(R.id.colorSchemeButt);
		uniSizeButt = (ImageButton) findViewById(R.id.uniSizeButt);
		realismButt = (ImageButton) findViewById(R.id.realismButt);
		realism = (CheckBox) findViewById(R.id.realism);
		
		if(Const.G == 6.67384E-11)
		{
			gravConstant.setProgress(00);
		}
		else if(Const.G == 6.67384E-10){
			gravConstant.setProgress(30);
		}
		else if(Const.G == 6.67384E-9){
			gravConstant.setProgress(50);
		}
		else if(Const.G == 6.67384E-8){
			gravConstant.setProgress(70);
		}
		else if(Const.G == 6.67384E-7){
			gravConstant.setProgress(100);
		}
		
		if(MyGLSurfaceView.size == 5)
		{
			massSize.setProgress(0);
		}
		else if(MyGLSurfaceView.size == 10){
			massSize.setProgress(15);
		}
		else if(MyGLSurfaceView.size == 15){
			massSize.setProgress(25);
		}
		else if(MyGLSurfaceView.size == 20){
			massSize.setProgress(35);
		}
		else if(MyGLSurfaceView.size == 25){
			massSize.setProgress(45);
		}
		else if(MyGLSurfaceView.size == 30){
			massSize.setProgress(55);
		}
		else if(MyGLSurfaceView.size == 35){
			massSize.setProgress(65);
		}
		else if(MyGLSurfaceView.size == 40){
			massSize.setProgress(75);
		}
		else if(MyGLSurfaceView.size == 45){
			massSize.setProgress(85);
		}
		else if(MyGLSurfaceView.size == 50){
			massSize.setProgress(100);
		}
		
		uniformSize.setChecked(globalVar.uniformSize);
		uniformColor.setChecked(globalVar.uniformColor);
		realism.setChecked(globalVar.realism);
		
		gravConstant.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(progress < 20)
				{
					Const.G = 6.67384E-11;
				}
				else if(progress >= 20 && progress < 40){
					Const.G = 6.67384E-10;
				}
				else if(progress >= 40 && progress < 60){
					Const.G = 6.67384E-9;
				}
				else if(progress >= 60 && progress < 80){
					Const.G = 6.67384E-8;
				}
				else if(progress >= 80 && progress <= 100){
					Const.G = 6.67384E-7;
				}
				
			}
	
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"Gravity Constant set to "+String.valueOf(Const.G), (Toast.LENGTH_SHORT)/2).show();
			}
		});
		
		massSize.setOnSeekBarChangeListener( new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if(progress < 10)
				{
					MyGLSurfaceView.size = 5;
				}
				else if(progress >= 10 && progress < 20){
					MyGLSurfaceView.size = 10;
				}
				else if(progress >= 20 && progress < 30){
					MyGLSurfaceView.size = 15;
				}
				else if(progress >= 30 && progress < 40){
					MyGLSurfaceView.size = 20;
				}
				else if(progress >= 40 && progress <= 50){
					MyGLSurfaceView.size = 25;
				}
				else if(progress >= 50 && progress <= 60){
					MyGLSurfaceView.size = 30;
				}
				else if(progress >= 60 && progress <= 70){
					MyGLSurfaceView.size = 35;
				}
				else if(progress >= 70 && progress <= 80){
					MyGLSurfaceView.size = 40;
				}
				else if(progress >= 80 && progress <= 90){
					MyGLSurfaceView.size = 45;
				}
				else if(progress >= 90 && progress <= 100){
					MyGLSurfaceView.size = 50;
				}
			}
	
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),"Mass size set to "+String.valueOf((MyGLSurfaceView.size)/5), (Toast.LENGTH_SHORT)/2).show();
			}
		});
		
		uniformSize.setOnCheckedChangeListener( new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				globalVar.uniformSize = isChecked;
			}
			
		});
		
		uniformColor.setOnCheckedChangeListener( new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				globalVar.uniformColor = isChecked;
				if(globalVar.uniformColor)
				{
					globalVar.colorRed = (rand.nextFloat());
					globalVar.colorGreen = (rand.nextFloat());
					globalVar.colorBlue = (rand.nextFloat());
				}
			}
			
		});
		
		realism.setOnCheckedChangeListener( new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				globalVar.realism = isChecked;
				if(globalVar.realism){
					globalVar.distSCALEUP = (float) Math.pow(10, 4);
					globalVar.distSCALEDOWN = (float) Math.pow(10,-4);
					globalVar.massSCALE = (float) Math.pow(10, 13);
					Const.SOFT = 1;
					Const.dT = 21600;
					MyGLSurfaceView.VSCALE = 4E3f;
					Toast.makeText(getApplicationContext(),"Realism mode is on.", (Toast.LENGTH_SHORT)/2).show();
				}
				else {
					globalVar.distSCALEUP = 1f;
					globalVar.distSCALEDOWN = 1f;
					globalVar.massSCALE = (float) Math.pow(10, 2);
					Const.SOFT = 3E3;
					Const.dT = 86400;
					MyGLSurfaceView.VSCALE = 2E8f;
					Toast.makeText(getApplicationContext(),"Realism mode is off.", (Toast.LENGTH_SHORT)/2).show();
				}
				MyGLRenderer.changeWalls();
			}
				
		});
		
		
		enterSimul.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(arg0.getContext(),OpenGL.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				
			}
			
		});
		
		reset.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Const.G = 6.67384E-9;
				MyGLSurfaceView.size = 10;
				globalVar.uniformSize = false;
				globalVar.uniformColor = false;
				uniformSize.setChecked(globalVar.uniformSize);
				uniformColor.setChecked(globalVar.uniformColor);
				gravConstant.setProgress(50);
				massSize.setProgress(15);
				Toast.makeText(getApplicationContext(),"The settings have been reverted back to default.", (Toast.LENGTH_SHORT)/2).show();
			}
			
		});
		
		colorSchemeButt.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(globalVar.uniformColor){
					uniformColor.setChecked(false);
				}
				else
				{
					uniformColor.setChecked(true);
				}
				
			}
		});
		
		uniSizeButt.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(globalVar.uniformSize){
					uniformSize.setChecked(false);
				}
				else
				{
					uniformSize.setChecked(true);
				}
				
			}
		});
		
		realismButt.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(globalVar.realism){
					realism.setChecked(false);
				}
				else
				{
					realism.setChecked(true);
				}
				
			}
		});
	}
}

