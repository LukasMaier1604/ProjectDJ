package controller;

import java.io.*;
import java.net.*;
import java.util.Map;


public class TcpClient {
	private static String hostName = "localhost"; 
	private static int port = 4711;
	
	public static void serverLog(String player, int score) {
	
	
	try (Socket socket = new Socket(hostName, port)){
		BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
		PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true); 
		
		
	
		socketOut.println("Der Spieler: " + player +" hat einen Score von "+ score+ " Punkten erreicht" );		

	} 
	catch (UnknownHostException ue) {
		System.out.println("Kein DNS-Eintrag fuer " + hostName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
}
}





