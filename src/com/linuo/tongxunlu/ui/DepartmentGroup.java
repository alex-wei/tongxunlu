package com.linuo.tongxunlu.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

public class DepartmentGroup extends ActivityGroup {
	private ArrayList<String> mIdList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if (mIdList == null)
			mIdList = new ArrayList<String>();
		startChildActivity("DepartmentActivity", new Intent(DepartmentGroup.this,
				DepartmentActivity.class));
	}
	@Override
	public void finishActivityFromChild(Activity child, int requestCode) {
		LocalActivityManager manager = getLocalActivityManager();
		int index = mIdList.size() - 1;
		if (index < 1) {
			// finish();
			return;
		}
		manager.destroyActivity(mIdList.get(index), true);
		mIdList.remove(index);
		index--;
		String lastId = mIdList.get(index);
		Intent lastIntent = manager.getActivity(lastId).getIntent();
		lastIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		Window newWindow = manager.startActivity(lastId, lastIntent);
		setContentView(newWindow.getDecorView());
	}
	
	public void startChildActivity(String Id, Intent intent) {

		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		Window window = getLocalActivityManager().startActivity(Id, intent);
		View tmp = window.getDecorView();

		if (window != null) {
			mIdList.add(Id);
			setContentView(tmp);
		}
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
		
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (mIdList.size() == 1) {
				return false;
			}
			onBackPressed();
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	
	@Override
	public void onBackPressed() {
		int length = mIdList.size();
		if (length > 1) {
			Activity current = getLocalActivityManager().getActivity(
					mIdList.get(length - 1));
			current.finish();
		}
	}
	
	public void goBack() {
		if (mIdList.size() != 1) {
			onBackPressed();
		}
	}
}
