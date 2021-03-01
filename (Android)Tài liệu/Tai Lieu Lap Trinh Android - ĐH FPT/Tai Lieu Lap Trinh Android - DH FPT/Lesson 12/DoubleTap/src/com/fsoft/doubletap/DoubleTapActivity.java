
package com.fsoft.doubletap;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

//Implement this interface to be notified when a gesture occurs
public class DoubleTapActivity extends Activity implements OnGestureListener 
{
	//creates a Gesture Detector
	private GestureDetector gd;
	
	//a TextView object
	private TextView tvTap;
	//another TextView object
	private TextView tvTapEvent;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //get the TextView from the XML file
        tvTap = (TextView)findViewById(R.id.tvTap);
        //get the other TextView from the XML file
        tvTapEvent = (TextView)findViewById(R.id.tvTapEvent);
        
        //initialize the Gesture Detector
        gd = new GestureDetector(this);
        
        //set the on Double tap listener
        gd.setOnDoubleTapListener(new OnDoubleTapListener()
        {
			@Override
			public boolean onDoubleTap(MotionEvent e) 
			{
				//set text color to green
				tvTap.setTextColor(0xff00ff00);
				//print a confirmation message
				tvTap.setText("The screen has been double tapped.");
				return false;
			}

			@Override
			public boolean onDoubleTapEvent(MotionEvent e) 
			{
				//if the second tap hadn't been released and it's being moved
				if(e.getAction() == MotionEvent.ACTION_MOVE)
				{
					//set text to blue
					tvTapEvent.setTextColor(0xff0000ff);
					//print a confirmation message and the position
					tvTapEvent.setText("Double tap with movement. Position:\n" 
							+ "X:" + Float.toString(e.getRawX()) +
							"\nY: " + Float.toString(e.getRawY()));
				}
				else if(e.getAction() == MotionEvent.ACTION_UP)//user released the screen
				{
					tvTapEvent.setText("");
				}
				return false;
			}

			@Override
			public boolean onSingleTapConfirmed(MotionEvent e) 
			{
				//set text color to red
				tvTap.setTextColor(0xffff0000);
				//print a confirmation message and the tap position
				tvTap.setText("Double tap failed. Please try again.");
				return false;
			}
        });
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		return gd.onTouchEvent(event);//return the double tap events
	}

	@Override
	public boolean onDown(MotionEvent e) 
	{
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) 
	{
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) 
	{
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) 
	{
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) 
	{
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) 
	{
		return false;
	}
}