/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.backup;

import com.ar.ais.utililty.Global;
import com.ar.ais.views.dialogs.ProgressDialog;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author java
 */
public class MySQLDumper {

    public static int createBackup;
    private static final String database = "inventry_system";
    private static final String user = "wiztech";
    private static final String pass = "wiz_admin";

//    private static String path;
    public static void saveAction() {
        String defaultPath = System.getProperty("user.home") + "\\desktop";
        JFileChooser saveFile = new JFileChooser(defaultPath);
        FileFilter filter = new FileNameExtensionFilter("Inventry System Data", new String[]{"isd"});
        saveFile.setFileFilter(filter);
        boolean b = true;
        do {
            int j = saveFile.showSaveDialog(null);
            if (j == JFileChooser.APPROVE_OPTION) {
                File f = chkExt(saveFile.getSelectedFile(), false);
                File crf = new File(f.getAbsolutePath());
                try {
                    b = crf.createNewFile();
                    if (b) {
                        exportDB(crf);
                    } else {
                        int a = JOptionPane.showConfirmDialog(null, "Over Write");
                        if (a == 0) // if over write is yes.. returns 0
                        {
                            crf.delete();
                            crf.createNewFile();
                            exportDB(crf);
                            break;
                        } else if (a == 1); // if over write is no.. returns 1
                        else {
                            break;     // else save is cancel .... returns 2
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } // end save file approve if
            else if (j == JFileChooser.CANCEL_OPTION) // if save file is cancelled
            {
                break;
            }
        } while (!b);  // repetation of file save dialogue
    }   // end save 

    private static File chkExt(File f, boolean flag) {
        String filePath = f.getAbsolutePath();
        if (!filePath.endsWith(".isd")) {
            if (flag) {
                JOptionPane.showMessageDialog(null, "Unknown File Error");
            }
            return new File(filePath + ".isd");
        }
        return f;
    }

    public static void exportDB(final File file) {
        createBackup = 0;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Global.progressState = true;
                BackUp bckup = new BackUp(file.getName(), file, getDataBase());
                BackUpImages backupImages = new BackUpImages();
                bckup.setEmpImages(backupImages.getEmpImages());
                bckup.setStdImages(backupImages.getStdImages());
                bckup.setGrdImages(backupImages.getGrdImages());

                createBackup = objectBackup(bckup, file);
                Global.progressState = false;
            }
        });
        t.start();
        ProgressDialog pd = new ProgressDialog(Global.getMainFrame(), true, 1);
        pd.setVisible(true);
        System.out.println("end " + createBackup);
    }

    private static StringBuilder getDataBase() {
        StringBuilder sb = new StringBuilder();
        StringBuilder err = new StringBuilder();
        Runtime rt = Runtime.getRuntime();
        String[] dump = {Global.getAppDir() + "ms/data/bin/mysqldump.exe", database, "-u", user, "-p" + pass};
        try {
            Process child = rt.exec(dump);
            InputStream in = child.getInputStream();
            int ch;
            while ((ch = in.read()) != -1) {
                sb.append((char) ch);
            }
            InputStream error = child.getErrorStream();
            while ((ch = error.read()) != -1) {
                err.append((char) ch);
            }
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(Global.getMainFrame(), err);
            Global.saveException(exc, true, "Error 204 :saving data exception");
        }
        return sb;
    }

    public static int objectBackup(BackUp backup, File f) {
        int response;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(backup);
                fos.flush();
            }
        } catch (IOException ex) {
            Global.saveException(ex, false, "");
        }

//        objectRestore(f);
        response = 1;
        System.out.println("objectBackup:" + response);
        return response;
    }  // end save proj

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean restoreFromBackup() {
        File file;
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home") + "\\Desktop");
        FileFilter filter = new FileNameExtensionFilter("Inventry System Data", new String[]{"isd"});
        jfc.setFileFilter(filter);
        int i = jfc.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                file = chkExt(jfc.getSelectedFile(), true);
                BackUp backup = getObjectFromFile(file);
                System.out.println("================" + backup.getContent());
                BackUpImages backupImages = new BackUpImages(backup);
                backupImages.createFiles();
                File tempFile = BackUpFiles.createMainDataBase(backup.getContent());
                importDB(tempFile, true);

            } catch (IOException ex) {
                Global.saveException(ex, false, "");
            }
        } else {
            return false;
        }
        return true;
    }

    public static BackUp getObjectFromFile(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (BackUp) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Global.saveException(e, false, "");
        }
        return null;
    }

    public static boolean importDB(final File f, final boolean deleteFlag) {
        final String path = f.getAbsolutePath();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Global.progressState = true;
                dropDB();
                createDB();
                String[] executeCmd = new String[]{Global.getAppDir() + "ms/bin/mysql", "--user=" + user, "--password=" + pass, database, "-e", "source " + path};
                Process runtimeProcess;
                try {
                    runtimeProcess = Runtime.getRuntime().exec(executeCmd);
                    int processComplete = runtimeProcess.waitFor();
                    if (processComplete == 0) {
                        System.out.println("Backup restored successfully");
                        runtimeProcess.destroy();
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not restore backup");
                        Global.progressState = false;
                    }
                } catch (HeadlessException | IOException | InterruptedException ex) {
                    Global.saveException(ex, false, "");
                    Global.progressState = false;
                }
                if (deleteFlag) {

                    f.delete();
                }
                Global.progressState = false;
            }
        });
        t.start();
        ProgressDialog pd = new ProgressDialog(Global.getMainFrame(), true, 4);
        pd.setVisible(true);

        return true;
    }

    public static boolean dropDB() {
        String[] executeCmd = new String[]{Global.getAppDir() + "ms/bin/mysql", "--user=" + user, "--password=" + pass, database, "-e", "DROP DATABASE " + database + ""};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Database Droped");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Could not Drop");
                Global.progressState = false;
            }
        } catch (HeadlessException | IOException | InterruptedException ex) {
            Global.saveException(ex, true, "");
            Global.progressState = false;
        }
        return false;
    }

    public static boolean createDB() {
        String[] executeCmd = new String[]{Global.getAppDir() + "ms/bin/mysql", "--user=" + user, "--password=" + pass, "-e", "CREATE DATABASE " + database + ""};
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);

            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Database Created");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Could not Create");
                Global.progressState = false;
            }
        } catch (HeadlessException | IOException | InterruptedException ex) {
            Global.saveException(ex, true, "");
            Global.progressState = false;
        }
        return false;
    }

//    public static int objectBackup(BackUpFile backup, HashMap<Integer, BackUpFile> files, File f) {
//        int response = 0;
//        try {
//            FileOutputStream fos = new FileOutputStream(f);
//            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//                oos.writeObject(backup);
//                for (Integer i : files.keySet()) {
//
//                }
//                oos.writeObject(files);
//                fos.flush();
//            }
//        } catch (IOException ex) {
//            MainFrame.saveException(ex, false, "");
//        }
//
//        objectRestore(f);
//        response = 1;
//        return response;
//    }  // end save proj
}
