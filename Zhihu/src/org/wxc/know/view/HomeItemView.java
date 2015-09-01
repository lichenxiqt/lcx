package org.wxc.know.view;

import org.wxc.know.R;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class HomeItemView extends BaseItemView {
	public HomeItemView(Context context) {
		super(context);
		initData();
	}
	

	@Override
	public void initData() {
		View.inflate(context, R.layout.home_item_view, rl);		
	}


	@Override
	public View getItemView() {
		return rl;
	}
	
}
