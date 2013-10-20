package com.linuo.tongxunlu.ui;

import com.linuo.tongxunlu.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

public class DepartmentFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.department_fragment);
		 FragmentManager fm = getSupportFragmentManager();
         
         if (fm != null) {
             FragmentTransaction ft = fm.beginTransaction();
             ft.replace(R.id.department_container, new DepartmentFragment());
             ft.commit();
         }
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			 FragmentManager fm = getSupportFragmentManager();
			 if (fm != null) {
				 fm.popBackStack();
				 return true;
	         }
			 else 
				 return false;
		}
		return super.onKeyDown(keyCode, event);
	}
}
