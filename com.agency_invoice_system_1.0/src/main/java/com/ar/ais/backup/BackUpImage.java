/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.backup;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author java
 */
public class BackUpImage implements Serializable {

    private String fileName;
    private ImageSerializable content;
    private File file;

    public BackUpImage() {

    }

    public BackUpImage(String fileName, File file, ImageSerializable content) {
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ImageSerializable getContent() {
        return content;
    }

    public void setContent(ImageSerializable content) {
        this.content = content;
    }

}
