package org.wxc.know.fragment;

import org.wxc.know.Zhihu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * Fragment之——公有部分
 * 
 * @author Shawn Wang
 * 
 */
public abstract class BaseFragment extends Fragment implements OnClickListener{
	/**
	 * 公有部分抽取：
	 *  1、 与Activity绑定、解绑
	 *  2、Add/Remove 
	 *  3、数据接口 
	 *  4、入栈出栈
	 */
	Zhihu mActivity;

	/**
	 * 出入动画资源
	 */
	int inAnim;
	int outAnim;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = (Zhihu) getActivity();
		in(inAnim);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return bindLayout(inflater,container,savedInstanceState);
	}
	
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();

		setListener();
	}

	@Override
	public void onResume() {
		super.onResume();
	}
	
	/**
	 * 设置整体出场动画
	 */
	@SuppressLint("NewApi") 
	public void in(int in) {
		FragmentTransaction ft = getActivity().getSupportFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(in, 0);
		ft.attach(this);
		ft.addToBackStack(null);
		ft.commit();
	}
	
	@Override
	public void onDetach() {
		super.onDetach();	
		out(outAnim);
	}
	
	@SuppressLint("NewApi")
	public void out(int out){
		FragmentTransaction ft = getActivity().getSupportFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(0, out);
		ft.detach(this);
		ft.addToBackStack(null);
		ft.commit();
	}

	/**
	 * 非公有部分抛出 
	 * 1、layout 
	 * 2、专用View 
	 * 3、专用View的事件监听 
	 * 4、绑定解绑动画
	 */

	/**
	 * 绑定Layout
	 */
	public abstract View bindLayout(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState);

	/**
	 * 初始化各view组件
	 */
	public abstract void initView();

	/**
	 * 绑定监听事件
	 */
	public abstract void setListener();

	/**
	 * 设置动画
	 */
	public abstract void setAnimation(int in, int out);

	
}
