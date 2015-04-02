/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

/**
 *
 * @author RajatBhageria
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The server class - this will listen for incoming connections.
 * It will create a socket that is used for the communication.
 * @author swapneel
 *
 */
public class Server {
	private ServerSocket socket;
	private Socket client;
	private Scanner in;
	private PrintWriter out;
	
	/**
	 * The constructor
	 * @param port It will create a server socket on this port number
	 */
	public Server(int port) {
		try {
			socket = new ServerSocket(port);
                        ServerSocket s;
                        
			System.out.println("The server is started at port " + port);
			
			client = socket.accept();
			System.out.println("Yay!! Client connected!");
			
			in = new Scanner(client.getInputStream());
			out = new PrintWriter(client.getOutputStream(), true);
			doSomething();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnections();
			System.out.println("I hate all clients @$Q#%!@#");
		}
		
	}

	/**
	 * This methods gracefully closes all connections
	 */
	private void closeConnections() {
		// TODO Auto-generated method stub
		try {
			out.close();
			in.close();
			client.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void doSomething() {
		// TODO Auto-generated method stub
		while(in.hasNextLine()) {
			String message = in.nextLine();
                        //int first = message.substring(0,message.indexOf(" "));
                        
			System.out.println("The Client says: " + message);
			out.println("I am a cool server who also says: " + message);
		}
		
	}

}
