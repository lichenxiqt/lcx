package org.wxc.know.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class BaseItemView {

	protected Context context;
	protected RelativeLayout rl;

	public BaseItemView(Context context) {
		this.context = context;
		rl = new RelativeLayout(context);
	}

	/**
	 * 每一个子类都应该实现的方法 1、 解析数据，分发到各个子view中
	 */
	public abstract void initData();

	/**
	 * 2、得到View
	 */
	public abstract View getItemView();
}
