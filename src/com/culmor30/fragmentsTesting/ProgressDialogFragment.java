package com.culmor30.fragmentsTesting;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment {
	ProgressDialog dialog;
	
	@Override
	public ProgressDialog onCreateDialog(Bundle savedInstanceState) {
		dialog = new ProgressDialog(getActivity());
		dialog.setMessage("Doing nothing useful...");
		dialog.setCancelable(false);	//Disables back button
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setProgress(0);
		return dialog;
	}
	
	public void setProgress(int p) {
		if(dialog != null)
			dialog.setProgress(p);
	}
}