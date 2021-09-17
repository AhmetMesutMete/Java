package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
	private int PORT = 1234;
	private Socket socket;
	private Scanner input;
	private PrintWriter output;
	
	public Client() {
		try {
			socket = new Socket("Localhost", PORT);
			input = new Scanner(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream(), true);
			
			(new Thread(this)).start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
					
	}
	
	public void Process()	{
		@SuppressWarnings("resource")
		Scanner UserInput = new Scanner(System.in);

		//while(true) {
			System.out.println("Message to broadcast :");
			String message = UserInput.nextLine();
			output.println(message);

		//}
	
	}
	
	
	@Override
	public void run() {
		String transmission;
		System.out.println("Waiting for server transmission...");
		//while(true) {
			try {
				transmission = input.nextLine();
				System.out.println("SERVER > " + transmission);

			} catch(Exception e) {
				e.getStackTrace();
			}

		//}
		
	}
		
		
}
	

