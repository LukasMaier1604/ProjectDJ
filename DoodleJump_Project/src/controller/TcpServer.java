package controller;

import java.io.*;
import java.net.*;
import java.util.Calendar;



public class TcpServer {
	private static Calendar cal = Calendar.getInstance();
	public static void main(String[] args) {

		int port = 4711; // Port-Nummer

		try (ServerSocket server = new ServerSocket(port)){

			System.out.println("Server gestartet!  Datum: " + cal.get(Calendar.DAY_OF_MONTH)+"."+ cal.get(Calendar.MONTH)+"."+cal.get(Calendar.YEAR) );

			while (true) {

				try (Socket socket = server.accept()) { 

					BufferedReader socketIn = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));				 // Inputstream vom Client
					PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true); // Outputstream zum Client 

					String line = socketIn.readLine();
					
				
					System.out.println(line +"      um "+ cal.get( Calendar.HOUR ) + ":" +cal.get( Calendar.MINUTE ) + " Uhr" ); 	// Ausgabe des Spielstandes nach Game Over siehe DoodleApp Methode serverLog
				}
			}
		}catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

	



