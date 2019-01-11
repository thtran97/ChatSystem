/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import java.awt.event.KeyEvent;
import main.system.model.Node;
import main.system.connection.service.TCPSenderService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import main.system.data.*;
import main.system.model.Peer;
import main.system.utilities.Emoji;

/**
 *
 */
public class ChatWindow extends javax.swing.JFrame implements WritableUI {

    /**
     * Creates attributs
     */
    private Node node;
    private Node client;
    private MessageLog l;
    int sourceport;

    /**
     * Creates new form Chat Window
     *
     * @param node
     * @param client
     * @param l
     */
    public ChatWindow(Node node, Node client, MessageLog l) {
        initComponents();
        this.l = l;
        if (this.l != null) {
            chatBox.setText(this.l.toString());
        }
        this.node = node;
        this.client = client;
        this.nicknameLabel.setText("Pseudo : " + node.getPeer().getPseudonyme());
        this.hostLabel.setText("My Host : " + node.getPeer().getHost());
//        this.portLabel.setText("Port : " + node.getPeer().getPort());
        sourceport = node.getPeer().getPort();
        //this.clientLabel.setText("To : " + this.client.getPeer().getPseudonyme() + " at " + this.client.getPeer().getHost() );
        this.clientLabel.setText("To : " + client.getPeer().getPseudonyme() + " at " + client.getPeer().getHost());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        nicknameLabel = new javax.swing.JLabel();
        hostLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        clientLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(client.getPeer().getPseudonyme() + " - ChatSystem");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageKeyPressed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        nicknameLabel.setForeground(new java.awt.Color(238, 238, 238));
        nicknameLabel.setText("Nickname : ");

        hostLabel.setText("My Host :");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        clientLabel.setText("To :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(nicknameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicknameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hostLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
            message.setText("");
            new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(), Peer.PORT_TCP, msg);
            this.node.getChatWindowForPeer(client.getPeer().getHost()).write(msg);
//            new TCPSenderService().sendMessageTo("localhost",target,msg);
//            new TCPSenderService().sendMessageTo(ipDistant,target,msg);
//            new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(),this.client.getPeer().getPort(),msg);
//            System.out.println("Client port : " + this.client.getPeer().getPort());
//            new UDPSenderService().sendMessageTo(ipDistant,target,msg);
//            this.write(msg);
        } catch (Exception ex) {
            Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendButtonActionPerformed


    private void messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
                message.setText("");
                new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(), Peer.PORT_TCP, msg);
                this.node.getChatWindowForPeer(client.getPeer().getHost()).write(msg);
                //            new TCPSenderService().sendMessageTo("localhost",target,msg);
                //            new TCPSenderService().sendMessageTo(ipDistant,target,msg);
                //            new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(),this.client.getPeer().getPort(),msg);
                //            System.out.println("Client port : " + this.client.getPeer().getPort());
                //            new UDPSenderService().sendMessageTo(ipDistant,target,msg);
                //            this.write(msg);
            } catch (Exception ex) {
                Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_messageKeyPressed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Create methods
     */
    public String getPseudo() {
        return this.node.getPeer().getPseudonyme();
    }

    public void setNicknameLabel(String s) {
        this.nicknameLabel.setText(s);
    }

    public void display() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void closeWindow() {
        this.setVisible(false);
    }

    public String timeStamp() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm, dd/MM/yyyy] - ");
        return sdf.format(cal.getTime());
    }

    @Override
    public void write(String s) {
        String msg = timeStamp() + Emoji.replaceInText(s);
        chatBox.append(msg + System.lineSeparator());
        this.l.addMessage(msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea chatBox;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

}
