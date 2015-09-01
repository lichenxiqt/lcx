package org.wxc.know.fragment;

import org.wxc.know.Zhihu;
import org.wxc.know.util.ListAdapterUtil;
import org.wxc.know.view.FindItemView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class HomeBody extends BaseFragment {

	ListView lv;

	@Override
	public View bindLayout(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		lv = new ListView(mActivity);
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 10;
			}

			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				return new FindItemView(mActivity).getItemView();
			}

		};
		lv.setDividerHeight(80);

		lv.setAdapter(adapter);

		return lv;
	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public void setAnimation(int in, int out) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
