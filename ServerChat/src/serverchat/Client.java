/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This is the client for the socket communication.
 * @author swapneel
 *
 */
public class Client {
	private Socket socket;
	private Scanner in;
	private PrintWriter out;
	
	/**
	 * This will connect to the server on the specified port
	 * @param servername
	 * @param port
	 */
	public Client(String servername, int port) {
		try {
			socket = new Socket(servername, port);
			System.out.println("Connected to server!");
			
			in = new Scanner(socket.getInputStream());
			out = new PrintWriter(socket.getOutputStream(), true);
			askUser();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnections();
		}
	}

	private void closeConnections() {
		// TODO Auto-generated method stub
		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void askUser() {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in);
		
		while(true) {
			System.out.println("Please enter a message to send to the server");
			String message = userInput.nextLine();
			
                        
                        
			out.println(message);
			String serverMessage = in.nextLine();
			System.out.println(serverMessage);
		}
		
	}

}
