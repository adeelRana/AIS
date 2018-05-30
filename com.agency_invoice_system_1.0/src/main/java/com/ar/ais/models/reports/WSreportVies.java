/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.reports;

import com.ar.ais.models.EntityBeans.Summary;

/**
 *
 * @author Adeel rana
 */
public class WSreportVies {

    private String date;
    private String summary;
    private String booker;
    private double qty;
    private double rtn;
    private double amount;

    public WSreportVies(Summary s, String date) {
        this.date = date;
        this.summary = s.toString();
        this.booker = s.getSummaryBooker().toString();
        this.qty = s.getQty();
        this.rtn = s.getRtn();
        this.amount = s.getAmount();
    }

    public WSreportVies() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
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
