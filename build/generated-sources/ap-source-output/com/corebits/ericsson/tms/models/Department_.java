package com.corebits.ericsson.tms.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Department.class)
public abstract class Department_ {

	public static volatile SingularAttribute<Department, String> departmentName;
	public static volatile ListAttribute<Department, Member1> member1List;
	public static volatile SingularAttribute<Department, String> departmentCode;
	public static volatile SingularAttribute<Department, String> departmentDescription;
	public static volatile SingularAttribute<Department, Integer> id;

}

