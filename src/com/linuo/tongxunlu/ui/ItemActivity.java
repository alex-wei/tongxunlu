package com.linuo.tongxunlu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.data.AppData;
import com.linuo.tongxunlu.domain.User;

public class ItemActivity extends Activity {
	private int postion;
	private TextView mName,mPhone,mMobile;
	private User mUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.itempage);
		 Intent intent=getIntent();
		 postion=intent.getIntExtra("postion", -1);
		 initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		mName=(TextView) findViewById(R.id.name);
		mPhone=(TextView) findViewById(R.id.phone);
		mMobile=(TextView) findViewById(R.id.mobile);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(postion!=-1){
			mUser=AppData.departmentList.get(postion);
			if(!TextUtils.isEmpty(mUser.getS_Name())){
				mName.setVisibility(View.VISIBLE);
				mName.setText(mUser.getS_Name());
			}else{
				mName.setVisibility(View.GONE);
			}
			if(!TextUtils.isEmpty(mUser.getS_Phone())){
				mPhone.setVisibility(View.VISIBLE);
				mPhone.setText(mUser.getS_Phone());
			}else{
				mPhone.setVisibility(View.GONE);
			}
			if(!TextUtils.isEmpty(mUser.getS_Mobile())){
				mMobile.setVisibility(View.VISIBLE);
				mMobile.setText(mUser.getS_Mobile());
			}else{
				mMobile.setVisibility(View.GONE);
			}
		}
	}
}
