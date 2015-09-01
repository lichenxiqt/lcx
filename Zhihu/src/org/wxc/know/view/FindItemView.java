package org.wxc.know.view;

import org.wxc.know.R;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

public class FindItemView extends BaseItemView {
	public FindItemView(Context context) {
		super(context);
		initData();
	}
	

	@Override
	public void initData() {
		View.inflate(context, R.layout.find_item_view, rl);		
	}


	@Override
	public View getItemView() {
		return rl;
	}
	
}
