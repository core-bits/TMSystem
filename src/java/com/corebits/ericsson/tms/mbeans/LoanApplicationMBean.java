
package com.corebits.ericsson.tms.mbeans;

import com.corebits.ericsson.tms.controllers.LoanApplicationController;
import com.corebits.ericsson.tms.dao.PaymentDAO;
import com.corebits.ericsson.tms.dao.RepaymentEntryDAO;
import com.corebits.ericsson.tms.mbeans.util.JsfUtil;
import com.corebits.ericsson.tms.models.LoanApplication;
import com.corebits.ericsson.tms.models.LoanType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author xtphere
 */
//@Named(value="loanApplicationMBean")
//@RequestScoped
@ManagedBean(name="loanApplicationMBean")
@ViewScoped
public class LoanApplicationMBean extends AbstractMBean<LoanApplication> implements Serializable{    
    @EJB
    LoanApplicationController ejbFacade;
    private int loanPeriodInYears;
    private BigDecimal loanAmount;
    private BigDecimal annualInterestRate;
    private Date loanStartDate;
    private int numberOfPayment;
    private PaymentDAO payment;
    private BigDecimal maxLoanAmount;
    private int maxTenure;
    private LoanType loanType;
    
    
    public LoanApplicationMBean(){        
        super(LoanApplication.class);
        System.out.println("constructor");
        
    }
    
    @PostConstruct
    public void init(){
        super.setFacade(ejbFacade);
        System.out.println("init");
        maxLoanAmount = new BigDecimal(10000000);
        maxTenure = 24;
        annualInterestRate = new BigDecimal(7.5);
        payment = repaymentEntries();
    }
    
    public void tenureInputControl(AjaxBehaviorEvent event){
        System.out.println("tenureInputControl: numberOfPayment=" + numberOfPayment);
        if(maxTenure < numberOfPayment){
            this.numberOfPayment = maxTenure;
            JsfUtil.addErrorMessage("Allowed maximum tenure for \"" + loanType + "\" is " + "\"" + maxTenure + "\"");
            System.out.println("message: Allowed maximum tenure for \"" + loanType + "\" is " + "\"" + maxTenure + "\"");            
        }
        payment = repaymentEntries();
    }
    
    public void loanAmountInputControl(AjaxBehaviorEvent event){
        System.out.println("loanAmountInputControl: loanAmount=" + loanAmount);
        if(maxLoanAmount != null && maxLoanAmount.compareTo(loanAmount) < 1){
            loanAmount = BigDecimal.ZERO;
            JsfUtil.addErrorMessage("Allowed maximum amount for \"" + loanType + "\" is " + "\"" + maxLoanAmount + "\"");
            System.out.println("message: Allowed maximum amount for \"" + loanType + "\" is " + "\"" + maxLoanAmount + "\"");            
        }
        payment = repaymentEntries(); 
        System.out.println("payments... : " + payment.getRepaymentEntry().size());
    }
    
    public void startDateInputControl(AjaxBehaviorEvent event){
        System.out.println("startDateInputControl: loanStartDate=" + loanStartDate);
        payment = repaymentEntries(); 
    }
    
    
    private PaymentDAO repaymentEntries(){
        System.out.println("repaymentEntries: loanAmount: " + loanAmount +", annualInterestRate: " + annualInterestRate + ", loanStartDate: "
                + loanStartDate + ", numberOfPayment: " + numberOfPayment);
        if((loanAmount == null || loanAmount.compareTo(BigDecimal.ZERO) == 0) || 
                (annualInterestRate == null || annualInterestRate.compareTo(BigDecimal.ZERO) == 0) || 
                loanStartDate == null || numberOfPayment < 1)
            return new PaymentDAO();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder builder = new StringBuilder();
        RepaymentEntryDAO entry;
        BigDecimal mBeginningBal = loanAmount;
        BigDecimal mPayment;
        BigDecimal mInterest;
        BigDecimal mEndingBal;
        BigDecimal mPrincipal;
        BigDecimal totInterest = BigDecimal.ZERO;
        BigDecimal totCostOfLoan;
        mPayment = calculateMPayment();
        List<RepaymentEntryDAO> entryList;
        entryList = new ArrayList<>();
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(loanStartDate);
        for(int i = 1; i <= numberOfPayment; i++){
            mInterest = calculateMInterest(mBeginningBal);
            totInterest = totInterest.add(mInterest);
            mPrincipal = mPayment.subtract(mInterest);
            mEndingBal = mBeginningBal.subtract(mPrincipal);
            cal.add(Calendar.MONTH, 1);
            entry = new RepaymentEntryDAO(sdf.format(cal.getTime()), mBeginningBal, mPayment, mPrincipal, mInterest, mEndingBal);
            entryList.add(entry); 
            builder.append(sdf.format(cal.getTime()))
                    .append("\t")
                    .append(mBeginningBal)
                    .append("\t")
                    .append(mPayment)
                    .append("\t")
                    .append(mPrincipal)
                    .append("\t")
                    .append(mInterest)
                    .append("\t")
                    .append(mEndingBal)
                    .append("\n");
            mBeginningBal = mEndingBal;
        }
        
//        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:/temp/payments.txt"))) {
//                writer.write(builder.toString());
//            } catch (IOException ex) {
//                Logger.getLogger(LoanApplicationMBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
        totCostOfLoan = loanAmount.add(totInterest);
        PaymentDAO entries = new PaymentDAO(entryList, totInterest, totCostOfLoan); 
        
        System.out.println("payment: " + entries.getRepaymentEntry().size());
        
        return entries;
    }
    
    private BigDecimal calculateMPayment(){
        //montly payment (Equated Monthly Payment - EMI) = P * r(1+r)^n/((1+r)^n - 1)
        //where P = principal, r = annual interest rate/100 (divided by 12 in case of monthly repayment)
        //n = number of repayments
        BigDecimal rate = computeInterestRateCompounded();
        BigDecimal onePlusRateRaisedToN = BigDecimal.ONE.add(rate).pow(numberOfPayment);
        
        //numerator portion of formula
        BigDecimal numerator = loanAmount.multiply(rate).multiply(onePlusRateRaisedToN);
        
        //Denomination portion of formula
        BigDecimal denominator = onePlusRateRaisedToN.subtract(BigDecimal.ONE);
        
        // returns the monthly payment amount        
        return numerator.divide(denominator, 2, BigDecimal.ROUND_UP).setScale(2, BigDecimal.ROUND_UP);
    }
    
    private BigDecimal calculateMInterest(BigDecimal mRemainingBal){        
        return mRemainingBal
                .multiply(computeInterestRateCompounded())
                .setScale(2, BigDecimal.ROUND_UP); 
    }
    
    private BigDecimal computeInterestRateCompounded(){
        return annualInterestRate
                .divide(new BigDecimal(100), 10, BigDecimal.ROUND_UP)
                .divide(new BigDecimal(12), 10, BigDecimal.ROUND_UP)
                .setScale(10, BigDecimal.ROUND_UP); 
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

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(Date loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public int getNumberOfPayment() {
        return numberOfPayment;
    }

    public void setNumberOfPayment(int numberOfPayment) {
        this.numberOfPayment = numberOfPayment;
    }
    
    public static void main(String[] args){
        
        new LoanApplicationMBean().repaymentEntries();
    }

    public PaymentDAO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDAO payment) {
        this.payment = payment;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }
    
    
    
}
