package com.corebits.ericsson.tms.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Roles.class)
public abstract class Roles_ {

	public static volatile SingularAttribute<Roles, String> roleName;
	public static volatile SingularAttribute<Roles, Integer> id;
	public static volatile ListAttribute<Roles, UserRole> userRoleList;
	public static volatile SingularAttribute<Roles, String> roleDescription;

}

