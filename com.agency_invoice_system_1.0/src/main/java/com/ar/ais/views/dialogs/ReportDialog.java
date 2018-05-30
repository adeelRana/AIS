/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.views.dialogs;

import com.ar.ais.utililty.FileProcessing;
import com.ar.ais.utililty.Global;
import com.ar.ais.views.main.MainFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author java
 */
public class ReportDialog extends javax.swing.JDialog {

    public ReportDialog(java.awt.Frame parent, boolean modal, JRViewer viewer) {
        super(parent, modal);
        initComponents();
        jPanel1.add(viewer);
    }

    public ReportDialog(ArrayList dataList, HashMap parameters, JasperReport sourceFile, int type) {
        super(Global.getMainFrame(), true);
        initComponents();
        try {
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
            JasperPrint print = JasperFillManager.fillReport(
                    sourceFile,
                    parameters,
                    beanColDataSource);
            JasperExportManager.exportReportToPdfFile(print, "e://sample_report.pdf");
            JasperExportManager.exportReportToHtmlFile(print, "e://sample_report.html");
            JRViewer viewer = new JRViewer(print);
            viewer.setBounds(0, 0, 970, 650);
            jPanel1.add(viewer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static <T> Object getReport(List dataList, Map parameters, JasperReport sourceFile, int type) {
        try {

            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

            System.out.println("" + beanColDataSource.getData());
            JasperPrint print = JasperFillManager.fillReport(sourceFile, parameters, beanColDataSource);

            String f;
            switch (type) {
                case 1: //JASPER_VIEWER
                    JRViewer viewer = new JRViewer(print);
                    viewer.setBounds(0, 0, 970, 650);
                    return viewer;
                case 2: //PDF
                    f = FileProcessing.createNewFile(
                            new FileNameExtensionFilter("PDF File", new String[]{"pdf", "jpg"}),
                            JFileChooser.FILES_ONLY).getAbsolutePath();
                    JasperExportManager.exportReportToPdfFile(print, f);
                    return f;
                case 3: // HTML
                    f = FileProcessing.createNewFile(
                            new FileNameExtensionFilter("HTML Page", new String[]{"html"}),
                            JFileChooser.FILES_ONLY).getAbsolutePath();
                    JasperExportManager.exportReportToHtmlFile(print, f);
                    return f;
                case 4: // IMAGE
                    f = FileProcessing.createNewDirectory();
                    return getImage(f, print);
                default:
                    return print;
            }
        } catch (JRException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 530));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 998, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public static String getImage(String dir, JasperPrint jasperPrint) {
        try {
            // if jpeg image stream
            jasperPrint.getPages().size();
            for (int pageIndex = 0; pageIndex < jasperPrint.getPages().size(); pageIndex++) {
                File f = new File(dir + "/page" + pageIndex + (1) + ".png");
                if (!f.exists()) {
                    f.createNewFile();
                }
                FileOutputStream out = new FileOutputStream(f);
                BufferedImage pageImage = new BufferedImage(jasperPrint.getPageWidth(), jasperPrint.getPageHeight(), BufferedImage.TYPE_INT_RGB);
                JRGraphics2DExporter exporter = new JRGraphics2DExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, pageImage.getGraphics());
                exporter.setParameter(JRExporterParameter.PAGE_INDEX, pageIndex);
                exporter.exportReport();
                ImageIO.write(pageImage, "png", out);
                out.close();
            }
            return dir;
        } catch (JRException | IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static BufferedImage getImageAsBufferedImage(JasperPrint jasperPrint) {

        try {
            jasperPrint.getPages().size();
            int pageIndex = 0;
            BufferedImage pageImage = new BufferedImage(jasperPrint.getPageWidth(), jasperPrint.getPageHeight(), BufferedImage.TYPE_INT_RGB);
            JRGraphics2DExporter exporter = new JRGraphics2DExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D, pageImage.getGraphics());
            exporter.setParameter(JRExporterParameter.PAGE_INDEX, pageIndex);
            exporter.exportReport();
            return pageImage;
        } catch (JRException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
