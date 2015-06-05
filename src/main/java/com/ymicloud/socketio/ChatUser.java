package com.ymicloud.socketio;

import com.github.nkzawa.emitter.Emitter.Listener;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class ChatUser implements Runnable {

	private long userId;
	private String username;

	private int count = 0;

	public ChatUser(long userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public void run() {
        try {
        	final Socket socket = IO.socket("http://127.0.0.1:3000?userId=" + userId);
        	socket.on(Socket.EVENT_CONNECT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect]:" + username);
					sendMsg(socket);
				}
			});
        	socket.on(Socket.EVENT_DISCONNECT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[disconnect]:" + username);
				}
			});
        	socket.on(Socket.EVENT_CONNECT_ERROR, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect_error]:" + username);
					
				}
			});
        	socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect_timeout]:" + username);
					
				}
			});
        	socket.on(Socket.EVENT_ERROR, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[error]:" + username);
				}
			});
        	socket.on(Socket.EVENT_MESSAGE, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[message]-" + username + ":" + arg0[0]);
					sendMsg(socket);
				}
			});
        	socket.connect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void sendMsg(Socket socket) {
		int id = 11;
		if (userId == 11) {
			id = 12;
		}
		Msg msg = new Msg(id, username + " " + (count++));
		socket.emit(Socket.EVENT_MESSAGE, msg);
	}

}
