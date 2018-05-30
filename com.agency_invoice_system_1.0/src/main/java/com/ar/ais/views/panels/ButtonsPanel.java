package com.ar.ais.views.panels;

import com.ar.ais.utililty.Global;
import com.ar.ais.views.panels.accounts.AddAccountPanel;
import com.ar.ais.views.panels.accounts.AddExpensePanel;
import com.ar.ais.views.panels.accounts.ManageAccountsPanel;
import com.ar.ais.views.panels.file.UserInfoPanel;
import com.ar.ais.views.panels.file.UsersPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXTaskPane;

/**
 *
 * @author Adeel rana
 */
public class ButtonsPanel extends javax.swing.JPanel {

    private static final String PACKAGE_NAME = "com.ay.isystem.views.panels";
    private JPanel mainPanel;
    private Font font;

    private ButtonsPanel() {
        initComponents();
    }

    public ButtonsPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        initComponents();
        initTaskPane();
        this.font = addUser.getFont();
        backupPane.setVisible(false);
        usersPane.setVisible(false);
        jButton1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUser = new javax.swing.JLabel();
        deleteUser = new javax.swing.JLabel();
        editUser = new javax.swing.JLabel();
        mProducts = new javax.swing.JLabel();
        mProdVehicle = new javax.swing.JLabel();
        mProductLocation = new javax.swing.JLabel();
        mProdDesc = new javax.swing.JLabel();
        Sales = new javax.swing.JLabel();
        saleReturn = new javax.swing.JLabel();
        Purchases = new javax.swing.JLabel();
        purchaseReturn = new javax.swing.JLabel();
        vendors = new javax.swing.JLabel();
        payables = new javax.swing.JLabel();
        customers = new javax.swing.JLabel();
        receiveables = new javax.swing.JLabel();
        addAccount = new javax.swing.JLabel();
        transaction = new javax.swing.JLabel();
        expenses = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        backup = new javax.swing.JLabel();
        restore = new javax.swing.JLabel();
        agents = new javax.swing.JLabel();
        masterList = new javax.swing.JLabel();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        jButton1 = new javax.swing.JButton();
        adminPane = new org.jdesktop.swingx.JXTaskPane();
        productsPane = new org.jdesktop.swingx.JXTaskPane();
        salesPane = new org.jdesktop.swingx.JXTaskPane();
        Purchase = new org.jdesktop.swingx.JXTaskPane();
        parties = new org.jdesktop.swingx.JXTaskPane();
        payableReceiveable = new org.jdesktop.swingx.JXTaskPane();
        accountsPane = new org.jdesktop.swingx.JXTaskPane();
        backupPane = new org.jdesktop.swingx.JXTaskPane();
        usersPane = new org.jdesktop.swingx.JXTaskPane();

