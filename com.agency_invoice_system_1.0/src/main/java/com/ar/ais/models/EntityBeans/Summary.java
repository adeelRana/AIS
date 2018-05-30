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
@Table(name = "summary", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Summary.findAll", query = "SELECT s FROM Summary s")
    , @NamedQuery(name = "Summary.findById", query = "SELECT s FROM Summary s WHERE s.id = :id")
    , @NamedQuery(name = "Summary.findByQty", query = "SELECT s FROM Summary s WHERE s.qty = :qty")
    , @NamedQuery(name = "Summary.findByAmount", query = "SELECT s FROM Summary s WHERE s.amount = :amount")
    , @NamedQuery(name = "Summary.findByCash", query = "SELECT s FROM Summary s WHERE s.cash = :cash")
    , @NamedQuery(name = "Summary.findByCredit", query = "SELECT s FROM Summary s WHERE s.credit = :credit")
    , @NamedQuery(name = "Summary.findByBalance", query = "SELECT s FROM Summary s WHERE s.balance = :balance")
    , @NamedQuery(name = "Summary.findByStatus", query = "SELECT s FROM Summary s WHERE s.status = :status")})
public class Summary implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "QTY")
    private Double qty;
    @Basic(optional = false)
    @Column(name = "RTN")
    private Double rtn;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private Double amount;
    @Basic(optional = false)
    @Column(name = "CASH")
    private Double cash;
    @Basic(optional = false)
    @Column(name = "CREDIT")
    private Double credit;
    @Basic(optional = false)
    @Column(name = "BALANCE")
    private Double balance;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "W_SCHEDULE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private WorkingSchedule wSchedule;
    @JoinColumn(name = "SUMMARY_BOOKER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Booker summaryBooker;
    @JoinColumn(name = "SUMMARY_ROUTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Route summaryRoute;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceSummary")
    private List<Invoice> invoiceList;

    public Summary() {
    }

    public Summary(Long id) {
        this.id = id;
    }

    public Summary(Booker summaryBooker, Route summaryRoute) {
        this.qty = 0d;
        this.rtn = 0d;
        this.amount = 0d;
        this.cash = 0d;
        this.credit = 0d;
        this.balance = 0d;
        this.status = 1;
        this.summaryBooker = summaryBooker;
        this.summaryRoute = summaryRoute;
    }

    public Summary(Long id, double amount, double cash, double credit, double balance, short status) {
        this.id = id;
        this.amount = amount;
        this.cash = cash;
        this.credit = credit;
        this.balance = balance;
        this.status = status;
        calculate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getRtn() {
        return rtn;
    }

    public void setRtn(Double rtn) {
        this.rtn = rtn;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public WorkingSchedule getWSchedule() {
        return wSchedule;
    }

    public void setWSchedule(WorkingSchedule wSchedule) {
        this.wSchedule = wSchedule;
    }

    public Booker getSummaryBooker() {
        return summaryBooker;
    }

    public void setSummaryBooker(Booker summaryBooker) {
        this.summaryBooker = summaryBooker;
    }

    public Route getSummaryRoute() {
        return summaryRoute;
    }

    public void setSummaryRoute(Route summaryRoute) {
        this.summaryRoute = summaryRoute;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        if (null == invoiceList) {
            invoiceList = new ArrayList<>();
        }
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public final void calculate() {
        double totalQty = 0;
        double totalRtn = 0;
        double totalAmount = 0;
        double cr = 0;
        for (Invoice i : getInvoiceList()) {
            cr += i.getCredit();
            totalQty += i.getTotalQty();
            totalRtn += i.getRtnQty();
            totalAmount += i.getTotalAmount();
        }
        this.qty = totalQty;
        this.rtn = totalRtn;
        this.amount = totalAmount;
        this.credit = cr;
        this.balance = this.amount - this.credit - this.cash;
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
        if (!(object instanceof Summary)) {
            return false;
        }
        Summary other = (Summary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Summary-" + id;
    }

}
