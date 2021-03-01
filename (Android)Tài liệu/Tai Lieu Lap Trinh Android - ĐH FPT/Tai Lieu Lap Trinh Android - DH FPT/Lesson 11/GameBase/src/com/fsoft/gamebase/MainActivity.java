package com.fsoft.gamebase;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.fsoft.gamebase.AnimationView.AnimationThread;

public class MainActivity extends Activity {
	
    private static final int MENU_PAUSE = 4;
    private static final int MENU_RESUME = 5;
    private static final int MENU_CLEAR = 6;
    private static final int MENU_STOP = 7;
        
	private AnimationThread mAnimationThread;
	private AnimationView mAnimationView;
	
	 /**
     * Invoked during init to give the Activity a chance to set up its Menu.
     * 
     * @param menu the Menu to which entries may be added
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, MENU_CLEAR, 0, R.string.menu_clear);
        menu.add(0, MENU_STOP, 0, R.string.menu_exit);
        menu.add(0, MENU_PAUSE, 0, R.string.menu_pause);
        menu.add(0, MENU_RESUME, 0, R.string.menu_resume);

        return true;
    }

    /**
     * Invoked when the user selects an item from the Menu.
     * 
     * @param item the Menu entry which was selected
     * @return true if the Menu item was legit (and we consumed it), false
     *         otherwise
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_CLEAR:
                mAnimationThread.clearSprites();
                return true;
            case MENU_STOP:
            	finish();
                return true;
            case MENU_PAUSE:
            	mAnimationThread.pause();
                return true;
            case MENU_RESUME:
            	mAnimationThread.unpause();
                return true;
        }

        return false;
    }
    
	
    /**
     * Invoked when the Activity is created.
     * 
     * @param savedInstanceState a Bundle containing state saved from a previous
     *        execution, or null if this is a new execution
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // tell system to use the layout defined in our XML file
        setContentView(R.layout.main);

        // get handles to the LunarView from XML, and its LunarThread
        mAnimationView = (AnimationView) findViewById(R.id.aview);
        mAnimationThread = mAnimationView.getThread();

        // give the LunarView a handle to the TextView used for messages
        mAnimationView.setTextView((TextView) findViewById(R.id.text));

        if (savedInstanceState == null) {
            // we were just launched: set up a new game
        	mAnimationThread.setState(AnimationThread.STATE_READY);
            Log.w(this.getClass().getName(), "SIS is null");
        } else {
            // we are being restored: resume a previous game
        	mAnimationThread.restoreState(savedInstanceState);
            Log.w(this.getClass().getName(), "SIS is nonnull");
        }
    }

    /**
     * Invoked when the Activity loses user focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mAnimationView.getThread().pause(); // pause game when Activity pauses
    }

    /**
     * Notification that something is about to happen, to give the Activity a
     * chance to save state.
     * 
     * @param outState a Bundle into which this Activity should save its state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // just have the View's thread save its state into our Bundle
        super.onSaveInstanceState(outState);
        mAnimationThread.saveState(outState);
        Log.w(this.getClass().getName(), "SIS called");
    }
}