/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.models.ProductQty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "stock_detail", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockDetail.findAll", query = "SELECT s FROM StockDetail s")
    , @NamedQuery(name = "StockDetail.findById", query = "SELECT s FROM StockDetail s WHERE s.id = :id")
    , @NamedQuery(name = "StockDetail.findByQty", query = "SELECT s FROM StockDetail s WHERE s.qty = :qty")
    , @NamedQuery(name = "StockDetail.findByPurchasePrice", query = "SELECT s FROM StockDetail s WHERE s.purchasePrice = :purchasePrice")})
public class StockDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "QTY")
    private double qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PURCHASE_PRICE")
    private Double purchasePrice;
    @JoinColumn(name = "STOCK", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Stock stock;
    @JoinColumn(name = "STOCK_PRODUCT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Products stockProduct;
    @Transient
    private ProductQty detailQty;

    public StockDetail() {
    }

    public StockDetail(Long id) {
        this.id = id;
    }

    public StockDetail(Long id, double qty, Double purchasePrice) {
        this.id = id;
        this.qty = qty;
        this.purchasePrice = purchasePrice;
    }

    public StockDetail(Products stockProduct) {
        this.stockProduct = stockProduct;
        this.qty = 0d;
        this.purchasePrice = stockProduct.getPurchasePrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Products getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(Products stockProduct) {
        this.stockProduct = stockProduct;
    }

    public ProductQty getDetailQty() {
        if (detailQty == null) {
            this.detailQty = new ProductQty(this.stockProduct.getPiecesPerCtn(), this.stockProduct.getCurrentQty(), this.stockProduct.getWeight());
        }
        return detailQty;
    }

    public void setDetailQty(ProductQty detailQty) {
        this.detailQty = detailQty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockDetail)) {
            return false;
        }
        StockDetail other = (StockDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.stockProduct + "";
    }

}
