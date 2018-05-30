/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.utililty.DateUtility;
import com.ar.ais.utililty.Global;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "booker", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booker.findAll", query = "SELECT b FROM Booker b")
    , @NamedQuery(name = "Booker.findById", query = "SELECT b FROM Booker b WHERE b.id = :id")
    , @NamedQuery(name = "Booker.findByName", query = "SELECT b FROM Booker b WHERE b.name = :name")
    , @NamedQuery(name = "Booker.findByOpeningDate", query = "SELECT b FROM Booker b WHERE b.openingDate = :openingDate")
    , @NamedQuery(name = "Booker.findByStatus", query = "SELECT b FROM Booker b WHERE b.status = :status")})
public class Booker implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Column(name = "OPENING_CR")
    private Double openingCr;
    @Basic(optional = false)
    @Column(name = "CURRENT_CR")
    private Double currentCr;
    @Basic(optional = false)
    @Column(name = "OPENING_DATE")
    private long openingDate;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "summaryBooker")
    private List<Summary> summaryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopBooker")
    private List<Shop> shopList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routeBooker")
    private List<Route> routeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crBooker")
    private List<BookerCr> bookerCrList;

    public Booker() {
    }

    public Booker(Long id) {
        this.id = id;
    }

    public Booker(String name, Double opening) {
        this.name = name;
        this.openingCr = opening;
        this.currentCr = opening;
        this.openingDate = Global.DATE_UTIL.getNewDate().getTime();
        this.status = 1;
    }

    public Booker(String name, Double openingCr, Double currentCr, long openingDate, short status) {
        this.name = name;
        this.openingCr = openingCr;
        this.currentCr = currentCr;
        this.openingDate = openingDate;
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

    public long getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(long openingDate) {
        this.openingDate = openingDate;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @XmlTransient
    public List<Summary> getSummaryList() {

        if (null == summaryList) {
            summaryList = new ArrayList<>();
        }
        return summaryList;
    }

    public void setSummaryList(List<Summary> summaryList) {
        this.summaryList = summaryList;
    }

    @XmlTransient
    public List<Shop> getShopList() {
        if (null == shopList) {
            shopList = new ArrayList<>();
        }
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    @XmlTransient
    public List<Route> getRouteList() {
        if (null == routeList) {
            routeList = new ArrayList<>();
        }
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    @XmlTransient
    public List<BookerCr> getBookerCrList() {
        if (null == bookerCrList) {
            bookerCrList = new ArrayList<>();
        }
        return bookerCrList;
    }

    public void setBookerCrList(List<BookerCr> bookerCrList) {
        this.bookerCrList = bookerCrList;
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
        if (!(object instanceof Booker)) {
            return false;
        }
        Booker other = (Booker) object;
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
