package com.example.bilibilititlebar;

import javax.crypto.Mac;

import com.example.bilibilititlebar.ChooseBar.OnChooseListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private ChooseBar mChooseBar;
	private LinearLayout mSlideLayout;
	private CustomLayout mCustomLayout;
	private int mWidthOfSlideBlock;
	private int mScrollXOfSlide;
	private int mCurrentPosition = 0;
	private boolean mIsBeChoose = false;
	private boolean isFirst = true;
	private float mInitX;
	private float mInitY;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setContentView(R.layout.test);
		
		mCustomLayout = (CustomLayout) findViewById(R.id.customLayout);
		
		mWidthOfSlideBlock = this.getResources().getDisplayMetrics().widthPixels / 5;
		
		mViewPager = (ViewPager) findViewById(R.id.view_pager);
		mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		
		
		mChooseBar = (ChooseBar) findViewById(R.id.choosebar);
		mSlideLayout = (LinearLayout) mChooseBar.findViewById(R.id.customLayout);
		mChooseBar.setOnChooseListener(new OnChooseListener() {
			@Override
			public void beChoose(int id) {
				// TODO Auto-generated method stub
				mIsBeChoose = true;
				mViewPager.setCurrentItem(id, true);
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.d("onPageSelected", ""+arg0);
				if(!mIsBeChoose)
					mChooseBar.setCurrentPosition(arg0);
			}
			
			@Override
			public void onPageScrolled(int position, float arg1, int positionOffsetPixels) {
				// TODO Auto-generated method stub
				Log.i("onPageScrolled", ""+position+" "+arg1+" "+positionOffsetPixels);
				mSlideLayout.scrollTo((int) (-(position+arg1)*mWidthOfSlideBlock), 0);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 == 0){
				    mIsBeChoose = false;
				}
				Log.e("onPageScrollStateChanged", ""+arg0);
			}
		});
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		/*Log.e("MainActivity", ""+event.getAction());
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.e("MainActivity", ""+event.getY());
			mInitX = event.getX();
			mInitY = event.getY();
			break;
        case MotionEvent.ACTION_MOVE:
        	Log.e("MainActivity", ""+event.getY());
        	if(isFirst){
        		mInitX = event.getX();
        		mInitY = event.getY();
        		isFirst = false;
        	}
        	if(!isFirst){
        		Log.e("mInitY - event.getY()", ""+(mInitY - event.getY()));
        		mCustomLayout.scrollTo(0, (int) (mInitY - event.getY()));
        	}
		default:
			break;
		}
		return super.onTouchEvent(event);
	}*/
		return super.onTouchEvent(event);
	}
}
