package org.wxc.know.view;

import org.wxc.know.R;
import org.wxc.know.constant.Constant;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 自定义的Button，用于Title中
 * 可以为ImageButton，也可以是TextButton
 * 此外，还有加新消息小红点的功能
 * layout: rl_action_button.xml
 * @author Shawn Wang
 *
 */
public class ActionButton extends RelativeLayout {

	Context mContext;

	ImageView action;
	ImageView actionNotify;

	Bitmap icon;
	String text;
	
	TextView actionText;

	public boolean hasNotice;

	public ActionButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.ActionButton);
		// 获得自定义的属性
		int n = a.getIndexCount();
		for (int i = 0; i < n; i++) {
			int itemId = a.getIndex(i);
			switch(itemId){
			case R.styleable.ActionButton_abIcon:
				setIcon(a.getResourceId(itemId,-1));
				break;
			case R.styleable.ActionButton_abText:
				setText(a.getString(itemId));
				break;
			}
		}
		a.recycle();
		initView();
	}

	public ActionButton(Context context) {
		super(context);
		mContext = context;

		initView();

	}

	public ActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mContext = context;

		initView();

	}

	private void initView() {
		inflate(mContext, R.layout.rl_action_button, this);
		this.setBackgroundColor(Constant.backColor);
		action = (ImageView) findViewById(R.id.iv_action);
		actionNotify = (ImageView) findViewById(R.id.iv_action_notify);

		actionText = (TextView)findViewById(R.id.tv_action_text);
		
		if (this.icon != null) {
			action.setImageBitmap(this.icon);
		}
		
		if(this.text != null) {
			actionText.setVisibility(VISIBLE);
			actionText.setText(text);
		} else {
			actionText.setVisibility(GONE);
		}
		// 初始设置通知红点为隐藏
		action.setVisibility(VISIBLE);
		actionNotify.setVisibility(GONE);
		hasNotice = false;
	}

	public void setIcon(int resId) {
		this.icon = BitmapFactory.decodeResource(getResources(), resId);
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			/*
			 * 按下则
			 */
			this.setBackgroundColor(Constant.pressedColor);
			break;
		case MotionEvent.ACTION_UP:
			this.setBackgroundColor(Constant.backColor);
			// TODO 点击事件
			// 如果长按，Toast

			// 如果短按，点击事件

			break;
		}
		return true;
	}
}
