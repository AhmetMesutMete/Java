package network;

import database.createTable.DataBaseManagement;
import gui.TwitterApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ServerBroadcast{
	TwitterApp twitterApp = new TwitterApp();

	DataBaseManagement dbM;

	{
		try {
			dbM = new DataBaseManagement();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	private ServerSocket socket;
	private ArrayList<Socket> ClientList = new ArrayList<Socket>();
	private int PORT = 1234;
	private int counter;
	public ServerBroadcast() {
		try {
			
			socket = new ServerSocket(PORT);

		} catch(IOException e) {
			e.getStackTrace();
		}
		counter =0;
		(new Thread(new ListenForClients())).start();
	}
	
	class ListenForClients implements Runnable{
		
		@Override
		public void run() {
			while(true) {
				Socket socketClient = null;
				
				try {
					socketClient = socket.accept();
				}catch(IOException e) {
					e.getStackTrace();
				}
				
				ClientList.add(socketClient);
				counter++;
				twitterApp.showClients(counter);
				twitterApp.setVisible(true);
				System.out.println("New Client, Total: "+ ClientList.size());
				(new Thread(new ReadFromClient(socketClient, counter))).start();
			}
		}
	}
	
	class ReadFromClient implements Runnable{
		private int clientNumber;
		private Scanner ClientInput;
		
		public ReadFromClient(Socket sk, int number) {
			try {
				 ClientInput = new Scanner(sk.getInputStream());
				 clientNumber = number;
			} 
			catch(IOException e) {
				e.getStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					String Message =  ClientInput.nextLine();

					//System.out.println("DEBUG "+Message);
					twitterApp.showMessages(clientNumber,Message);
					dbM.addMessage(clientNumber,Message);
					twitterApp.setVisible(true);
					(new Thread(new BroadcastToClients(Message, clientNumber))).start();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
		}
	}
	
	class BroadcastToClients implements Runnable{

		private String MessageToBroadcast;
		
		public BroadcastToClients(String Message, int CN ) {
			 MessageToBroadcast = "Client " + CN +" : " +Message ;
		
			 System.out.println("About to broadcast: "+ MessageToBroadcast);
			
		}
		
		@Override
		public void run() {
			int AllClients = ClientList.size();
			for(int i =0; i<AllClients; i++) {
				try {
					PrintWriter outputWriter = new PrintWriter((ClientList.get(i)).getOutputStream(), true);
					outputWriter.println(MessageToBroadcast);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
