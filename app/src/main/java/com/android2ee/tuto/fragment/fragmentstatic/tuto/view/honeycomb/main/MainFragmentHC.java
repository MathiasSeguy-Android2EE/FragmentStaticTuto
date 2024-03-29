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
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android2ee.tuto.fragment.fragmentstatic.tuto.MApplication;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.R;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.dao.HumanDao;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.adapters.HumanArrayAdapter;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.callback.MainFragmentCallBack;
import com.android2ee.tuto.fragment.fragmentstatic.tuto.view.honeycomb.detail.DetailActivityHC;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
@SuppressLint("NewApi")
public class MainFragmentHC extends Fragment {
	/**
	 * The ListView
	 */
	private ListView listView;
	/**
	 * The arrayAdapter
	 */
	private HumanArrayAdapter arrayAdapter;
	/**
	 * The parent of the fragment (its callback/its activity container)
	 */
	private MainFragmentCallBack parent;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onAttach(android.app.Activity)
	 */
	@Override
	public void onAttach(Activity activity) {
		Log.w("MainFragmentHC", "onAttach called");
		super.onAttach(activity);
		// use this method to link the fragment with its parent/container
		parent = (MainFragmentCallBack) activity;
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		Log.w("MainFragmentHC", "onActivityCreated called");
		super.onActivityCreated(savedInstanceState);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.w("MainFragmentHC", "onCreate called");
		super.onCreate(savedInstanceState);
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onDestroy()
	 */
	@Override
	public void onDestroy() {
		Log.w("MainFragmentHC", "onDestroy called");
		super.onDestroy();
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onDestroyView()
	 */
	@Override
	public void onDestroyView() {
		Log.w("MainFragmentHC", "onDestroyView called");
		super.onDestroyView();
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onPause()
	 */
	@Override
	public void onPause() {
		Log.w("MainFragmentHC", "onPause called");
		super.onPause();
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onStart()
	 */
	@Override
	public void onStart() {
		Log.w("MainFragmentHC", "onStart called");
		super.onStart();
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onStop()
	 */
	@Override
	public void onStop() {
		Log.w("MainFragmentHC", "onStop called");
		super.onStop();
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onDetach()
	 */
	@Override
	public void onDetach() {
		Log.w("MainFragmentHC", "onDetach called");
		super.onDetach();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.w("MainFragmentHC", "onCreateView called");
		// inflate the view
		View view = inflater.inflate(R.layout.fragment_list, container, false);
		// Retrieve the ListView, EditText and Button
		listView = (ListView) view.findViewById(R.id.humanListView);
		// Create the adapter
		arrayAdapter = new HumanArrayAdapter(getActivity(), HumanDao.instance.getHumans());
		// bind the listView and its adapter.
		listView.setAdapter(arrayAdapter);
		// Add a listener on the listView
		listView.setClickable(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				onItemSelected(position);
			}
		});
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		Log.w("MainFragmentHC", "onResume called");
		super.onResume();
		// Update the selected item (the one that has been stored in the application object when the
		// user has selected an item before the activity has been destroyed and recreated due to a
		// Configuration change)
		// first find if it a two pane configuration or not
		Boolean twoPanes = getResources().getBoolean(R.bool.twoPane);
		// then retrieve the selected item
		int selectedItem = MApplication.getInstance().getSelectedItem();
		if (twoPanes) {
			// then make a full update, it will update the DetailFragmentHC and the arrayAdapter
			if (selectedItem != DetailActivityHC.ITEM_ID_DEFAULT_VALUE) {
				onItemSelected(selectedItem);
			}
		} else {
			// then do a gentle update (if we update the parent activity, it won't update the
			// DetailFragmentHC that is not displayed, but launch the DetailActivity and it's not the
			// goal here)
			if (selectedItem != DetailActivityHC.ITEM_ID_DEFAULT_VALUE) {
				onItemSelectedSimple(selectedItem);
			}
		}
	}

	/**
	 * An item has been updated, notify the change to every body
	 * @param position of the item
	 */
	public void onItemSelected(int position) {
		//Notify the parent that a new item has been selected
		parent.onItemSelected(position);
		//notify the arrayAdapter that an item has been selected
		arrayAdapter.setSelectedItem(position);
		//and notify the Application object too, it will persist the information when activity will be destroyed and recreated
		MApplication.getInstance().setSelectedItem(position);
	}

	/**
	 * An item has been updated, notify only the adapter of the change
	 * @param position of the item
	 */
	public void onItemSelectedSimple(int position) {
		arrayAdapter.setSelectedItem(position);
	}
}
