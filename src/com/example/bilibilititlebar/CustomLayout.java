package com.example.bilibilititlebar;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomLayout extends LinearLayout{

	private final static int DOWN = 0;
	private final static int UP = 1;
	private int mHeightOfTitleBar, mHeightOfChooseBar;
	private Scroller mScroller;
	private float mInterInitX;
	private float mInterInitY;
	private int mState = DOWN;
	private float mLastY;
	private float mLastX;

	public CustomLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScroller = new Scroller(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		mHeightOfTitleBar = getChildAt(0).getMeasuredHeight();
		mHeightOfChooseBar = getChildAt(1).getMeasuredHeight();
		Log.e("mWidthOfTitleBar", ""+mHeightOfTitleBar);
		Log.e("mWidthOfChooseBar", ""+mHeightOfChooseBar);
		super.onLayout(changed, l, t, r, b);
	}

	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mInterInitX = ev.getX();
			mInterInitY = ev.getY();
			mLastY = ev.getY();
			mLastX = ev.getX();
			Log.e("CustomLayout.onInterceptTouchEvent", ""+mInterInitY);
			break;
		case MotionEvent.ACTION_MOVE:
			if(Math.abs(mLastX-ev.getX()) > Math.abs(mLastY-ev.getY()))
				break;
			if(mLastY > mInterInitY && mLastY > ev.getY() && mState == DOWN){
				mInterInitY = mLastY;
				mInterInitX = mLastX;
			}
			if(mLastY < mInterInitY && mLastY < ev.getY() && mState == UP){
				mInterInitY = mLastY;
				mInterInitX = mLastX;
			}
			int s = (int) (mInterInitY-ev.getY());
			if(getScrollY() <= mHeightOfTitleBar && getScrollY() >= 0){
				if(s > 0  && mState == DOWN){
					if(s <= mHeightOfTitleBar)
						scrollTo(0, s);
					else{
						scrollTo(0, mHeightOfTitleBar);
						mState = UP;
					}
				}
				if(s < 0 && mState == UP){
					if(s >= -mHeightOfTitleBar)
						scrollTo(0, mHeightOfTitleBar + s);
					else{
						scrollTo(0, 0);
						mState = DOWN;
					}
				}
			}
			mLastY = ev.getY();
			mLastX = ev.getX();
			break;
		case MotionEvent.ACTION_UP:
			if(Math.abs(mInterInitX-ev.getX()) > Math.abs(mInterInitY-ev.getY()))
				break;
			if(getScrollY() > mHeightOfTitleBar/2){
        		mScroller.startScroll(0, getScrollY(), 0, (int) (mHeightOfTitleBar-getScrollY()), 500);
        		mState = UP;
			}
        	else{
        		mScroller.startScroll(0, getScrollY(), 0, (int) (0-getScrollY()), 500);
        		mState = DOWN;
        	}
			invalidate();
			break;
		default:
			break;
		}
		boolean b =  super.dispatchTouchEvent(ev);
		return b;
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void computeScroll() {
		// TODO Auto-generated method stub
		if(mScroller.computeScrollOffset()){
			scrollTo(0, mScroller.getCurrY());
			invalidate();
		}
	}
}
