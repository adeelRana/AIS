/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.utililty.Global;
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
@Table(name = "company", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c")
    , @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.id = :id")
    , @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name")
    , @NamedQuery(name = "Company.findByOpeningDate", query = "SELECT c FROM Company c WHERE c.openingDate = :openingDate")
    , @NamedQuery(name = "Company.findByOpeningCr", query = "SELECT c FROM Company c WHERE c.openingCr = :openingCr")
    , @NamedQuery(name = "Company.findByCurrentCr", query = "SELECT c FROM Company c WHERE c.currentCr = :currentCr")
    , @NamedQuery(name = "Company.findByStatus", query = "SELECT c FROM Company c WHERE c.status = :status")})
public class Company implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "OPENING_CR")
    private Double openingCr;
    @Basic(optional = false)
    @Column(name = "CURRENT_CR")
    private Double currentCr;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "OPENING_DATE")
    private long openingDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCompany")
    private List<Products> productsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockCompany")
    private List<Stock> stockList;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
        this.openingDate = Global.DATE_UTIL.getNewDate().getTime();
        this.openingCr = 0d;
        this.currentCr = 0d;
        this.status = 1;
    }

    public Company(Long id) {
        this.id = id;
    }

    public Company(Long id, String name, long openingDate, Double openingCr, Double currentCr, short status) {
        this.id = id;
        this.name = name;
        this.openingDate = openingDate;
        this.openingCr = openingCr;
        this.currentCr = currentCr;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(long openingDate) {
        this.openingDate = openingDate;
    }

    public Double getOpeningCr() {
        return openingCr;
    }

    public void setOpeningCr(Double openingCr) {
        this.openingCr = openingCr;
    }

    public Double getCurrentCr() {
        return currentCr;
    }

    public void setCurrentCr(Double currentCr) {
        this.currentCr = currentCr;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<Products> getProductsList() {
        if (null == productsList) {
            productsList = new ArrayList<>();
        }
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        if (null == stockList) {
            stockList = new ArrayList<>();
        }
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
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
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
