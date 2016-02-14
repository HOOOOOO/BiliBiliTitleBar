package com.example.bilibilititlebar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

public class ViewPagerAdapter extends FragmentPagerAdapter{

	public Fragment mCurrentFragment;
	public Fragment[] fragments = {FragmentA.newInstance(0),
								   FragmentB.newInstance(0),
								   FragmentA.newInstance(0),
								   FragmentB.newInstance(0),
								   FragmentA.newInstance(0)};
	
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments[arg0];
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	public Fragment getFragment(int position){
		return FragmentA.newInstance(0);
	}
}
