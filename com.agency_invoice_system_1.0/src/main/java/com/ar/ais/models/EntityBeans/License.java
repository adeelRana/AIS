/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "license", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "License.findAll", query = "SELECT l FROM License l")
    , @NamedQuery(name = "License.findById", query = "SELECT l FROM License l WHERE l.id = :id")
    , @NamedQuery(name = "License.findByInstallationDate", query = "SELECT l FROM License l WHERE l.installationDate = :installationDate")
    , @NamedQuery(name = "License.findByUpdateDate", query = "SELECT l FROM License l WHERE l.updateDate = :updateDate")
    , @NamedQuery(name = "License.findByDaysAllow", query = "SELECT l FROM License l WHERE l.daysAllow = :daysAllow")
    , @NamedQuery(name = "License.findByDaysRun", query = "SELECT l FROM License l WHERE l.daysRun = :daysRun")
    , @NamedQuery(name = "License.findByCreated", query = "SELECT l FROM License l WHERE l.created = :created")
    , @NamedQuery(name = "License.findByPass", query = "SELECT l FROM License l WHERE l.pass = :pass")
    , @NamedQuery(name = "License.findByDbVersion", query = "SELECT l FROM License l WHERE l.dbVersion = :dbVersion")})
public class License implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Lob
    @Column(name = "KEY")
    private String key;
    @Lob
    @Column(name = "MAC_ADDRESS")
    private String macAddress;
    @Column(name = "INSTALLATION_DATE")
    private BigInteger installationDate;
    @Column(name = "UPDATE_DATE")
    private BigInteger updateDate;
    @Column(name = "DAYS_ALLOW")
    private Integer daysAllow;
    @Column(name = "DAYS_RUN")
    private Integer daysRun;
    @Basic(optional = false)
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "PASS")
    private String pass;
    @Basic(optional = false)
    @Column(name = "DB_VERSION")
    private String dbVersion;

    public License() {
    }

    public License(Integer id) {
        this.id = id;
    }

    public License(Integer id, Date created, String pass, String dbVersion) {
        this.id = id;
        this.created = created;
        this.pass = pass;
        this.dbVersion = dbVersion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public BigInteger getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(BigInteger installationDate) {
        this.installationDate = installationDate;
    }

    public BigInteger getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(BigInteger updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDaysAllow() {
        return daysAllow;
    }

    public void setDaysAllow(Integer daysAllow) {
        this.daysAllow = daysAllow;
    }

    public Integer getDaysRun() {
        return daysRun;
    }

    public void setDaysRun(Integer daysRun) {
        this.daysRun = daysRun;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDbVersion() {
        return dbVersion;
    }

    public void setDbVersion(String dbVersion) {
        this.dbVersion = dbVersion;
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
        if (!(object instanceof License)) {
            return false;
        }
        License other = (License) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ar.ais.models.EntityBeans.License[ id=" + id + " ]";
    }
    
}