        addUser.setForeground(new java.awt.Color(0, 51, 153));
        addUser.setText("Add User");
        addUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addUserMouseEntered(evt);
            }
        });

        deleteUser.setForeground(new java.awt.Color(0, 51, 153));
        deleteUser.setText("Delete user");
        deleteUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteUserMouseExited(evt);
            }
        });

        editUser.setForeground(new java.awt.Color(0, 51, 153));
        editUser.setText("Edit user");
        editUser.setToolTipText("");
        editUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mProducts.setForeground(new java.awt.Color(0, 51, 153));
        mProducts.setText("Manage Products");
        mProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mProdVehicle.setForeground(new java.awt.Color(0, 51, 153));
        mProdVehicle.setText("Manage Vehicles");
        mProdVehicle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mProductLocation.setForeground(new java.awt.Color(0, 51, 153));
        mProductLocation.setText("Manage Location");

        mProdDesc.setForeground(new java.awt.Color(0, 51, 153));
        mProdDesc.setText("Manage Description");
        mProdDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Sales.setForeground(new java.awt.Color(0, 51, 153));
        Sales.setText("Sales");
        Sales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        saleReturn.setForeground(new java.awt.Color(0, 51, 153));
        saleReturn.setText("Sale Return");
        saleReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Purchases.setForeground(new java.awt.Color(0, 51, 153));
        Purchases.setText("Purchases");
        Purchases.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        purchaseReturn.setForeground(new java.awt.Color(0, 51, 153));
        purchaseReturn.setText("Purchase Return ");
        purchaseReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        vendors.setForeground(new java.awt.Color(0, 51, 153));
        vendors.setText("Vendors");
        vendors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        payables.setForeground(new java.awt.Color(0, 51, 153));
        payables.setText("Payables");
        payables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        customers.setForeground(new java.awt.Color(0, 51, 153));
        customers.setText("Customers");
        customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        receiveables.setForeground(new java.awt.Color(0, 51, 153));
        receiveables.setText("Receiveables");
        receiveables.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addAccount.setForeground(new java.awt.Color(0, 51, 153));
        addAccount.setText("Add Account");
        addAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        transaction.setForeground(new java.awt.Color(0, 51, 153));
        transaction.setText("Create Transaction");
        transaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        expenses.setForeground(new java.awt.Color(0, 51, 153));
        expenses.setText("Expenses");
        expenses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        logout.setForeground(new java.awt.Color(0, 51, 153));
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        backup.setForeground(new java.awt.Color(0, 51, 204));
        backup.setText("Backup");
        backup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        restore.setForeground(new java.awt.Color(0, 51, 204));
        restore.setText("Restore");
        restore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        agents.setText("Agent");

        masterList.setText("Master List");

        setLayout(new java.awt.BorderLayout());

        jXTaskPaneContainer1.setPreferredSize(new java.awt.Dimension(200, 536));
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jXTaskPaneContainer1.setLayout(verticalLayout1);

        jButton1.setText("Main Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jXTaskPaneContainer1.add(jButton1);

        adminPane.setEnabled(false);
        adminPane.setMinimumSize(new java.awt.Dimension(100, 46));
        adminPane.setTitle("Admin");
        jXTaskPaneContainer1.add(adminPane);

        productsPane.setToolTipText("Products");
        productsPane.setName("Products"); // NOI18N
        productsPane.setTitle("Products");
        jXTaskPaneContainer1.add(productsPane);
        productsPane.getAccessibleContext().setAccessibleName("");

        salesPane.setTitle("Sales");
        jXTaskPaneContainer1.add(salesPane);

        Purchase.setTitle("Purchases");
        jXTaskPaneContainer1.add(Purchase);

        parties.setTitle("Parties");
        jXTaskPaneContainer1.add(parties);

        payableReceiveable.setTitle("Payables & Receiveables");
        jXTaskPaneContainer1.add(payableReceiveable);

        accountsPane.setTitle("Accounts");
        jXTaskPaneContainer1.add(accountsPane);

        backupPane.setTitle("Backup");
        jXTaskPaneContainer1.add(backupPane);

        usersPane.setTitle("User");
        jXTaskPaneContainer1.add(usersPane);

        add(jXTaskPaneContainer1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addUserMouseEntered

    private void deleteUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteUserMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Global.goToMainScreen();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTaskPane Purchase;
    private javax.swing.JLabel Purchases;
    private javax.swing.JLabel Sales;
    private org.jdesktop.swingx.JXTaskPane accountsPane;
    private javax.swing.JLabel addAccount;
    private javax.swing.JLabel addUser;
    private org.jdesktop.swingx.JXTaskPane adminPane;
    private javax.swing.JLabel agents;
    private javax.swing.JLabel backup;
    private org.jdesktop.swingx.JXTaskPane backupPane;
    private javax.swing.JLabel customers;
    private javax.swing.JLabel deleteUser;
    private javax.swing.JLabel editUser;
    private javax.swing.JLabel expenses;
    private javax.swing.JButton jButton1;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel mProdDesc;
    private javax.swing.JLabel mProdVehicle;
    private javax.swing.JLabel mProductLocation;
    private javax.swing.JLabel mProducts;
    private javax.swing.JLabel masterList;
    private org.jdesktop.swingx.JXTaskPane parties;
    private org.jdesktop.swingx.JXTaskPane payableReceiveable;
    private javax.swing.JLabel payables;
    private org.jdesktop.swingx.JXTaskPane productsPane;
    private javax.swing.JLabel purchaseReturn;
    private javax.swing.JLabel receiveables;
    private javax.swing.JLabel restore;
    private javax.swing.JLabel saleReturn;
    private org.jdesktop.swingx.JXTaskPane salesPane;
    private javax.swing.JLabel transaction;
    private org.jdesktop.swingx.JXTaskPane usersPane;
    private javax.swing.JLabel vendors;
    // End of variables declaration//GEN-END:variables

    private void initTaskPane() {
        addToTaskPane(adminPane, addUser, UserInfoPanel.class);
        addToTaskPane(adminPane, editUser, UsersPanel.class);
        addDialogToTaskPane(adminPane, masterList, "");

//        addToTaskPane(productsPane, mProducts, ProductsPanel.class);
//        addToTaskPane(productsPane, mProdVehicle, VehiclesPanel.class);
//
//        addToTaskPane(salesPane, Sales, ShowSalePanel.class);
//
//        addToTaskPane(Purchase, Purchases, ShowPurchase.class);
//        addToTaskPane(parties, vendors, VendorsPanel.class, "Vendor", "vendor");
//        addToTaskPane(parties, customers, VendorsPanel.class, "Customer", "vendor");
//        addToTaskPane(parties, agents, VendorsPanel.class, "Agent", "vendor");
//        addToTaskPane(payableReceiveable, payables, PayablePanel.class, "Vendor", "payable");
        addToTaskPane(accountsPane, addAccount, AddAccountPanel.class);
        addToTaskPane(accountsPane, transaction, ManageAccountsPanel.class);
        addToTaskPane(accountsPane, expenses, AddExpensePanel.class);

    }

    private void addPanel(Class cls) {
        try {
            mainPanel.removeAll();
            JPanel panel = (JPanel) cls.newInstance();
            panel.setSize(mainPanel.getSize());
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void addPanel(String type, String cat) {
        mainPanel.removeAll();
        JPanel panel = new JPanel(); // temporary initialization 
        if (cat.equalsIgnoreCase("payable")) {
//            panel = new PayablePanel(type);
        } else {
//            panel = new VendorsPanel(type);
        }

        panel.setSize(mainPanel.getSize());
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    private void addToTaskPane(JXTaskPane taskPane, JLabel label, final Class panelClass, final String type, final String cat) {
        taskPane.add(label);
        taskPane.setVisible(false);
        taskPane.setCollapsed(true);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addPanel(type, cat);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setFont(new Font("tahoma", Font.BOLD, 13));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setFont(font);
            }

        });
    }

    private void addDialogToTaskPane(JXTaskPane taskPane, JLabel label, final String cat) {
        taskPane.add(label);
        taskPane.setVisible(false);
        taskPane.setCollapsed(true);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                new AddMasterListDialog(null, true).setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setFont(new Font("tahoma", Font.BOLD, 13));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setFont(font);
            }

        });
    }

    private void addToTaskPane(JXTaskPane taskPane, JLabel label, final Class panelClass) {
        taskPane.add(label);
        taskPane.setVisible(false);
        taskPane.setCollapsed(true);
        label.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                addPanel(panelClass);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.getComponent().setFont(new Font("tahoma", Font.BOLD, 13));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setFont(font);
            }

        });
    }

    public boolean EnableForAdmin() {
        adminPane.setVisible(true);
        productsPane.setVisible(true);
        salesPane.setVisible(true);
        Purchase.setVisible(true);
        payableReceiveable.setVisible(true);
        parties.setVisible(true);
        accountsPane.setVisible(true);
        backupPane.setVisible(true);
        usersPane.setVisible(true);
        jButton1.setVisible(true);
        return false;
    }

    public boolean EnableForUser() {
//        adminPane.setVisible(true);
        productsPane.setVisible(true);
        salesPane.setVisible(true);
        Purchase.setVisible(true);
//        vendorsPane.setVisible(true);
//        customersPane.setVisible(true);
//        accountsPane.setVisible(true);
//        backupPane.setVisible(true);
        usersPane.setVisible(true);
        jButton1.setVisible(true);
        return false;
    }
}
