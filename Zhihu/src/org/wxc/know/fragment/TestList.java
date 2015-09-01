package org.wxc.know.fragment;

import org.wxc.know.Zhihu;
import org.wxc.know.view.HomeItemView;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TestList extends ListFragment {

	@Override
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
				return new HomeItemView(Zhihu.zhihu).getItemView();
			}

		};
		setListAdapter(adapter);

		int totalHeight = 0;
		for (int i = 0, len = adapter.getCount(); i < len; i++) {
			// listAdapter.getCount()返回数据项的数目
			View listItem = adapter.getView(i, null, getListView());
			// 计算子项View 的宽高
			listItem.measure(0, 0);
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = getListView().getLayoutParams();
		params.height = totalHeight
				+ (getListView().getDividerHeight() * (adapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		getListView().setLayoutParams(params);

	}
}
