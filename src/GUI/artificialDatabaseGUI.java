/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import dataManagment.ArtificialDatabase;
import java.awt.Color;
import java.io.File;
import javax.swing.JOptionPane;
import tournamentManagment.Movement;

/**
 *
 * @author uzivatel
 */
public class artificialDatabaseGUI extends javax.swing.JFrame {


    
    public artificialDatabaseGUI() {
        initComponents();
    }

    /**
     * Enchance STOP method => set everything to NULL
     * 
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startArtificialDatabase = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        startArtificialDatabase1 = new javax.swing.JButton();
        stopArtificialDatabase = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        playermanagerState = new javax.swing.JLabel();
        movementState = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        resultDatabaseState = new javax.swing.JLabel();
        startPlayerManager = new javax.swing.JButton();
        startMovementData = new javax.swing.JButton();
        startResultReader = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        movementMenu = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        startArtificialDatabase.setBackground(new java.awt.Color(177, 253, 141));
        startArtificialDatabase.setText("Start AD");
        startArtificialDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startArtificialDatabaseActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 36)); // NOI18N
        jLabel2.setText("Artificial database");

        startArtificialDatabase1.setBackground(new java.awt.Color(177, 253, 141));
        startArtificialDatabase1.setText("Start AD");
        startArtificialDatabase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startArtificialDatabase1ActionPerformed(evt);
            }
        });

        stopArtificialDatabase.setBackground(new java.awt.Color(255, 111, 102));
        stopArtificialDatabase.setText("Stop AD");
        stopArtificialDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopArtificialDatabaseActionPerformed(evt);
            }
        });

        jLabel1.setText("All-data collector, manager and distributor");

        jLabel3.setText("Movement");

        jLabel5.setText("Player manager");

        playermanagerState.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        playermanagerState.setForeground(new java.awt.Color(255, 21, 0));
        playermanagerState.setText("SHUT DOWN");

        movementState.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        movementState.setForeground(new java.awt.Color(255, 21, 0));
        movementState.setText("SHUT DOWN");

        jLabel6.setText("Result database");

        resultDatabaseState.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        resultDatabaseState.setForeground(new java.awt.Color(255, 21, 0));
        resultDatabaseState.setText("SHUT DOWN");

        startPlayerManager.setBackground(new java.awt.Color(177, 253, 141));
        startPlayerManager.setText("Start");
        startPlayerManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPlayerManagerActionPerformed(evt);
            }
        });

        startMovementData.setBackground(new java.awt.Color(177, 253, 141));
        startMovementData.setText("Start");
        startMovementData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startMovementDataActionPerformed(evt);
            }
        });

        startResultReader.setBackground(new java.awt.Color(177, 253, 141));
        startResultReader.setText("Start");
        startResultReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startResultReaderActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Actions");

        movementMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        movementMenu.setMnemonic('o');
        movementMenu.setText("Movement");
        movementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movementMenuActionPerformed(evt);
            }
        });
        fileMenu.add(movementMenu);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(resultDatabaseState))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(movementState))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(26, 26, 26)
                                                .addComponent(playermanagerState)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(startPlayerManager, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(startMovementData, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                            .addComponent(startResultReader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(startArtificialDatabase1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(stopArtificialDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(stopArtificialDatabase)
                    .addComponent(startArtificialDatabase1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(movementState)
                    .addComponent(startMovementData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(playermanagerState)
                    .addComponent(startPlayerManager))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(resultDatabaseState)
                    .addComponent(startResultReader))
                .addGap(402, 402, 402)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void movementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movementMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movementMenuActionPerformed

    private void startArtificialDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startArtificialDatabaseActionPerformed
        
    }//GEN-LAST:event_startArtificialDatabaseActionPerformed

    private void startArtificialDatabase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startArtificialDatabase1ActionPerformed
       startArtificialDatabase1.setEnabled(false);
       stopArtificialDatabase.setEnabled(true);
       bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "artificialDatabaseEnabled", "true");
        bridgetournamentcontroller.BridgeTorunamentController.ac = new ArtificialDatabase();
        bridgetournamentcontroller.BridgeTorunamentController.ac.start();
    }//GEN-LAST:event_startArtificialDatabase1ActionPerformed

    private void stopArtificialDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopArtificialDatabaseActionPerformed
       startArtificialDatabase1.setEnabled(true);
       stopArtificialDatabase.setEnabled(false);
       
       // disable movement segment
       bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "ACMovementRunning", "false");
       movementState.setForeground(Color.RED);
              movementState.setText("SHUT DOWN");
       // disable player manager segment
       bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "ACPlayerManagerRunning", "false");
       playermanagerState.setForeground(Color.RED);
              playermanagerState.setText("SHUT DOWN");
       
       
       bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "artificialDatabaseEnabled", "false");
        bridgetournamentcontroller.BridgeTorunamentController.ac.stop();
        bridgetournamentcontroller.BridgeTorunamentController.ac = null;
    }//GEN-LAST:event_stopArtificialDatabaseActionPerformed

    private void startPlayerManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPlayerManagerActionPerformed
        File f= new File("tournaments/"+bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName+"/databases/movement.dat");
              if(!f.exists()) {
                 JOptionPane.showMessageDialog(null, "Movement file does not exist! Unable to generate player database");
              return;
              }
              
              if(!bridgetournamentcontroller.BridgeTorunamentController.vm.movementUpdated.equals("true")) {
                 JOptionPane.showMessageDialog(null, "Movement file probably exists, but movement wasn't read yet. Please open movement tab");
              return;
              }
              
              if(!bridgetournamentcontroller.BridgeTorunamentController.vm.artificialDatabaseEnabled.equals("true")) {
              JOptionPane.showMessageDialog(null, "Artificial database is shut down");
              return;
              }
              
              // start player manager
              
              bridgetournamentcontroller.BridgeTorunamentController.ac.pm.start();
              
              // update info in dataCollector
              bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "ACPlayerManagerRunning", "true");
              
              playermanagerState.setForeground(Color.GREEN);
              playermanagerState.setText("Running");
              JOptionPane.showMessageDialog(null, "PlayerManager started successfully");
    }//GEN-LAST:event_startPlayerManagerActionPerformed

    private void startMovementDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMovementDataActionPerformed
       if(bridgetournamentcontroller.BridgeTorunamentController.dc.mailObjectExists("MOVEMENT")) {
          // check if movement has been read (to movement class) and then apply it on artificialDatabase class
           
           bridgetournamentcontroller.BridgeTorunamentController.ac.m  = (Movement) bridgetournamentcontroller.BridgeTorunamentController.dc.receiveObject("MOVEMENT");
              movementState.setForeground(Color.GREEN);
              movementState.setText("Running");
              // update info in dataCollector
              bridgetournamentcontroller.BridgeTorunamentController.dc.collect("artificialDatabaseGUI", "ACMovementRunning", "true");
              
              JOptionPane.showMessageDialog(null, "Movement sucessfully updated!");
              return;
              } else {JOptionPane.showMessageDialog(null, "Movement file probably exists, but movement wasn't read yet. Please open movement tab");}
        
        
    }//GEN-LAST:event_startMovementDataActionPerformed

    private void startResultReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startResultReaderActionPerformed
        bridgetournamentcontroller.BridgeTorunamentController.ac.tickRead();
        JOptionPane.showMessageDialog(null, "Database is being read!");
        resultDatabaseState.setForeground(Color.GREEN);
        resultDatabaseState.setText("Running");
    }//GEN-LAST:event_startResultReaderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(artificialDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(artificialDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(artificialDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(artificialDatabaseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new artificialDatabaseGUI().setVisible(true);
            }
        });
    }
    
                       


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem movementMenu;
    private javax.swing.JLabel movementState;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JLabel playermanagerState;
    private javax.swing.JLabel resultDatabaseState;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JButton startArtificialDatabase;
    private javax.swing.JButton startArtificialDatabase1;
    private javax.swing.JButton startMovementData;
    private javax.swing.JButton startPlayerManager;
    private javax.swing.JButton startResultReader;
    private javax.swing.JButton stopArtificialDatabase;
    // End of variables declaration//GEN-END:variables

}
