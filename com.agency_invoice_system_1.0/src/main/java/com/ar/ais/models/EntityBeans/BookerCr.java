/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "booker_cr", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookerCr.findAll", query = "SELECT b FROM BookerCr b")
    , @NamedQuery(name = "BookerCr.findById", query = "SELECT b FROM BookerCr b WHERE b.id = :id")
    , @NamedQuery(name = "BookerCr.findByCrType", query = "SELECT b FROM BookerCr b WHERE b.crType = :crType")
    , @NamedQuery(name = "BookerCr.findByCrInvoice", query = "SELECT b FROM BookerCr b WHERE b.crInvoice = :crInvoice")
    , @NamedQuery(name = "BookerCr.findByCrAmount", query = "SELECT b FROM BookerCr b WHERE b.crAmount = :crAmount")
    , @NamedQuery(name = "BookerCr.findByCrPiad", query = "SELECT b FROM BookerCr b WHERE b.crPiad = :crPiad")
    , @NamedQuery(name = "BookerCr.findByCrStatus", query = "SELECT b FROM BookerCr b WHERE b.crStatus = :crStatus")})
public class BookerCr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CR_DATE")
    private long crDate;
    @Basic(optional = false)
    @Column(name = "CR_TYPE")
    private short crType;
    @Basic(optional = false)
    @Column(name = "CR_INVOICE")
    private long crInvoice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CR_AMOUNT")
    private Double crAmount;
    @Basic(optional = false)
    @Column(name = "CR_PIAD")
    private Double crPiad;
    @Basic(optional = false)
    @Column(name = "CR_STATUS")
    private short crStatus;
    @Basic(optional = false)
    @Lob
    @Column(name = "CR_REMARKS")
    private String crRemarks;
    @JoinColumn(name = "CR_BOOKER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Booker crBooker;

    public BookerCr() {
    }

    public BookerCr(Long id) {
        this.id = id;
    }

    public BookerCr(Long id, short crType, long crInvoice, Double crAmount, Double crPiad, short crStatus, String crRemarks) {
        this.id = id;
        this.crType = crType;
        this.crInvoice = crInvoice;
        this.crAmount = crAmount;
        this.crPiad = crPiad;
        this.crStatus = crStatus;
        this.crRemarks = crRemarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCrDate() {
        return crDate;
    }

    public void setCrDate(long crDate) {
        this.crDate = crDate;
    }

    public short getCrType() {
        return crType;
    }

    public void setCrType(short crType) {
        this.crType = crType;
    }

    public long getCrInvoice() {
        return crInvoice;
    }

    public void setCrInvoice(long crInvoice) {
        this.crInvoice = crInvoice;
    }

    public Double getCrAmount() {
        return crAmount;
    }

    public void setCrAmount(Double crAmount) {
        this.crAmount = crAmount;
    }

    public Double getCrPiad() {
        return crPiad;
    }

    public void setCrPiad(Double crPiad) {
        this.crPiad = crPiad;
    }

    public short getCrStatus() {
        return crStatus;
    }

    public void setCrStatus(short crStatus) {
        this.crStatus = crStatus;
    }

    public String getCrRemarks() {
        return crRemarks;
    }

    public void setCrRemarks(String crRemarks) {
        this.crRemarks = crRemarks;
    }

    public Booker getCrBooker() {
        return crBooker;
    }

    public void setCrBooker(Booker crBooker) {
        this.crBooker = crBooker;
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
        if (!(object instanceof BookerCr)) {
            return false;
        }
        BookerCr other = (BookerCr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ar.ais.models.EntityBeans.BookerCr[ id=" + id + " ]";
    }

}
