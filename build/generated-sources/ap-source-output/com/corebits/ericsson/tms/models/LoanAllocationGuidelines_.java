package com.corebits.ericsson.tms.models;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoanAllocationGuidelines.class)
public abstract class LoanAllocationGuidelines_ {

	public static volatile SingularAttribute<LoanAllocationGuidelines, String> loanName;
	public static volatile SingularAttribute<LoanAllocationGuidelines, Integer> interestRate;
	public static volatile SingularAttribute<LoanAllocationGuidelines, String> maximumTenure;
	public static volatile SingularAttribute<LoanAllocationGuidelines, String> minimumTenure;
	public static volatile SingularAttribute<LoanAllocationGuidelines, LoanType> loanType;
	public static volatile SingularAttribute<LoanAllocationGuidelines, BigDecimal> maximumAmount;
	public static volatile SingularAttribute<LoanAllocationGuidelines, BigDecimal> minimumAmount;
	public static volatile SingularAttribute<LoanAllocationGuidelines, Integer> id;

}

