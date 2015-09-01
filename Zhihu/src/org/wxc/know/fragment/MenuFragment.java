package org.wxc.know.fragment;

import org.wxc.know.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment之——侧滑菜单
 * 
 * @author Shawn Wang
 * 
 */
public class MenuFragment extends BaseFragment {

	@Override
	public View bindLayout(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left_menu, container, false);
		return view;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAnimation(int in, int out) {
		// TODO Auto-generated method stub

	}
/*
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
