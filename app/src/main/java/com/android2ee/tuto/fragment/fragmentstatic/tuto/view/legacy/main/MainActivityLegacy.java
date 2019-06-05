/**<ul>
 * <li>FragmentStaticTuto</li>
 * <li>com.android2ee.tuto.fragment.fragmentstatic.tuto.view.legacy</li>
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
package com.android2ee.tuto.fragment.fragmentstatic.tuto.view.legacy.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.view.Menu;

import com.android2ee.tuto.fragment.fragmentstatic.tuto.R;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.callback.MainFragmentCallBack;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail.DetailActivityHC;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail.DetailFragmentHC;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.legacy.detail.DetailActivityLegacy;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.legacy.detail.DetailFragmentLegacy;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 * This class aims to:
 * <ul><li></li></ul>
 */
public class MainActivityLegacy extends FragmentActivity implements MainFragmentCallBack{


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ok build the view, nothing more, every thing is handled by the fragment which displays the data
		setContentView(R.layout.activity_main);
		
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
			FragmentManager fm = getSupportFragmentManager();
			// retrieve the DetailFragmentHC
			DetailFragmentLegacy detailFragmentLeg = (DetailFragmentLegacy) fm.findFragmentById(R.id.detail_fragment);
			if (null == detailFragmentLeg) {
				// should not be
				detailFragmentLeg = new DetailFragmentLegacy();
			}
			// and update it
			detailFragmentLeg.updateData(itemId);
		} else {
			// Launch the second activity
			Intent detailIntent = new Intent(this, DetailActivityLegacy.class);
			// add parameter to the intent to pass it to the activity
			detailIntent.putExtra(DetailFragmentLegacy.ITEM_ID, itemId);
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
