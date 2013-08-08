package com.culmor30.fragmentsTesting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment {
	ProgressDialog dialog;
	
	public ProgressDialogFragment() {
		super();
	}
	
	@Override
	public ProgressDialog onCreateDialog(Bundle savedInstanceState) {
		dialog = new ProgressDialog(getActivity());
		dialog.setMessage("Doing nothing useful...");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setProgress(0);
		
		dialog.setCancelable(true);
		
		return dialog;
	}
	
	@Override
	public void onCancel(DialogInterface d) {
		super.onCancel(d);
		
		AsyncTask1.interruptTask();
	}
	
	public void setProgress(int p) {
		if(dialog != null)
			dialog.setProgress(p);
	}
}