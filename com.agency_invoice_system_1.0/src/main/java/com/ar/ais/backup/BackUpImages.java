/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.backup;

import com.ar.ais.utililty.Global;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author java
 */
public class BackUpImages implements Serializable {

    private HashMap<String, BackUpImage> stdImages;
    private HashMap<String, BackUpImage> empImages;
    private HashMap<String, BackUpImage> grdImages;

    private final String imagesFilesDir = Global.getAppDir() + "images";

    public BackUpImages() {
        readTempFiles();
    }

    public BackUpImages(BackUp b) {
        this.stdImages = b.getStdImages();
        this.empImages = b.getEmpImages();
        this.grdImages = b.getGrdImages();

    }

    public HashMap<String, BackUpImage> getStdImages() {
        return stdImages;
    }

    public void setStdImages(HashMap<String, BackUpImage> stdImages) {
        this.stdImages = stdImages;
    }

    public HashMap<String, BackUpImage> getEmpImages() {
        return empImages;
    }

    public void setEmpImages(HashMap<String, BackUpImage> empImages) {
        this.empImages = empImages;
    }

    public HashMap<String, BackUpImage> getGrdImages() {
        return grdImages;
    }

    public void setGrdImages(HashMap<String, BackUpImage> grdImages) {
        this.grdImages = grdImages;
    }

    public void readTempFiles() {

        stdImages = new HashMap<>();
        empImages = new HashMap<>();
        grdImages = new HashMap<>();

        File stdFolder = new File(imagesFilesDir + "/students");
        File empFolder = new File(imagesFilesDir + "/employee");
        File grdFolder = new File(imagesFilesDir + "/guardians");

        if (stdFolder.exists()) {
            for (File f : stdFolder.listFiles()) {
                String name;
                name = f.getName();
                stdImages.put(name, new BackUpImage(name, f, readDataFromFile(f)));
            }
        }
        if (empFolder.exists()) {
            for (File f : empFolder.listFiles()) {
                String name;
                name = f.getName();
                empImages.put(name, new BackUpImage(name, f, readDataFromFile(f)));
            }
        }
        if (grdFolder.exists()) {
            for (File f : grdFolder.listFiles()) {
                String name;
                name = f.getName();
                grdImages.put(name, new BackUpImage(name, f, readDataFromFile(f)));
            }
        }
    }

    public ImageSerializable readDataFromFile(File f) {
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(f);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Global.getMainPanel(), "readDataFromFile error");
        }
        return new ImageSerializable(bf);
    }

    public void createFiles() throws IOException {
        File folder = new File(imagesFilesDir);
        if (BackUpFiles.deleteFile(folder)) {
            folder.mkdir();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Global.saveException(ex, true, "createFiles err");
        }

        for (String key : stdImages.keySet()) {
            BackUpImage bf = stdImages.get(key);
            new File(imagesFilesDir + "/students").mkdirs();
            File f = new File(imagesFilesDir + "/students/" + bf.getFileName());
            f.createNewFile();
            createImageFile(f, bf.getContent().getImage());
            bf.setFile(f);
        }
        for (String key : empImages.keySet()) {
            BackUpImage bf = empImages.get(key);
            new File(imagesFilesDir + "/employee").mkdirs();
            File f = new File(imagesFilesDir + "/employee/" + bf.getFileName());
            f.createNewFile();
            createImageFile(f, bf.getContent().getImage());
            bf.setFile(f);
        }
        for (String key : grdImages.keySet()) {
            BackUpImage bf = grdImages.get(key);
            new File(imagesFilesDir + "/guardians").mkdirs();
            File f = new File(imagesFilesDir + "/guardians/" + bf.getFileName());
            f.createNewFile();
            createImageFile(f, bf.getContent().getImage());
            bf.setFile(f);
        }
    }

    public int createImageFile(File file, BufferedImage content) {
        try {
            File f = new File(file.getAbsolutePath());
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            ImageIO.write(content, "png", file);
            fos.flush();
        } catch (IOException ex) {
            Global.saveException(ex, false, "file write exception");
            return 0;
        }
        return 1;
    }

}
