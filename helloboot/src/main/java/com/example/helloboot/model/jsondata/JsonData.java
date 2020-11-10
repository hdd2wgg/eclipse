package com.example.helloboot.model.jsondata;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonData {

	private int code;
	private Object data;
	private String msg;
	private int count;
	public JsonData() {}
	public JsonData(int code, Object data, String msg, int count) {
		this.code = code;
		this.data = data;
		this.msg = msg;
		this.count = count;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
//	int code,Object data,String msg,int count
	public JSONObject jsonData() {
		
		JSONObject job = new JSONObject();
		job.put("code", this.code);
		job.put("data", this.data);
		job.put("msg", this.msg);
		job.put("count", this.count);
		return job;
	}
}
