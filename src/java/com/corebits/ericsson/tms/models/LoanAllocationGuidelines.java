/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corebits.ericsson.tms.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tommy
 */
@Entity
@Table(name = "loan_allocation_guidelines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanAllocationGuidelines.findAll", query = "SELECT l FROM LoanAllocationGuidelines l"),
    @NamedQuery(name = "LoanAllocationGuidelines.findById", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.id = :id"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByLoanName", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.loanName = :loanName"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByMaximumAmount", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.maximumAmount = :maximumAmount"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByMinimumAmount", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.minimumAmount = :minimumAmount"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByMaximumTenure", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.maximumTenure = :maximumTenure"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByMinimumTenure", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.minimumTenure = :minimumTenure"),
    @NamedQuery(name = "LoanAllocationGuidelines.findByInterestRate", query = "SELECT l FROM LoanAllocationGuidelines l WHERE l.interestRate = :interestRate")})
public class LoanAllocationGuidelines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 65)
    @Column(name = "loan_name")
    private String loanName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maximum_amount")
    private BigDecimal maximumAmount;
    @Column(name = "minimum_amount")
    private BigDecimal minimumAmount;
    @Size(max = 45)
    @Column(name = "maximum_tenure")
    private String maximumTenure;
    @Size(max = 45)
    @Column(name = "minimum_tenure")
    private String minimumTenure;
    @Column(name = "interest_rate")
    private Integer interestRate;
    @JoinColumn(name = "loan_type", referencedColumnName = "id")
    @ManyToOne
    private LoanType loanType;

    public LoanAllocationGuidelines() {
    }

    public LoanAllocationGuidelines(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    public String getMaximumTenure() {
        return maximumTenure;
    }

    public void setMaximumTenure(String maximumTenure) {
        this.maximumTenure = maximumTenure;
    }

    public String getMinimumTenure() {
        return minimumTenure;
    }

    public void setMinimumTenure(String minimumTenure) {
        this.minimumTenure = minimumTenure;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
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
        if (!(object instanceof LoanAllocationGuidelines)) {
            return false;
        }
        LoanAllocationGuidelines other = (LoanAllocationGuidelines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.corebits.ericsson.models.LoanAllocationGuidelines[ id=" + id + " ]";
    }
    
}
