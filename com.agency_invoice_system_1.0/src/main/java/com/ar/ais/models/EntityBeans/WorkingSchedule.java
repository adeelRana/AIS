/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.ais.models.EntityBeans;

import com.ar.ais.enums.Status;
import com.ar.ais.utililty.Global;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "working_schedule", catalog = "ar_ais", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkingSchedule.findAll", query = "SELECT w FROM WorkingSchedule w ORDER BY w.id DESC ")
    , @NamedQuery(name = "WorkingSchedule.findById", query = "SELECT w FROM WorkingSchedule w WHERE w.id = :id")
    , @NamedQuery(name = "WorkingSchedule.findByDate", query = "SELECT w FROM WorkingSchedule w WHERE w.date = :date")
    , @NamedQuery(name = "WorkingSchedule.findByStatus", query = "SELECT w FROM WorkingSchedule w WHERE w.status = :status")})
public class WorkingSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "DATE")
    private long date;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wSchedule", fetch = FetchType.LAZY)
    private List<Summary> summaryList;

    public WorkingSchedule() {
    }

    public WorkingSchedule(Long id) {
        this.id = id;
    }

    public WorkingSchedule(Date date) {
        this.date = date.getTime();
        this.status = 1;
    }

    public WorkingSchedule(Long id, long date, short status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkingSchedule)) {
            return false;
        }
        WorkingSchedule other = (WorkingSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Global.DATE_UTIL.getStingDateFromLongValue(date);
    }

    public boolean areSummariesLocked() {
        boolean flag = true;
        for (Summary s : getSummaryList()) {
            if (s.getStatus() != Status.LOCKED.getValue()) {
                return false;
            }
        }
        return flag;
    }

}
