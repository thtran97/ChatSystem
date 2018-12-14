package main.system.connection.handler;

import main.system.ui.WritableUI;
import main.system.model.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPListenerHandler implements Runnable {

	private final Node node;
	private ServerSocket serverSocket = null;
	private Socket chatSocket;
	//private BufferedReader in;
	private WritableUI ui=null;
        private volatile boolean running = true;

        
	// this handler is used at a node of the network
	public TCPListenerHandler (Node node, WritableUI ui) throws IOException {	
            this.node = node;
            this.ui = ui;
            this.serverSocket = new ServerSocket(node.getPeer().getPort());
	}
        
        
        public void terminate() throws IOException {
            running = false;
            this.serverSocket.close();
            //this.chatSocket.close();
        }
            
	@Override
	public void run() {
            while(running) {
                try {
                        System.out.println(node.getPeer().getPseudonyme() + " is listening at port " + node.getPeer().getPort() + "...");
                        this.chatSocket = this.serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));

                        System.out.println("CALL IN TCP Listner handler run");
                        // Print the message received from a node distant
                        String msgDistant = in.readLine();

                        if(msgDistant != null) {
                            ui.write(msgDistant);
                            System.out.println(msgDistant);
                        }
                        // Close the socket
                        //chatSocket.close();
                   
                } catch(Exception e) {
                        e.printStackTrace();
                }
            }
		
	}


}
