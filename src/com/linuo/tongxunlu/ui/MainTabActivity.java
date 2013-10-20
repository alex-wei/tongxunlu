package com.linuo.tongxunlu.ui;

import com.linuo.tongxunlu.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class MainTabActivity extends TabActivity {
	private TabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.maintab);
		super.onCreate(savedInstanceState);
		mTabHost = getTabHost();
		TabSpec tabMyDepartment = mTabHost.newTabSpec("本部门");
		tabMyDepartment
				.setIndicator(getTabView(R.drawable.tab_main_nav_me, "本部门"));
		Intent myDepartment = new Intent(this, DepartmentFragmentActivity.class);
		myDepartment.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
		tabMyDepartment.setContent(myDepartment);
		mTabHost.addTab(tabMyDepartment);

		TabSpec tabCompany = mTabHost.newTabSpec("其他部门");
		tabCompany
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "其他部门"));
		Intent newCompany = new Intent(this, CompanyActivity.class);
		tabCompany.setContent(newCompany);
		mTabHost.addTab(tabCompany);
		
		TabSpec tabUnit = mTabHost.newTabSpec("全单位");
		tabUnit
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "全单位"));
		Intent newUnit = new Intent(this, UnitActivity.class);
		tabUnit.setContent(newUnit);
		mTabHost.addTab(tabUnit); 
		
		TabSpec tabMore = mTabHost.newTabSpec("更多功能");
		tabMore
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "更多功能"));
		Intent newMore = new Intent(this, MoreActivity.class);
		tabMore.setContent(newMore);
		mTabHost.addTab(tabMore);

	}

	/**
	 * 返回某一个条目的indicator
	 * 
	 * @param icon
	 * @param text
	 * @return
	 */
	private View getTabView(int icon, String text) {
		View view = View.inflate(this, R.layout.tab_main_nav, null);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.ivIcon);
		TextView tv_tilte = (TextView) view.findViewById(R.id.tvTitle);
		iv_icon.setImageResource(icon);
		tv_tilte.setText(text);
		return view;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			AlertDialog.Builder builder = new Builder(this);
			builder.setTitle("提示");
			builder.setMessage("确定退出力诺通讯录吗?");
			builder.setPositiveButton("确定", new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			builder.setNegativeButton("取消", new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			
			builder.create().show();
			return true;
		}

		return super.dispatchKeyEvent(event);
	}
}
