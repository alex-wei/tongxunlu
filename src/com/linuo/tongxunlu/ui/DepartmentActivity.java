package com.linuo.tongxunlu.ui;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.adapter.MyListViewAdapter;
import com.linuo.tongxunlu.data.AppData;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;
public class DepartmentActivity extends Activity {
	private ListView lv;
//	private 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.department);
		lv = (ListView) findViewById(R.id.melistview);
		lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
		lv.setDividerHeight(5);
		lv.setAdapter(new MyListViewAdapter(this, AppData.departmentList));
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
}
