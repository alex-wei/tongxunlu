package com.linuo.tongxunlu.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.adapter.MyListViewAdapter;
import com.linuo.tongxunlu.data.AppData;
import com.linuo.tongxunlu.domain.User;
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
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent =new Intent();
				intent.setClass(DepartmentActivity.this, ItemActivity.class);
				intent.putExtra("postion", arg2);
				startActivity(intent);
			}
			
		});
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
