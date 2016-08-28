package com.corebits.ericsson.tms.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoanType.class)
public abstract class LoanType_ {

	public static volatile SingularAttribute<LoanType, String> loanName;
	public static volatile SingularAttribute<LoanType, String> loanDescription;
	public static volatile ListAttribute<LoanType, LoanAllocationGuidelines> loanAllocationGuidelinesList;
	public static volatile SingularAttribute<LoanType, Integer> id;

}

