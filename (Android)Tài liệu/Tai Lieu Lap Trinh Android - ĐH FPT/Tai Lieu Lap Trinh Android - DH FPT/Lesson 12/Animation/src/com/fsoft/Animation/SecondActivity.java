package com.fsoft.Animation;

import com.fsoft.Animation.FirstActivity.MyGestureDetector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import android.view.GestureDetector.SimpleOnGestureListener;


public class SecondActivity extends Activity
{
	private static final int SWIPE_MIN_DISTANCE = 50;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 50;
	private GestureDetector gestureDetector;
	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.second );
        gestureDetector = new GestureDetector(new MyGestureDetector());
        View mainview = (View) findViewById(R.id.mainView2);
        
        // Set the touch listener for the main view to be our custom gesture listener
        mainview.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });
	}
	class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	        	Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
        	
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                return false;
            }
            
            // right to left swipe
            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
    				startActivity(intent);
    				
      				overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
    			// right to left swipe
            }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
    				startActivity(intent);
  
    				overridePendingTransition( R.anim.slide_in_left, R.anim.slide_out_left );
            }

            return false;
        }
        
        // It is necessary to return true from onDown for the onFling event to register
        @Override
        public boolean onDown(MotionEvent e) {
	        	return true;
        }

    }
	private void goBack()
	{
		finish();
		overridePendingTransition( R.anim.slide_in_right, R.anim.slide_out_right );
	}

	@Override
	public boolean onKeyUp( int keyCode, KeyEvent event )
	{
		if( keyCode == KeyEvent.KEYCODE_BACK )
		{
			goBack();
			return true;
		}
		return super.onKeyUp( keyCode, event );
	}
}
