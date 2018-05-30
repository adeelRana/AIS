/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.components.render;

import java.awt.Color;
import java.awt.Insets;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

/**
 *
 * @author java
 */
public class CustomDatePicker extends org.jdesktop.swingx.JXDatePicker {

    public CustomDatePicker() {
        super();
        customEditings();
    }

    public CustomDatePicker(Date selected) {
        super(selected);
        customEditings();
    }

    public CustomDatePicker(Locale locale) {
        super(locale);
        customEditings();
    }

    public CustomDatePicker(Date selection, Locale locale) {
        super(selection, locale);
        customEditings();
    }

    private void customEditings() {

        this.getMonthView().setZoomable(true);
        this.getMonthView().setBorder(null);
        ((org.jdesktop.swingx.JXHyperlink) this.getLinkPanel().getComponent(0)).setForeground(Color.WHITE);
        this.getLinkPanel().setBorder(null);
        this.getLinkPanel().setBackground(new Color(39, 48, 60));

        JFormattedTextField editor = this.getEditor();
        editor.setOpaque(true);
        editor.setBackground(Color.WHITE);
        editor.setEditable(false);
        editor.getSize();

        JButton dateBtn = (JButton) this.getComponent(1);
        dateBtn.setBorder(null);
        dateBtn.setBorderPainted(false);
        dateBtn.setContentAreaFilled(false);
        dateBtn.setSize(32, 32);
        dateBtn.setIcon(new ImageIcon(getClass().getResource("/Buttons/Calendar-icon.png")));
        dateBtn.setPressedIcon(new ImageIcon(getClass().getResource("/Buttons/Calendar-icon.png")));
        dateBtn.setRolloverIcon(new ImageIcon(getClass().getResource("/Buttons/Calendar-icon-1.png")));
        dateBtn.setFocusPainted(false);
        dateBtn.setMargin(new Insets(0, 0, 0, 0));
        dateBtn.setOpaque(false);

    }

}
