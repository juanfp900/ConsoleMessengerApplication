# ConsoleMessengerApplication
This applciation allows for multiple clients to communicate with a each other from any computer that has a connection. 
Any client that compiles and runs these files will be able to communicate in a messenger console style layout assuming 
the server is running and each clients uses the exact same port number as the server. 

# Prerequisites
java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
are used in this project, but any Java version after 7 should work.

# Instructions to run
Have every file located in a speicfied local directory. 
Compile every .java file within directory using javac *.java 
open 3 or more terminal windows (each window will simulate a specific computer) and navigate to the specified 
local directory with all the files in each terminal window

Ensure that exactly one terminal window runs the server at all times.
To run a server and a client, pick a port number to put in the first 
argument. It should look like so.
         
          java Server <port number>
          java Server 7000 
          
          java Client <port number>
          java Client 7000
          
Follow the prompts that appear on the Client window. You should see "Client Connected"
on the server window everytime a client is connected.
(There can be many clients that can connect and message in this program. 



