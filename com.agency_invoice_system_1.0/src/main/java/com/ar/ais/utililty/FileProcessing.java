/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.utililty;

import com.ar.ais.views.main.MainFrame;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author java
 */
public class FileProcessing {

    public static File openFile(String fileType, String... supportedExtensions) {
        File file = null;
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home") + "\\Desktop");
        FileFilter filter = new FileNameExtensionFilter(fileType, supportedExtensions);
        jfc.setFileFilter(filter);
        int i = jfc.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            try {
                file = chkExt(jfc.getSelectedFile(), false, supportedExtensions);
                file.getAbsoluteFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private static File chkExt(File f, boolean flag, String... extension) {
        String filePath = f.getAbsolutePath();
        for (String ext : extension) {
            if (filePath.endsWith("." + ext)) {
                return f;
            }
        }
        if (flag) {
            return new File(filePath.substring(0, filePath.lastIndexOf(".") + 1) + extension[0]);
        } else {
            JOptionPane.showMessageDialog(null, "Unknown File Extension");
            return null;
        }
    }

    public static String getTempFile(String resourceFilePath) {
        OutputStream output;
        File f = new File(Global.getAppDir() + resourceFilePath);
        try {
            String dir = Global.getAppDir() + resourceFilePath.substring(0, resourceFilePath.lastIndexOf("/"));
            if (!f.exists()) {
                new File(dir).mkdirs();
                f.createNewFile();
            } else {
                f.delete();
                f.createNewFile();
            }
            InputStream input = FileProcessing.class.getResourceAsStream("/" + resourceFilePath);
            output = new FileOutputStream(f);
            byte[] buffer = new byte[input.available()];
            for (int i = 0; i != -1; i = input.read(buffer)) {
                output.write(buffer, 0, i);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f.getAbsolutePath();
    }

    public static File createNewFile(FileFilter filter, int fileSelectionMode) {
        String defaultPath = System.getProperty("user.home") + "\\desktop";
        JFileChooser saveFile = new JFileChooser(defaultPath);
//        FileFilter filter = new FileNameExtensionFilter("Excel Macro-Enabled Workbook ", new String[]{"xlsx"});
        saveFile.setFileFilter(filter);
//        saveFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        saveFile.setFileSelectionMode(fileSelectionMode);
        boolean b = true;
        do {
            int j = saveFile.showSaveDialog(null);
            if (j == JFileChooser.APPROVE_OPTION) {

                File f = chkExt(saveFile.getSelectedFile(), false, filter.toString());
//                File f = saveFile.getSelectedFile();
                File crf = new File(f.getAbsolutePath());
                try {
                    b = crf.createNewFile();
                    if (b) {
                        return crf;
                    } else {
                        int a = JOptionPane.showConfirmDialog(null, "Over Write");
                        if (a == 0) // if over write is yes.. returns 0
                        {
                            crf.delete();
                            crf.createNewFile();
                            return crf;
                        } else if (a == 1) {
                        } // if over write is no.. returns 1
                        else {
                            return null;  // else save is cancel .... returns 2
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return null;
                }
            } // end save file approve if
            else if (j == JFileChooser.CANCEL_OPTION) // if save file is cancelled
            {
                return null;
            }
        } while (!b);  // repetation of file save dialogue

        return null;
    }   // end save 

    public static String createNewDirectory() {
        JFileChooser saveFile = new JFileChooser();
//        FileFilter filter = new FileNameExtensionFilter("Excel Macro-Enabled Workbook ", new String[]{"xlsx"});
        saveFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        boolean b = true;
        do {
            int j = saveFile.showSaveDialog(null);
            if (j == JFileChooser.APPROVE_OPTION) {
                File f = saveFile.getSelectedFile();
                File dir = new File(f.getAbsolutePath());
                dir.mkdirs();
                return dir.getAbsolutePath();
            } // end save file approve if
            else if (j == JFileChooser.CANCEL_OPTION) // if save file is cancelled
            {
                return null;
            }
        } while (!b);  // repetation of file save dialogue

        return null;
    }   // end save 

    private static File chkExt(File f, boolean flag, String filter) {

        String extension = filter.substring(filter.indexOf("extensions=[") + 12, filter.lastIndexOf("]]") - 1);
        extension = extension.split(",")[0];

        String filePath = f.getAbsolutePath();
        if (!filePath.endsWith("." + extension)) {
            if (flag) {
                JOptionPane.showMessageDialog(null, "Unknown File Error");
            }
            return new File(filePath + "." + extension);
        }
        return f;
    }
}
