import java.io.*;
import java.net.*;
import java.util.*;


public class Server{
	private int port;
	private HashSet<String> clientNames = new HashSet<String>();
	private HashSet<String> clientAges = new HashSet<String>();
    private HashSet<ClientThread> clientThreads = new HashSet<ClientThread>();
    private LinkedHashSet<HashSet<String>> clientDatabase = new LinkedHashSet<HashSet<String>>();
	
	public Server(int port){
		this.port = port;
	}
	
	public HashSet<ClientThread> getClientThread(){
		return this.clientThreads;
	}
	
	public int getClientThreadNum(){
		int count = 0;
		for (ClientThread clientThread : clientThreads){
			count++;
		}
		return count;
	}
	public LinkedHashSet<HashSet<String>> getClientDatabase(){
		return this.clientDatabase;
	}
	
	public HashSet<String> getClientNames(){
		return this.clientNames;
	}
	
	public HashSet<String> getClientAge(){
		return this.clientAges;
	}
	
	//stores userName of new client
	public void setClientName(String clientName){
		clientNames.add(clientName);
	}
	
	//stores userName of new client
	public void setClientAge(String clientAge){
		clientAges.add(clientAge);
	}

	public void checkForRepeatedClients(LinkedHashSet<String> combine){
		//System.out.println("Combine" + combine);
		for (Set <String> innerSet : clientDatabase){ 
			if (innerSet.equals(combine)){
				System.out.println("Client with your information is already registered in this chat. Enter new name");
				//enter new name or your name is already registered!!
			}
		}
	}
	
	public void addToDatabase(HashSet <String> combine){
		clientDatabase.add(combine);
		//System.out.println("Client Database updated" + clientDatabase);
	}
	

	public void removeAClient(ClientThread clientThread, LinkedHashSet <String> combine, String clientName, String clientAge){
		System.out.println("Removing information for client " +  clientName + " " + clientAge + " " + combine);
		clientDatabase.remove(combine);
		clientNames.remove(clientName);
		clientAges.remove(clientAge);
		clientThreads.remove(clientThread);
	}
	
	public void displayToAll(ClientThread clientThread, String readInput, String clientName){
		for(ClientThread client : clientThreads){
			if (client != clientThread){
				client.sendOutMessage(readInput, clientName);
			}
		}
	}
	
	public static void main(String[] args){
		int port = Integer.parseInt(args[0]);
		Server server = new Server(port);
		server.startProcess();
	}

	public void startProcess(){
		try(ServerSocket serverSocket = new ServerSocket(port)){
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client Connected");	
				ClientThread newClientThread = new ClientThread(socket, this);
				clientThreads.add(newClientThread);
				newClientThread.start();	
			}
		
		}catch(IOException e){
			System.out.println("Issue with server");
		}
	}
		
}
	





