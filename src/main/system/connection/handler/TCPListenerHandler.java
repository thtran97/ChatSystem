package main.system.connection.handler;

import main.system.model.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import main.system.data.ChatHistory;
import main.system.model.Peer;

public class TCPListenerHandler implements Runnable {

    /*
     * Attributs
     */
    private final Node node;
    private ServerSocket serverSocket = null;
    private Socket chatSocket;
    private volatile boolean running = true;
    public static ChatHistory history;

    /**
     * Constructors
     * @param node
     * @param history
     * @throws java.io.IOException
     */
    
    /* this handler is used at a node of the network */
    public TCPListenerHandler (Node node, ChatHistory history) throws IOException {	
        this.node = node;
        TCPListenerHandler.history = history;
//        this.serverSocket = new ServerSocket(node.getPeer().getPort());
        this.serverSocket = new ServerSocket(Peer.PORT_TCP);
        this.node.getPeer().setPort(this.serverSocket.getLocalPort());
    }

    /*
     * Methods
     */
    
    public void terminate() throws IOException {
        running = false;
        this.serverSocket.close();
        //this.chatSocket.close();
    }

    @Override
    public void run() {
            try {
                while(running) {
                    System.out.println("[TCP] " + node.getPeer().getPseudonyme() + " is listening by TCP at port " + node.getPeer().getPort() + "...");
                    this.chatSocket = this.serverSocket.accept();

                    /* Receive the message */
                    BufferedReader in = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
                    String msgDistant = in.readLine();

                    /* Write the message on the chat window between this node and client */
                    Node client = new Node (new Peer(chatSocket.getInetAddress().getHostAddress()));
                    if(msgDistant != null) {
                        this.node.getChatWindowForPeer(client.getPeer().getHost()).write(msgDistant);
                        System.out.println(msgDistant);
                    }
                    
                    /* Close the socket */
                    //chatSocket.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }


    }


}
