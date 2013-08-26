package com.linuo.tongxunlu.domain;

public class User {
	
	/*{'N_ID':1,'N_FilieId':2,'N_DepId':3,'S_Name':'ºÎ¾¸','S_Post':'¾­Àí',
	 *'S_Phone':'65614890','S_Mobile':'13888734179',
	 *'EntityState':2,'EntityKey':{'EntitySetName':'T_UserInfo','EntityContainerName':'Entities',
	 *'EntityKeyValues':[{'Key':'N_ID','Value':1}],'IsTemporary':false}}
	 * 
	 * 
	 * 
	 */
	private String N_DepId;
	private String S_Name;
	private String S_Post;
	private String S_Phone;
	private String S_Mobile;
	public String getN_DepId() {
		return N_DepId;
	}
	public void setN_DepId(String n_DepId) {
		N_DepId = n_DepId;
	}
	public String getS_Name() {
		return S_Name;
	}
	public void setS_Name(String s_Name) {
		S_Name = s_Name;
	}
	public String getS_Post() {
		return S_Post;
	}
	public void setS_Post(String s_Post) {
		S_Post = s_Post;
	}
	public String getS_Phone() {
		return S_Phone;
	}
	public void setS_Phone(String s_Phone) {
		S_Phone = s_Phone;
	}
	public String getS_Mobile() {
		return S_Mobile;
	}
	public void setS_Mobile(String s_Mobile) {
		S_Mobile = s_Mobile;
	}
	
}
