
package com.corebits.ericsson.tms.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xtphere
 */
@Entity
@Table(name = "loan_application")
@NamedQueries({
    @NamedQuery(name = "LoanApplication.findAll", query = "SELECT l FROM LoanApplication l"),
    @NamedQuery(name = "LoanApplication.findById", query = "SELECT l FROM LoanApplication l WHERE l.id = :id"),
    @NamedQuery(name = "LoanApplication.findByMemberId", query = "SELECT l FROM LoanApplication l WHERE l.memberId = :memberId"),
    @NamedQuery(name = "LoanApplication.findByLoanPeriodInYears", query = "SELECT l FROM LoanApplication l WHERE l.loanPeriodInYears = :loanPeriodInYears"),
    @NamedQuery(name = "LoanApplication.findByLoanAmount", query = "SELECT l FROM LoanApplication l WHERE l.loanAmount = :loanAmount"),
    @NamedQuery(name = "LoanApplication.findByAnnualInterestRate", query = "SELECT l FROM LoanApplication l WHERE l.annualInterestRate = :annualInterestRate"),
    @NamedQuery(name = "LoanApplication.findByLoanStartDate", query = "SELECT l FROM LoanApplication l WHERE l.loanStartDate = :loanStartDate"),
    @NamedQuery(name = "LoanApplication.findByMonthlyPaymentAmount", query = "SELECT l FROM LoanApplication l WHERE l.monthlyPaymentAmount = :monthlyPaymentAmount"),
    @NamedQuery(name = "LoanApplication.findByNumberOfPayment", query = "SELECT l FROM LoanApplication l WHERE l.numberOfPayment = :numberOfPayment"),
    @NamedQuery(name = "LoanApplication.findByTotalInterest", query = "SELECT l FROM LoanApplication l WHERE l.totalInterest = :totalInterest"),
    @NamedQuery(name = "LoanApplication.findByTotalCostOfLoan", query = "SELECT l FROM LoanApplication l WHERE l.totalCostOfLoan = :totalCostOfLoan"),
    @NamedQuery(name = "LoanApplication.findByMonthlyPrincipal", query = "SELECT l FROM LoanApplication l WHERE l.monthlyPrincipal = :monthlyPrincipal"),
    @NamedQuery(name = "LoanApplication.findByDateOfApplication", query = "SELECT l FROM LoanApplication l WHERE l.dateOfApplication = :dateOfApplication"),
    @NamedQuery(name = "LoanApplication.findByApprovedBy", query = "SELECT l FROM LoanApplication l WHERE l.approvedBy = :approvedBy"),
    @NamedQuery(name = "LoanApplication.findByDateOfApproval", query = "SELECT l FROM LoanApplication l WHERE l.dateOfApproval = :dateOfApproval")})
public class LoanApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "member_id")
    private String memberId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loan_period_in_years")
    private int loanPeriodInYears;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "loan_amount")
    private BigDecimal loanAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annual_interest_rate")
    private int annualInterestRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loan_start_date")
    @Temporal(TemporalType.DATE)
    private Date loanStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monthly_payment_amount")
    private BigDecimal monthlyPaymentAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_payment")
    private int numberOfPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_interest")
    private BigDecimal totalInterest;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cost_of_loan")
    private BigDecimal totalCostOfLoan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monthly_principal")
    private BigDecimal monthlyPrincipal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_application")
    @Temporal(TemporalType.DATE)
    private Date dateOfApplication;
    @Size(max = 45)
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "date_of_approval")
    @Temporal(TemporalType.DATE)
    private Date dateOfApproval;

    public LoanApplication() {
    }

    public LoanApplication(Integer id) {
        this.id = id;
    }

    public LoanApplication(Integer id, String memberId, int loanPeriodInYears, BigDecimal loanAmount, int annualInterestRate, Date loanStartDate, BigDecimal monthlyPaymentAmount, int numberOfPayment, BigDecimal totalInterest, BigDecimal totalCostOfLoan, BigDecimal monthlyPrincipal, Date dateOfApplication) {
        this.id = id;
        this.memberId = memberId;
        this.loanPeriodInYears = loanPeriodInYears;
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.loanStartDate = loanStartDate;
        this.monthlyPaymentAmount = monthlyPaymentAmount;
        this.numberOfPayment = numberOfPayment;
        this.totalInterest = totalInterest;
        this.totalCostOfLoan = totalCostOfLoan;
        this.monthlyPrincipal = monthlyPrincipal;
        this.dateOfApplication = dateOfApplication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getLoanPeriodInYears() {
        return loanPeriodInYears;
    }

    public void setLoanPeriodInYears(int loanPeriodInYears) {
        this.loanPeriodInYears = loanPeriodInYears;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(int annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public BigDecimal getMonthlyPaymentAmount() {
        return monthlyPaymentAmount;
    }

    public void setMonthlyPaymentAmount(BigDecimal monthlyPaymentAmount) {
        this.monthlyPaymentAmount = monthlyPaymentAmount;
    }

    public int getNumberOfPayment() {
        return numberOfPayment;
    }

    public void setNumberOfPayment(int numberOfPayment) {
        this.numberOfPayment = numberOfPayment;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public BigDecimal getTotalCostOfLoan() {
        return totalCostOfLoan;
    }

    public void setTotalCostOfLoan(BigDecimal totalCostOfLoan) {
        this.totalCostOfLoan = totalCostOfLoan;
    }

    public BigDecimal getMonthlyPrincipal() {
        return monthlyPrincipal;
    }

    public void setMonthlyPrincipal(BigDecimal monthlyPrincipal) {
        this.monthlyPrincipal = monthlyPrincipal;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateOfApproval() {
        return dateOfApproval;
    }

    public void setDateOfApproval(Date dateOfApproval) {
        this.dateOfApproval = dateOfApproval;
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
        if (!(object instanceof LoanApplication)) {
            return false;
        }
        LoanApplication other = (LoanApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoanApplication{" + "id=" + id + ", memberId=" + memberId + ", loanPeriodInYears=" 
                + loanPeriodInYears + ", loanAmount=" + loanAmount + ", annualInterestRate=" 
                + annualInterestRate + ", loanStartDate=" + loanStartDate + ", monthlyPaymentAmount=" 
                + monthlyPaymentAmount + ", numberOfPayment=" + numberOfPayment + ", totalInterest=" 
                + totalInterest + ", totalCostOfLoan=" + totalCostOfLoan + ", monthlyPrincipal=" 
                + monthlyPrincipal + ", dateOfApplication=" + dateOfApplication + ", approvedBy=" 
                + approvedBy + ", dateOfApproval=" + dateOfApproval + '}';
    }
    
    
    
}
