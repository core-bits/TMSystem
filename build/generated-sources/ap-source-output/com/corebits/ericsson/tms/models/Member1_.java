package com.corebits.ericsson.tms.models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member1.class)
public abstract class Member1_ {

	public static volatile SingularAttribute<Member1, String> phoneOfNok;
	public static volatile SingularAttribute<Member1, String> mobileNumber;
	public static volatile SingularAttribute<Member1, String> addressOfNok;
	public static volatile SingularAttribute<Member1, String> memberName;
	public static volatile SingularAttribute<Member1, String> memberAddress;
	public static volatile SingularAttribute<Member1, String> referralName;
	public static volatile SingularAttribute<Member1, BuisnessUnit> buisnessUnit;
	public static volatile SingularAttribute<Member1, Date> presidentApprovalDate;
	public static volatile SingularAttribute<Member1, String> bank;
	public static volatile SingularAttribute<Member1, Date> secretaryApprovalDate;
	public static volatile SingularAttribute<Member1, byte[]> presidentSignature;
	public static volatile SingularAttribute<Member1, Date> undertakingDate;
	public static volatile SingularAttribute<Member1, String> witnessName;
	public static volatile SingularAttribute<Member1, Integer> id;
	public static volatile SingularAttribute<Member1, Department> department;
	public static volatile SingularAttribute<Member1, String> email;
	public static volatile SingularAttribute<Member1, String> memberId;
	public static volatile SingularAttribute<Member1, String> witnessResidentialAddress;
	public static volatile SingularAttribute<Member1, String> nextOfKin;
	public static volatile SingularAttribute<Member1, String> sex;
	public static volatile SingularAttribute<Member1, byte[]> witnessSignature;
	public static volatile SingularAttribute<Member1, Date> authorityToDeductEffectiveDate;
	public static volatile SingularAttribute<Member1, String> accountNumber;
	public static volatile SingularAttribute<Member1, String> relationshipToNok;
	public static volatile SingularAttribute<Member1, String> undertakingName;
	public static volatile SingularAttribute<Member1, Date> witnessApprovalDate;
	public static volatile SingularAttribute<Member1, Short> presidentApprovalStatus;
	public static volatile SingularAttribute<Member1, Short> secretaryApprovalStatus;
	public static volatile SingularAttribute<Member1, byte[]> secretarySignature;
	public static volatile SingularAttribute<Member1, String> maritalStatus;
	public static volatile SingularAttribute<Member1, byte[]> applicantSignature;
	public static volatile SingularAttribute<Member1, BigDecimal> authorityToDeductAmount;
	public static volatile SingularAttribute<Member1, Date> applicationDate;

}

