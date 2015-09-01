package com.example.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	private TextView textView4;

	private ImageView cursor;

	private ViewPager mViewPager;
	private List<View> listview;
	private MyPagerAdater mPagerAdater;

	private static final int DELAY_TIME = 3000;
	public static final int SCROLL_WHAT = 0;
	private int cursorWidth;
	private int currentPage = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initTextView();
		initList();
		initCursor();

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mPagerAdater = new MyPagerAdater(listview);
		mViewPager.setCurrentItem(0);
		mViewPager.setAdapter(mPagerAdater);
		mPagerAdater.notifyDataSetChanged();
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

		startAutoScrolled();

		mViewPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					stopAutoScrolled();
					break;
				case MotionEvent.ACTION_UP:
					startAutoScrolled();
					break;
				}
				return false;
			}
		});

	}

	private void initCursor() {
		cursor = (ImageView) findViewById(R.id.cursor);
		cursorWidth = BitmapFactory.decodeResource(getResources(),
				R.drawable.cursor).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int windowWidth = dm.widthPixels; // 获取分辨率宽度
		int tabWidth = windowWidth / listview.size();
		cursor.getLayoutParams().width = tabWidth;
		cursorWidth = tabWidth;
	}

	private void initTextView() {
		textView1 = (TextView) findViewById(R.id.textview1);
		textView2 = (TextView) findViewById(R.id.textview2);
		textView3 = (TextView) findViewById(R.id.textview3);
		textView4 = (TextView) findViewById(R.id.textview4);
		textView1.setOnClickListener(this);
		textView2.setOnClickListener(this);
		textView3.setOnClickListener(this);
		textView4.setOnClickListener(this);
	}

	private void initList() {
		listview = new ArrayList<View>();
		LayoutInflater inflater = getLayoutInflater();
		listview.add(inflater.inflate(R.layout.l1, null));
		listview.add(inflater.inflate(R.layout.l2, null));
		listview.add(inflater.inflate(R.layout.l3, null));
		listview.add(inflater.inflate(R.layout.l4, null));
	}

	private void startAutoScrolled() {
		mHandler.sendEmptyMessageDelayed(SCROLL_WHAT, DELAY_TIME);
	}

	private void stopAutoScrolled() {
		mHandler.removeMessages(SCROLL_WHAT);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textview1:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.textview2:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.textview3:
			mViewPager.setCurrentItem(2);
			break;
		case R.id.textview4:
			mViewPager.setCurrentItem(3);
			break;
		}
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			int toPage = (++currentPage) % listview.size();
			mViewPager.setCurrentItem(toPage);
			mHandler.removeMessages(SCROLL_WHAT);
			mHandler.sendEmptyMessageDelayed(SCROLL_WHAT, DELAY_TIME);
		}
	};

	public class MyOnPageChangeListener implements OnPageChangeListener {

		private boolean isScrolled = false;

		public void onPageScrollStateChanged(int arg0) {
			/*
			 * 页卡正常滑动时，会经历 1-2-0的三个阶段；
			 * 
			 * 页卡在最后一页向右滑，或者第一页向左滑经历 1-0-2-0的阶段；
			 * 
			 * 直接调用 setCurrentItem则只是经历 2-0的阶段
			 */
			switch (arg0) {
			/*
			 * 每一次的滑动arg0都会经历1-2-0的阶段，但是在最后一个页面向右滑，或者第一个页面向左滑时会经历 1-0-2-0的阶段 例如：
			 * 最后页面右滑时
			 * ，刚刚开始会是1，这时isScrolled为false，但是没有下一页面，所以此时的页面还是最后一个页面，满足if条件
			 */
			case 0:

				if (mViewPager.getCurrentItem() == mViewPager.getAdapter()
						.getCount() - 1 && !isScrolled)
					mViewPager.setCurrentItem(0);
				else if (mViewPager.getCurrentItem() == 0 && !isScrolled) {
					mViewPager.setCurrentItem(mViewPager.getAdapter()
							.getCount() - 1);
				}
				break;
			case 1:
				isScrolled = false;
				break;
			case 2:
				isScrolled = true;
				break;
			}
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		/*
		 * 页面跳转完成后调用的方法
		 */
		public void onPageSelected(int arg0) {
			Animation animation = new TranslateAnimation(cursorWidth
					* currentPage, cursorWidth * arg0, 0, 0);
			animation.setDuration(300);
			animation.setFillAfter(true);
			cursor.startAnimation(animation);
			currentPage = arg0;
		}
	}
}
