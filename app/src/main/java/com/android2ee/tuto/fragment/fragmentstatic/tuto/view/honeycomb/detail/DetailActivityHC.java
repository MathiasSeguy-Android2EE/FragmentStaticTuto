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
package com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import com.android2ee.tuto.fragment.fragmentstatic.tuto.R;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
@SuppressLint("NewApi")
public class DetailActivityHC extends Activity {
	/**
	 * Constant for default value of an item not iniitialized
	 */
	public static final int ITEM_ID_DEFAULT_VALUE = -1;
	/**
	 * The item id displayed
	 */
	private int itemId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// first of all, if there are 2 panes displayed, kill this activity and go back to the main
		// activity which will displayed the both fragment
		// this is tricky and occurs when device rotate from portrait to landscape
		Boolean twoPanes = getResources().getBoolean(R.bool.twoPane);
		if (twoPanes) {
			finish();
		}
		// Else, we are on one pane, so do the stuff:
		super.onCreate(savedInstanceState);
		// set the view
		setContentView(R.layout.detail_activity_one_pane_hc);
		// retrieve the id of the element to display
		itemId = getIntent().getIntExtra(DetailFragmentHC.ITEM_ID, ITEM_ID_DEFAULT_VALUE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		Log.w("DetailActivity onResume", "DetailActivity : onResume");
		super.onResume();
		// find the fragment manager
		FragmentManager fm = getFragmentManager();
		// retrieve the DetailFragmentHC
		DetailFragmentHC detailFragmentHC = (DetailFragmentHC) fm.findFragmentById(R.id.detail_fragment);
		// and update it
		if (itemId != ITEM_ID_DEFAULT_VALUE) {
			detailFragmentHC.updateData(itemId);
		}

	}

}
