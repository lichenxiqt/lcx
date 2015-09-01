package com.wf.example.slidingtabtrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.wf.example.slidingtabtrip.PagerSlidingTabStrip.OnPagerSlidingTabStripChanged;

public class MainActivity  extends FragmentActivity {

	//切换的按钮
	private PagerSlidingTabStrip tabs;
	//滑动的界面
	private ViewPager pager;
	//滑动的菜单
	private SlidingMenu menu;
	// 每天个界面
	private OneFrag oneFrag;
	private TwoFrag twoFrag;
	private ThreeFrag threeFrag;
	private FourFrag  fourFrag;
	private FiveFrag fiveFrag;
	
	String[] titles = { "界面一","界面二", "界面三", "界面四" ,"界面五"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initView();
	}
	
	private void initView(){
		setContentView(R.layout.activity_main);
		pager = (ViewPager) findViewById(R.id.pager);
		menu = (SlidingMenu)findViewById(R.id.id_menu);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		menu.setChildView(pager);
		//menu.setChildView(tabs);
		
		pager.setAdapter(new MyAdapter(getSupportFragmentManager(),titles));
		tabs.setViewPager(pager);
		tabs.setOnPagerSlidingTabStripChanged(new OnPagerSlidingTabStripChanged() {
			@Override
			public void onPageChanged(int position) {
				//将当前的界面的下表设置到silmenu中
				menu.setIndexpos(position);
				
			}
		});
		
		
	}
	

	public class MyAdapter extends FragmentPagerAdapter{
		String[] _titles;
		public MyAdapter(FragmentManager fm,String[] titles) {
			super(fm);
			_titles=titles;
		}
		
		@Override
		public CharSequence getPageTitle(int position) {
			return _titles[position];
		}
		
		@Override
		public int getCount() {
			return _titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (oneFrag == null) {
					oneFrag = new OneFrag();
				}
				return oneFrag;
			case 1:
				if (twoFrag == null) {
					twoFrag = new TwoFrag();
				}
				return twoFrag;
			case 2:
				if (threeFrag == null) {
					threeFrag = new ThreeFrag();
				}
				return threeFrag;
			case 3:
				if (fourFrag == null) {
					fourFrag = new FourFrag();
				}
				return fourFrag;
			case 4:
				if (fiveFrag == null) {
					fiveFrag = new FiveFrag();
				}
				return fiveFrag;
			default:
				return null;
			}
		}
	}
}
