package com.corebits.ericsson.tms.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> userLoginId;
	public static volatile SingularAttribute<User, String> userLoginPassword;
	public static volatile SingularAttribute<User, Date> dateCreated;
	public static volatile SingularAttribute<User, Boolean> userStatus;
	public static volatile SingularAttribute<User, Boolean> firstLoginStatus;
	public static volatile SingularAttribute<User, String> userEmail;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Date> lastLoginDate;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile ListAttribute<User, UserRole> userRoleList;

}

