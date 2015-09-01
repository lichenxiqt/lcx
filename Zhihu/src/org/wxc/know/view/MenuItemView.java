package org.wxc.know.view;

import org.wxc.know.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 菜单中的带icon和name的单个View
 * @author Shawn Wang
 *
 */
public class MenuItemView extends RelativeLayout {

	ImageView menu_icon;
	TextView menu_name;
	
	boolean isSelected = true;

	@SuppressLint("NewApi") 
	public MenuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initView(context);
	}

	public MenuItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public MenuItemView(Context context) {
		super(context);
		initView(context);
	}

	private void initView(Context context) {
		inflate(context, R.layout.rl_menu_item, this);
		menu_icon = (ImageView) findViewById(R.id.iv_menu_icon);
		menu_name = (TextView) findViewById(R.id.tv_menu_name);		
	}
	
	public void setSelected(boolean isSelected){
		if(isSelected){
			this.setBackgroundColor(Color.parseColor("#3399ff"));
			this.menu_name.setTextColor(Color.WHITE);
		} else {
			this.setBackgroundColor(Color.WHITE);
			this.menu_name.setTextColor(Color.BLACK);
		}
	}

	public void setMenuIcon(int resId) {
		menu_icon.setImageResource(resId);
	}

	public void setMenuName(String name) {
		menu_name.setText(name);
	}
}
