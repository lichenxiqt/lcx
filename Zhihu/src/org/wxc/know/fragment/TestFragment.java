package org.wxc.know.fragment;

import org.wxc.know.Zhihu;
import org.wxc.know.view.FindItemView;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestFragment extends ListFragment {

	@SuppressLint("NewApi") @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				return 10;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if (position == 0) {
					TextView tv = new TextView(Zhihu.zhihu);
					tv.setBackgroundColor(Color.parseColor("#3366ff"));
					tv.setText("知乎精选");
					tv.setGravity(Gravity.CENTER);
					tv.setTextSize(60);
					tv.setTextColor(Color.parseColor("#ffffff"));
					return tv;
				} else
					return new FindItemView(Zhihu.zhihu).getItemView();
			}

		};
		setListAdapter(adapter);
		
		getListView().setScrollBarSize(0);
		
		getListView().setDividerHeight(60);
		/*
		 * int totalHeight = 0; for (int i = 0, len = adapter.getCount(); i <
		 * len; i++) { // listAdapter.getCount()返回数据项的数目 View listItem =
		 * adapter.getView(i, null, getListView()); // 计算子项View 的宽高
		 * listItem.measure(0, 0); // 统计所有子项的总高度 totalHeight +=
		 * listItem.getMeasuredHeight(); }
		 * 
		 * ViewGroup.LayoutParams params = getListView().getLayoutParams();
		 * params.height = totalHeight + (getListView().getDividerHeight() *
		 * (adapter.getCount() - 1)); //
		 * listView.getDividerHeight()获取子项间分隔符占用的高度 //
		 * params.height最后得到整个ListView完整显示需要的高度
		 * getListView().setLayoutParams(params);
		 */

	}
}
