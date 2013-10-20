package com.linuo.tongxunlu.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.data.AppData;
import com.linuo.tongxunlu.domain.User;

public class PersonFragment extends Fragment {
	
	private int postion;
	private TextView mName,mPhone,mMobile;
	private User mUser;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Bundle data=getArguments();
		postion=data.getInt("position");
		View view =inflater.inflate(R.layout.itempage, null);
		mName=(TextView) view.findViewById(R.id.name);
		mPhone=(TextView) view.findViewById(R.id.phone);
		mMobile=(TextView) view.findViewById(R.id.mobile);
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
		return view;
	}

}
