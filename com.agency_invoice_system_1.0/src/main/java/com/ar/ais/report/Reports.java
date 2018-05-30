/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.report;

import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Summary;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.reports.InvoiceReportView;
import com.ar.ais.models.reports.ProductsEditReportVIew;
import com.ar.ais.models.reports.SummaryInvoicesReport;
import com.ar.ais.models.reports.WSreportVies;
import com.ar.ais.utililty.Global;
import com.ar.ais.views.dialogs.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Adeel rana
 */
class Reports {

    public static HashMap getReportMap() {

        HashMap hm = new HashMap();
        hm.put("COMPANY_NAME", ReportConstants.COMPANY_NAME);
        hm.put("DISTRIBUTOR_NAME", ReportConstants.DBT_NAME);
        hm.put("DISTRIBUTOR_PHN", ReportConstants.DBT_PHN);

        return hm;
    }

    public static ArrayList<InvoiceReportView> getInvoicesReportData(Summary s) {
        ArrayList<InvoiceReportView> reportDataList = new ArrayList<>();
        InvoiceReportView irv;

        for (Invoice i : s.getInvoiceList()) {
            irv = new InvoiceReportView(i);
            reportDataList.add(irv);
        }
        return reportDataList;
    }

    public static ArrayList<SummaryInvoicesReport> getSummaryInvoicesReportData(Summary s) {

        ArrayList<SummaryInvoicesReport> reportDataList = new ArrayList<>();
        SummaryInvoicesReport irv;

        for (Invoice i : s.getInvoiceList()) {
            irv = new SummaryInvoicesReport(i);
            reportDataList.add(irv);
        }

        return reportDataList;
    }

    public static ArrayList<WSreportVies> getDailySummariesReportData(List<WorkingSchedule> li) {

        ArrayList<WSreportVies> reportDataList = new ArrayList<>();
        WSreportVies irv;

        for (WorkingSchedule ws : li) {
            for (Summary s : ws.getSummaryList()) {
                irv = new WSreportVies(s, Global.DATE_UTIL.getStingDateFromLongValue(ws.getDate()));
                reportDataList.add(irv);
            }
        }
        return reportDataList;
    }

    public static ArrayList<ProductsEditReportVIew> getProductEditReportData(List<Products> li) {

        ArrayList<ProductsEditReportVIew> reportDataList = new ArrayList<>();
        ProductsEditReportVIew irv;

        for (Products p : li) {

            irv = new ProductsEditReportVIew(p);
            reportDataList.add(irv);
        }
        return reportDataList;
    }

    public static void showReport(List reportData, Map map, String reportPath) {
        try {
            JasperDesign jasperDesign;
            jasperDesign
                    = JRXmlLoader.load(Reports.class
                            .getResourceAsStream(reportPath));
//            JasperDesign jasperDesign = 
//                    JRXmlLoader.load(Reports.class.getResourceAsStream("/reports/invoice_header.jrxml"));
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Object[] possibilities = {"APPLICATION VIEWER", "PDF", "IMAGE"};

            String s = (String) JOptionPane.showInputDialog(null, "Report Print Type", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, possibilities, "APPLICATION VIEWER");
            if ((s != null) && (s.length() > 0)) {
                if (s.equalsIgnoreCase("PDF")) {
                    ReportDialog.getReport(reportData, map, jasperReport, 2);
                } else if (s.equalsIgnoreCase("IMAGE")) {
                    ReportDialog.getReport(reportData, map, jasperReport, 3);
                } else if (s.equalsIgnoreCase("HTML")) {
                    ReportDialog.getReport(reportData, map, jasperReport, 4);
                } else if (s.equalsIgnoreCase("APPLICATION VIEWER")) {
                    JRViewer viewer = (JRViewer) ReportDialog.getReport(reportData, map, jasperReport, 1);

                    new ReportDialog(Global.getMainFrame(), true, viewer).setVisible(true);
                }
            }
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

}
