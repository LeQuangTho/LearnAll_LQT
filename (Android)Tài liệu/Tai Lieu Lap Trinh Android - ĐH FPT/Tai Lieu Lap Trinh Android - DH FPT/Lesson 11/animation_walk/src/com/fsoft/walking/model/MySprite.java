/**
 * 
 */
package com.fsoft.walking.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * @author impaler
 *
 */
public class MySprite {
	
	private static final String TAG = MySprite.class.getSimpleName();

	private Bitmap mAnimation;		// the animation sequence
	private Rect mSRectangle;	// the rectangle to be drawn from the animation bitmap
	private int mNoOfFrames;		// number of frames in animation
	private int mCurrentFrame;	// the current frame
	private long mFrameTimer;	// the time of the last frame update
	private int mFPS;	// milliseconds between each frame (1000/fps)
	
	private int mSpriteWidth;	// the width of the sprite to calculate the cut out rectangle
	private int mSpriteHeight;	// the height of the sprite
	
	private int mXPos;				// the X coordinate of the object (top left of the image)
	private int mYPos;				// the Y coordinate of the object (top left of the image)
	
	public MySprite(Bitmap bitmap, int x, int y, int width, int height, int fps, int frameCount) {
		this.mAnimation = bitmap;
		this.mXPos = x;
		this.mYPos = y;
		mCurrentFrame = 0;
		mNoOfFrames = frameCount;
		mSpriteWidth = bitmap.getWidth() / frameCount;
		mSpriteHeight = bitmap.getHeight();
		mSRectangle = new Rect(0, 0, mSpriteWidth, mSpriteHeight);
		mFPS = 1000 / fps;
		mFrameTimer = 0l;
	}
	
	
	public Bitmap getBitmap() {
		return mAnimation;
	}
	public void setBitmap(Bitmap bitmap) {
		this.mAnimation = bitmap;
	}
	public Rect getSourceRect() {
		return mSRectangle;
	}
	public void setSourceRect(Rect sourceRect) {
		this.mSRectangle = sourceRect;
	}
	public int getFrameNr() {
		return mNoOfFrames;
	}
	public void setFrameNr(int frameNr) {
		this.mNoOfFrames = frameNr;
	}
	public int getCurrentFrame() {
		return mCurrentFrame;
	}
	public void setCurrentFrame(int currentFrame) {
		this.mCurrentFrame = currentFrame;
	}
	public int getFramePeriod() {
		return mFPS;
	}
	public void setFramePeriod(int framePeriod) {
		this.mFPS = framePeriod;
	}
	public int getSpriteWidth() {
		return mSpriteWidth;
	}
	public void setSpriteWidth(int spriteWidth) {
		this.mSpriteWidth = spriteWidth;
	}
	public int getSpriteHeight() {
		return mSpriteHeight;
	}
	public void setSpriteHeight(int spriteHeight) {
		this.mSpriteHeight = spriteHeight;
	}
	public int getX() {
		return mXPos;
	}
	public void setX(int x) {
		this.mXPos = x;
	}
	public int getY() {
		return mYPos;
	}
	public void setY(int y) {
		this.mYPos = y;
	}
	
	// the update method for Elaine
	public void update(long gameTime) {
		if (gameTime > mFrameTimer + mFPS) {
			mFrameTimer = gameTime;
			// increment the frame
			mCurrentFrame++;
			if (mCurrentFrame >= mNoOfFrames) {
				mCurrentFrame = 0;
			}
		}
		// define the rectangle to cut out sprite
		this.mSRectangle.left = mCurrentFrame * mSpriteWidth;
		this.mSRectangle.right = this.mSRectangle.left + mSpriteWidth;
	}
	
	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		Rect destRect = new Rect(getX(), getY(), getX() + mSpriteWidth, getY() + mSpriteHeight);
		canvas.drawBitmap(mAnimation, mSRectangle, destRect, null);
		canvas.drawBitmap(mAnimation, 20, 150, null);
		Paint paint = new Paint();
		paint.setARGB(50, 0, 255, 0);
		canvas.drawRect(20 + (mCurrentFrame * destRect.width()), 150, 20 + (mCurrentFrame * destRect.width()) + destRect.width(), 150 + destRect.height(),  paint);
	}
}
