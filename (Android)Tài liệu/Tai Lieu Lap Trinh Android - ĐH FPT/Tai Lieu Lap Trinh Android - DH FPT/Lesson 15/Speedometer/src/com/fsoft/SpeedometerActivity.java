package com.fsoft;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class SpeedometerActivity extends Activity {
	
	SensorManager sensorManager;
	TextView myTextView;

	float appliedAcceleration = 0;
	float currentAcceleration = 0;
	float velocity = 0;
	Date lastUpdate;

	Handler handler = new Handler();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myTextView = (TextView)findViewById(R.id.myTextView);
		lastUpdate = new Date(System.currentTimeMillis());

		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_FASTEST);

		Timer updateTimer = new Timer("velocityUpdate");
		updateTimer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				updateGUI();
			}
		}, 0, 1000);

    }
    
    private void updateVelocity() {
		// Calculate how long this acceleration has been applied.
		Date timeNow = new Date(System.currentTimeMillis());
		long timeDelta = timeNow.getTime()-lastUpdate.getTime();
		lastUpdate.setTime(timeNow.getTime());
		//Log.i("data", "timeDelta: " +timeDelta);
		// Calculate the change in velocity at the 
		// current acceleration since the last update. 
		float deltaVelocity = (float)(appliedAcceleration * timeDelta)/1000;
		appliedAcceleration = currentAcceleration;
		//Log.i("data", "appliedAcceleration: " +appliedAcceleration);
		// Add the velocity change to the current velocity.
		velocity = deltaVelocity;
		//Log.i("data", "velocity1: " +velocity);
	}
    private final SensorEventListener sensorListener = new SensorEventListener() {

		double calibration = Double.NaN;

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			double x = event.values[SensorManager.DATA_X];
			double y = event.values[SensorManager.DATA_Y];
			double z = event.values[SensorManager.DATA_Z];
			Log.i("data", "x:" +x + " y: " + y +" z: "+z);
			double a = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)); 
				
			if (calibration == Double.NaN)
				calibration = a;
			else {
				updateVelocity();
				currentAcceleration = (float)a;
				//Log.i("data", "velocity: " +velocity);
			}
		}
		
		
	};	
	private void updateGUI() {
		// Convert from meters per second to miles per hour.
		//final double mph = (Math.round(100*velocity / 1.6 *	3.6))/100;

		// Update the GUI
		handler.post(new Runnable() {
			public void run() {
				myTextView.setText(String.valueOf(velocity) + "mps");
			}
		});
	}

}