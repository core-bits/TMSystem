
package com.corebits.ericsson.tms.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xtphere
 */
public class PaymentDAO  implements Serializable{
    private List<RepaymentEntryDAO> repaymentEntry;
    private BigDecimal totalInterest;
    private BigDecimal totalCostOfLoan;
    
    public PaymentDAO(){
        repaymentEntry = new ArrayList<>();
        totalInterest = BigDecimal.ZERO;
        totalCostOfLoan = BigDecimal.ZERO;
    }

    public PaymentDAO(List<RepaymentEntryDAO> repaymentEntry, BigDecimal totalInterest, BigDecimal totalCostOfLoan) {
        this.repaymentEntry = repaymentEntry;
        this.totalInterest = totalInterest;
        this.totalCostOfLoan = totalCostOfLoan;
    }
    
    

    public List<RepaymentEntryDAO> getRepaymentEntry() {
        return repaymentEntry;
    }

    public void setRepaymentEntry(List<RepaymentEntryDAO> repaymentEntry) {
        this.repaymentEntry = repaymentEntry;
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
    
    @Override
    public String toString() {
        return "PaymentDAO{" + "repaymentEntry=" + repaymentEntry + ", totalInterest=" + totalInterest + ", totalCostOfLoan=" + totalCostOfLoan + '}';
    }
    
    
}
