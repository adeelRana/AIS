/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "invoice_detail", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceDetail.findAll", query = "SELECT i FROM InvoiceDetail i")
    , @NamedQuery(name = "InvoiceDetail.findById", query = "SELECT i FROM InvoiceDetail i WHERE i.id = :id")
    , @NamedQuery(name = "InvoiceDetail.findByDayId", query = "SELECT i FROM InvoiceDetail i WHERE i.dayId = :dayId")
    , @NamedQuery(name = "InvoiceDetail.findByQty", query = "SELECT i FROM InvoiceDetail i WHERE i.qty = :qty")
    , @NamedQuery(name = "InvoiceDetail.findByReturnQty", query = "SELECT i FROM InvoiceDetail i WHERE i.returnQty = :returnQty")
    , @NamedQuery(name = "InvoiceDetail.findByPrice", query = "SELECT i FROM InvoiceDetail i WHERE i.price = :price")
    , @NamedQuery(name = "InvoiceDetail.findByStatus", query = "SELECT i FROM InvoiceDetail i WHERE i.status = :status")})
public class InvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DAY_ID")
    private long dayId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QTY")
    private double qty;
    @Basic(optional = false)
    @Column(name = "RETURN_QTY")
    private double returnQty;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "DETAIL_INVOICE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Invoice detailInvoice;
    @JoinColumn(name = "DETAIL_PRODUCT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Products detailProduct;

    public InvoiceDetail() {
    }

    public InvoiceDetail(Long id) {
        this.id = id;
    }

    public InvoiceDetail(Products p, long wsId) {
        this.dayId = wsId;
        this.qty = 0;
        this.price = p.getSalePrice();
        this.status = 1;
        this.detailProduct = p;
    }

    public InvoiceDetail(Long id, long dayId, double qty, double returnQty, double price, short status) {
        this.id = id;
        this.dayId = dayId;
        this.qty = qty;
        this.returnQty = returnQty;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDayId() {
        return dayId;
    }

    public void setDayId(long dayId) {
        this.dayId = dayId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(double returnQty) {
        this.returnQty = returnQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Invoice getDetailInvoice() {
        return detailInvoice;
    }

    public void setDetailInvoice(Invoice detailInvoice) {
        this.detailInvoice = detailInvoice;
    }

    public Products getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(Products detailProduct) {
        this.detailProduct = detailProduct;
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
        if (!(object instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.detailProduct + "";
    }

}
