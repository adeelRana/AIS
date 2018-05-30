/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import com.ar.ais.db.DBM;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Adeel rana
 */
public class StartupUtility {

    private final String sqlDir;
    private String appDir;

    public StartupUtility() {
        this.sqlDir = Global.getAppDir().concat("MS/Data/");
    }

    public boolean extractData() {
        appDir = Global.getAppDir();
        try {
            File dir = new File(appDir + "MS");
            if (!dir.exists()) {
                dir.mkdir();
                Utility.unzip(appDir + "data1.zip", appDir);
            }
        } catch (IOException ex) {
            Global.saveException(ex, false, "");
            return false;
        }
        return true;
    }

    public boolean connectDataSource() {
        int i = 0;
        boolean databaseFlag = true;
        while (i < 10) {
            try {
                Thread.sleep(600);
                if (DBM.getEntityManager() != null) {
                    databaseFlag = true;
                    i = 10;
                }
                i++;
            } catch (InterruptedException ex) {
                Global.saveException(ex, false, ex.getLocalizedMessage());
                return false;
            }
        }
        return databaseFlag;
    }

    public boolean checkForTrials() {
        return true;
    }

     public void startDataSource() {
        ArrayList<String> li = new ArrayList<>();
        ProcessBuilder pb;
        li.add(sqlDir + "bin/mysqld");
        pb = new ProcessBuilder(li);
        try {
            pb.start();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Err 201 :     Unknown Error : \n\nRe Installing the Application May Fix This Error\n  " + ex);
            System.exit(0);
        }
    }

    public void stopDataSource() {
        ArrayList<String> li = new ArrayList<>();
        ProcessBuilder pb;
        li.add(sqlDir + "bin/mysqladmin.exe");
        li.add("-u");
        li.add("root");
        li.add("shutdown");
        pb = new ProcessBuilder(li);
        try {
            pb.start();
            Runtime.getRuntime().exec("TASKKILL /F /IM mysqld.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Err 202 :     Unknown Error : \n\nRe Installing the Application May Fix This Error\n  " + ex);
            System.exit(0);
        }
    }

}
