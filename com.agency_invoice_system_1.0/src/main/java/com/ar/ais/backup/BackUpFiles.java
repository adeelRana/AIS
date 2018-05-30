/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.backup;

import com.ar.ais.utililty.Global;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author java
 */
public class BackUpFiles {

    public static int writeDataToFile(File file, StringBuilder content) {
        try {
            File f = new File(file.getAbsolutePath());
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            writer.write("" + content);
            writer.flush();
            fos.flush();
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Global.saveException(ex, false, "file write exception");
            return 0;
        }
        Global.progressState = false;
        return 1;
    }

    public static File createMainDataBase(StringBuilder bkup) {
        File f = new File(Global.getAppDir() + "/temp-main");
        try {
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            writeDataToFile(f, bkup);
        } catch (IOException ex) {
            Global.saveException(ex, true, "createMainDataBase err");
        }
        return f;
    }

    public static boolean deleteFile(File f) {
        if (f.exists()) {
            if (f.isDirectory()) {
                if (f.listFiles().length != -1) {
                    for (File files : f.listFiles()) {
                        if (files.isDirectory()) {
                            deleteFile(files);
                        } else {
                            files.delete();
                        }
                    }
                }
            }
        }
        return true;
    }

    public static String getTempFile(String resourceFileName, Class c) {
        OutputStream output = null;
        File f = new File(Global.getAppDir() + resourceFileName);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            InputStream input = c.getResourceAsStream("/reports" + resourceFileName);
            output = new FileOutputStream(f);
            byte[] buffer = new byte[input.available()];
            for (int i = 0; i != -1; i = input.read(buffer)) {
                output.write(buffer, 0, i);
            }
            input.close();
            output.close();
        } catch (Exception e) {
            Global.saveException(e, true, "getTempFile err");
        }
        return f.getAbsolutePath();
    }

}
