package com.ymicloud.socketio;

public class Msg {

	private long userId;
	private String data;
	public Msg(long userId, String data) {
		this.userId = userId;
		this.data = data;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "{\"userId\":" + userId + ", \"data\":\"" + data + "\"}";
	}
	
}
