/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.reports;

import com.ar.ais.models.EntityBeans.Invoice;
import com.ar.ais.utililty.Frmttr;

/**
 *
 * @author Adeel rana
 */
public class SummaryInvoicesReport {

    private String invoiceNo;
    private String invoiceShop;
    private double qty;
    private double rtn;
    private double amount;

    public SummaryInvoicesReport(Invoice inv) {
        this.invoiceNo = inv.getInvoiceNo();
        this.invoiceShop = inv.getInvoiceShop().toString();
        this.qty = inv.getTotalQty();
        this.rtn = inv.getRtnQty();
        this.amount = inv.getTotalAmount();
    }

    public SummaryInvoicesReport() {

    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceShop() {
        return invoiceShop;
    }

    public void setInvoiceShop(String invoiceShop) {
        this.invoiceShop = invoiceShop;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getRtn() {
        return rtn;
    }

    public void setRtn(double rtn) {
        this.rtn = rtn;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
