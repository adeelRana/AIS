/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.views.panels.sale;

import com.ar.ais.views.panels.purchase.*;
import com.ar.ais.components.render.CustomKeyListener;
import com.ar.ais.enums.Status;
import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.InvoiceDetail;
import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Shop;
import com.ar.ais.models.ProductQty;
import com.ar.ais.models.Response;
import com.ar.ais.utililty.Calc;
import com.ar.ais.utililty.Frmttr;
import com.ar.ais.utililty.Global;
import com.ar.ais.views.dialogs.ProductSelectionDialog;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adeel rana
 */
public class EditInvoicePanel extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private boolean isDialogueVisible = false;
    private ProductSelectionDialog psd;

    private Invoice inv;

    /**
     *
     * @param mainPanel
     * @param invoice
     */
    public EditInvoicePanel(JPanel mainPanel, Object invoice) {
        this.inv = (Invoice) invoice;
        this.jPanel1 = mainPanel;
        initComponents();
        initData();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new com.ar.ais.components.render.CustomTable(true);
        jButtonAddItem = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextFieldTotal = new javax.swing.JTextField();
        jTextFieldDiscount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();
        jTextFieldGTotal1 = new javax.swing.JTextField();
        jLabelGTotal = new javax.swing.JLabel();
        jTextFieldRoute = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldDiscountShow = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldInvoice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Army Expanded", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Sale Invoice");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jTable1.setBackground(new java.awt.Color(178, 178, 178));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Available", "Price ", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setNextFocusableComponent(jButtonAddItem);
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jButtonAddItem.setText("Add Item");
        jButtonAddItem.setNextFocusableComponent(jButtonRemove);
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.setNextFocusableComponent(jComboBox1);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remove");
        jButtonRemove.setNextFocusableComponent(jButtonSave);
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Shop");

        jComboBox1.setNextFocusableComponent(jTextFieldRoute);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");

        jLabelDiscount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDiscount.setText("Discount ");

        jLabelGTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGTotal.setText("G.Total");

        jTextFieldRoute.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldRoute.setEnabled(false);
        jTextFieldRoute.setFocusable(false);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Route");

        jTextFieldAddress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldAddress.setEnabled(false);
        jTextFieldAddress.setFocusable(false);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");

        jTextFieldCr.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldCr.setEnabled(false);
        jTextFieldCr.setFocusable(false);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cr");

        jTextFieldDiscountShow.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldDiscountShow.setEnabled(false);
        jTextFieldDiscountShow.setFocusable(false);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Discount");

        jTextFieldInvoice.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldInvoice.setEnabled(false);
        jTextFieldInvoice.setFocusable(false);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Invoice No.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAddItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemove)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSave))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldInvoice))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldRoute, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelDiscount, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelGTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldGTotal1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldTotal)
                                    .addComponent(jTextFieldDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDiscountShow, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldAddress, jTextFieldCr, jTextFieldDiscountShow, jTextFieldRoute});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldDiscountShow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDiscount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGTotal))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSave)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAddItem, jButtonRemove, jButtonSave, jComboBox1, jLabel2, jTextFieldDiscount, jTextFieldGTotal1, jTextFieldInvoice, jTextFieldTotal});

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        addProductToTable();
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (jTable1.getRowCount() > 0) {
            insertInvoice();
            Global.addPanel(InvoicesPanel.class, Global.getMainPanel());
        } else {
            JOptionPane.showMessageDialog(this, "No Product to create Invoice");
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        removeFromTable();
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        if (jTable1.getRowCount() > 0) {
            calculate();
        }
    }//GEN-LAST:event_jTable1PropertyChange

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Shop s = (Shop) jComboBox1.getSelectedItem();
        if (null != s) {
            jTextFieldAddress.setText(s.getAddress());
            jTextFieldCr.setText(s.getCurrentCr() + "");
            jTextFieldRoute.setText(s.getShopRoute() + "");

            if (s.getDiscountValue() > 0) {
                jTextFieldDiscountShow.setText(s.showDiscount());
            } else {
                jTextFieldDiscountShow.setText("-");
            }
        }
        calculate();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelGTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldCr;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldDiscountShow;
    private javax.swing.JTextField jTextFieldGTotal1;
    private javax.swing.JTextField jTextFieldInvoice;
    private javax.swing.JTextField jTextFieldRoute;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        Global.setLookNFeel(jTable1);

        Global.addListToCombo(jComboBox1, inv.getInvoiceSummary().getSummaryBooker().getShopList());
        jComboBox1.setSelectedItem(inv.getInvoiceShop());

        addKeyListeners();
    }

    private void loadInvoice() {

        for (InvoiceDetail dt : inv.getInvoiceDetailList()) {
            dtm.addRow(new Object[]{
                dt.getDetailProduct().getCode(),
                dt,
                dt.getDetailProduct().getProductQty(),
                dt.getDetailProduct().getSalePrice()
            });

        }

    }

    private void addProductToTable() {
        if (jTable1.isEditing()) {
            jTable1.getCellEditor().stopCellEditing();
        }

        psd = new ProductSelectionDialog(Global.getMainFrame(), true, false);
        psd.setVisible(true);
        InvoiceDetail detail;
        if (null != psd.getproduct()) {
            Products product = psd.getproduct();
            detail = new InvoiceDetail(product, summary.getWSchedule().getId());

            dtm.addRow(new Object[]{
                detail.getDetailProduct().getCode(),
                detail,
                detail.getDetailProduct().getProductQty(),
                detail.getDetailProduct().getSalePrice()
            });

            Global.setDefaultColumnSelect(jTable1, 4);
            psd = null;
        }

    }

    private void removeFromTable() {
        if (jTable1.getSelectedRowCount() > 0 && jTable1.getSelectedRowCount() < 2) {
            dtm.removeRow(jTable1.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(this, "Please select One record");
        }
    }

    private void insertInvoice() {
        inv = new Invoice();
        Shop shop = (Shop) jComboBox1.getSelectedItem();

        inv.setInvoiceNo(summary.getWSchedule().getDate() + "-" + summary.getInvoiceList().size());
        if (null != shop) {
            inv.setInvoiceShop(shop);
        } else {
            JOptionPane.showMessageDialog(this, "Please select the shop first");
            return;
        }
        inv.setInvoiceSummary(summary);
        inv.setStatus(Status.ACTIVE.getValue());
        inv.setReturn(false);
        inv.setRtnQty(0d);
        inv.setCollection(0d);
        inv.setCredit(0d);
        inv.setInvDiscountType(shop.getDiscountType());
        inv.setInvDiscount(shop.getDiscountAgency());
        addDetails(inv);
        Response insertInv = Global.CONTROLLER.insertRecord(inv, "Invoice");
        if (insertInv.isSuccess()) {
            summary.getInvoiceList().add(inv);
            summary.calculate();
            Response insertRecord = Global.CONTROLLER.updateRecord(summary, "Summary");

            if (insertRecord.isSuccess()) {
                Products p;
                for (InvoiceDetail d : inv.getInvoiceDetailList()) {
                    p = d.getDetailProduct();
                    p.setCurrentQty(p.getCurrentQty() - d.getQty());
                    if (p.getCurrentQty() < 1) {
                        p.setStatus(Status.OUT_OF_STOCK.getValue());
                    }
                    Global.CONTROLLER.updateRecord(d.getDetailProduct(), "Products");
                }
                Global.addPanel(PurchasePanel.class, Global.getMainPanel());
            }
        }
    }

    private void addDetails(Invoice inv) {
        InvoiceDetail dt;
        ProductQty qtyObj;
        double totalQty = 0;
        double totalAmount = 0;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            dt = (InvoiceDetail) dtm.getValueAt(i, 1);
            qtyObj = new ProductQty();
            qtyObj.createObjValuesByCartons(dt.getDetailProduct().getPiecesPerCtn(), Frmttr.getDoubleFromString("" + dtm.getValueAt(i, 4)), dt.getDetailProduct().getWeight());

            dt.setDetailInvoice(inv);
            dt.setQty(qtyObj.getTotalPieces());
            dt.setReturnQty(0);
            inv.getInvoiceDetailList().add(dt);

            totalQty += qtyObj.getCartons();
            totalAmount += dt.getDetailProduct().getSalePrice() * qtyObj.getCartons();
        }

        inv.setTotalAmount(Calc.lessDiscount(totalAmount, inv.getInvoiceShop()));
        inv.setTotalQty(totalQty);
    }

    private void addKeyListeners() {
        jComboBox1.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
        jTextFieldRoute.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
        jTable1.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
        jButtonAddItem.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
        jButtonSave.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
        jButtonRemove.addKeyListener(new CustomKeyListener() {
            @Override
            public void keyReleased(KeyEvent ke) {
                keyActions(ke);
            }
        });
    }

    private void keyActions(java.awt.event.KeyEvent evt) {

        switch (evt.getKeyCode()) {
            case 10:            //10 Enter
//                selectProduct();
                break;
            case 27:            //27 esc         

                if (!isDialogueVisible && null == psd) {
                    isDialogueVisible = true;
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Are you sure, You want to go back");
                    if (showConfirmDialog == 0) {
                        Global.addPanel(PurchasePanel.class, Global.getMainPanel());
                    }
                } else {
                    isDialogueVisible = false;
                }
                break;
            case 116:            //116 f5 OR 119 f8
                jTextFieldRoute.setText("");
                initData();
                break;
            case 120:             // 120 f9
                addProductToTable();
                break;
            case 123:             // 120 f12
                if (jTable1.getRowCount() > 0) {
                    insertInvoice();
                } else {
                    JOptionPane.showMessageDialog(this, "No Product to create Invoice");
                }
                break;
            default:
                break;

        }
    }

    private void calculate() {

        if (jTable1.getRowCount() > 0) {
            Shop shop = (Shop) jComboBox1.getSelectedItem();
            double total = 0;

            double price;
            double qty;

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                price = Frmttr.getDoubleFromString(dtm.getValueAt(i, 3) + "");
                qty = Frmttr.getDoubleFromString(dtm.getValueAt(i, 4) + "");
                dtm.setValueAt(price * qty, i, 5);

                total += price * qty;
            }

            jTextFieldTotal.setText(total + "");
            jTextFieldDiscount.setText("" + Calc.getDiscount(total, shop));
            jTextFieldGTotal1.setText("" + Frmttr.Format(Calc.lessDiscount(total, shop), Frmttr.SIMPLE_NUMBER));

        }
    }
}
