package org.wxc.know.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CollectionBody extends BaseFragment{
/*
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
*/
	@Override
	public View bindLayout(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView tv = new TextView(mActivity);
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(30);
		tv.setTextColor(Color.BLACK);
		tv.setText("Collection Body");
		return tv;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setListener() {
		
	}

	@Override
	public void setAnimation(int in, int out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
