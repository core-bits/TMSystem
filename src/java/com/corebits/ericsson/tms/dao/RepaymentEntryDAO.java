
package com.corebits.ericsson.tms.dao;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author xtphere
 */
public class RepaymentEntryDAO  implements Serializable{
    private String paymentDate;
    private BigDecimal beginingBalance;
    private BigDecimal monthlyPayment;
    private BigDecimal principal;
    private BigDecimal interest;
    private BigDecimal endinBalance;   
    
    public RepaymentEntryDAO(){        
    }

    public RepaymentEntryDAO(String paymentDate, BigDecimal beginingBalance, BigDecimal monthlyPayment, BigDecimal principal, 
            BigDecimal interest, BigDecimal endinBalance) {
        this.paymentDate = paymentDate;
        this.beginingBalance = beginingBalance;
        this.monthlyPayment = monthlyPayment;
        this.principal = principal;
        this.interest = interest;
        this.endinBalance = endinBalance;
    }
    
    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getBeginingBalance() {
        return beginingBalance;
    }

    public void setBeginingBalance(BigDecimal beginingBalance) {
        this.beginingBalance = beginingBalance;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getEndinBalance() {
        return endinBalance;
    }

    public void setEndinBalance(BigDecimal endinBalance) {
        this.endinBalance = endinBalance;
    }

    @Override
    public String toString() {
        return "RepaymentEntryDAO{" + "paymentDate=" + paymentDate + ", beginingBalance=" + beginingBalance + ", monthlyPayment=" + monthlyPayment + ", principal=" + principal + ", interest=" + interest + ", endinBalance=" + endinBalance + '}';
    }
    
}
