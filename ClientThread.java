import java.io.*;
import java.net.*;
import java.util.*;


public class ClientThread extends Thread{
	private Socket socket;
	private Server server;
	private volatile InputStreamReader getSocketData;
	private volatile BufferedReader input;
	private volatile PrintWriter output;
	private ReturnClientInfo readClientInfo;
	private String readInput;
	
	
	private String clientName;
	private String clientAge;
	private HashSet <UserDatabase> clientSet = new HashSet <UserDatabase>();
	private LinkedHashSet <String> combine = new LinkedHashSet <String>();
	private HashSet <ClientThread> currClientThread = new HashSet <ClientThread>();
	private HashSet <ClientThread> sent = new HashSet <ClientThread>();
	
	public ClientThread(Socket socket, Server server){
		this.socket = socket;
		this.server = server;
	}

	//we wont use try with resource since we are not creating socket in this method
	@Override
	public void run(){
		try{
			//Receives message from specific client
			getSocketData = new InputStreamReader(socket.getInputStream());
			input = new BufferedReader(getSocketData);
			
			//Sends message to specific client 
			output = new PrintWriter(socket.getOutputStream());
		
			clientData(input);
	
			server.checkForRepeatedClients(combine); 	//check for repeated users
			server.addToDatabase(combine);				//add to database
			server.setClientName(clientName);
			server.setClientAge(clientAge);
			
			
			do{
				String readInput = input.readLine();
				server.displayToAll(this, readInput, clientName);
			
			}while (!readInput.equals("quit"));
			
			server.removeAClient(this, combine, clientName, clientAge);
			socket.close();
			
			//server.displayToAll(this, readInput, clientName);
			
		}catch(IOException e){
			System.out.println("error with clientThread");
		}
	}
	
	public void sendOutMessage(String readInput, String clientName){
		output.println(readInput);
		output.println(clientName);
		output.flush();
	}
	
		
	public LinkedHashSet <String> clientData(BufferedReader input){
		try{
			int count = 0;
			boolean loop = true;
			while (loop) {
				readInput = input.readLine();
		
				if (count == 0){
					this.clientName = readInput;
					//System.out.println("client name: " + clientName);
					
				}else if (count == 1){
					this.clientAge = readInput;
				//	System.out.println("client age: " + clientAge);
				
					loop = false;
				}else if(readInput.equals("quit")){
					break;
				}
				count++;
			}
		}catch(IOException e){
				System.out.println("error with clientThread");
		}
		combine.add(clientName);
		combine.add(clientAge);
		
		return combine;
	}
	
}	







				
				
				