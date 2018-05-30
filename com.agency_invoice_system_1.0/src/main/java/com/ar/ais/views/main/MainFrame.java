package com.ar.ais.views.main;

import com.ar.ais.utililty.Global;

import com.ar.ais.views.panels.LoginPanel;
import com.ar.ais.views.panels.ButtonsPanel;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Adeel rana
 */
public final class MainFrame extends javax.swing.JFrame {

    LoginPanel loginPanel;

    public MainFrame() {
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("A.R School Management System");
//        this.setIconImage(imageIcon);
//        scrlPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.setAlignmentX(CENTER_ALIGNMENT);
        setMenuEnabled(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Global.setMainPanel(mainPanel);
        logout();
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//                if (JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure to close this window?") == JOptionPane.YES_OPTION) {
//                new StartupUtility().stopDataSource();
                System.exit(0);
//                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusPanel = new javax.swing.JPanel();
        leftPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        Main = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iSystem - Demo");
        setMinimumSize(new java.awt.Dimension(250, 300));

        statusPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(statusPanel, java.awt.BorderLayout.PAGE_END);

        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(leftPanel, java.awt.BorderLayout.WEST);

        mainPanel.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        Main.setText("Main");
        Main.setFocusable(false);
        Main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainActionPerformed(evt);
            }
        });
        jToolBar1.add(Main);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainActionPerformed
        Global.goToMainScreen();
    }//GEN-LAST:event_MainActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Main;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    public static void setMenuEnabled(boolean bol) {
//        File.setEnabled(bol);
//        jMenu2.setEnabled(bol);
//        jMenu3.setEnabled(bol);
//        jMenu5.setEnabled(bol);
//        jMenu7.setEnabled(bol);

    }

    public void logout() {

        ButtonsPanel buttonsPanel = new ButtonsPanel(mainPanel);
        this.leftPanel.setVisible(false);
        this.leftPanel.add(buttonsPanel);
        buttonsPanel.setPreferredSize(new Dimension(buttonsPanel.getPreferredSize().width, leftPanel.getPreferredSize().height));
        loginPanel = new LoginPanel(mainPanel, buttonsPanel);
        mainPanel.removeAll();
        loginPanel.setSize(mainPanel.getSize());
        mainPanel.add(loginPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

    }
}
