package com.fsoft.samples.singletouch;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import android.graphics.Matrix;

import android.util.Log;
import android.view.GestureDetector;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;


public class SingletouchView extends View {
	private static final String DEBUG_TAG =	  "SimpleGesture->GameAreaView";
	  private GestureDetector gestures;
	  private Matrix translate;
	  private Bitmap droid;
	  private Matrix animateStart;
	  private OvershootInterpolator animateInterpolator;
	  private long startTime;
	  private long endTime;
	  private float totalAnimDx;
	  private float totalAnimDy;
	 
	  public SingletouchView(Context context, int iGraphicResourceId) {
		  super(context);
		  translate = new Matrix();
		  GestureListener listener = new GestureListener(this);
		  gestures = new GestureDetector(context, listener, null, true);
		  droid = BitmapFactory.decodeResource(getResources(),  iGraphicResourceId);
	  }
	  
	  @Override
	  public boolean onTouchEvent(MotionEvent event) {
		  boolean retVal = false;
		  
		  retVal = gestures.onTouchEvent(event);
		  return retVal;
	  }
	  
	  @Override
	  protected void onDraw(Canvas canvas) {
		  Log.v(DEBUG_TAG, "onDraw");
		  canvas.drawBitmap(droid, translate, null);
	  }
	  public void onResetLocation() {
		  translate.reset();
		  invalidate();
	  }
	  
	  public void onMove(float dx, float dy) {
		  translate.postTranslate(dx, dy);
		  invalidate();
	  }
	  public void onAnimateMove(float dx, float dy, long duration) {
		 
		  animateStart = new Matrix(translate);
		  animateInterpolator = new OvershootInterpolator();
		 
		  startTime = System.currentTimeMillis();
		  endTime = startTime + duration;
		  totalAnimDx = dx;
		  totalAnimDy = dy;
		  
		  post(new Runnable() {
			  @Override
			  public void run() {
				  onAnimateStep();
			  }
		  });
	  }
	  private void onAnimateStep() {
		  long curTime = System.currentTimeMillis();
		  float percentTime = (float) (curTime - startTime) /  (float) (endTime - startTime);
		  float percentDistance = animateInterpolator.getInterpolation(percentTime);
		  float curDx = percentDistance * totalAnimDx;
		  float curDy = percentDistance * totalAnimDy;
		  
		  translate.set(animateStart);
		  onMove(curDx, curDy);
		  if (percentTime < 1.0f) {
			  post(new Runnable() {
				  @Override
				  public void run() {
					  onAnimateStep();
				  }
			  });
		  }
	  }
	  private class GestureListener extends  GestureDetector.SimpleOnGestureListener  {
		  SingletouchView view;
		  
		  public GestureListener(SingletouchView view) {
			  this.view = view;
		  }
		  
		  @Override
		  public boolean onDown(MotionEvent e) {
			  return true;
		  }
		  
		  @Override
		  public boolean onFling(MotionEvent e1, MotionEvent e2, final float velocityX, final float velocityY) {
			  final float distanceTimeFactor = 0.4f;
			  final float totalDx = (distanceTimeFactor * velocityX / 2);
			  final float totalDy = (distanceTimeFactor * velocityY / 2);
			  
			  view.onAnimateMove(totalDx, totalDy,(long) (1000 * distanceTimeFactor));
			  return true;
		  }
		  @Override
		  public boolean onDoubleTap(MotionEvent e) {
			  view.onResetLocation();
			  return true;
		  }
		  @Override
		  public boolean onScroll(MotionEvent e1, MotionEvent e2,  float distanceX, float distanceY) {
			  
			  //view.onMove(-distanceX, -distanceY);
			  return true;
		  }
	  }
}