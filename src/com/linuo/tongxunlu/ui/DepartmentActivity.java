package com.linuo.tongxunlu.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.adapter.MyListViewAdapter;
import com.linuo.tongxunlu.data.AppData;
public class DepartmentActivity extends Activity {
	private ListView lv;
	private LinearLayout userinfoLayout,userNameLayout,userPhoneLayout;
	private TextView userNameText,UserPhoneText;
//	private 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.department);
		lv = (ListView) findViewById(R.id.melistview);
		userinfoLayout=(LinearLayout) findViewById(R.id.userinfo);
		userNameText=(TextView) findViewById(R.id.user_name);
		UserPhoneText=(TextView) findViewById(R.id.phone_number);
		lv.setDivider(new ColorDrawable(Color.TRANSPARENT));
		lv.setDividerHeight(5);
		lv.setAdapter(new MyListViewAdapter(this, AppData.departmentList));
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
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
