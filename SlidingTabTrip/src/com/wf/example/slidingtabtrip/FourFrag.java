package com.wf.example.slidingtabtrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

public class FourFrag extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		View v=new View(getActivity());
		v.setLayoutParams(params);
		v.setBackgroundResource(android.R.color.holo_orange_dark);
		return v;
	}
}
