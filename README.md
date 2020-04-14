# ConsoleMessengerApplication
This applciation allows for multiple clients to communicate with a each other from any computer with connection. 
Any client that compiles and runs these files will be connected to the server and will share a port number at run time. 

# Prerequisites
java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
are used in this project, but any Java version after 7 should work.

# Instructions to run
Have every file located in a speicfied local directory. 
Compile every .java file within directory using javac *.java 
open 3 or more terminal windows and navigate to the specified 
local directory with all the files in each terminal window

Ensure that exactly one terminal window runs the server at all times.
To run a server and a client, pick a port number to put as an argument.
java Server <port number> so if we pick port number "7000" it will look like so:
         
          java Server 7000 

          java Client 7000
          
And follow the prompts that appear on the screen. There can be many clients that can
connect and message each other using this program. 



