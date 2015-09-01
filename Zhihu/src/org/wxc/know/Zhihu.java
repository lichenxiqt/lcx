package org.wxc.know;

import java.util.LinkedList;

import org.wxc.know.fragment.AttentionBody;
import org.wxc.know.fragment.FindBody;
import org.wxc.know.fragment.MenuFragment;
import org.wxc.know.fragment.TestList;
import org.wxc.know.status.ContentStatus;
import org.wxc.know.util.BodyManager;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;

/**
 * 新的Activity思路， 基于DrawerListener的Activity
 * 
 * @author Shawn Wang
 * 
 */
public class Zhihu extends ActionBarActivity implements OnRefreshListener {

	/**
	 * 内容状态
	 */
	public int contentStatus;
	/**
	 * title状态
	 */
	public boolean titleStatus;
	/**
	 * bottom状态
	 */
	public boolean bottomStatus;
	/**
	 * 登录状态
	 */
	public boolean loginStatus;
	/**
	 * 加载状态
	 */
	public boolean loadStatus;

	String[] actionBarText = { "首页", "", "发现", "关注", "收藏", "草稿", "提问", "设置" };

	/**
	 * 内容状态有一个stack来维护 分情况将当前的内容状态入栈 通常在其他的内容状态back后，会回到HomeStatus HomeStatus
	 * back，则退出应用
	 */
	public static LinkedList<Fragment> bodyStack;

	/**
	 * 不需要入栈的body及 title menu bottom用Map来存储 public static Map<String,Fragment>
	 * fragmentMap;
	 */

	Dialog d;
	/**
	 * Fragment管理
	 */
	FragmentManager fm;
	FragmentTransaction ft;
	Fragment body;
	Fragment title;
	Fragment menu;
	Fragment bottom;

	public static Zhihu zhihu;

	BodyManager bm;

	FrameLayout bodyLayout;

	DrawerLayout dl;

	FrameLayout menuLayout;
	FrameLayout titleLayout;

	/*
	 * 要用到的ActionBar
	 */
	ActionBar ab;
	ActionBarDrawerToggle mDrawerToggle;

	private Toolbar toolbar;
	
	/*
	 * Toolbar中的选项
	 */
	MenuBuilder mb; // MenuBuilder是Fragment
	
	private ActionMenuPresenter outerPresenter;


	// PullToRefresh fields
	private PullToRefreshLayout mPullToRefreshLayout;



	/**
	 * TODO 应专门设置一个BodyManager，监听Activity的状态 状态改变时，获取状态改变标识，做相应的BodyFragment的切换
	 * BodyFragment切换后以单例形式存储在内存中。
	 */

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhihu);
		zhihu = this;
		fm = getSupportFragmentManager();
		ft = fm.beginTransaction();
		bm = BodyManager.getInstance();

		dl = (DrawerLayout) findViewById(R.id.dl_left);

		// Toolbar
		toolbar = (Toolbar) findViewById(R.id.tl_custom);

		toolbar.setTitle("首页");// 设置Toolbar标题
		toolbar.setTitleTextColor(Color.parseColor("#ffffff")); // 设置标题颜色
		
		
		/*
		 * 设置菜单
		 */
		mb = new MenuBuilder(this);
		outerPresenter = new ActionMenuPresenter(this);
		toolbar.setMenu(mb, outerPresenter);

		// PullToRefresh view
		mPullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);

		// ListView
		// mListView = (ListView) findViewById(R.id.listview);

		// ListView 换成 Fragment

		// Setup the PullToRefreshLayout
		ActionBarPullToRefresh.from(this)
		// Mark All Children as pullable
				.allChildrenArePullable()
				// Set a OnRefreshListener
				.listener(this)
				// Finally ommit the setup to our PullToRefreshLayout
				.setup(mPullToRefreshLayout);

		setSupportActionBar(toolbar);

		ab = getSupportActionBar();

		// 1、初始化Fragments
		contentStatus = 0;
		body = new TestList();
		// title = new TitleFragment();
		menu = new MenuFragment();

		// TODO 将Fragment添加到PullToRefreshLayout中的ScrollView中
		// getSupportFragmentManager().beginTransaction()
		// .add(R.id.zhihu_body, body).commit();
		ft.add(R.id.zhihu_body, body);
		ft.add(R.id.zhihu_menu, menu);
		ft.commit();
		
		// ab.setCustomView(R.layout.ll_title);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		dl.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		// 创建返回键，并实现打开关/闭监听
		mDrawerToggle = new ActionBarDrawerToggle(this, dl, toolbar,
				R.string.drawer_open, R.string.drawer_close) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				ab.setTitle("知乎");
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				// TODO 此处需按body status确定
				ab.setTitle(actionBarText[contentStatus]);

				invalidateOptionsMenu();
			}
		};

		mDrawerToggle.syncState();

		// 2、控制DrawerLayout中startView即menu的拉出/收起
		menuLayout = (FrameLayout) findViewById(R.id.zhihu_menu);
		// ab.setDisplayHomeAsUpEnabled(true);
		// ab.setHomeButtonEnabled(true);
		// dl.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

		dl.setDrawerListener(mDrawerToggle);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void hideMenu() {
		dl.closeDrawers();
	}

	public void showMenu() {
		dl.openDrawer(menuLayout);
	}

	@Override
	public void onRefreshStarted(View view) {
		// Hide the list
		// setListShown(false);

		/**
		 * Simulate Refresh with 4 seconds sleep
		 */
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			protected void onPostExecute(Void result) {
				super.onPostExecute(result);

				// Notify PullToRefreshLayout that the refresh has finished
				mPullToRefreshLayout.setRefreshComplete();
			}
		}.execute();
	}

	// TODO 根据当前状态改变body中的Fragment
	public void changeStatus() {
		ft = fm.beginTransaction();
		if (contentStatus == ContentStatus.STATUS_HOME)
			body = new TestList();
		else if (contentStatus == ContentStatus.STATUS_FIND)
			body = new FindBody();
		else if (contentStatus == ContentStatus.STATUS_ATTENTION)
			body = new AttentionBody();
		else
			body = bm.getBody(contentStatus);
		ft.setCustomAnimations(R.anim.anim_slide_right_in, R.anim.anim_fade_out);
		ft.replace(R.id.zhihu_body, body);
		ft.commit();

	}
}
