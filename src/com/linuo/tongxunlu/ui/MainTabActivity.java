package com.linuo.tongxunlu.ui;

import java.util.HashMap;
import java.util.Stack;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.base.AppConstants;

public class MainTabActivity extends FragmentActivity {
	private TabHost mTabHost;
    private HashMap<String, Stack<Fragment>> mStacks;

    private String mCurrentTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.maintab);
		super.onCreate(savedInstanceState);
		mStacks = new HashMap<String, Stack<Fragment>>();
	    mStacks.put(AppConstants.TAB_A, new Stack<Fragment>());
	    mStacks.put(AppConstants.TAB_B, new Stack<Fragment>());
	    mStacks.put(AppConstants.TAB_C, new Stack<Fragment>());
	    mStacks.put(AppConstants.TAB_D, new Stack<Fragment>());
		mTabHost = (TabHost)findViewById(android.R.id.tabhost);
		mTabHost.setOnTabChangedListener(listener);
		mTabHost.setup();
		TabSpec tabMyDepartment = mTabHost.newTabSpec(AppConstants.TAB_A);
		mTabHost.setCurrentTabByTag(AppConstants.TAB_A);
		tabMyDepartment
				.setIndicator(getTabView(R.drawable.tab_main_nav_me, "本部门"));
//		Intent myDepartment = new Intent(this, DepartmentFragmentActivity.class);
//		myDepartment.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
		tabMyDepartment.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
		mTabHost.addTab(tabMyDepartment);

		TabSpec tabCompany = mTabHost.newTabSpec(AppConstants.TAB_B);
		tabCompany
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "其他部门"));
//		Intent newCompany = new Intent(this, CompanyActivity.class);
		tabCompany.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
		mTabHost.addTab(tabCompany);
		
		TabSpec tabUnit = mTabHost.newTabSpec(AppConstants.TAB_C);
		tabUnit
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "全单位"));
//		Intent newUnit = new Intent(this, UnitActivity.class);
		tabUnit.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
		mTabHost.addTab(tabUnit); 
		
		TabSpec tabMore = mTabHost.newTabSpec(AppConstants.TAB_D);
		tabMore
		.setIndicator(getTabView(R.drawable.tab_main_nav_book, "更多功能"));
//		Intent newMore = new Intent(this, MoreActivity.class);
		tabMore.setContent(new TabHost.TabContentFactory() {
            public View createTabContent(String tag) {
                return findViewById(R.id.realtabcontent);
            }
        });
		mTabHost.addTab(tabMore);
	}
	 TabHost.OnTabChangeListener listener = new TabHost.OnTabChangeListener() {
	      public void onTabChanged(String tabId) {
	        mCurrentTab = tabId;
	        if(mStacks.get(tabId).size() == 0){
	          if(tabId.equals(AppConstants.TAB_A)){
	            pushFragments(tabId, new DepartmentFragment(), false,true);
	          }
	         /* else if(tabId.equals(AppConstants.TAB_B)){
	            pushFragments(tabId, new DepartmentFragment(), false,true);
	          }
	          else if(tabId.equals(AppConstants.TAB_C)){
	        	pushFragments(tabId, new DepartmentFragment(), false,true);
	          }
	          else if(tabId.equals(AppConstants.TAB_D)){
	    	  pushFragments(tabId, new DepartmentFragment(), false,true);
	          }*/
	        }else {
	          pushFragments(tabId, mStacks.get(tabId).lastElement(), false,false);
	        }
	      }
	    };

	/**
	 * 返回某一个条目的indicator
	 * 
	 * @param icon
	 * @param text
	 * @return
	 */
	    public void pushFragments(String tag, Fragment fragment,boolean shouldAnimate, boolean shouldAdd){
	        if(shouldAdd)
	            mStacks.get(tag).push(fragment);
	        FragmentManager   manager         =   getSupportFragmentManager();
	        FragmentTransaction ft            =   manager.beginTransaction();
	        if(shouldAnimate)
	            ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
	        ft.replace(R.id.realtabcontent, fragment);
	        ft.commit();
	      }


	      public void popFragments(){
	        Fragment fragment = mStacks.get(mCurrentTab).elementAt(mStacks.get(mCurrentTab).size() - 2);
	        mStacks.get(mCurrentTab).pop();
	        FragmentManager   manager         =   getSupportFragmentManager();
	        FragmentTransaction ft            =   manager.beginTransaction();
	        ft.replace(R.id.realtabcontent, fragment);
	        ft.commit();
	      }   


	  @Override
	  public void onBackPressed() {
	 		if(mStacks.get(mCurrentTab).size() == 1){
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
	 		}else{
	 			popFragments();
	 		}
	  	}
	private View getTabView(int icon, String text) {
		View view = View.inflate(this, R.layout.tab_main_nav, null);
		ImageView iv_icon = (ImageView) view.findViewById(R.id.ivIcon);
		TextView tv_tilte = (TextView) view.findViewById(R.id.tvTitle);
		iv_icon.setImageResource(icon);
		tv_tilte.setText(text);
		return view;
	}

	/*@Override
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
	}*/
}
