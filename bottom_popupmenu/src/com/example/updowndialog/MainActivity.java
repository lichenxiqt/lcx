package com.example.updowndialog;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void click(View view){
		Intent intent=new Intent();
		intent.setClass(this, DialogActivity.class);
		startActivity(intent);
		//添加开启activity的动画
		overridePendingTransition(R.anim.dialog_enter, 0);
	}
}
