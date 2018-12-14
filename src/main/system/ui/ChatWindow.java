/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import main.system.model.Node;
import main.system.connection.service.TCPSenderService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ChatWindow extends javax.swing.JFrame implements WritableUI {
    
	private Node node;
        
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

        boutonFermer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        buttonEnvoyer = new javax.swing.JButton();
        targetPort = new javax.swing.JTextField();
        buttonTarget = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        nicknameField = new javax.swing.JLabel();
        hostField = new javax.swing.JLabel();
        portField = new javax.swing.JLabel();
        ipDistantField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutonFermer.setText("Disconnect");
        boutonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonFermerActionPerformed(evt);
            }
        });

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        buttonEnvoyer.setText("Envoyer");
        buttonEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEnvoyerActionPerformed(evt);
            }
        });

        targetPort.setText("5678");
        targetPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetPortActionPerformed(evt);
            }
        });

        buttonTarget.setText("Target");
        buttonTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTargetActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        nicknameField.setText("Nickname : ");

        hostField.setText("Host :");

        portField.setText("Port :");

        ipDistantField.setText("192.168.1.10");
        ipDistantField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipDistantFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ipDistantField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(buttonTarget))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boutonFermer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEnvoyer))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nicknameField)
                                .addComponent(hostField)
                                .addComponent(portField))
                            .addComponent(boutonFermer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEnvoyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTarget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ipDistantField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int target;
    String ipDistant;
    private void buttonTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTargetActionPerformed
      target = Integer.parseInt(this.targetPort.getText());
      ipDistant = this.ipDistantField.getText();
      System.out.println("Target to "+ ipDistant + " : " + target);
    }//GEN-LAST:event_buttonTargetActionPerformed

    private void buttonEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEnvoyerActionPerformed
        //TransfererMessage trans = new TransfererMessage(message.getText(), hostField.getText(), Integer.parseInt(portCible.getText()));
        //trans.start();
        try {
            String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
            new TCPSenderService().sendMessageTo("localhost",target,msg);
            //new TCPSenderService().sendMessageTo(ipDistant,target,msg);
            this.write(msg);
            message.setText("");
        } catch (Exception ex) {
            Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEnvoyerActionPerformed

    private void targetPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetPortActionPerformed

    private void boutonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonFermerActionPerformed
            
        // Stop thread running
        
        
        // Close the chat window
        this.setVisible(false);
        Login loginWindow = new Login(node);
        loginWindow.setTitre("You have disconnected.");
        loginWindow.display();     
    }//GEN-LAST:event_boutonFermerActionPerformed

    private void ipDistantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipDistantFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipDistantFieldActionPerformed


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
    private javax.swing.JButton boutonFermer;
    private javax.swing.JButton buttonEnvoyer;
    private javax.swing.JButton buttonTarget;
    private javax.swing.JTextArea chatBox;
    private javax.swing.JLabel hostField;
    private javax.swing.JTextField ipDistantField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField message;
    private javax.swing.JLabel nicknameField;
    private javax.swing.JLabel portField;
    private javax.swing.JTextField targetPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void write(String s) {
        chatBox.append(s + System.lineSeparator());
    }
}
