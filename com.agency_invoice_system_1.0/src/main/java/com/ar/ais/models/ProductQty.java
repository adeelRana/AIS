/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models;

/**
 *
 * @author Adi Rana
 */
public class ProductQty {

    private Double cartons;
    private Double pieces;
    private Double weight;
    private Double totalPieces;

    public ProductQty() {
    }

    /**
     *
     * @param piecesPerCarton
     * @param pieces
     * @param weight
     */
    public ProductQty(double piecesPerCarton, double pieces, double weight) {
        this.weight = weight;
        this.totalPieces = pieces;
        setCartonsAndPeices(piecesPerCarton, pieces);
    }

    public double getCartons() {
        return cartons;
    }

    public void setCartons(double cartons) {
        this.cartons = cartons;
    }

    public double getPieces() {
        return pieces;
    }

    public void setPieces(double pieces) {
        this.pieces = pieces;
    }

    public Double getTotalWeightInTons() {
        if (weight != 0 && (totalPieces != 0)) {
            return (weight * totalPieces) / 1000000;
        }
        return 0.0;
    }

    public Double getTotalWeightInKgs() {
        if (weight != 0 && (totalPieces != 0)) {
            return (weight * totalPieces) / 1000;
        }
        return 0.0;
    }

    public Double getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(Double totalPieces) {
        this.totalPieces = totalPieces;
    }

    public void createObjValuesByCartons(double piecesPerCarton, double cartons, double weight) {
        this.cartons = cartons;
        this.pieces = 0.0;
        this.weight = weight;
        this.totalPieces = piecesPerCarton * cartons;
    }

    private void setCartonsAndPeices(double pcsPerCarton, double pieces) {
        this.cartons = Math.floor(pieces / pcsPerCarton);
        this.pieces = pieces % pcsPerCarton;
    }

    @Override
    public String toString() {
        return cartons.intValue() + " Ctns" + (pieces > 0 ? " & " + pieces.intValue() + " Pcs" : "");
    }

}
