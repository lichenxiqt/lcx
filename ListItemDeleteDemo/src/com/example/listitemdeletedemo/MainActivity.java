package com.example.listitemdeletedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.example.listitemdeletedemo.MyDialog.IDialogOnclickInterface;

public class MainActivity extends Activity implements IDialogOnclickInterface {
	private ListView listView;
	private ListViewAdapter listViewAdapter;
	private List<String> dataList;
	private int longClickPosition;
	private MyDialog myDialog;
	private static final String TAG = "MainActivity";
	private View currentItemView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listview);
		myDialog = new MyDialog(this, R.style.MyDialogStyle);
		dataList = new ArrayList<String>();
		for (int i = 0; i < 19; i++) {
			dataList.add("data " + i);
		}
		listViewAdapter = new ListViewAdapter(this, dataList);
		listView.setAdapter(listViewAdapter);
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				int[] location = new int[2];
				// 获取当前view在屏幕中的绝对位置
				// ,location[0]表示view的x坐标值,location[1]表示view的坐标值
				view.getLocationOnScreen(location);
				view.setBackgroundColor(getResources().getColor(R.color.blue));
				currentItemView = view;
				longClickPosition = position;
				DisplayMetrics displayMetrics = new DisplayMetrics();
				Display display = MainActivity.this.getWindowManager().getDefaultDisplay();
				display.getMetrics(displayMetrics);
				WindowManager.LayoutParams params = myDialog.getWindow().getAttributes();
				params.gravity = Gravity.BOTTOM;
				params.y =display.getHeight() -  location[1];
				myDialog.getWindow().setAttributes(params);
				myDialog.setCanceledOnTouchOutside(true);
				myDialog.show();
				return false;
			}
		});
		myDialog.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				currentItemView.setBackgroundColor(getResources().getColor(android.R.color.white));
			}
		});
	}

	@Override
	public void leftOnclick() {
		// TODO Auto-generated method stub
		myDialog.dismiss();
		currentItemView.setBackgroundColor(getResources().getColor(android.R.color.white));
		dataList.remove(longClickPosition);
		listViewAdapter.notifyDataSetChanged();
	}

	@Override
	public void rightOnclick() {
		// TODO Auto-generated method stub
		myDialog.dismiss();
		currentItemView.setBackgroundColor(getResources().getColor(android.R.color.white));
		dataList.remove(longClickPosition);
		listViewAdapter.notifyDataSetChanged();
	}

}
