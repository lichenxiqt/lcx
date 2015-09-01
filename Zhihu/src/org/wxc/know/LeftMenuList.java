package org.wxc.know;

import org.wxc.know.status.ContentStatus;
import org.wxc.know.view.MenuItemView;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class LeftMenuList extends ListFragment {

	String[] menuText = { "首页", "发现", "关注", "收藏", "草稿", "提问"};
	int[] statusIds = { 0, 2, 3, 4, 5, 6};
	int[] resIds = { R.drawable.ic_drawer_home_normal, R.drawable.ic_drawer_explore_normal,
			R.drawable.ic_drawer_follow_normal, R.drawable.ic_drawer_collect_normal,
			R.drawable.ic_drawer_draft_normal, R.drawable.ic_drawer_question_normal,
			};

	Zhihu activity;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		activity = ((Zhihu) getActivity());
		// Create a new Adapter and bind it to the List View
		ListAdapter adapter = new BaseAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return menuText.length;
			}

			@Override
			public Object getItem(int position) {
				return position;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// TODO 写一个ImageView + TextView 的公用View
				MenuItemView miv = new MenuItemView(getActivity());
				miv.setMenuIcon(resIds[position]);
				miv.setMenuName(menuText[position]);

				return miv;
			}

		};
		for (int i = 0; i < statusIds.length; i++) {
			if (statusIds[i] == activity.contentStatus)
				getListView().setSelection(i);
		}
		getListView().setDivider(null);
		getListView().setSelector(R.drawable.background_pressed);
		setListAdapter(adapter);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		activity.hideMenu();
		// TODO 用一个判断控制Activity的状态变化
		switch (position) {
		case 0:
			if (activity.contentStatus != ContentStatus.STATUS_HOME) {
				activity.contentStatus = ContentStatus.STATUS_HOME;
				activity.changeStatus();
			}
			break;
		case 1:
			if (activity.contentStatus != ContentStatus.STATUS_FIND) {
				activity.contentStatus = ContentStatus.STATUS_FIND;
				activity.changeStatus();
			}
			break;
		case 2:
			if (activity.contentStatus != ContentStatus.STATUS_ATTENTION) {
				activity.contentStatus = ContentStatus.STATUS_ATTENTION;
				activity.changeStatus();
			}
			break;
		case 3:
			if (activity.contentStatus != ContentStatus.STATUS_COLLECTION) {
				activity.contentStatus = ContentStatus.STATUS_COLLECTION;
				activity.changeStatus();
			}
			break;
		case 4:
			if (activity.contentStatus != ContentStatus.STATUS_DRAFT) {
				activity.contentStatus = ContentStatus.STATUS_DRAFT;
				activity.changeStatus();
			}
			break;
		case 5:
			if (activity.contentStatus != ContentStatus.STATUS_ASK) {
				activity.contentStatus = ContentStatus.STATUS_ASK;
				activity.changeStatus();
			}
			break;
		case 6:
			if (activity.contentStatus != ContentStatus.STATUS_SETTING) {
				activity.contentStatus = ContentStatus.STATUS_SETTING;
				activity.changeStatus();
			}
			break;
		}
		super.onListItemClick(l, v, position, id);
	}
}
