package com.culmor30.fragmentsTesting;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

public class AsyncTask1 extends AsyncTask<Void, Integer, String> {
	private Activity context;
	private FragmentManager fmgr;
	
	public void updateActivity(Activity c, FragmentManager fm) {
		context = c;
		fmgr = fm;
	}
	
	@Override
	protected void onPreExecute() {
		new ProgressDialogFragment().show(fmgr, "DIALOG_F1");
	}
	
	@Override
	protected String doInBackground(Void... arg0) {
		int progress = 0;
		while(progress < 100) {
			progress += 10;
			SystemClock.sleep(1000);
			publishProgress(progress);
		}
		
		return "\"Done\"";
	}
	
	@Override
	protected void onProgressUpdate(Integer... ints) {
		ProgressDialogFragment d1 = (ProgressDialogFragment) fmgr.findFragmentByTag("DIALOG_F1");
		d1.dialog.setProgress(ints[0]);
	}
	
	@Override
	protected void onPostExecute(String result) {
		ProgressDialogFragment d1 = (ProgressDialogFragment) fmgr.findFragmentByTag("DIALOG_F1");
		d1.dismiss();
		
		Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
	}
}