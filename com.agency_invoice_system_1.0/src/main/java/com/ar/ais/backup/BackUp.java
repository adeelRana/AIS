/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.backup;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author java
 */
public class BackUp implements Serializable {

    private String fileName;
    private StringBuilder content;
    private File file;
    private HashMap<String, BackUpImage> stdImages;
    private HashMap<String, BackUpImage> empImages;
    private HashMap<String, BackUpImage> grdImages;

    public BackUp(String fileName, File file, StringBuilder content) {
        this.fileName = fileName;
        this.content = content;
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public StringBuilder getContent() {
        return content;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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

}
