package com.ccpa.n_body;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.arshajii.nbody.backend.Const;

public class Settings extends Activity{
	Random rand = new Random();
	SeekBar gravConstant;
	SeekBar massSize;
	CheckBox uniformSize, uniformColor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		setContentView(R.layout.settings);

		gravConstant = (SeekBar) findViewById(R.id.gravConstant);
		massSize = (SeekBar) findViewById(R.id.massSize);
		uniformSize = (CheckBox) findViewById(R.id.uniformSize);
		uniformColor = (CheckBox) findViewById(R.id.uniformColor);
		
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
			massSize.setProgress(10);
		}
		else if(MyGLSurfaceView.size == 10){
			massSize.setProgress(20);
		}
		else if(MyGLSurfaceView.size == 15){
			massSize.setProgress(30);
		}
		else if(MyGLSurfaceView.size == 20){
			massSize.setProgress(40);
		}
		else if(MyGLSurfaceView.size == 25){
			massSize.setProgress(50);
		}
		else if(MyGLSurfaceView.size == 30){
			massSize.setProgress(60);
		}
		else if(MyGLSurfaceView.size == 35){
			massSize.setProgress(70);
		}
		else if(MyGLSurfaceView.size == 40){
			massSize.setProgress(80);
		}
		else if(MyGLSurfaceView.size == 45){
			massSize.setProgress(90);
		}
		else if(MyGLSurfaceView.size == 50){
			massSize.setProgress(100);
		}
		
		uniformSize.setChecked(globalVar.uniformSize);
		uniformColor.setChecked(globalVar.uniformColor);
		
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
	}
}

