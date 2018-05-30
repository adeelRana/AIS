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
@Table(name = "route", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
    , @NamedQuery(name = "Route.findById", query = "SELECT r FROM Route r WHERE r.id = :id")
    , @NamedQuery(name = "Route.findByName", query = "SELECT r FROM Route r WHERE r.name = :name")
    , @NamedQuery(name = "Route.findByWeekDay", query = "SELECT r FROM Route r WHERE r.weekDay = :weekDay")
    , @NamedQuery(name = "Route.findByStatus", query = "SELECT r FROM Route r WHERE r.status = :status")})
public class Route implements Serializable {

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
    @Column(name = "WEEK_DAY")
    private String weekDay;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "summaryRoute")
    private List<Summary> summaryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopRoute")
    private List<Shop> shopList;
    @JoinColumn(name = "ROUTE_BOOKER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Booker routeBooker;

    public Route() {
    }

    public Route(Long id) {
        this.id = id;
    }

    public Route(Long id, String name, String weekDay, short status) {
        this.id = id;
        this.name = name;
        this.weekDay = weekDay;
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

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
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

    public Booker getRouteBooker() {
        return routeBooker;
    }

    public void setRouteBooker(Booker routeBooker) {
        this.routeBooker = routeBooker;
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
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " (" + this.weekDay + ")";
    }

}
