package com.linuo.tongxunlu.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.adapter.MyListViewAdapter;
import com.linuo.tongxunlu.base.AppConstants;
import com.linuo.tongxunlu.data.AppData;

public class DepartmentFragment extends Fragment {
	private ListView lv;
	
	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		 View view =inflater.inflate(R.layout.department, container,false);
		 lv = (ListView) view.findViewById(R.id.melistview);
			lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
			lv.setDividerHeight(5);
			lv.setAdapter(new MyListViewAdapter(getActivity(), AppData.departmentList));
			lv.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					Fragment fragment=new PersonFragment();
					Bundle data=new Bundle();
					data.putInt("position", arg2);
					fragment.setArguments(data);
					((MainTabActivity)getActivity()).pushFragments(AppConstants.TAB_A, fragment, false, true);
				}
				
			});
		return view;
	}
}
