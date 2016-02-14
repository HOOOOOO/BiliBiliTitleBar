package com.example.bilibilititlebar;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChooseBar extends LinearLayout implements OnClickListener{

	public final static int CHOOSEHOME = 0;
	public final static int CHOOSEHOT = 1;
	public final static int CHOOSEADVISE = 2;
	public final static int CHOOSEPARTITION = 3;
	public final static int CHOOSECOMIC = 4;
	
	private TextView mChooseHome, mChooseHot, mChooseAdvise, mChoosePartition, mChooseComic;
	private OnChooseListener mOnChooseListener;
	private View mSlideBlock;
	private int mWidthOfSlideBlock;
	
	public ChooseBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater inflater = LayoutInflater.from(context);
		inflater.inflate(R.layout.choose_bar, this, true);
		
	    mSlideBlock = (View) findViewById(R.id.slide_block);
		mChooseHome = (TextView) findViewById(R.id.choose_home);
		mChooseHome.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
		mChooseHome.setOnClickListener(this);
		mChooseHot = (TextView) findViewById(R.id.choose_hot);
		mChooseHot.setOnClickListener(this);
		mChooseAdvise = (TextView) findViewById(R.id.choose_advise);
		mChooseAdvise.setOnClickListener(this);
		mChoosePartition = (TextView) findViewById(R.id.choose_partition);
		mChoosePartition.setOnClickListener(this);
		mChooseComic = (TextView) findViewById(R.id.choose_comic);
		mChooseComic.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.choose_home:
			clearTextTypeface();
			mChooseHome.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			mOnChooseListener.beChoose(CHOOSEHOME);
			break;
		case R.id.choose_hot:
			clearTextTypeface();
			mChooseHot.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			mOnChooseListener.beChoose(CHOOSEHOT);
			break;
		case R.id.choose_advise:
			clearTextTypeface();
			mChooseAdvise.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			mOnChooseListener.beChoose(CHOOSEADVISE);
			break;
		case R.id.choose_partition:
			clearTextTypeface();
			mChoosePartition.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			mOnChooseListener.beChoose(CHOOSEPARTITION);
			break;
		case R.id.choose_comic:
			clearTextTypeface();
			mChooseComic.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			mOnChooseListener.beChoose(CHOOSECOMIC);
			default:
			break;
		}
	}
	
	public void setCurrentPosition(int position) {
		clearTextTypeface();
		switch (position) {
		case CHOOSEHOME:
			mChooseHome.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case CHOOSEHOT:
			mChooseHot.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case CHOOSEADVISE:
			mChooseAdvise.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case CHOOSEPARTITION:
			mChoosePartition.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		case CHOOSECOMIC:
			mChooseComic.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
			break;
		default:
			break;
		}
	}
	
	private void clearTextTypeface() {
		// TODO Auto-generated method stub
		mChooseHome.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
		mChooseHot.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
		mChooseAdvise.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
		mChoosePartition.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
		mChooseComic.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
	}

	public void setOnChooseListener(OnChooseListener onChooseListener) {
		this.mOnChooseListener = onChooseListener;
	}
	
	public interface OnChooseListener{
		public void beChoose(int id);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int widthOfScreen = getContext().getResources().getDisplayMetrics().widthPixels;
		android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) mSlideBlock.getLayoutParams();
		mWidthOfSlideBlock = layoutParams.width = widthOfScreen / 5;
		layoutParams.height = android.widget.LinearLayout.LayoutParams.FILL_PARENT;
		mSlideBlock.setLayoutParams(layoutParams);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

}