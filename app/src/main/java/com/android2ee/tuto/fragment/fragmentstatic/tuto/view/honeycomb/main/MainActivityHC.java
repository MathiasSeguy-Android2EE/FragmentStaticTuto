/**<ul>
 * <li>FragmentStaticTuto</li>
 * <li>com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb</li>
 * <li>16 oct. 2012</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage except training and can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.android2ee.tuto.fragment.fragmentstatic.tuto.R;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.dao.HumanDao;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.adapters.HumanArrayAdapter;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.callback.MainFragmentCallBack;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail.DetailActivityHC;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail.DetailFragmentHC;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to display either a human list and an human detail panel or just the humanList
 */
@SuppressLint({ "NewApi" })
public class MainActivityHC extends Activity implements MainFragmentCallBack {
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.e("MainActivityHC", "onCreate called");
		super.onCreate(savedInstanceState);
		//ok build the view, nothing more, every thing is handled by the fragment which displays the data
		setContentView(R.layout.activity_main);
		Log.e("MainActivityHC", "onCreate finished");
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onRestoreInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.e("MainActivityHC", "onRestoreInstanceState called");
		super.onRestoreInstanceState(savedInstanceState);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.e("MainActivityHC", "onSaveInstanceState called");
		super.onSaveInstanceState(outState);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		Log.e("MainActivityHC", "onPause called");
		super.onPause();
		Log.e("MainActivityHC", "onPause finished");
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		Log.e("MainActivityHC", "onStart called");
		super.onStart();
		Log.e("MainActivityHC", "onStart finished");
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.e("MainActivityHC", "onStop called");
		super.onStop();
		Log.e("MainActivityHC", "onStop finished");
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.e("MainActivityHC", "onDestroy called");
		super.onDestroy();
		Log.e("MainActivityHC", "onDestroy finished");
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.e("MainActivityHC", "onResume called");
		super.onResume();
		Log.e("MainActivityHC", "onResume finished");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.main.MainFragmentCallBack#
	 * onItemSelected(int)
	 */
	@Override
	public void onItemSelected(int itemId) {	
		//Depending on the number of pane we either update the detailFragment either launch the DetailActivity
		boolean twoPane = getResources().getBoolean(R.bool.twoPane);
		if (twoPane) {
			// find the fragment manager
			FragmentManager fm = getFragmentManager();
			// retrieve the DetailFragmentHC
			DetailFragmentHC detailFragmentHC = (DetailFragmentHC) fm.findFragmentById(R.id.detail_fragment);
			if (null == detailFragmentHC) {
				// should not be
				detailFragmentHC = new DetailFragmentHC();
			}
			// and update it
			detailFragmentHC.updateData(itemId);
		} else {
			// Launch the second activity
			Intent detailIntent = new Intent(this, DetailActivityHC.class);
			// add parameter to the intent to pass it to the activity
			detailIntent.putExtra(DetailFragmentHC.ITEM_ID, itemId);
			// launch the intent and start other activity
			startActivity(detailIntent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//inflate the menu
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
