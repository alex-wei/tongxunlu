package com.linuo.tongxunlu.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.linuo.tongxunlu.R;
import com.linuo.tongxunlu.data.AppData;
import com.linuo.tongxunlu.domain.UpdateInfo;
import com.linuo.tongxunlu.domain.User;

public class SplashActivity extends Activity {
	private UpdateInfo info;
	private static final int GET_INFO_SUCCESS = 10;
	private static final int SERVER_ERROR = 11;
	private static final int SERVER_URL_ERROR = 12;
	private static final int PROTOCOL_ERROR = 13;
	private static final int IO_ERROR = 14;
	private static final int XML_PARSE_ERROR = 15;
	private static final int DOWNLOAD_SUCCESS = 16;
	private static final int DOWNLOAD_ERROR = 17;
	private static final String OTHER_DEPARTMENT="http://116.55.226.216:903/admin/phone/DepartmentList.aspx";
	private static final String COMPANY="http://116.55.226.216:903/admin/phone/FilialeList.aspx";
	protected static final String TAG = "SplashActivity";
	private long startTime;
	private long endTime;
	private Handler handler= new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_INFO_SUCCESS:
				loadMainUI();
				break;

			default:
				break;
			}
			
		};
	};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Thread(){

			@Override
			public void run() {
				startTime = System.currentTimeMillis();
				Message msg = Message.obtain();
				String content = "";
				try {
					String serverurl ="http://116.55.226.216:903/Admin/Phone/UserList.aspx";
					URL url = new URL(serverurl);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(5000);
					int code = conn.getResponseCode();
					String subStr[]=null;
					if (code == 200) {
						
						InputStream is = conn.getInputStream();
						InputStreamReader isr = new InputStreamReader(is,"utf-8");
						 int i;

			                while ((i = isr.read()) != -1) {

			                        content = content + (char) i;
			                }
			                isr.close();
			                try {
								AppData.departmentList=loadJson(content);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
//						info = UpdateInfoParser.getUpdateInfo(is);
						endTime = System.currentTimeMillis();
						long resulttime = endTime - startTime;
						if (resulttime < 2000) {
							try {
								Thread.sleep(2000 - resulttime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						msg.what = GET_INFO_SUCCESS;
						handler.sendMessage(msg);
					} else {
						// ������״̬����.
						msg.what = SERVER_ERROR;
						handler.sendMessage(msg);
						endTime = System.currentTimeMillis();
						long resulttime = endTime - startTime;
						if (resulttime < 2000) {
							try {
								Thread.sleep(2000 - resulttime);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				} catch (MalformedURLException e) {
					e.printStackTrace();
					msg.what = SERVER_URL_ERROR;
					handler.sendMessage(msg);
				} catch (ProtocolException e) {
					msg.what = PROTOCOL_ERROR;
					handler.sendMessage(msg);
					e.printStackTrace();
				} catch (IOException e) {
					msg.what = IO_ERROR;
					handler.sendMessage(msg);
					e.printStackTrace();
				} 
			}
        	
        }.start();
    }
 
    private List<User> loadJson(String jsonStr) throws Exception {
		List<User> users = new ArrayList<User>();
		
		JSONArray arr = new JSONArray(jsonStr);		// ͨ�����˴��ص��ַ�, ����JSONArray
		
		for (int i = 0; i < arr.length(); i++) {				// ѭ������ÿһ��JSONObject
			JSONObject obj = arr.getJSONObject(i);
			User user = new User();
			user.setN_DepId(obj.getString("N_DepId"));
			user.setS_Name(obj.getString("S_Name"));
			user.setS_Post(obj.getString("S_Post"));
			user.setS_Phone(obj.getString("S_Phone"));
			user.setS_Mobile(obj.getString("S_Mobile"));
			users.add(user);
		}
		return users;
	}
    
    private void loadMainUI() {
		Intent intent = new Intent(this, MainTabActivity.class);
		startActivity(intent);
		finish();// �ѵ�ǰ��activity������ջ�����Ƴ�
	}
}