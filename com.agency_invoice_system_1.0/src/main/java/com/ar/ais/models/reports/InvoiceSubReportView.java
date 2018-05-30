/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.reports;

import com.ar.ais.models.EntityBeans.InvoiceDetail;
import com.ar.ais.utililty.Frmttr;

/**
 *
 * @author Adi Rana
 */
public class InvoiceSubReportView {

    private String pCode;
    private String pName;
    private String pFlavor;
    private int pWeight;
    private int pSale;
    private Double pRetun;
    private Double pPrice;

    public InvoiceSubReportView() {
    }

    public InvoiceSubReportView(InvoiceDetail i) {
        this.pCode = i.getDetailProduct().getCode();
        this.pName = i.getDetailProduct().getName();
        this.pFlavor = i.getDetailProduct().getFlavour();
        this.pWeight = Frmttr.getIntFromDouble(i.getDetailProduct().getWeight());
        this.pSale = Frmttr.getIntFromDouble(i.getDetailProduct().getProductQtyObjectFromPieces(i.getQty()).getCartons());
        this.pRetun = i.getDetailProduct().getProductQtyObjectFromPieces(i.getReturnQty()).getCartons();
        this.pPrice = i.getPrice();
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpSale() {
        return pSale;
    }

    public void setpSale(int pSale) {
        this.pSale = pSale;
    }

  

    public Double getpRetun() {
        return pRetun;
    }

    public void setpRetun(Double pRetun) {
        this.pRetun = pRetun;
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpFlavor() {
        return pFlavor;
    }

    public void setpFlavor(String pFlavor) {
        this.pFlavor = pFlavor;
    }

    public int getpWeight() {
        return pWeight;
    }

    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

}
