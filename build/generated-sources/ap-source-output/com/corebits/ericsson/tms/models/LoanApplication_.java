package com.corebits.ericsson.tms.models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoanApplication.class)
public abstract class LoanApplication_ {

	public static volatile SingularAttribute<LoanApplication, Date> loanStartDate;
	public static volatile SingularAttribute<LoanApplication, Date> dateOfApproval;
	public static volatile SingularAttribute<LoanApplication, String> approvedBy;
	public static volatile SingularAttribute<LoanApplication, Integer> loanPeriodInYears;
	public static volatile SingularAttribute<LoanApplication, BigDecimal> loanAmount;
	public static volatile SingularAttribute<LoanApplication, Integer> numberOfPayment;
	public static volatile SingularAttribute<LoanApplication, Integer> annualInterestRate;
	public static volatile SingularAttribute<LoanApplication, BigDecimal> monthlyPrincipal;
	public static volatile SingularAttribute<LoanApplication, BigDecimal> totalCostOfLoan;
	public static volatile SingularAttribute<LoanApplication, Date> dateOfApplication;
	public static volatile SingularAttribute<LoanApplication, Integer> id;
	public static volatile SingularAttribute<LoanApplication, BigDecimal> monthlyPaymentAmount;
	public static volatile SingularAttribute<LoanApplication, BigDecimal> totalInterest;
	public static volatile SingularAttribute<LoanApplication, String> memberId;

}

