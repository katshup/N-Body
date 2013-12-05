package com.ccpa.n_body;

import java.net.URL;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Compass_Mode extends Activity implements SensorEventListener, LocationListener {
 // this compass works by comparing the orientation of the phone to the orientation
 // of magnetic north
	float azimut;
	double windSpeed , direction;
	private SensorManager mSensorManager;
	private Sensor sensor;
	private LocationManager locationManager;
	private String provider;
	TextView ComMessage;
	TextView latitute;
	TextView longitude;
	String url;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compass__mode);
		// register the textbox for debugging
	    ComMessage = (TextView) findViewById(R.id.compassInfo);
	    latitute = (TextView) findViewById(R.id.latitute);
	    longitude = (TextView) findViewById(R.id.longitude);
	    
		// register the sensor listeners
		mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		sensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
		// initialize the sensors
	    if (sensor != null) {
	      mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	      Log.i("Compass MainActivity", "Registerered for ORIENTATION Sensor");

	    } else {
	      Log.e("Compass MainActivity", "Registerered for ORIENTATION Sensor");
	      Toast.makeText(this, "ORIENTATION Sensor not found",
	          Toast.LENGTH_LONG).show();
	      finish();
	    }
	    
	    // register the location manager
	    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    // define the criteria how to select the location provider
	    provider = locationManager.NETWORK_PROVIDER; // a general area is good enough so we can just use the network provider
	    Location location = locationManager.getLastKnownLocation(provider);
	    // Initialize the location fields
	    if (location != null){
	    	System.out.println("Provider " + provider + " has been selected.");
	    	onLocationChanged(location);
		    //url = "http://api.openweathermap.org/data/2.5/weather?lat="+String.valueOf(lat)+"&lon="+String.valueOf(lng)+"&APPID=19c8a9b7048067ba61114a1cb00e992e";
	    } else {
	    	latitute.setText("Location not available");
	    	longitude.setText("Location not available");
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compass__mode, menu);
		return true;
	}
	

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy){  }
		
	@Override
	public void onSensorChanged(SensorEvent event){
	//angle between the magnetic north direction
	// 0=North, 90=East, 180=South, 270=west
	azimut = event.values[0];
	ComMessage.setText(String.valueOf(azimut));
	};
	
	  /* Request updates of mag sensor at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
	    mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	    mSensorManager.unregisterListener(this);
	  }
	  @Override
	  public void onLocationChanged(Location location) {
		  /* we should only update location every 30 minutes */ 
		  double lat = (location.getLatitude());
		  double lng = (location.getLongitude());
		  latitute.setText(String.valueOf(lat));
		  longitude.setText(String.valueOf(lng));
	  }
	  
	  @Override
	  public void onStatusChanged(String provider, int status, Bundle extras) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void onProviderEnabled(String provider) {
	    Toast.makeText(this, "Enabled new provider " + provider,
	        Toast.LENGTH_SHORT).show();

	  }

	  @Override
	  public void onProviderDisabled(String provider) {
	    Toast.makeText(this, "Disabled provider " + provider,
	        Toast.LENGTH_SHORT).show();
	  }


	
	
	
	
}
