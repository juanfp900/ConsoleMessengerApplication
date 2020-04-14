import java.io.*;
import java.net.*;
import java.util.*;


public class Client{
	private int port;
	private String clientName;
	private String clientAge;
	private Socket socket;
	private PrintWriter sendToServer;
	private InputStreamReader temp;
	private BufferedReader readFromServer;
	private String response;
	private String clientMessage;
	
	public Client(int port){
		this.port = port;
	}
	
	public static void main(String[] args){
		
		int port = Integer.parseInt(args[0]);
		Client initializeClient = new Client(port);	
		initializeClient.startClient(port);
	}
	
	
	public void startClient(int port){
		//"localhost" is an alias for computers IP address
		try(Socket socket = new Socket("localhost", port)){
			sendToServer = new PrintWriter(socket.getOutputStream(),true);
		
			if (clientName == null && clientAge ==null){
				getInformation();
				sendToServerMethod(clientName, clientAge);
			}
			do{
				ClientRead clientRead = new ClientRead(socket, this);
				Thread readThread = new Thread(clientRead);
				readThread.start();
				
				Console console = System.console();
				clientMessage = console.readLine(": ");
				if(clientMessage.length() > 0){
					sendToServer.println(clientMessage);
				}
 	
			}while(!clientMessage.equals("quit"));
			socket.close();
		
		
		}catch(IOException e){
			System.out.println("Client error");
		}
	}	

	//Method returns more than one value from ReturnClientInfo class
	public ReturnClientInfo getInformation(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hi new user! What is you're name?");
		clientName = scanner.nextLine();
		System.out.println("How old are you? ");
		clientAge = scanner.nextLine();
		
		return new ReturnClientInfo(clientName, clientAge);	
	}
	
	public void sendToServerMethod(String clientName, String clientAge){
		sendToServer.println(clientName);
		sendToServer.println(clientAge);
	}
}
		
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		