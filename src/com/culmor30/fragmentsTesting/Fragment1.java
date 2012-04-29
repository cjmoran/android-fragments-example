package com.culmor30.fragmentsTesting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class Fragment1 extends Fragment implements OnClickListener {
	AsyncTask1 aTask;
	
	public static Fragment1 newInstance(int index) {
		Fragment1 f = new Fragment1();
		
		Bundle args = new Bundle();
		args.putInt("index", index);
		f.setArguments(args);
		
		return f;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		
		if(aTask != null)
			aTask.updateActivity(getActivity(), getFragmentManager());
		
		setupClickListeners();
	}
	
	public void setupClickListeners() {
		View f1Button1 = getView().findViewById(R.id.f1_button1);
		f1Button1.setOnClickListener(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.test1_fragment, container, false);
		return layout;
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.f1_button1:
			aTask = new AsyncTask1();
			aTask.updateActivity(getActivity(), getFragmentManager());
			aTask.execute();
		}
	}
}