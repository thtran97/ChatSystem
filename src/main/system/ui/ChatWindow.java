/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import com.sun.glass.events.KeyEvent;
import main.system.model.Node;
import main.system.connection.service.TCPSenderService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.system.data.*;

/**
 *
 */
public class ChatWindow extends javax.swing.JFrame implements WritableUI {
    
	private Node node;
        public static ChatHistory history = new ChatHistory();
        private MessageLog l;
        int sourceport;
        
    /**
     * Creates new form Chat Window
     */
    public ChatWindow() {
        initComponents();
    }
    
    public ChatWindow(Node node) throws IOException {
        initComponents();       
        this.node = node;
        this.nicknameField.setText("Pseudo : " + node.getPeer().getPseudonyme());
        this.hostField.setText("Host : " + node.getPeer().getHost());
        this.portField.setText("Port : " + node.getPeer().getPort());
        sourceport = node.getPeer().getPort();
        //listen = new Thread(new TCPListenerHandler(this.node,this));  
        //listen.start();
    }
    
    public String getPseudo() {return this.node.getPeer().getPseudonyme();} 
    
    
    public void display(){
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disconnectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        targetPort = new javax.swing.JTextField();
        targetButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        nicknameField = new javax.swing.JLabel();
        hostField = new javax.swing.JLabel();
        portField = new javax.swing.JLabel();
        ipDistantField = new javax.swing.JTextField();
        renameButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        historyBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        chatBox.setColumns(20);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });
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

        targetPort.setText("5678");
        targetPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetPortActionPerformed(evt);
            }
        });

        targetButton.setText("Target");
        targetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        nicknameField.setText("Nickname : ");

        hostField.setText("Host :");

        portField.setText("Port :");

        ipDistantField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipDistantFieldActionPerformed(evt);
            }
        });

        renameButton.setText("Rename");

        historyBox.setColumns(20);
        historyBox.setRows(5);
        jScrollPane3.setViewportView(historyBox);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ChatHistory");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Friends Online");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipDistantField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(renameButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disconnectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disconnectButton)
                    .addComponent(nicknameField)
                    .addComponent(hostField)
                    .addComponent(portField)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(renameButton)
                            .addComponent(targetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ipDistantField)
                            .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int target;
    String ipDistant;
    private void targetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetButtonActionPerformed
      target = Integer.parseInt(this.targetPort.getText());
      ipDistant = this.ipDistantField.getText();
      System.out.println("Target to "+ ipDistant + " : " + target);
      if (history.existHistory(sourceport, target) == false) {
          l = new MessageLog(sourceport, target);
          history.addHistory(l);
          chatBox.setText("");
          historyBox.append(l.toString() + System.lineSeparator());
      }
//      else {
//          chatBox.setText("");
//          l = history.getMessageLog(sourceport, target);
//          for (String m : l.getLog()) {
//              chatBox.append(m + System.lineSeparator());
//          }
//      }
//      if (history.existHistory(sourceport, target)) {
//          l = new MessageLog(sourceport, target);
//          history.addHistory(l);
//          chatBox.setText("");
//      } else {
//          l = history.getMessageLog(sourceport, target);
//      }

    }//GEN-LAST:event_targetButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        //TransfererMessage trans = new TransfererMessage(message.getText(), hostField.getText(), Integer.parseInt(portCible.getText()));
        //trans.start();
        try {
            String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
            //new TCPSenderService().sendMessageTo("localhost",target,msg);
            new TCPSenderService().sendMessageTo(ipDistant,target,msg);
            this.write(msg);
            message.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void targetPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetPortActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed

        // Close the chat window
        this.setVisible(false);
        Login loginWindow = new Login(node);
        loginWindow.setTitre("You have disconnected.");
        loginWindow.display();     
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void ipDistantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipDistantFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipDistantFieldActionPerformed




    /*
    private void ipDistantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    */
    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageActionPerformed

    private void messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
            try {
                String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
                //new TCPSenderService().sendMessageTo("localhost",target,msg);
                new TCPSenderService().sendMessageTo(ipDistant,target,msg);
                this.write(msg);
                message.setText("");
            } catch (Exception ex) {
                Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_messageKeyPressed
    
    

    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatWindow().setVisible(true);
//            }
//        });
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatBox;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextArea historyBox;
    private javax.swing.JLabel hostField;
    private javax.swing.JTextField ipDistantField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField message;
    private javax.swing.JLabel nicknameField;
    private javax.swing.JLabel portField;
    private javax.swing.JButton renameButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton targetButton;
    private javax.swing.JTextField targetPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String s) {
        chatBox.append(s + System.lineSeparator());
    }
}
