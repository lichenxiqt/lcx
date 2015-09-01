package org.wxc.know.view;

import org.wxc.know.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Bottom中的子View
 * @author Shawn Wang
 *
 */
public class BottomView extends RelativeLayout {
	TextView tv_tabicon;
	ImageView iv_tabicon;
	ImageView iv_tabicon_pressed;

	public BottomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public void initView(Context context) {
		inflate(context, R.layout.bottom_view, this);
		tv_tabicon = (TextView) findViewById(R.id.tv_tabicon);
		iv_tabicon = (ImageView) findViewById(R.id.iv_tabicon);
		iv_tabicon_pressed = (ImageView) findViewById(R.id.iv_tabicon_pressed);

	}

	public void initTv_tabicon(String text) {
		this.tv_tabicon.setText(text);
	}

	public void initIv_tabicon(int resId) {
		this.iv_tabicon.setImageResource(resId);
	}

	public void initIv_tabiconPressed(int resId, float alpha) {
		this.initIv_tabiconPressed(resId);
		this.initAlpha(alpha);
	}

	public void initIv_tabiconPressed(int resId) {
		this.iv_tabicon_pressed.setImageResource(resId);

	}

	@SuppressLint("NewApi")
	public void initAlpha(float alpha) {
		this.iv_tabicon_pressed.setAlpha(alpha);
		this.tv_tabicon.setAlpha(1 - alpha);
	}
}
