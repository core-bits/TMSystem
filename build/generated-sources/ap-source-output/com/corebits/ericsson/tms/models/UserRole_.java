package com.corebits.ericsson.tms.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserRole.class)
public abstract class UserRole_ {

	public static volatile SingularAttribute<UserRole, String> reason;
	public static volatile SingularAttribute<UserRole, String> assignedBy;
	public static volatile SingularAttribute<UserRole, Date> dateAuthorised;
	public static volatile SingularAttribute<UserRole, Roles> roleId;
	public static volatile SingularAttribute<UserRole, String> authorisedBy;
	public static volatile SingularAttribute<UserRole, Integer> id;
	public static volatile SingularAttribute<UserRole, String> authoriseStatus;
	public static volatile SingularAttribute<UserRole, Date> dateAssigned;
	public static volatile SingularAttribute<UserRole, User> userId;
	public static volatile SingularAttribute<UserRole, Boolean> status;

}

