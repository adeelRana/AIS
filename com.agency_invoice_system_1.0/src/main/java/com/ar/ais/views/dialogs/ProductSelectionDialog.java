/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.views.dialogs;

import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.utililty.Global;
import com.ar.ais.utililty.Utility;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Adeel rana
 */
public class ProductSelectionDialog extends javax.swing.JDialog {

    private ArrayList<Object> list;
    private ArrayList filteredList;
    boolean sameFlag = false;
    boolean showAll = false;
    private Products p;

    /**
     * Creates new form ProductInquiryDialog
     *
     * @param parent
     * @param modal
     * @param showAll
     */
    public ProductSelectionDialog(java.awt.Frame parent, boolean modal, boolean showAll) {
        super(parent, modal);
        initComponents();
        this.showAll = showAll;
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Enquiry");

        jLabel2.setText("Search");

        jTextField1.setNextFocusableComponent(jList);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.setNextFocusableComponent(jTextField1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jList.setNextFocusableComponent(jButton1);
        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMouseClicked(evt);
            }
        });
        jList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jListKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jList);

        jTextField2.setNextFocusableComponent(jList);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jTextField3.setNextFocusableComponent(jList);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jLabel3, jTextField1, jTextField2, jTextField3});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectProduct();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        search();
        switch (evt.getKeyCode()) {
            case 39:
                jTextField2.requestFocus();
                jTextField2.selectAll();
                break;
//        39 37
            case 40:
                jList.requestFocus();
                break;
            default:
                jTextField2.requestFocus();
                jTextField2.selectAll();
                break;
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        keyActions(evt);
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListKeyPressed
        keyActions(evt);
    }//GEN-LAST:event_jListKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        keyActions(evt);
    }//GEN-LAST:event_jButton1KeyPressed

    private void jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMouseClicked
        if (evt.getClickCount() == 2) {
            selectProduct();
        }
    }//GEN-LAST:event_jListMouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        search();
        switch (evt.getKeyCode()) {
            case 39:
                jTextField3.requestFocus();
                jTextField3.selectAll();
                break;
            case 37:
                jTextField1.requestFocus();
                jTextField1.selectAll();
                break;
            case 40:
                jList.requestFocus();
                break;
            default:
                jTextField3.requestFocus();
                jTextField3.selectAll();
                break;
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        keyActions(evt);
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        search();
        if (evt.getKeyCode() == 37) {
            jTextField2.requestFocus();
            jTextField2.selectAll();
        } else if (evt.getKeyCode() == 40) {
            jList.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        keyActions(evt);
    }//GEN-LAST:event_jTextField3KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public Products getproduct() {
        return this.p;
    }

    private void initData() {
        filteredList = new ArrayList<>();
        if (showAll) {
            list = (ArrayList) Global.CONTROLLER.fetch("Products").getResponseObject();
        } else {
            list = (ArrayList) Global.CONTROLLER.fetchActive("Products").getResponseObject();
        }
        jList.setModel(Global.addlistToJList(list));
    }

    private void search() {

        jList.removeAll();
        jLabel3.setText("");
        setFilteredList(jTextField1.getText(), jTextField2.getText(), jTextField3.getText());
        jList.setModel(Global.addlistToJList(filteredList));
        if (sameFlag && filteredList.size() > 0) {
            jTextField2.requestFocus();
        } else if (filteredList.isEmpty()) {
            jLabel3.setText("PRoduct not found");
        }
    }

    private boolean setFilteredList(String name, String flavor, String wght) {
        sameFlag = false;
        filteredList.clear();

        for (Object obj : list) {
//            Products p = (Products) obj;
//            if (Utility.matchPattern(p.getName(), "^\\s*" + name + ".+")
//                    && Utility.matchPattern(p.getFlavour(), "^\\s*" + flavor + ".+")
//                    && Utility.matchPattern(p.getWeight().intValue() + " " + "", "^\\s*" + wght + ".+")) {
//                filteredList.add((Products) obj);
//            }
            Products p = (Products) obj;
            if (Utility.matchPattern(
                    p.getName() + " " + p.getFlavour() + " " + p.getWeight(),
                    "(" + name + ".*) (" + flavor + ".*) (" + wght + ".*)")) {

                filteredList.add((Products) obj);
            }

        }
        return sameFlag;
    }

    private void keyActions(java.awt.event.KeyEvent evt) {

        switch (evt.getKeyCode()) {
            case 27:            //27 esc            
                this.dispose();
                break;
            case 116:            //116 f5 OR 119 f8
            case 119:
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                initData();
                break;
            case 10:            //10 Enter
                selectProduct();
                break;
            default:
                break;
            //120 f9
        }
    }

    private void selectProduct() {
        if (jList.getSelectedIndex() == -1) {
            jLabel3.setText("No Product is selected");
        } else {
            p = (Products) ((DefaultListModel) jList.getModel()).get(jList.getSelectedIndex());
            this.dispose();
        }
    }
}
