package com.example.viewpager;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyPagerAdater extends PagerAdapter {

	private List<View> listview;

	public MyPagerAdater(List<View> l) {
		listview = l;
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		((ViewPager) container).addView(listview.get(position));
		return listview.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listview.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		((ViewPager) container).removeView(listview.get(position));

	}

}
