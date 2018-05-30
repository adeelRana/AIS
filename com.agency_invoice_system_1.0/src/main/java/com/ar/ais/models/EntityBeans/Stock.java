/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "stock", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s WHERE s.stockType <> 'OPENING'")
    , @NamedQuery(name = "Stock.findById", query = "SELECT s FROM Stock s WHERE s.id = :id")
    , @NamedQuery(name = "Stock.findByInvoiceNo", query = "SELECT s FROM Stock s WHERE s.invoiceNo = :invoiceNo")
    , @NamedQuery(name = "Stock.findByDate", query = "SELECT s FROM Stock s WHERE s.date = :date")
    , @NamedQuery(name = "Stock.findByTotalQty", query = "SELECT s FROM Stock s WHERE s.totalQty = :totalQty")
    , @NamedQuery(name = "Stock.findByTotalAmount", query = "SELECT s FROM Stock s WHERE s.totalAmount = :totalAmount")
    , @NamedQuery(name = "Stock.findByPaid", query = "SELECT s FROM Stock s WHERE s.paid = :paid")
    , @NamedQuery(name = "Stock.findByPayable", query = "SELECT s FROM Stock s WHERE s.payable = :payable")
    , @NamedQuery(name = "Stock.findByStockType", query = "SELECT s FROM Stock s WHERE s.stockType = :stockType")
    , @NamedQuery(name = "Stock.findByTimeIn", query = "SELECT s FROM Stock s WHERE s.timeIn = :timeIn")
    , @NamedQuery(name = "Stock.findByStatus", query = "SELECT s FROM Stock s WHERE s.status = :status")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "INVOICE_NO")
    private long invoiceNo;
    @Basic(optional = false)
    @Column(name = "DATE")
    private long date;
    @Basic(optional = false)
    @Column(name = "TOTAL_QTY")
    private double totalQty;
    @Basic(optional = false)
    @Column(name = "TOTAL_AMOUNT")
    private double totalAmount;
    @Basic(optional = false)
    @Column(name = "PAID")
    private double paid;
    @Basic(optional = false)
    @Column(name = "PAYABLE")
    private double payable;
    @Basic(optional = false)
    @Column(name = "STOCK_TYPE")
    private String stockType;
    @Basic(optional = false)
    @Column(name = "TIME_IN")
    private String timeIn;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "STOCK_COMPANY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Company stockCompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<StockDetail> stockDetailList;

    public Stock() {
    }

    public Stock(Long id) {
        this.id = id;
    }

    public Stock(Long id, long invoiceNo, long date, double totalQty, double totalAmount, double paid, double payable, String stockType, String timeIn, short status) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.totalQty = totalQty;
        this.totalAmount = totalAmount;
        this.paid = paid;
        this.payable = payable;
        this.stockType = stockType;
        this.timeIn = timeIn;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(double totalQty) {
        this.totalQty = totalQty;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getPayable() {
        return payable;
    }

    public void setPayable(double payable) {
        this.payable = payable;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Company getStockCompany() {
        return stockCompany;
    }

    public void setStockCompany(Company stockCompany) {
        this.stockCompany = stockCompany;
    }

    @XmlTransient
    public List<StockDetail> getStockDetailList() {
        if (null == stockDetailList) {
            stockDetailList = new ArrayList<>();
        }
        return stockDetailList;
    }

    public void setStockDetailList(List<StockDetail> stockDetailList) {
        this.stockDetailList = stockDetailList;
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
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.stockCompany.getName();
    }

}
