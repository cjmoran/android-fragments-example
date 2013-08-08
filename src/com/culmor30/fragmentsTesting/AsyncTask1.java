package com.culmor30.fragmentsTesting;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

public class AsyncTask1 extends AsyncTask<Void, Integer, String> {
	private Activity context;
	private FragmentManager fmgr;
	private static boolean interrupted = false;
	
	public void updateActivity(Activity c, FragmentManager fm) {
		context = c;
		fmgr = fm;
	}
	
	
	@Override
	protected void onPreExecute() {
		interrupted = false;
		ProgressDialogFragment pdf = new ProgressDialogFragment();
		pdf.show(fmgr, "DIALOG_F1");
	}
	
	@Override
	protected String doInBackground(Void... arg0) {
		int progress = 0;
		while(progress < 100) {
			if(interrupted)
				break;	//Kills our AsyncTask if the task has been cancelled
			
			progress += 10;
			SystemClock.sleep(1000);
			publishProgress(progress);
		}
		
		return "\"Done\"";
	}
	
	@Override
	protected void onProgressUpdate(Integer... ints) {
		ProgressDialogFragment d1 = (ProgressDialogFragment) fmgr.findFragmentByTag("DIALOG_F1");
		if(d1 != null) {
			d1.dialog.setProgress(ints[0]);
		}
	}
	
	@Override
	protected void onPostExecute(String result) {
		ProgressDialogFragment d1 = (ProgressDialogFragment) fmgr.findFragmentByTag("DIALOG_F1");
		if(d1 != null)
			fmgr.beginTransaction().remove(d1).commitAllowingStateLoss();	//works even if state is lost
		
		Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
	}
	
	public static void interruptTask() {
		interrupted = true;
	}
}