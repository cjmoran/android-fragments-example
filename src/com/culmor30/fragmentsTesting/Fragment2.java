package com.culmor30.fragmentsTesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment {
	public static Fragment2 newInstance(int index) {
		Fragment2 f = new Fragment2();
		
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		f.setRetainInstance(true);
		
		return f;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.test2_fragment, container, false);
		return layout;
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
}