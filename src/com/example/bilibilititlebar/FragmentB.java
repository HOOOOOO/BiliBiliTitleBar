package com.example.bilibilititlebar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment{

	public static FragmentB newInstance(int index){
		FragmentB fragmentB = new FragmentB();
		Bundle args = new Bundle();  
        args.putInt("index", index);  
        fragmentB.setArguments(args);  
		return fragmentB;
	}
	
	public int getShownIndex() {  
        return getArguments().getInt("index", 0);  
    }  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_b, container, false);
	}
}
