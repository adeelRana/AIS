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
@Table(name = "transactions", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id")
    , @NamedQuery(name = "Transactions.findByTranPartyId", query = "SELECT t FROM Transactions t WHERE t.tranPartyId = :tranPartyId")
    , @NamedQuery(name = "Transactions.findByTranAccount", query = "SELECT t FROM Transactions t WHERE t.tranAccount = :tranAccount")
    , @NamedQuery(name = "Transactions.findByTranType", query = "SELECT t FROM Transactions t WHERE t.tranType = :tranType")
    , @NamedQuery(name = "Transactions.findByTranAmount", query = "SELECT t FROM Transactions t WHERE t.tranAmount = :tranAmount")
    , @NamedQuery(name = "Transactions.findByStatus", query = "SELECT t FROM Transactions t WHERE t.status = :status")
    , @NamedQuery(name = "Transactions.findByRemarks", query = "SELECT t FROM Transactions t WHERE t.remarks = :remarks")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "TRAN_PARTY_ID")
    private long tranPartyId;
    @Column(name = "TRAN_ACCOUNT")
    private Long tranAccount;
    @Basic(optional = false)
    @Column(name = "TRAN_TYPE")
    private int tranType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TRAN_AMOUNT")
    private Double tranAmount;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @Basic(optional = false)
    @Column(name = "REMARKS")
    private String remarks;

    public Transactions() {
    }

    public Transactions(Long id) {
        this.id = id;
    }

    public Transactions(long tranPartyId, int tranType, Double tranAmount) {
        this.tranPartyId = tranPartyId;
        this.tranType = tranType;
        this.tranAmount = tranAmount;
        this.tranAccount = 0l;
        this.status = 1;
        this.remarks = "";
    }

    public Transactions(Long id, long tranPartyId, int tranType, Double tranAmount, short status, String remarks) {
        this.id = id;
        this.tranPartyId = tranPartyId;
        this.tranType = tranType;
        this.tranAmount = tranAmount;
        this.status = status;
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTranPartyId() {
        return tranPartyId;
    }

    public void setTranPartyId(long tranPartyId) {
        this.tranPartyId = tranPartyId;
    }

    public Long getTranAccount() {
        return tranAccount;
    }

    public void setTranAccount(Long tranAccount) {
        this.tranAccount = tranAccount;
    }

    public int getTranType() {
        return tranType;
    }

    public void setTranType(int tranType) {
        this.tranType = tranType;
    }

    public Double getTranAmount() {
        return tranAmount;
    }

    public void setTranAmount(Double tranAmount) {
        this.tranAmount = tranAmount;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ar.ais.models.EntityBeans.Transactions[ id=" + id + " ]";
    }

}
