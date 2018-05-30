/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.components.render;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Adi Rana
 */
public class CustomTable extends JTable {

    private boolean isSelectAllForMouseEvent = false;
    private boolean isSelectAllForActionEvent = false;
    private boolean isSelectAllForKeyEvent = false;

    public CustomTable() {
        super();
    }

    public CustomTable(boolean flag) {
        super();
        this.isSelectAllForMouseEvent = true;
        this.isSelectAllForActionEvent = true;
        this.isSelectAllForKeyEvent = true;
    }

    @Override
    public boolean editCellAt(int row, int column, EventObject e) {
        boolean result = super.editCellAt(row, column, e);

        if (isSelectAllForMouseEvent
                || isSelectAllForActionEvent
                || isSelectAllForKeyEvent) {
            selectAll(e);
        }

        return result;
    }

    @Override
    public TableModel getModel() {
        return super.getModel();
    }

    private void selectAll(EventObject e) {
        final Component editor = getEditorComponent();

        if (editor == null
                || !(editor instanceof JTextComponent)) {
            return;
        }

        if (e == null) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  Typing in the cell was used to activate the editor
        if (e instanceof KeyEvent && isSelectAllForKeyEvent) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  F2 was used to activate the editor
        if (e instanceof ActionEvent && isSelectAllForActionEvent) {
            ((JTextComponent) editor).selectAll();
            return;
        }

        //  A mouse click was used to activate the editor.
        //  Generally this is a double click and the second mouse click is
        //  passed to the editor which would remove the text selection unless
        //  we use the invokeLater()
        if (e instanceof MouseEvent && isSelectAllForMouseEvent) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ((JTextComponent) editor).selectAll();
                }
            });
        }
    }

    public void setSelectAllForEdit(boolean isSelectAllForEdit) {
        setSelectAllForMouseEvent(isSelectAllForEdit);
        setSelectAllForActionEvent(isSelectAllForEdit);
        setSelectAllForKeyEvent(isSelectAllForEdit);
    }

    public void setSelectAllForMouseEvent(boolean isSelectAllForMouseEvent) {
        this.isSelectAllForMouseEvent = isSelectAllForMouseEvent;
    }

    public void setSelectAllForActionEvent(boolean isSelectAllForActionEvent) {
        this.isSelectAllForActionEvent = isSelectAllForActionEvent;
    }

    public void setSelectAllForKeyEvent(boolean isSelectAllForKeyEvent) {
        this.isSelectAllForKeyEvent = isSelectAllForKeyEvent;
    }

    public static void reorderColumns(JTable table, Object... columnNames) {
        TableColumnModel model = table.getColumnModel();

        for (int newIndex = 0; newIndex < columnNames.length; newIndex++) {
            try {
                Object columnName = columnNames[newIndex];
                int index = model.getColumnIndex(columnName);
                model.moveColumn(index, newIndex);
            } catch (IllegalArgumentException e) {
            }
        }
    }

}
