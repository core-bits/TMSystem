/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Tommy
 */
@Entity
@Table(name = "user_role")
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id"),
    @NamedQuery(name = "UserRole.findByDateAssigned", query = "SELECT u FROM UserRole u WHERE u.dateAssigned = :dateAssigned"),
    @NamedQuery(name = "UserRole.findByAssignedBy", query = "SELECT u FROM UserRole u WHERE u.assignedBy = :assignedBy"),
    @NamedQuery(name = "UserRole.findByDateAuthorised", query = "SELECT u FROM UserRole u WHERE u.dateAuthorised = :dateAuthorised"),
    @NamedQuery(name = "UserRole.findByAuthorisedBy", query = "SELECT u FROM UserRole u WHERE u.authorisedBy = :authorisedBy"),
    @NamedQuery(name = "UserRole.findByStatus", query = "SELECT u FROM UserRole u WHERE u.status = :status"),
    @NamedQuery(name = "UserRole.findByAuthoriseStatus", query = "SELECT u FROM UserRole u WHERE u.authoriseStatus = :authoriseStatus"),
    @NamedQuery(name = "UserRole.findByReason", query = "SELECT u FROM UserRole u WHERE u.reason = :reason")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_assigned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAssigned;
    @Size(max = 45)
    @Column(name = "assigned_by")
    private String assignedBy;
    @Column(name = "date_authorised")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAuthorised;
    @Size(max = 45)
    @Column(name = "authorised_by")
    private String authorisedBy;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 2)
    @Column(name = "authorise_status")
    private String authoriseStatus;
    @Size(max = 130)
    @Column(name = "reason")
    private String reason;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Roles roleId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public UserRole() {
    }

    public UserRole(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Date getDateAuthorised() {
        return dateAuthorised;
    }

    public void setDateAuthorised(Date dateAuthorised) {
        this.dateAuthorised = dateAuthorised;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAuthoriseStatus() {
        return authoriseStatus;
    }

    public void setAuthoriseStatus(String authoriseStatus) {
        this.authoriseStatus = authoriseStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.corebits.ericsson.tms.models.UserRole[ id=" + id + " ]";
    }
    
}
