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
		TabSpec tabMyDepartment = mTabHost.newTabSpec("������");
		tabMyDepartment
				.setIndicator(getTabView(R.drawable.tab_main_nav_me, "������"));
		Intent myDepartment = new Intent(this, DepartmentGroup.class);
		myDepartment.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
		tabMyDepartment.setContent(myDepartment);
		mTabHost.addTab(tabMyDepartment);

		TabSpec tabCompany = mTabHost.newTabSpec("��������");
		tabCompany
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "��������"));
		Intent newCompany = new Intent(this, CompanyActivity.class);
		tabCompany.setContent(newCompany);
		mTabHost.addTab(tabCompany);
		
		TabSpec tabUnit = mTabHost.newTabSpec("ȫ��λ");
		tabUnit
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "ȫ��λ"));
		Intent newUnit = new Intent(this, UnitActivity.class);
		tabUnit.setContent(newUnit);
		mTabHost.addTab(tabUnit); 
		
		TabSpec tabMore = mTabHost.newTabSpec("���๦��");
		tabMore
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "���๦��"));
		Intent newMore = new Intent(this, MoreActivity.class);
		tabMore.setContent(newMore);
		mTabHost.addTab(tabMore);

	}

	/**
	 * ����ĳһ����Ŀ��indicator
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
			builder.setTitle("��ʾ");
			builder.setMessage("ȷ���˳���ŵͨѶ¼��?");
			builder.setPositiveButton("ȷ��", new OnClickListener() {
				
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			builder.setNegativeButton("ȡ��", new OnClickListener() {
				
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
