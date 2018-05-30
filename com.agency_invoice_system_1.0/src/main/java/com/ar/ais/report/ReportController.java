/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.report;

import com.ar.ais.models.EntityBeans.Products;
import com.ar.ais.models.EntityBeans.Summary;
import com.ar.ais.models.EntityBeans.WorkingSchedule;
import com.ar.ais.models.reports.InvoiceReportView;
import com.ar.ais.models.reports.ProductsEditReportVIew;
import com.ar.ais.models.reports.SummaryInvoicesReport;
import com.ar.ais.models.reports.WSreportVies;
import static com.ar.ais.report.Reports.getReportMap;
import com.ar.ais.utililty.Global;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Adi Rana
 */
public class ReportController {

    public static void createPurchaseInvoice(Summary s) {

        try {
            JasperReport studentResultSubReportDatail
                    = JasperCompileManager.compileReport(JRXmlLoader.load(ReportController.class.getResourceAsStream(ReportConstants.INVOICE_SUB_REPORT_PATH)));
            ArrayList<InvoiceReportView> invoiceReportData = Reports.getInvoicesReportData(s);
            HashMap hm1 = getReportMap();
            hm1.put("SUB_REPORT_DIR", ReportConstants.INVOICE_SUB_REPORT_PATH);
            hm1.put("SUB_REPORT", studentResultSubReportDatail);

            Reports.showReport(invoiceReportData, hm1, ReportConstants.INVOICE_REPORT_PATH);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

    public static void createSummaryReport(Summary s) {

        ArrayList<SummaryInvoicesReport> invoiceReportData = Reports.getSummaryInvoicesReportData(s);
        HashMap hm1 = getReportMap();
        hm1.put("ROUTE", s.getSummaryRoute().toString());
        hm1.put("BOOKER", s.getSummaryBooker().toString());
        hm1.put("DATE", Global.DATE_UTIL.getStingDateFromLongValue(s.getWSchedule().getDate()));
        hm1.put("SUMMARY", s.toString());

        Reports.showReport(invoiceReportData, hm1, ReportConstants.SUMMARY_REPORT_PATH);

    }

    public static void createDateWiseSummaryReport(List<WorkingSchedule> li) {

        ArrayList<WSreportVies> invoiceReportData = Reports.getDailySummariesReportData(li);
        HashMap hm1 = getReportMap();
        hm1.put("DATE", (Global.DATE_UTIL.getStingDateFromLongValue(li.get(0).getDate())) + " - " + Global.DATE_UTIL.getStingDateFromLongValue(li.get(li.size() - 1).getDate()));
        hm1.put("COMPANY", ReportConstants.TRADER_NAME);

        Reports.showReport(invoiceReportData, hm1, ReportConstants.DAY_WISE_SUMMARY_REPORT_PATH);

    }

    public static void createProductsEditReport(List<Products> li, boolean flag) {

        ArrayList<ProductsEditReportVIew> invoiceReportData = Reports.getProductEditReportData(li);
        HashMap hm1 = getReportMap();
        hm1.put("DATE", Global.DATE_UTIL.getNewDate());
        hm1.put("COMPANY", ReportConstants.TRADER_NAME);
        if (flag) {
            Reports.showReport(invoiceReportData, hm1, ReportConstants.PRODUCT_EDIT_REPORT_PATH);
        } else {
            Reports.showReport(invoiceReportData, hm1, ReportConstants.PRODUCT_RATE_REPORT_PATH);
        }

    }
}
