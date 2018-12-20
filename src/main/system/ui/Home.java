/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import main.system.connection.handler.TCPListenerHandler;
import main.system.data.ChatHistory;
import main.system.data.MessageLog;
import main.system.model.Node;
import main.system.model.Peer;
import static main.system.ui.Login.listenTCP;

/**
 *
 * @author th_tran
 */
public class Home extends javax.swing.JFrame {

    private Node node;
    DefaultListModel<String> listFriendsOnlineModel;
    static Thread listenTCP = null;
    static TCPListenerHandler runnableTCP = null;
    public static ChatHistory history ;
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }
    
    public Home(Node node) {
        this.node = node;
        this.listFriendsOnlineModel = new DefaultListModel<>();
        //listFriendsOnlineModel.addElement("User");
        for(Peer p : node.getOnlinePeers()){
            listFriendsOnlineModel.addElement(p.getPseudonyme()+ ":"+ p.getHost()+":"+p.getPort());
        }
        initComponents();
        this.nicknameLabel.setText("Your nickname : " + node.getPeer().getPseudonyme());
    }

    public Home(Node node, ChatHistory history) {
        this.node = node;
        this.history = history;
        this.listFriendsOnlineModel = new DefaultListModel<>();
        //listFriendsOnlineModel.addElement("User");
        for(Peer p : node.getOnlinePeers()){
            listFriendsOnlineModel.addElement(p.getPseudonyme()+ ":"+ p.getHost()+":"+p.getPort());
        }
        initComponents();
        this.nicknameLabel.setText("Your nickname : " + node.getPeer().getPseudonyme());
    }
    
    public void setNicknameLabel(String s) {
        nicknameLabel.setText(s);
    }
    
    public Node getNode() {
        return this.node;
    }
    
    public Boolean checkNameUniq() {
        Boolean res = true;
        for (Peer p : this.node.getOnlinePeers()) {
            System.out.println(p.getPseudonyme());
            if (this.node.getPeer().getPseudonyme().equals(p.getPseudonyme())) {
                res = false;
            }
        }
        return res;
    }
    
    public void removeFromList(Peer p) {
        this.listFriendsOnlineModel.removeElement(p.getPseudonyme()+ ":"+ p.getHost()+":"+p.getPort());
    }

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

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        nicknameLabel = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        renameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setForeground(new java.awt.Color(51, 51, 250));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("HOME");

        friendsList.setModel(listFriendsOnlineModel);
        friendsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        friendsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                friendsListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                friendsListMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(friendsList);

        nicknameLabel.setText("Nickname : ");

        logOutButton.setText("Log out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        historyBox.setColumns(20);
        historyBox.setRows(5);
        jScrollPane2.setViewportView(historyBox);

        jLabel1.setText("History");

        renameButton.setLabel("Rename");
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logOutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renameButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nicknameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nicknameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logOutButton)
                    .addComponent(renameButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void friendsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendsListMouseClicked
        // TODO add your handling code here:
        
        if(!friendsList.isSelectionEmpty()){
            int index = friendsList.getSelectedIndex();
            String friend = friendsList.getSelectedValue();
            System.out.println(index + ":" + friend);
            String seg[] = friend.split(":");
            
            
            // TODO : find a peer/node when we know his nickname..
            try {
//                Node client = new Node(new Peer(seg[0],seg[1],Integer.parseInt(seg[2])));
                Node client = new Node(new Peer(seg[0],seg[1]));

                MessageLog l = history.getMessageLog(node.getPeer().getHost(), client.getPeer().getHost());
//                if (history.existHistory(l)) {
//                    l = history.getMessageLog(node.getPeer().getHost(), client.getPeer().getHost());
//                }
//                else {
//                    history.addHistory(l);
//                    //chatBox.setText("New chat" + System.lineSeparator());
//                    historyBox.setText("");
//                    historyBox.append(history.toString());
//                }
                ChatWindow chatWindow = new ChatWindow(node,client,l);
                chatWindow.display();
                
                
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_friendsListMouseClicked

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
        // Close the chat window
        this.setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.dispose();
        Login loginWindow = new Login(node);
        loginWindow.setTitle("You have disconnected.");
        loginWindow.display();   
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void friendsListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_friendsListMouseEntered
        // TODO add your handling code here:
        listFriendsOnlineModel.removeAllElements();
        for(Peer p : node.getOnlinePeers()){
            listFriendsOnlineModel.addElement(p.getPseudonyme()+ ":"+ p.getHost()+":"+p.getPort());
        }
        
        
    }//GEN-LAST:event_friendsListMouseEntered

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        // TODO add your handling code here:
        ChangeName changeNameWindow = new ChangeName(this.node, this);
        changeNameWindow.display();
        System.out.println(this.node.getPeer().getPseudonyme());
    }//GEN-LAST:event_renameButtonActionPerformed

    
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> friendsList;
    private javax.swing.JTextArea historyBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JButton renameButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
