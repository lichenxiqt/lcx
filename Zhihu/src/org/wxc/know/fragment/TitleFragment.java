/*package org.wxc.know.fragment;

import org.wxc.know.R;
import org.wxc.know.status.ContentStatus;
import org.wxc.know.status.LoadingStatus;
import org.wxc.know.view.ActionButton;
import org.wxc.know.view.Content2Back;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

*//**
 * Fragment之——Title
 * 
 * @author Shawn Wang
 * 
 *//*
public class TitleFragment extends BaseFragment{

	public static Content2Back c2b;
	ActionButton abSearch;
	ActionButton abShare;
	ActionButton abEdit;
	ActionButton abMsg;
	ActionButton abRandom;
	ActionButton abHide;

	ActionButton abCleanUnread;
	ActionButton abPulish;

	TextView tvTitle;

	
	 * 当前状态 Title的文字
	 
	String titleText;

	@Override
	public void initView() {
		c2b = (Content2Back) mActivity.findViewById(R.id.b2h);

		tvTitle = (TextView) mActivity.findViewById(R.id.tab_text);

		abSearch = (ActionButton) mActivity.findViewById(R.id.ab_search);
		abShare = (ActionButton) mActivity.findViewById(R.id.ab_share);
		abEdit = (ActionButton) mActivity.findViewById(R.id.ab_edit);
		abMsg = (ActionButton) mActivity.findViewById(R.id.ab_msg);
		abRandom = (ActionButton) mActivity.findViewById(R.id.ab_random);
		abHide = (ActionButton) mActivity.findViewById(R.id.ab_hide);

		abPulish = (ActionButton) mActivity.findViewById(R.id.ab_pulish);
		abCleanUnread = (ActionButton) mActivity
				.findViewById(R.id.ab_clean_unread);

		refresh();

	}

	private void hideContent2Back() {
		c2b.setVisibility(View.GONE);
	}

	private void showContent2Back() {
		c2b.setVisibility(View.VISIBLE);
	}

	private void showActionButton(ActionButton... abs) {
		abCleanUnread.setVisibility(View.GONE);
		abEdit.setVisibility(View.GONE);
		abHide.setVisibility(View.GONE);
		abMsg.setVisibility(View.GONE);
		abPulish.setVisibility(View.GONE);
		abRandom.setVisibility(View.GONE);
		abSearch.setVisibility(View.GONE);
		abShare.setVisibility(View.GONE);
		abPulish.setVisibility(View.GONE);

		for (ActionButton item : abs) {
			item.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void setListener() {
		
	}

	@Override
	public void setAnimation(int in, int out) {
		// TODO Auto-generated method stub

	}

	@Override
	public View bindLayout(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ll_title, container, false);
		return view;
	}

	

	public void refresh() {
		// 如果应用没有在加载状态，则显示正常的Title
		if (LoadingStatus.STATUS_LOADED == mActivity.loadStatus) {
			tvTitle.setGravity(Gravity.LEFT);
			// 控制哪些ActionButton显示
			switch (mActivity.contentStatus) {
			case ContentStatus.STATUS_HOME:
				// 显示search msg hide
				showActionButton(abSearch, abMsg, abHide);
				this.titleText = "首页";
				showContent2Back();
				break;
			case ContentStatus.STATUS_FIND:
				// 显示random search msg hide
				showActionButton(abRandom, abSearch, abMsg, abHide);
				this.titleText = "发现";
				showContent2Back();
				break;
			case ContentStatus.STATUS_ATTENTION:
				// 显示search msg hide
				showActionButton(abSearch, abMsg, abHide);
				this.titleText = "关注";
				showContent2Back();
				break;
			case ContentStatus.STATUS_COLLECTION:
				// 显示search msg hide
				showActionButton(abSearch, abMsg, abHide);
				this.titleText = "收藏";
				showContent2Back();
				break;
			case ContentStatus.STATUS_DRAFT:
				// 显示search msg hide
				showActionButton(abSearch, abMsg, abHide);
				this.titleText = "草稿";
				showContent2Back();
				break;
			case ContentStatus.STATUS_ASK:
				// 显示pulish
				showActionButton(abPulish);
				this.titleText = "添加问题";
				hideContent2Back();
				break;
			case ContentStatus.STATUS_MINE:
				// 显示share edit
				showActionButton(abShare, abEdit);
				// TODO 这里需要接收服务器数据
				this.titleText = "我的名字";
				hideContent2Back();
				break;
			case ContentStatus.STATUS_MSG:
				// 显示cleanUnread
				showActionButton(abCleanUnread);
				this.titleText = "消息";
				hideContent2Back();
				break;
			case ContentStatus.STATUS_QUESTION:
				// 显示share hide
				showActionButton(abShare, abHide);
				// TODO 这里需要接收服务器数据
				this.titleText = "共***回答";
				hideContent2Back();
				break;
			case ContentStatus.STATUS_ANSWER:
				// 显示share hide
				showActionButton(abShare, abHide);
				// TODO 这里需要接收服务器数据
				this.titleText = "问题的title";
				hideContent2Back();
				break;

			default:
				// 加载中，评论，Answers等
				showActionButton();
				break;
			}
		} else {// 否则只显示TitleText，并居中
			titleText = "正在加载...";
			tvTitle.setGravity(Gravity.CENTER);
		}

		tvTitle.setText(titleText);
	}

	@Override
	public void onClick(View v) {
		
	}
}
*/