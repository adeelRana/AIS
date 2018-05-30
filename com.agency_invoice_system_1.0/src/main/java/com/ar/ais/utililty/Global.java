/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import com.ar.ais.controller.InventryController;
import com.ar.ais.models.EntityBeans.AppUser;
import com.ar.ais.models.Response;
import com.ar.ais.views.main.MainFrame;
import com.ar.ais.views.panels.WelcomePanel;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Adeel rana
 */
public class Global {

    public static final InventryController CONTROLLER = new InventryController();
    public static final DateUtility DATE_UTIL = new DateUtility();

    public static final String APP_DIR = getAppDir();
    public static AppUser LOGGED_USER = new AppUser();
    public static boolean progressState = false;

    private static JPanel mainPanel;
    private static MainFrame mainFrame;

    /*
        Panels 
     */
    public static JPanel getMainPanel() {
        return mainPanel;
    }

    public static void setMainPanel(JPanel mainPanel) {
        Global.mainPanel = mainPanel;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static void setMainFrame(MainFrame mainFrame) {
        Global.mainFrame = mainFrame;
    }

    public static void addPanel(JPanel panel, JPanel mainPanel) {
        mainPanel.removeAll();
        panel.setSize(mainPanel.getSize());
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public static JPanel addPanel(Class cls, JPanel mainPanel) {

        JPanel panel = null;
        try {
            mainPanel.removeAll();
            panel = (JPanel) cls.getConstructor(JPanel.class).newInstance(mainPanel);
            panel.setSize(mainPanel.getSize());
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return panel;
    }

    public static void addPanel(Class cls, JPanel mainPanel, Object obj) {
        try {
            mainPanel.removeAll();
            JPanel panel = (JPanel) cls.getConstructor(JPanel.class, Object.class).newInstance(mainPanel, obj);
            panel.setSize(mainPanel.getSize());
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    public static void goToMainScreen() {
        JPanel parent = getMainPanel();
        parent.removeAll();
        JPanel panel = new WelcomePanel(parent);
        panel.setSize(parent.getSize());
        parent.add(panel);
        parent.repaint();
        parent.revalidate();
    }

    /*
    *   JComboBOx
     */
    public static <T> boolean addListToCombo(JComboBox c, List<T> li) {
        c.removeAllItems();
        AutoCompleteDecorator.decorate(c);
        try {
            for (Object o : li) {
                c.addItem(o);
            }
        } catch (Exception e) {
        }

        return true;
    }

    public static void addListToCombo(Response response, JComboBox combo) {
        for (Object obj : (ArrayList<Object>) response.getResponseObject()) {
            combo.addItem(obj);
        }
    }

    /*
        JList
     */
    public static DefaultListModel addlistToJList(ArrayList<Object> elements) {
        DefaultListModel modal = new DefaultListModel();
        for (Object ob : elements) {
            modal.addElement(ob);
        }
        return modal;
    }

    public static void addToList(DefaultListModel li, Object val) {
        if (li.indexOf(val) == -1) {
            li.addElement(val);
        }
    }

    /**
     * JTable
     *
     * @param table
     * @param column
     */
    public static void setDefaultColumnSelect(JTable table, int column) {
        table.setCellSelectionEnabled(true);
        table.changeSelection(table.getRowCount() - 1, column, false, false);
        table.requestFocus();
    }

    public static void setLookNFeel(JTable table) {
        table.setRowHeight(25);
        table.setBackground(Color.getHSBColor(0, 0, 1f));
        table.getTableHeader().setFont(new Font("Cambria", Font.BOLD, 14));
        table.setFont(new Font("Calibri", Font.CENTER_BASELINE, 14));
        table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 180, 169)));
        table.setRowHeight(30);
    }

    /*
       Others
     */
    public static void removeFromList(DefaultListModel li, Object val) {
        if (li.indexOf(val) != -1) {
            li.removeElement(val);
        }
    }

    public static void saveException(Exception e, boolean flag, String text) {
        if (flag) {
            JOptionPane.showMessageDialog(getMainPanel(), text + "\n---->" + e);
        }
        File folder = new File(getAppDir() + "Exceptions");
        int lastFile = 0;
        String name;
        if (folder.exists()) {
            name = folder.listFiles()[folder.listFiles().length - 1].getName().split("\\.")[0];
            lastFile = Integer.parseInt("" + name.charAt(name.length() - 1));
        } else {
            folder.mkdir();
        }
        try {
            FileWriter fw;
            try (StringWriter errors = new StringWriter()) {
                String content = errors.toString();
                File file = new File(getAppDir() + "Exceptions/exception" + (lastFile + 1) + ".txt");
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file.getAbsoluteFile());
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(content);
                    bw.close();
                }
                fw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(getMainPanel(), ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getMainPanel(), ex);
        }
    }

    public static String getAppDir() {
        return System.getProperty("user.home").concat("/AppData/Roaming/ShibamInventry/SIS/").replace("\\", "/");
    }

}
