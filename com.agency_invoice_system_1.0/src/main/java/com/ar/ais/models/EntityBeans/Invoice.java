/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.utililty.Calc;
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
@Table(name = "invoice", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id")
    , @NamedQuery(name = "Invoice.findByInvoiceNo", query = "SELECT i FROM Invoice i WHERE i.invoiceNo = :invoiceNo")
    , @NamedQuery(name = "Invoice.findByTotalQty", query = "SELECT i FROM Invoice i WHERE i.totalQty = :totalQty")
    , @NamedQuery(name = "Invoice.findByTotalAmount", query = "SELECT i FROM Invoice i WHERE i.totalAmount = :totalAmount")
    , @NamedQuery(name = "Invoice.findByCollection", query = "SELECT i FROM Invoice i WHERE i.collection = :collection")
    , @NamedQuery(name = "Invoice.findByCredit", query = "SELECT i FROM Invoice i WHERE i.credit = :credit")
    , @NamedQuery(name = "Invoice.findByStatus", query = "SELECT i FROM Invoice i WHERE i.status = :status")
    , @NamedQuery(name = "Invoice.findByRtn", query = "SELECT i FROM Invoice i WHERE i.rtn = :rtn")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "INVOICE_NO")
    private String invoiceNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TOTAL_QTY")
    private Double totalQty;
    @Basic(optional = false)
    @Column(name = "RTN_QTY")
    private Double rtnQty;
    @Basic(optional = false)
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @Basic(optional = false)
    @Column(name = "COLLECTION")
    private Double collection;
    @Basic(optional = false)
    @Column(name = "CREDIT")
    private Double credit;
    @Basic(optional = false)
    @Column(name = "INV_DISCOUNT")
    private Double invDiscount;
    @Basic(optional = false)
    @Column(name = "INV_DISCOUNT_TYPE")
    private String invDiscountType;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @Basic(optional = false)
    @Column(name = "RTN")
    private boolean rtn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detailInvoice")
    private List<InvoiceDetail> invoiceDetailList;
    @JoinColumn(name = "INVOICE_SHOP", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Shop invoiceShop;
    @JoinColumn(name = "INVOICE_SUMMARY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Summary invoiceSummary;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }

    public Invoice(Long id, String invoiceNo, Double totalQty, Double totalAmount, Double collection, Double credit, short status, boolean rtn) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.totalQty = totalQty;
        this.totalAmount = totalAmount;
        this.collection = collection;
        this.credit = credit;
        this.status = status;
        this.rtn = rtn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Double getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Double totalQty) {
        this.totalQty = totalQty;
    }

    public Double getRtnQty() {
        return rtnQty;
    }

    public void setRtnQty(Double rtnQty) {
        this.rtnQty = rtnQty;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getCollection() {
        return collection;
    }

    public void setCollection(Double collection) {
        this.collection = collection;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getInvDiscount() {
        return invDiscount;
    }

    public void setInvDiscount(Double invDiscount) {
        this.invDiscount = invDiscount;
    }

    public String getInvDiscountType() {
        return invDiscountType;
    }

    public void setInvDiscountType(String invDiscountType) {
        this.invDiscountType = invDiscountType;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public boolean hasReturn() {
        return rtn;
    }

    public void setReturn(boolean rtn) {
        this.rtn = rtn;
    }

    @XmlTransient
    public List<InvoiceDetail> getInvoiceDetailList() {
        if (null == invoiceDetailList) {
            invoiceDetailList = new ArrayList<>();
        }
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    public Shop getInvoiceShop() {
        return invoiceShop;
    }

    public void setInvoiceShop(Shop invoiceShop) {
        this.invoiceShop = invoiceShop;
    }

    public Summary getInvoiceSummary() {
        return invoiceSummary;
    }

    public void setInvoiceSummary(Summary invoiceSummary) {
        this.invoiceSummary = invoiceSummary;
    }

    public void calculate() {
        this.totalQty = 0d;
        this.rtnQty = 0d;
        this.totalAmount = 0d;

        double detailQty;
        double detailRtn;
        for (InvoiceDetail dt : getInvoiceDetailList()) {
            detailQty = dt.getDetailProduct().getProductQtyObjectFromPieces(dt.getQty()).getCartons();
            detailRtn = dt.getDetailProduct().getProductQtyObjectFromPieces(dt.getReturnQty()).getCartons();

            totalQty += detailQty;
            rtnQty += detailRtn;
            totalAmount += dt.getPrice() * (detailQty - detailRtn);
        }

        this.totalAmount = Calc.lessDiscount(this.totalAmount, this.getInvoiceShop());

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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getInvoiceShop().getName();
    }

}
