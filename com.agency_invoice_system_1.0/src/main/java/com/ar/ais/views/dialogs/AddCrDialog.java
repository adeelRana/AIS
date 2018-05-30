/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.views.dialogs;

import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.Summary;
import com.ar.ais.utililty.Frmttr;
import com.ar.ais.utililty.Global;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Adeel rana
 */
public class AddCrDialog extends javax.swing.JDialog {

    private Summary s;

    /**
     * Creates new form ProductInquiryDialog
     *
     * @param parent
     * @param modal
     * @param s
     */
    public AddCrDialog(java.awt.Frame parent, boolean modal, Summary s) {
        super(parent, modal);
        this.s = s;
        initComponents();
        loadCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxInvoice = new javax.swing.JComboBox<>();
        jTextFieldCr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Credit");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Shop");

        jLabel4.setText("Cr Amount");

        jComboBoxInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInvoiceActionPerformed(evt);
            }
        });
        jComboBoxInvoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBoxInvoiceKeyTyped(evt);
            }
        });

        jLabel3.setText("Current Balance");

        jTextFieldBalance.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 60, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxInvoice, 0, 160, Short.MAX_VALUE)
                            .addComponent(jTextFieldCr)
                            .addComponent(jTextFieldBalance))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jComboBoxInvoice, jLabel2, jLabel4, jTextFieldBalance, jTextFieldCr});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (null != jComboBoxInvoice.getSelectedItem() && !jTextFieldCr.getText().isEmpty()) {
            Invoice i = (Invoice) jComboBoxInvoice.getSelectedItem();
            try {
                double cr = Frmttr.getDoubleFromString(jTextFieldCr.getText());
                i.setCredit(i.getCredit() + cr);
                i.getInvoiceShop().setCurrentCr(i.getInvoiceShop().getCurrentCr() + i.getCredit());
                Global.CONTROLLER.updateRecord(i.getInvoiceShop(), "Shop");
                i.getInvoiceSummary().calculate();
                Global.CONTROLLER.updateRecord(i.getInvoiceSummary(), "Summary");
                jComboBoxInvoice.getEditor().setItem(null);
                jComboBoxInvoice.requestFocus();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Number");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInvoiceActionPerformed
        if (null != jComboBoxInvoice.getSelectedItem()) {
            Invoice i = (Invoice) jComboBoxInvoice.getSelectedItem();
            jTextFieldBalance.setText(i.getTotalAmount() - i.getCredit() - i.getCollection() + "");

        } else {
            jTextFieldBalance.setText("");
            jTextFieldCr.setText("");
        }
    }//GEN-LAST:event_jComboBoxInvoiceActionPerformed

    private void jComboBoxInvoiceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxInvoiceKeyTyped
        if (evt.getKeyCode() == 10) {
            jTextFieldCr.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxInvoiceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxInvoice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldBalance;
    private javax.swing.JTextField jTextFieldCr;
    // End of variables declaration//GEN-END:variables

    private void loadCombos() {
        Global.addListToCombo(jComboBoxInvoice, s.getInvoiceList());
        AutoCompleteDecorator.decorate(jComboBoxInvoice);
    }

    public Summary getSummary() {
        return this.s;
    }

}
