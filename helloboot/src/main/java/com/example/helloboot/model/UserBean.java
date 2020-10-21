package com.example.helloboot.model;

public class UserBean {

	private String phone;				// 电话号码
	private int usertype;				// 用户类型
	private String pwd;					// 登录密码
//	private long register_time;			// 注册时间
	public UserBean() {}
	public UserBean(String phone, int usertype, String pwd) {
		this.phone = phone;
		this.usertype = usertype;
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
