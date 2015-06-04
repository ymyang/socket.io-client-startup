package com.ymicloud.socketio;

import com.github.nkzawa.emitter.Emitter.Listener;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
        	final Socket socket = IO.socket("http://127.0.0.1:3000");
        	socket.on(Socket.EVENT_CONNECT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect]:" + arg0);
					socket.emit("event", "[event]: hello");
					socket.emit("message", "[messsage]: hello");
				}
			});
        	socket.on(Socket.EVENT_DISCONNECT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[disconnect]:" + arg0);
				}
			});
        	socket.on(Socket.EVENT_CONNECT_ERROR, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect_error]:" + arg0);
					
				}
			});
        	socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[connect_timeout]:" + arg0);
					
				}
			});
        	socket.on(Socket.EVENT_ERROR, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[error]:" + arg0);
				}
			});
        	socket.on("event", new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[event]:" + arg0[0]);
				}
			});
        	socket.on(Socket.EVENT_MESSAGE, new Listener() {
				
				public void call(Object... arg0) {
					System.out.println("[message]:" + arg0[0]);
				}
			});
        	socket.connect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
}
