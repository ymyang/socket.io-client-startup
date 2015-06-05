package com.ymicloud.socketio;


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
        	new Thread(new ChatUser(11, "user11")).start();
        	new Thread(new ChatUser(12, "user12")).start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
}
