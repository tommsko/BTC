/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import bridgetournamentcontroller.BRC;
import dataManagment.DataCollector;
import bridgetournamentcontroller.TW;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import dataManagment.BoardData;
import dataManagment.DatabaseConnector;

/**
 *
 * @author uzivatel
 */
public class mainGUI extends javax.swing.JFrame {

  
DataCollector dc;
playerGUI pg = new playerGUI();
movementGUI mg = new movementGUI();
tournamentGUI tg = new tournamentGUI();
scoreGUI sg = new scoreGUI();
dealsGUI dg = new dealsGUI();
artificialDatabaseGUI adg = new artificialDatabaseGUI();
    
    public mainGUI() {
        initComponents();
        this.dc = bridgetournamentcontroller.BridgeTorunamentController.dc;
        
        // open choose tournament immediately
         tg.setVisible(true);
         tg.setAlwaysOnTop(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tournamentName = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        tournamentMenu = new javax.swing.JMenuItem();
        artificialDatabaseMenu = new javax.swing.JMenuItem();
        movementMenu = new javax.swing.JMenuItem();
        dealsMenu = new javax.swing.JMenuItem();
        playerMenu = new javax.swing.JMenuItem();
        scoreMenu = new javax.swing.JMenuItem();
        resultMenu = new javax.swing.JMenuItem();
        watchdogMenu = new javax.swing.JMenuItem();
        delayMenu = new javax.swing.JMenuItem();
        correctionsMenu = new javax.swing.JMenuItem();
        externalMenu = new javax.swing.JMenuItem();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Active tournament:");

        tournamentName.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        tournamentName.setText("Tournament not opened!");

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("Actions");

        tournamentMenu.setMnemonic('s');
        tournamentMenu.setText("Tournament");
        tournamentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tournamentMenuActionPerformed(evt);
            }
        });
        fileMenu.add(tournamentMenu);

        artificialDatabaseMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        artificialDatabaseMenu.setMnemonic('s');
        artificialDatabaseMenu.setText("Artificial database");
        artificialDatabaseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artificialDatabaseMenuActionPerformed(evt);
            }
        });
        fileMenu.add(artificialDatabaseMenu);

        movementMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        movementMenu.setMnemonic('o');
        movementMenu.setText("Movement");
        movementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movementMenuActionPerformed(evt);
            }
        });
        fileMenu.add(movementMenu);

        dealsMenu.setMnemonic('o');
        dealsMenu.setText("Deals");
        dealsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(dealsMenu);

        playerMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        playerMenu.setMnemonic('x');
        playerMenu.setText("Players");
        playerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerMenuActionPerformed(evt);
            }
        });
        fileMenu.add(playerMenu);

        scoreMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        scoreMenu.setMnemonic('x');
        scoreMenu.setText("Scoring");
        scoreMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreMenuActionPerformed(evt);
            }
        });
        fileMenu.add(scoreMenu);

        resultMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        resultMenu.setMnemonic('x');
        resultMenu.setText("Result");
        resultMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultMenuActionPerformed(evt);
            }
        });
        fileMenu.add(resultMenu);

        watchdogMenu.setMnemonic('x');
        watchdogMenu.setText("WatchDog");
        watchdogMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchdogMenuActionPerformed(evt);
            }
        });
        fileMenu.add(watchdogMenu);

        delayMenu.setMnemonic('x');
        delayMenu.setText("Delay");
        delayMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delayMenuActionPerformed(evt);
            }
        });
        fileMenu.add(delayMenu);

        correctionsMenu.setMnemonic('x');
        correctionsMenu.setText("Corrections");
        correctionsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctionsMenuActionPerformed(evt);
            }
        });
        fileMenu.add(correctionsMenu);

        externalMenu.setMnemonic('x');
        externalMenu.setText("External & dev");
        externalMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externalMenuActionPerformed(evt);
            }
        });
        fileMenu.add(externalMenu);

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
                .addGap(553, 553, 553)
                .addComponent(jLabel4)
                .addGap(71, 173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tournamentName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tournamentName)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(update)))
                .addGap(508, 508, 508)
                .addComponent(jLabel4)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerMenuActionPerformed
        
       pg.setVisible(true);
    }//GEN-LAST:event_playerMenuActionPerformed

    private void movementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movementMenuActionPerformed
       
       mg.setVisible(true);
    }//GEN-LAST:event_movementMenuActionPerformed

    private void tournamentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tournamentMenuActionPerformed
       
       tg.setVisible(true);
    }//GEN-LAST:event_tournamentMenuActionPerformed

    private void scoreMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreMenuActionPerformed
       
       sg.setVisible(true);
    }//GEN-LAST:event_scoreMenuActionPerformed

    private void resultMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultMenuActionPerformed

    private void watchdogMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchdogMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_watchdogMenuActionPerformed

    private void delayMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delayMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delayMenuActionPerformed

    private void correctionsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctionsMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correctionsMenuActionPerformed

    private void externalMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externalMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_externalMenuActionPerformed

    private void dealsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealsMenuActionPerformed
       
       dg.setVisible(true);
    }//GEN-LAST:event_dealsMenuActionPerformed

    private void artificialDatabaseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artificialDatabaseMenuActionPerformed
        
        adg.setVisible(true);
    }//GEN-LAST:event_artificialDatabaseMenuActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // update tournament name field
        if(!bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName.equals("")) {
        tournamentName.setText(bridgetournamentcontroller.BridgeTorunamentController.vm.tournamentName);
        }
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainGUI().setVisible(true);
            }
        });
    }
    
                       


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem artificialDatabaseMenu;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem correctionsMenu;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem dealsMenu;
    private javax.swing.JMenuItem delayMenu;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem externalMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem movementMenu;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem playerMenu;
    private javax.swing.JMenuItem resultMenu;
    private javax.swing.JMenuItem scoreMenu;
    private javax.swing.JMenuItem tournamentMenu;
    private javax.swing.JLabel tournamentName;
    private javax.swing.JButton update;
    private javax.swing.JMenuItem watchdogMenu;
    // End of variables declaration//GEN-END:variables

}
