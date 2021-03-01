package com.fsoft;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class CompassActivity extends Activity {
	
	float pitch = 0;
	float roll = 0;
	float heading = 0;

	CompassView compassView;
	SensorManager sensorManager;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		compassView = (CompassView)this.findViewById(R.id.compassView);
		sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		updateOrientation(0, 0, 0);

    }
    private void updateOrientation(float _heading , float _pitch, float _roll) {
		heading = _heading;
		pitch = _pitch;
		roll = _roll;

		Log.i("data","rollz" + _roll + " pitchy: " + _pitch + " headingx " + _heading);
		if (compassView!= null) {
			compassView.setBearing(heading);
			compassView.setPitch(pitch);
			compassView.setRoll(roll);
			compassView.invalidate();
		}
	}
    private final SensorEventListener sensorListener = new SensorEventListener() {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			updateOrientation(event.values[SensorManager.DATA_X], 
					event.values[SensorManager.DATA_Y], 
					event.values[SensorManager.DATA_Z]);
		}
	};
	@Override
	protected void onResume()
	{
		super.onResume();
		sensorManager.registerListener(sensorListener,sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
				SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	protected void onStop()
	{
		sensorManager.unregisterListener(sensorListener);
		super.onStop();
	}


}