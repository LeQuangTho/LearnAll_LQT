/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fsoft.gamebase;

import java.util.ArrayList;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;


/**
 * View that draws, takes keystrokes, etc. for a simple LunarLander game.
 * 
 * Has a mode which RUNNING, PAUSED, etc. Has a x, y, dx, dy, ... capturing the
 * current ship physics. All x/y etc. are measured with (0,0) at the lower left.
 * updatePhysics() advances the physics based on realtime. draw() renders the
 * ship, and does an invalidate() to prompt another draw() as soon as possible
 * by the system.
 */
class AnimationView extends SurfaceView implements SurfaceHolder.Callback {
    class AnimationThread extends Thread {
    	
        /*
         * Difficulty setting constants
         */
        public static final int DIFFICULTY_EASY = 0;
        public static final int DIFFICULTY_HARD = 1;
        public static final int DIFFICULTY_MEDIUM = 2;
        
        /*
         * State-tracking constants
         */
        public static final int STATE_LOSE = 1;
        public static final int STATE_PAUSE = 2;
        public static final int STATE_READY = 3;
        public static final int STATE_RUNNING = 4;
        public static final int STATE_WIN = 5;

        /*
         * UI constants 
         */
        private static final String KEY_DIFFICULTY = "mDifficulty";
        private static final String KEY_WINS = "mWinsInARow";
        
        /*
         * Member (state) fields
         */
        private Bitmap b;
        
        /** What to draw for the Lander when it has crashed */
        private ArrayList<AnimatedSprite> mSprites;
        private ArrayList<AnimatedSprite> mSpritestoRemove;
        
        /**
         * Current difficulty -- amount of fuel, allowed angle, etc. Default is
         * MEDIUM.
         */
        private int mDifficulty;

        /** Message handler used by thread to interact with TextView */
        private Handler mHandler;

        /** The state of the game. One of READY, RUNNING, PAUSE, LOSE, or WIN */
        private int mMode;

        /** Used to figure out elapsed time between frames */
        private long mLastTime;
        
        /** Indicate whether the surface has been created & is ready to draw */
        private boolean mRun = false;
       
        private int frameSamplesCollected = 0;
        private int frameSampleTime = 0;
        private int fps = 0;
        

        /** Handle to the surface manager object we interact with */
        private SurfaceHolder mSurfaceHolder;

        private Paint textPaint;
        
        /** Number of sprites drawed in a row. */
        private int numSprites;
        
        private Resources res;
        
        public AnimationThread(SurfaceHolder surfaceHolder, Context context, Handler handler) {
            // get handles to some important objects
            mSurfaceHolder = surfaceHolder;
            mHandler = handler;
            mContext = context;

            res = context.getResources();
            
            mSprites = new ArrayList<AnimatedSprite>();                        
            mSpritestoRemove = new ArrayList<AnimatedSprite>();
                        
            textPaint = new Paint();
            textPaint.setARGB(255,255,255,255);
            textPaint.setTextSize(16);
            
            numSprites = 0;
            mDifficulty = DIFFICULTY_MEDIUM;

        }

