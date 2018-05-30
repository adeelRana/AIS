/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.reports;

import com.ar.ais.models.EntityBeans.Products;

/**
 *
 * @author Adeel rana
 */
public class ProductsEditReportVIew {

    private String name;
    private String flavor;
    private double weight;
    private double pieces;
    private double price;
    private double rate;
    private double current;

    public ProductsEditReportVIew(Products p) {
        this.name = p.getName();
        this.flavor = p.getFlavour();
        this.weight = p.getWeight();
        this.pieces = p.getPiecesPerCtn();
        this.price = p.getSalePrice();
        this.current = p.getCurrentQty();
        this.rate = p.getPiecePrice();

    }

    public ProductsEditReportVIew(String name, String flavor, double weight, double pieces, double rate, double price) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    
}
