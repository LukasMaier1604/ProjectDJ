package controller;

import java.io.*;
import java.net.*;
import java.util.HashMap;

import game.Closingclass;

public class TcpServer {
	public static void main(String[] args) {

//		HashMap <Integer,String>spielstand = Closingclass.getMap();



		int port = 4711; // Port-Nummer

		try (ServerSocket server = new ServerSocket(port)){

			System.out.println("Server gestartet!");

			while (true) {

				try (Socket socket = server.accept()) { // try-with-resources, Auf Verbindung warten, Methode blockiert
					// socket.setSoTimeout(5000);

					BufferedReader socketIn = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));				 // Inputstream vom Client
					PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true); // Outputstream zum Client mit autoflush

					String line = socketIn.readLine();
					
				
					System.out.println(line);
//						socketOut.println(spielstand.get(score));




				}
		}
			
		}catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

	



