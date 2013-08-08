/*
 * 	This is a test of the fragment support libraries for Android 1.6+
 * 	And also AsyncTask rotation + DialogFragments
 * 	
 * 	By Cullin Moran
 * 
 * 	Using reference: http://developer.android.com/guide/topics/fundamentals/fragments.html
 * 	And also: http://stackoverflow.com/questions/8417885/android-fragments-retaining-an-asynctask-during-screen-rotation-or-configuratio
 */

package com.culmor30.fragmentsTesting;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentsTestingActivity extends FragmentActivity{
	private final int FRAGMENT_1 = 0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Add fragment 1 without XML
        FragmentManager fragmentManager = getSupportFragmentManager();	//"support" because we're using the support libraries
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        Fragment1 fragment1 = Fragment1.newInstance(FRAGMENT_1);
        fragment1.setRetainInstance(true);
        fragmentTransaction.add(R.id.main_viewgroup, fragment1);
        fragmentTransaction.commit();
	}
}