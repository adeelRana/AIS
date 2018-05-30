/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.reports;

import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.models.EntityBeans.InvoiceDetail;
import com.ar.ais.utililty.Global;
import java.util.ArrayList;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Adeel rana
 */
public class InvoiceReportView {

    private String date;
    private String customerName;
    private String customerRoute;
    private Double total;
    private Double discount;

    private JRBeanCollectionDataSource detailReportData;

    public InvoiceReportView(Invoice inv) {
        this.date = Global.DATE_UTIL.getStingDateFromLongValue(inv.getInvoiceSummary().getWSchedule().getDate());
        this.customerName = inv.getInvoiceShop().getName();
        this.customerRoute = inv.getInvoiceShop().getShopRoute().getName();
        this.total = inv.getTotalAmount();
        this.discount = inv.getInvDiscount();
        setSubReportData(inv);
    }

    public InvoiceReportView() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerRoute() {
        return customerRoute;
    }

    public void setCustomerRoute(String customerRoute) {
        this.customerRoute = customerRoute;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public JRBeanCollectionDataSource getDetailReportData() {
        return detailReportData;
    }

    public void setDetailReportData(ArrayList<InvoiceSubReportView> detailReportData) {
        this.detailReportData = new JRBeanCollectionDataSource(detailReportData);
    }

    private void setSubReportData(Invoice inv) {
        InvoiceSubReportView dtView;
        ArrayList<InvoiceSubReportView> detailList = new ArrayList<>();

        for (InvoiceDetail dt : inv.getInvoiceDetailList()) {
            dtView = new InvoiceSubReportView(dt);
            detailList.add(dtView);
        }

        detailReportData = new JRBeanCollectionDataSource(detailList);
    }

}
