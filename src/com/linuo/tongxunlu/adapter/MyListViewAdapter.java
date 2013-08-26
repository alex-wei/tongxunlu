package com.linuo.tongxunlu.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.data.AppData;
import com.linuo.tongxunlu.domain.User;


public class MyListViewAdapter extends BaseAdapter {
	private LayoutInflater mInflater = null;
	private Context mContext;
	private List mDataList;
	public MyListViewAdapter(Context context,List list)
	{
		mContext=context;
		mInflater=LayoutInflater.from(context);
		mDataList=list;
	}
	
	public int getCount() {
		// TODO Auto-generated method stub
		return mDataList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDataList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder = null;
		User user=(User) AppData.departmentList.get(position);
		if(null == convertView)
		{
			mHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item, null);
			mHolder.itemName = (TextView)convertView.findViewById(R.id.txtName);
			convertView.setTag(mHolder);
		}else
		{
			mHolder = (ViewHolder)convertView.getTag();
		}
//		mHolder.itemName.setText((String)mVideoList.get(position).getmTitle());
		mHolder.itemName.setText(user.getS_Name());
		
		return convertView;
	}
	public static class ViewHolder
	{
		public TextView itemName;
	}

}