        @Override
        public void run() {
            while (mRun) {
                Canvas c = null;
                try {
                    c = mSurfaceHolder.lockCanvas(null);
                    synchronized (mSurfaceHolder) {
                    	
                        if (mMode == STATE_RUNNING) 
                        	updatePhysics();
                        
                        doDraw(c);
                    }
                } catch(Exception e){
                	System.out.println(e.getStackTrace());
                }finally {
                    // do this in a finally so that if an exception is thrown
                    // during the above, we don't leave the Surface in an
                    // inconsistent state
                    if (c != null) {
                        mSurfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
        
        
        /**
         * Draws to the provided Canvas.
         */
        private void doDraw(Canvas canvas) {
            // Draw the background image. Operations on the Canvas accumulate
            // so this is like clearing the screen.
            //canvas.drawBitmap(mBackgroundImage, 0, 0, null);
        	canvas.drawColor(Color.BLACK);
        	        	        	
        	for( AnimatedSprite a : mSprites){
        		a.draw(canvas);
        	}       		
        	
        	
        	if(mMode == STATE_RUNNING ){
	        	canvas.drawText(fps + " fps", getWidth() - 60, getHeight() - 40, textPaint);
	        	canvas.drawText(numSprites + " sprites", getWidth() - 60, getHeight() - 20, textPaint);
        	}
        	
        	canvas.restore();            
        }

        
        
        /**
         * Figures the lander state (x, y, fuel, ...) based on the passage of
         * realtime. Does not invalidate(). Called at the start of draw().
         * Detects the end-of-game and sets the UI to the next state.
         */
        private void updatePhysics() {
            long now = System.currentTimeMillis();
            
            // Do nothing if mLastTime is in the future.
            // This allows the game-start to delay the start of the physics
            // by 100ms or whatever.
            if (mLastTime > now) return;
            
            if (mLastTime != 0) {
        		int time = (int) (now - mLastTime);
        		frameSampleTime += time;
        		frameSamplesCollected++;
        		if (frameSamplesCollected == 10) {
	        		fps = (int) (10000 / frameSampleTime);
	        		frameSampleTime = 0;
	        		frameSamplesCollected = 0;
        		}        		
        	}
            
            synchronized(mSprites){
	            for( AnimatedSprite a : mSprites){
	            	a.Update(now);
	            	
	            	if(a.dispose)
	            		mSpritestoRemove.add(a);            	
	            }
            }
            
            synchronized(mSpritestoRemove){
	            mSprites.removeAll(mSpritestoRemove); 
	            mSpritestoRemove.clear();
            }
            
            numSprites = mSprites.size();
            mLastTime = now;

        }
        

        /**
         * Detected touch event
         * @param e
         */
        public void doTouch(MotionEvent event){
        	
        	int action = event.getAction();
            float x = event.getX();  // or getRawX();
            float y = event.getY();
            
            switch(action){
            case MotionEvent.ACTION_DOWN:
            	if(mMode != STATE_RUNNING)
            		setState(STATE_RUNNING);
            	else if(mMode == STATE_RUNNING){
            		
            		AnimatedSprite a = new AnimatedSprite();
            		
            		if(b == null)
            			b = BitmapFactory.decodeStream(res.openRawResource(R.drawable.explosion));
                                		
                    a.Initialize(b, 120, 160, 24, 20, true);
                    
            		a.setXPos((int)x);
            		a.setYPos((int)y);  
            		
            		synchronized(mSprites){
            			mSprites.add(a);
            		}
            	}            	
            	break;
            }
        }
        
     
        
        /**
         * Sets the game mode. That is, whether we are running, paused, in the
         * failure state, in the victory state, etc.
         * 
         * @param mode one of the STATE_* constants
         * @param message string to add to screen or null
         */
        public void setState(int mode, CharSequence message) {
            /*
             * This method optionally can cause a text message to be displayed
             * to the user when the mode changes. Since the View that actually
             * renders that text is part of the main View hierarchy and not
             * owned by this thread, we can't touch the state of that View.
             * Instead we use a Message + Handler to relay commands to the main
             * thread, which updates the user-text View.
             */
            synchronized (mSurfaceHolder) {
                mMode = mode;

                if (mMode == STATE_RUNNING) {
                    Message msg = mHandler.obtainMessage();
                    Bundle b = new Bundle();
                    b.putString("text", "");
                    b.putInt("viz", View.INVISIBLE);
                    msg.setData(b);
                    mHandler.sendMessage(msg);
                } else {
                   
                    Resources res = mContext.getResources();
                    CharSequence str = "";
                    if (mMode == STATE_READY)
                        str = res.getText(R.string.mode_ready);
                    else if (mMode == STATE_PAUSE)
                        str = res.getText(R.string.mode_pause);
                    else if (mMode == STATE_LOSE)
                        str = res.getText(R.string.mode_lose);
                    else if (mMode == STATE_WIN)
                        str = res.getString(R.string.mode_win_prefix)
                                + numSprites + " "
                                + res.getString(R.string.mode_win_suffix);

                    if (message != null) {
                        str = message + "\n" + str;
                    }

                    if (mMode == STATE_LOSE) numSprites = 0;

                    Message msg = mHandler.obtainMessage();
                    Bundle b = new Bundle();
                    b.putString("text", str.toString());
                    b.putInt("viz", View.VISIBLE);
                    msg.setData(b);
                    mHandler.sendMessage(msg);
                }
            }
        }
        
        /**
         * Dump game state to the provided Bundle. Typically called when the
         * Activity is being suspended.
         * 
         * @return Bundle with this view's state
         */
        public Bundle saveState(Bundle map) {
            synchronized (mSurfaceHolder) {
                if (map != null) {
                    map.putInt(KEY_DIFFICULTY, Integer.valueOf(mDifficulty));                    
                    map.putInt(KEY_WINS, Integer.valueOf(numSprites));
                }
            }
            return map;
        }

        /**
         * Sets the current difficulty.
         * 
         * @param difficulty
         */
        public void setDifficulty(int difficulty) {
            synchronized (mSurfaceHolder) {
                mDifficulty = difficulty;
            }
        }

        /**
         * Used to signal the thread whether it should be running or not.
         * Passing true allows the thread to run; passing false will shut it
         * down if it's already running. Calling start() after this was most
         * recently called with false will result in an immediate shutdown.
         * 
         * @param b true to run, false to shut down
         */
        public void setRunning(boolean b) {
            mRun = b;
        }

        /**
         * Sets the game mode. That is, whether we are running, paused, in the
         * failure state, in the victory state, etc.
         * 
         * @see #setState(int, CharSequence)
         * @param mode one of the STATE_* constants
         */
        public void setState(int mode) {
            synchronized (mSurfaceHolder) {
                setState(mode, null);
            }
        }

        /* Callback invoked when the surface dimensions change. */
        public void setSurfaceSize(int width, int height) {
            // synchronized to make sure these all change atomically
            synchronized (mSurfaceHolder) {


            }
        }

        /**
         * Resumes from a pause.
         */
        public void unpause() {
            // Move the real time clock up to now
            synchronized (mSurfaceHolder) {
                mLastTime = System.currentTimeMillis() + 100;
            }
            setState(STATE_RUNNING);
        }
        
        /**
         * Starts the game, setting parameters for the current difficulty.
         */
        public void doStart() {
            synchronized (mSurfaceHolder) {               
                mLastTime = System.currentTimeMillis() + 100;
                setState(STATE_RUNNING);
            }
        }

        /**
         * Pauses the physics update & animation.
         */
        public void pause() {
            synchronized (mSurfaceHolder) {
                if (mMode == STATE_RUNNING) setState(STATE_PAUSE);
            }
        }

        /**
         * Restores game state from the indicated Bundle. Typically called when
         * the Activity is being restored after having been previously
         * destroyed.
         * 
         * @param savedState Bundle containing the game state
         */
        public synchronized void restoreState(Bundle savedState) {
            synchronized (mSurfaceHolder) {
                setState(STATE_PAUSE);         

                mDifficulty = savedState.getInt(KEY_DIFFICULTY);               
                numSprites = savedState.getInt(KEY_WINS);
            }
        }

		public void clearSprites() {
			synchronized(mSprites){
				mSprites.clear();			
			}
		}

        


        
    }

    /** Handle to the application context, used to e.g. fetch Drawables. */
    private Context mContext;

    /** Pointer to the text view to display "Paused.." etc. */
    private TextView mStatusText;

    /** The thread that actually draws the animation */
    private AnimationThread thread;

    public AnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // register our interest in hearing about changes to our surface
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        // create thread only; it's started in surfaceCreated()
        thread = new AnimationThread(holder, context, new Handler() {
            @Override
            public void handleMessage(Message m) {
                mStatusText.setVisibility(m.getData().getInt("viz"));
                mStatusText.setText(m.getData().getString("text"));
            }
        });

        setFocusable(true); // make sure we get key events
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event){
    	thread.doTouch(event);
    	return super.onTouchEvent(event);
    }
    
    /**
     * Fetches the animation thread corresponding to this LunarView.
     * 
     * @return the animation thread
     */
    public AnimationThread getThread() {
        return thread;
    }

    /**
     * Standard window-focus override. Notice focus lost so we can pause on
     * focus lost. e.g. user switches to take a call.
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (!hasWindowFocus) thread.pause();
    }

    /**
     * Installs a pointer to the text view used for messages.
     */
    public void setTextView(TextView textView) {
        mStatusText = textView;
    }

    /* Callback invoked when the surface dimensions change. */
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        thread.setSurfaceSize(width, height);
    }

    /*
     * Callback invoked when the Surface has been created and is ready to be
     * used.
     */
    public void surfaceCreated(SurfaceHolder holder) {
        // start the thread here so that we don't busy-wait in run()
        // waiting for the surface to be created
        thread.setRunning(true);
        thread.start();
    }

    /*
     * Callback invoked when the Surface has been destroyed and must no longer
     * be touched. WARNING: after this method returns, the Surface/Canvas must
     * never be touched again!
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        // we have to tell thread to shut down & wait for it to finish, or else
        // it might touch the Surface after we return and explode
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}
