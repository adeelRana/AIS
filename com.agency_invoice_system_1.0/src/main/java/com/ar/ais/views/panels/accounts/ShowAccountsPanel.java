/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.views.panels.accounts;

import com.ar.ais.db.DBM;
import com.ar.ais.models.Response;
import com.ar.ais.utililty.Global;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author java
 */
public class ShowAccountsPanel extends javax.swing.JPanel {

    static String selctionValue;
    int customerId;
    int vendorId;

    DefaultTableModel dtm;

    public ShowAccountsPanel() {
        initComponents();
        dtm = (DefaultTableModel) accountsTable.getModel();
        loadDataToTable("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountsTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(650, 400));

        cancelBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelBtn.setText("BACK");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteBtn.setText("Edit");
        deleteBtn.setEnabled(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        updateBtn.setText("Add");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 30, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accounts Information");

        deleteBtn1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteBtn1.setText("DELETE");
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        accountsTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 180, 169)));
        accountsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Branch Code", "Account No", "Current Balance", "Opening Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accountsTable.setRowHeight(25);
        accountsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountsTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(accountsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelBtn, deleteBtn, updateBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelBtn, deleteBtn, updateBtn});

    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        delete();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Global.addPanel(new AddAccountPanel((JPanel) this.getParent()), (JPanel) this.getParent());
    }//GEN-LAST:event_updateBtnActionPerformed

    private void accountsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountsTableKeyPressed
        if (evt.getKeyCode() == 127) {
            delete();
        }
    }//GEN-LAST:event_accountsTableKeyPressed

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
//        if (accountsTable.getSelectedRowCount() > 0 && accountsTable.getSelectedRowCount() < 2) {
//            int row = accountsTable.getSelectedRow();
//            Response deleteRecord = Global.CONTROLLER.deleteRecord(((Accounts) accountsTable.getValueAt(row, 0)).getAccId(), Accounts.class);
//            if (deleteRecord.isError()) {
//                JOptionPane.showMessageDialog(this, "Error :" + deleteRecord.getErrorMsg());
//            } else {
//                loadDataToTable("");
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Please select One record");
//        }
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        Global.goToMainScreen();
    }//GEN-LAST:event_cancelBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accountsTable;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void loadDataToTable(String type) {
//        dtm.setRowCount(0);
//        ArrayList<Accounts> li = DBM.getAllRecords(Accounts.class);
//        for (Accounts ac : li) {
//            dtm.addRow(new Object[]{
//                ac, ac.getAccCurrentBalance(), ac.getAccOpeningBalance()
//            });
//        }
    }

    public void delete() {
        int numOfRows = this.accountsTable.getSelectedRowCount();
        if (numOfRows != 0) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure You Want to Delete Record / Records ?") == JOptionPane.YES_OPTION) {
                int[] selectedRows = this.accountsTable.getSelectedRows();
                int id;
                for (int i = 0; i < numOfRows; i++) {
                    id = Integer.parseInt(accountsTable.getValueAt(selectedRows[i], 0).toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        }
    }

    public void showLedger() {
//        int numOfRows = this.accountsTable.getSelectedRowCount();
//        if (numOfRows != 0) {
//            if (!(numOfRows > 1)) {
//                int selectedRow = this.accountsTable.getSelectedRow();
//                int id;
//                id = Integer.parseInt(accountsTable.getValueAt(selectedRow, 0).toString());
//                if (id == (int) DBManager.getCashId(true)) {
//                    HashMap m = new HashMap();
//                    m.put("COMPANY_NAME", MainFrame.companyName);
//                    m.put("REPORT_TITLE", "Cash Ledger");
//                    m.put("DATE1", "2015-10-20");
//                    m.put("DATE2", "2015-10-27");
//                    Reports.showReport("FMS_cash_ledger", m, this);        // TODO add your handling code here:
//                } else {
//                    HashMap m = new HashMap();
//                    m.put("COMPANY_NAME", MainFrame.companyName);
//                    m.put("REPORT_TITLE", "" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//                    m.put("ACCOUNT", id);
//                    Reports.showReport("FMS_account_ledger", m, this);        // TODO add your handling code here:
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(MainFrame.obj, "Please Select Single Record to View Ledger");
//            }
//        } else {
//            JOptionPane.showMessageDialog(MainFrame.obj, "Please select a Customer");
//        }
    }
}
