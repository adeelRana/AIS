/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.components.render;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.plaf.UIManagerExt;
import org.jdesktop.swingx.plaf.basic.CalendarHeaderHandler;
import swingdesigning.MyComboBoxUI;
import swingdesigning.frame;

/**
 *
 * @author java
 */
public class UI {

    public static void setUI() {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());

            MyComboBoxUI.icon = new ImageIcon(frame.class.getResource("/Buttons/Dropdown-2.png"));
            MyComboBoxUI.rolloverIcon = new ImageIcon(frame.class.getResource("/Buttons/Dropdown-2-hover.png"));
            UIManager.put("ComboBoxUI", MyComboBoxUI.class.getName());

            UIManager.put(CalendarHeaderHandler.uiControllerID, CustomCalendarHeaderHandler.class.getName());

//        UIManager.put("CheckBox.icon", new ImageIcon(UI.class.getResource("/a.png")));
            UIManager.put("JXMonthView.background", new Color(31, 38, 47));
            UIManager.put("JXMonthView.foreground", new Color(121, 135, 153));
            UIManager.put("JXMonthView.monthStringBackground", new ColorUIResource(37, 174, 207));
            UIManager.put("JXMonthView.daysOfTheWeekForeground", new ColorUIResource(155, 170, 189));
            UIManager.put("JXMonthView.weekOfTheYearForeground", new ColorUIResource(155, 170, 189));
            UIManager.put("JXMonthView.unselectableDayForeground", new ColorUIResource(Color.RED));
            UIManager.put("JXMonthView.selectedBackground", new ColorUIResource(39, 48, 60));
            UIManager.put("JXMonthView.selectedForeground", Color.white);
            UIManager.put("JXMonthView.flaggedDayForeground", new ColorUIResource(Color.RED));
            UIManager.put("JXMonthView.leadingDayForeground", new ColorUIResource(Color.GREEN));
            UIManager.put("JXMonthView.trailingDayForeground", new ColorUIResource(Color.GREEN));
            UIManager.put("JXMonthView.font", UIManagerExt.getSafeFont("Button.font", new FontUIResource("Dialog", Font.BOLD, 12)));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

    }
}
