/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.models.ProductQty;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "products", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p ORDER BY  p.status,p.name, p.weight, p.flavour ASC ")
    , @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id")
    , @NamedQuery(name = "Products.findByCode", query = "SELECT p FROM Products p WHERE p.code = :code")
    , @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name")
    , @NamedQuery(name = "Products.findByFlavour", query = "SELECT p FROM Products p WHERE p.flavour = :flavour")
    , @NamedQuery(name = "Products.findByWeight", query = "SELECT p FROM Products p WHERE p.weight = :weight")
    , @NamedQuery(name = "Products.findByWeightUnit", query = "SELECT p FROM Products p WHERE p.weightUnit = :weightUnit")
    , @NamedQuery(name = "Products.findByPiecesPerCtn", query = "SELECT p FROM Products p WHERE p.piecesPerCtn = :piecesPerCtn")
    , @NamedQuery(name = "Products.findBySalePrice", query = "SELECT p FROM Products p WHERE p.salePrice = :salePrice")
    , @NamedQuery(name = "Products.findByPurchasePrice", query = "SELECT p FROM Products p WHERE p.purchasePrice = :purchasePrice")
    , @NamedQuery(name = "Products.findByOpeningQty", query = "SELECT p FROM Products p WHERE p.openingQty = :openingQty")
    , @NamedQuery(name = "Products.findByCurrentQty", query = "SELECT p FROM Products p WHERE p.currentQty = :currentQty")
    , @NamedQuery(name = "Products.findByStatus", query = "SELECT p FROM Products p WHERE p.status = :status")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CODE")
    private String code;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "FLAVOUR")
    private String flavour;
    @Basic(optional = false)
    @Column(name = "WEIGHT")
    private Double weight;
    @Basic(optional = false)
    @Column(name = "WEIGHT_UNIT")
    private String weightUnit;
    @Basic(optional = false)
    @Column(name = "PIECE_PRICE")
    private Double piecePrice;
    @Basic(optional = false)
    @Column(name = "PIECES_PER_CTN")
    private Double piecesPerCtn;
    @Basic(optional = false)
    @Column(name = "SALE_PRICE")
    private Double salePrice;
    @Basic(optional = false)
    @Column(name = "PURCHASE_PRICE")
    private Double purchasePrice;
    @Basic(optional = false)
    @Column(name = "OPENING_QTY")
    private Double openingQty;
    @Basic(optional = false)
    @Column(name = "CURRENT_QTY")
    private Double currentQty;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @JoinColumn(name = "PRODUCT_COMPANY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Company productCompany;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockProduct")
    private List<StockDetail> stockDetailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detailProduct")
    private List<InvoiceDetail> invoiceDetailList;
    @Transient
    private ProductQty productQty;

    public Products() {
    }

    public Products(Long id) {
        this.id = id;
    }

    public Products(Long id, String name, String flavour, Double weight, String weightUnit, Double piecesPerCtn, Double salePrice, Double purchasePrice, Double openingQty, Double currentQty, short status) {
        this.id = id;
        this.name = name;
        this.flavour = flavour;
        this.weight = weight;
        this.weightUnit = weightUnit;
        this.piecesPerCtn = piecesPerCtn;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.openingQty = openingQty;
        this.currentQty = currentQty;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Double getPiecePrice() {
        return piecePrice;
    }

    public void setPiecePrice(Double piecePrice) {
        this.piecePrice = piecePrice;
    }

    public Double getPiecesPerCtn() {
        return piecesPerCtn;
    }

    public void setPiecesPerCtn(Double piecesPerCtn) {
        this.piecesPerCtn = piecesPerCtn;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getOpeningQty() {
        return openingQty;
    }

    public void setOpeningQty(Double openingQty) {
        this.openingQty = openingQty;
    }

    public Double getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(Double currentQty) {
        this.currentQty = currentQty;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Company getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(Company productCompany) {
        this.productCompany = productCompany;
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

    public ProductQty getProductQty() {
        if (productQty == null) {
            this.productQty = new ProductQty(this.piecesPerCtn, this.currentQty, this.weight);
        }
        return productQty;
    }

    public void setProductQty(ProductQty productQty) {
        this.productQty = productQty;
    }

    public ProductQty getProductQtyObjectFromPieces(double pieces) {
        return new ProductQty(this.piecesPerCtn, pieces, this.weight);
    }

    public ProductQty getProductQtyObjectFromCartons(double cartons) {
        ProductQty pq = new ProductQty();
        pq.createObjValuesByCartons(this.piecesPerCtn, cartons, this.weight);
        return pq;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "_" + flavour + "_" + weight.intValue() + weightUnit;
    }

}
