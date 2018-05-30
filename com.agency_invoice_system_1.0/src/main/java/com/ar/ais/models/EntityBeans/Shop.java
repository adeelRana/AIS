/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.enums.DiscountType;
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
@Table(name = "shop", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shop.findAll", query = "SELECT s FROM Shop s ORDER BY s.shopBooker, s.shopRoute, s.name ASC")
    , @NamedQuery(name = "Shop.findById", query = "SELECT s FROM Shop s WHERE s.id = :id")
    , @NamedQuery(name = "Shop.findByName", query = "SELECT s FROM Shop s WHERE s.name = :name")
    , @NamedQuery(name = "Shop.findByAddress", query = "SELECT s FROM Shop s WHERE s.address = :address")
    , @NamedQuery(name = "Shop.findByOpeningCr", query = "SELECT s FROM Shop s WHERE s.openingCr = :openingCr")
    , @NamedQuery(name = "Shop.findByOpeningDate", query = "SELECT s FROM Shop s WHERE s.openingDate = :openingDate")
    , @NamedQuery(name = "Shop.findByCurrentCr", query = "SELECT s FROM Shop s WHERE s.currentCr = :currentCr")
    , @NamedQuery(name = "Shop.findByScheme", query = "SELECT s FROM Shop s WHERE s.scheme = :scheme")
    , @NamedQuery(name = "Shop.findByDiscountAgency", query = "SELECT s FROM Shop s WHERE s.discountAgency = :discountAgency")
    , @NamedQuery(name = "Shop.findByDiscountDistributor", query = "SELECT s FROM Shop s WHERE s.discountDistributor = :discountDistributor")
    , @NamedQuery(name = "Shop.findByDiscountType", query = "SELECT s FROM Shop s WHERE s.discountType = :discountType")
    , @NamedQuery(name = "Shop.findByStatus", query = "SELECT s FROM Shop s WHERE s.status = :status ORDER BY s.name ASC")})
public class Shop implements Serializable {

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
    @Column(name = "ADDRESS")
    private String address;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "OPENING_CR")
    private Double openingCr;
    @Basic(optional = false)
    @Column(name = "OPENING_DATE")
    private long openingDate;
    @Basic(optional = false)
    @Column(name = "CURRENT_CR")
    private Double currentCr;
    @Column(name = "SCHEME")
    private Double scheme;
    @Column(name = "DISCOUNT_DISTRIBUTOR")
    private Double discountDistributor;
    @Column(name = "DISCOUNT_AGENCY")
    private Double discountAgency;
    @Column(name = "DISCOUNT_TYPE")
    private String discountType;
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "SHOP_BOOKER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Booker shopBooker;
    @JoinColumn(name = "SHOP_ROUTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Route shopRoute;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoiceShop")
    private List<Invoice> invoiceList;

    public Shop() {
    }

    public Shop(Long id) {
        this.id = id;
    }

    public Shop(Long id, String name, String address, Double openingCr, long openingDate, Double currentCr, short status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openingCr = openingCr;
        this.openingDate = openingDate;
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

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getOpeningCr() {
        return openingCr;
    }

    public void setOpeningCr(Double openingCr) {
        this.openingCr = openingCr;
    }

    public long getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(long openingDate) {
        this.openingDate = openingDate;
    }

    public Double getCurrentCr() {
        return currentCr;
    }

    public void setCurrentCr(Double currentCr) {
        this.currentCr = currentCr;
    }

    public Double getScheme() {
        return scheme;
    }

    public void setScheme(Double scheme) {
        this.scheme = scheme;
    }

    public Double getDiscountDistributor() {
        if (discountDistributor == null) {
            discountDistributor = 0d;
        }
        return discountDistributor;
    }

    public void setDiscountDistributor(Double discountDistributor) {
        this.discountDistributor = discountDistributor;
    }

    public Double getDiscountAgency() {
        if (discountAgency == null) {
            discountAgency = 0d;
        }
        return discountAgency;
    }

    public void setDiscountAgency(Double discountAgency) {
        this.discountAgency = discountAgency;
    }

    public String getDiscountType() {
        if (discountType == null) {
            discountType = "";
        }
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Booker getShopBooker() {
        return shopBooker;
    }

    public void setShopBooker(Booker shopBooker) {
        this.shopBooker = shopBooker;
    }

    public Route getShopRoute() {
        return shopRoute;
    }

    public void setShopRoute(Route shopRoute) {
        this.shopRoute = shopRoute;
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

    public double getDiscountValue() {
        switch (discountType) {
            case DiscountType.AGENCY_PER:
            case DiscountType.AGENCY_RS:
                return getDiscountAgency();
            case DiscountType.DISTRIBUTOR_PER:
            case DiscountType.DISTRIBUTOR_RS:
                return getDiscountDistributor();
            case DiscountType.JOINED_PER:
            case DiscountType.JOINED_RS:
                return getDiscountAgency() + getDiscountDistributor();
            default:
                return 0;
        }
    }

    public String showDiscount() {
        if (discountType.equalsIgnoreCase(DiscountType.AGENCY_RS)
                || discountType.equalsIgnoreCase(DiscountType.DISTRIBUTOR_RS)
                || discountType.equalsIgnoreCase(DiscountType.JOINED_RS)) {
            return "Rs " + (this.getDiscountDistributor() + this.getDiscountAgency());
        } else {
            return (this.getDiscountDistributor() + this.getDiscountAgency()) + " %";
        }

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
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " " + type;
    }

}
