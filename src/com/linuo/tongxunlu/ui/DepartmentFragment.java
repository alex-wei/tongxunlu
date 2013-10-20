package com.linuo.tongxunlu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.adapter.MyListViewAdapter;
import com.linuo.tongxunlu.data.AppData;

public class DepartmentFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		 Activity activity = getActivity();
	        
	        if (activity != null) {
	        	MyListViewAdapter listAdapter = new MyListViewAdapter(activity, AppData.departmentList);
	        	setListAdapter(listAdapter);
	        }
	}
	 @Override
	    public void onListItemClick(ListView l, View v, int position, long id) {
		 FragmentManager fm = getFragmentManager();
         
         if (fm != null) {
        	 PersonFragment person=new PersonFragment();
        	 Bundle data=new Bundle();
        	 data.putInt("position", position);
        	 person.setArguments(data);
             FragmentTransaction ft = fm.beginTransaction();
             ft.replace(R.id.department_container, person);
             ft.addToBackStack(null);
             ft.commit();
         }
	    }
}
