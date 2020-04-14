import java.io.*;
import java.net.*;
import java.util.*;

//Class reads server input!
public class ClientRead implements Runnable{
	private Socket socket;
	private BufferedReader readFromServer;
	private InputStreamReader temp;
	private String response;
	private Client client;
	private String clientName;
	
	public ClientRead(Socket socket, Client client){
		this.socket = socket;
		this.client = client;	
	}
	
	
	public void run(){
		try{
        	temp = new InputStreamReader(socket.getInputStream());
			readFromServer = new BufferedReader(temp);
        	response = readFromServer.readLine();
        	clientName = readFromServer.readLine();
			System.out.println("From:" + "[" + clientName + "] " + response);	
			
			
		}catch(IOException ex) {
			System.out.println("Error reading from server bro");
			ex.printStackTrace(); 
		}
	}
	

}
	




	




