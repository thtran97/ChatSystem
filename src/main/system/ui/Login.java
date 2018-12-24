/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import java.awt.event.KeyEvent;
import main.system.model.Node;
import main.system.model.Peer;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import main.system.connection.handler.TCPListenerHandler;
import main.system.connection.handler.UDPListenerHandler;
import main.system.connection.service.UDPSenderService;
import main.system.data.ChatHistory;



/**
 *
 */
public class Login extends javax.swing.JFrame {
    
    /**
     *  Creates attributs
     */
    private Node node;
    static Thread listenTCP = null;
    static Thread listenUDP = null;
    static TCPListenerHandler runnableTCP = null;    
    static UDPListenerHandler runnableUDP = null;
    public static ChatHistory history = new ChatHistory();
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public Login(Node node){

        this.node = node;
        initComponents();
        hostField.setText(node.getPeer().getHost());
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        nicknameLabel = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        hostField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        hostLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostLabel.setText("Your host :");

        nicknameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nicknameLabel.setText("Your nickname :");

        nicknameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicknameFieldKeyPressed(evt);
            }
        });

        hostField.setEditable(false);
        hostField.setText("localhost");

        titleLabel.setForeground(new java.awt.Color(250, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Welcome !!!");

        logInButton.setText("Log in");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Your password :");

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hostField)
                    .addComponent(nicknameField)
                    .addComponent(nicknameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(hostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nicknameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(hostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(logInButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        try {
            this.setTitle("Connecting... Please Wait"); 
            // Create a node with the nickname and the host address
            Peer peer = new Peer(nicknameField.getText(), hostField.getText()); // port = portTCP = 9999
            this.node =  new Node(peer);
            //Home home = this.node.getHome();

            // Start a server thread TCP to listen 
            if (listenTCP != null && runnableTCP != null ){
                runnableTCP.terminate();
                listenTCP.join();
            }
            runnableTCP = new TCPListenerHandler(this.node, Login.history); 
            listenTCP = new Thread(runnableTCP);  
            listenTCP.start();

            // This thread is used to reveice le broadcast by UDP
            if (listenUDP != null && runnableUDP != null ){
                runnableUDP.terminate();
                 listenUDP.join();
             }
            runnableUDP = new UDPListenerHandler(this.node); 
            listenUDP = new Thread(runnableUDP);  
            listenUDP.start();
            
           // Send a broadcast when log in
            new UDPSenderService().sendBroadcast(this.node);
            
            // Open homepage if the nickname is unique
//            Home home = new Home(node,this.history);
//            System.out.println(this.node.checkNameUniq());
//            System.out.println(this.node);
//            //this.node.getHome().display();
//            System.out.println(this.node);
//            System.out.println(this.node.checkNameUniq());
            sleep(10);
//            System.out.println(this.node);
            if (this.node.checkNameUniq()) {
                new UDPSenderService().sendBroadcast(this.node);
                this.node.getHome().display();
                this.setVisible(false);
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                this.dispose();
            }
            else {
                new UDPSenderService().sendDisconnect(this.node);
                this.setTitle("WARNING : This name has been used !");
            }
            //sleep(10);
            System.out.println(this.node);
            System.out.println(this.node.checkNameUniq());

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_logInButtonActionPerformed

    private void nicknameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicknameFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                this.setTitle("Connecting... Please Wait"); 
                // Create a node with the nickname and the host address
                Peer peer = new Peer(nicknameField.getText(), hostField.getText()); // port = portTCP = 9999
                this.node =  new Node(peer);
                //Home home = this.node.getHome();

                // Start a server thread TCP to listen 
                if (listenTCP != null && runnableTCP != null ){
                    runnableTCP.terminate();
                    listenTCP.join();
                }
                runnableTCP = new TCPListenerHandler(this.node, Login.history); 
                listenTCP = new Thread(runnableTCP);  
                listenTCP.start();

                // This thread is used to reveice le broadcast by UDP
                if (listenUDP != null && runnableUDP != null ){
                    runnableUDP.terminate();
                     listenUDP.join();
                 }
                runnableUDP = new UDPListenerHandler(this.node); 
                listenUDP = new Thread(runnableUDP);  
                listenUDP.start();

               // Send a broadcast when log in
                new UDPSenderService().sendBroadcast(this.node);

                // Open homepage if the nickname is unique
    //            Home home = new Home(node,this.history);
    //            System.out.println(this.node.checkNameUniq());
    //            System.out.println(this.node);
    //            //this.node.getHome().display();
    //            System.out.println(this.node);
    //            System.out.println(this.node.checkNameUniq());
                sleep(10);
    //            System.out.println(this.node);
                if (this.node.checkNameUniq()) {
                    new UDPSenderService().sendBroadcast(this.node);
                    this.node.getHome().display();
                    this.setVisible(false);
                    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    this.dispose();
                }
                else {
                    new UDPSenderService().sendDisconnect(this.node);
                    this.setTitle("WARNING : This name has been used !");
                }
                //sleep(10);
                System.out.println(this.node);
                System.out.println(this.node.checkNameUniq());

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_nicknameFieldKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            new UDPSenderService().sendDisconnect(node);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldKeyPressed

    /**
     * Create methods
     */
    
    public void display(){
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    
    @Override
    public void setTitle(String title){
        titleLabel.setText(title);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables


}

