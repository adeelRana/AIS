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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adi Rana
 */
@Entity
@Cacheable(false)
@Table(name = "app_user", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a")
    , @NamedQuery(name = "AppUser.findByUserId", query = "SELECT a FROM AppUser a WHERE a.userId = :userId")
    , @NamedQuery(name = "AppUser.findByUserName", query = "SELECT a FROM AppUser a WHERE a.userName = :userName")
    , @NamedQuery(name = "AppUser.findByUserPass", query = "SELECT a FROM AppUser a WHERE a.userPass = :userPass")
    , @NamedQuery(name = "AppUser.findByUserRole", query = "SELECT a FROM AppUser a WHERE a.userRole = :userRole")
    , @NamedQuery(name = "AppUser.findByLastLoginTime", query = "SELECT a FROM AppUser a WHERE a.lastLoginTime = :lastLoginTime")
    , @NamedQuery(name = "AppUser.findByCreatedBy", query = "SELECT a FROM AppUser a WHERE a.createdBy = :createdBy")
    , @NamedQuery(name = "AppUser.findByEditedBy", query = "SELECT a FROM AppUser a WHERE a.editedBy = :editedBy")
    , @NamedQuery(name = "AppUser.findByStatus", query = "SELECT a FROM AppUser a WHERE a.status = :status")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Long userId;
    @Basic(optional = false)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @Column(name = "USER_PASS")
    private String userPass;
    @Basic(optional = false)
    @Column(name = "USER_ROLE")
    private String userRole;
    @Basic(optional = false)
    @Column(name = "LAST_LOGIN_TIME")
    private long lastLoginTime;
    @Basic(optional = false)
    @Column(name = "CREATED_BY")
    private double createdBy;
    @Column(name = "EDITED_BY")
    private long editedBy;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private boolean status;
    @Transient
    private boolean loggedIn;

    public AppUser() {
    }

    public AppUser(Long userId) {
        this.userId = userId;
    }

    public AppUser(Long userId, String userName, String userPass, String userRole, long lastLoginTime, double createdBy, boolean status) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.userRole = userRole;
        this.lastLoginTime = lastLoginTime;
        this.createdBy = createdBy;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public double getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(double createdBy) {
        this.createdBy = createdBy;
    }

    public long getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(long editedBy) {
        this.editedBy = editedBy;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return userName;
    }

}
